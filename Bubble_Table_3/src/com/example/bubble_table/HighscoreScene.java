package com.example.bubble_table;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.text.Text;

import android.content.Context;

public class HighscoreScene extends MenuScene implements
		IOnMenuItemClickListener {
	
	AnimatedSprite ball2;
	boolean direction2 = true;
	boolean newHScore = false;
	


	void clearGameScene() {


		GameScene.deleteMyStars();
		GameScene.deleteUhr();
		GameScene.deleteFireBalls();
		GameScene.deleteFlashBalls();
		GameScene.deletePurpleBalls();
		GameScene.deleteAquaBalls();
		GameScene.deleteAmmoBullet();
		GameScene.deleteShieldActivator();
		GameScene.deleteMyStars();
		GameScene.deleteBullets();
		

		
	}

	public HighscoreScene() {
		super(MainActivity.getSharedInstance().mCamera);
		int hscore = -1;
		// In beiden Fällen(siehe weiter unten) MUSS sowieso die Highscoredatei
		// gelesen werden..
		FileInputStream in;
		try {
			in = MainActivity.getSharedInstance()
					.openFileInput("highscore2.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(in);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			// String in Integer
			hscore = Integer.parseInt(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Wenn gerade gespielt..
		if (MainActivity.getSharedInstance().played) {
			clearGameScene();
			MainActivity.getSharedInstance().played = false;

			if (MainActivity.getSharedInstance().punkte > hscore) {
				// Neuer Highscore.. Deswegen eintragen..
				Text congratulation = new Text(0, 0, MainActivity.getSharedInstance().mFont,
						"CONGRATULATION! NEW HIGHSCORE :)", MainActivity
								.getSharedInstance()
								.getVertexBufferObjectManager());
				congratulation
						.setPosition(
								MainActivity.getSharedInstance().CAMERA_WIDTH
										/ 2 - congratulation.getWidth() / 2,
								(MainActivity.getSharedInstance().CAMERA_HEIGHT / 2) - 32);
				this.attachChild(congratulation);
				// Hihgscore eintragen..
				String myPointsStr = "" + MainActivity.getSharedInstance().punkte;
				FileOutputStream fos;
				newHScore = true;

				try {
					fos = MainActivity.getSharedInstance().openFileOutput(
							"highscore2.txt", Context.MODE_PRIVATE);
					fos.write(myPointsStr.getBytes());
					fos.close();
					hscore = MainActivity.getSharedInstance().punkte; // Damit die Ausgabe auch
												// stimmt..
				} catch (IOException e) {

				}
			} else {
				Text congratulation = new Text(0,
						0, MainActivity.getSharedInstance().mFont,
						"You just lost..\nYour Score "+MainActivity.getSharedInstance().punkte, MainActivity.getSharedInstance()
								.getVertexBufferObjectManager());
				congratulation
						.setPosition(
								MainActivity.getSharedInstance().CAMERA_WIDTH
										/ 2 - congratulation.getWidth() / 2,
								(MainActivity.getSharedInstance().CAMERA_HEIGHT / 2) - congratulation.getHeight());
				this.attachChild(congratulation);
			}

		}

		// Highscore ausgeben
		Text highscoreOutput = new Text(0,
				(MainActivity.getSharedInstance().CAMERA_HEIGHT / 2),
				MainActivity.getSharedInstance().mFont, "YOUR HIGHSCORE: " + hscore, MainActivity
						.getSharedInstance().getVertexBufferObjectManager());
		highscoreOutput.setPosition(
				MainActivity.getSharedInstance().CAMERA_WIDTH / 2
						- highscoreOutput.getWidth() / 2,
				(MainActivity.getSharedInstance().CAMERA_HEIGHT / 2));
		this.attachChild(highscoreOutput);

		// Zurückbutton
		IMenuItem zurueckButton = new TextMenuItem(1,
				MainActivity.getSharedInstance().mFont, "Back", MainActivity
						.getSharedInstance().getVertexBufferObjectManager());
		zurueckButton.setPosition(
				MainActivity.getSharedInstance().mCamera.getWidth() / 2
						- zurueckButton.getWidth() / 2,
				MainActivity.getSharedInstance().mCamera.getHeight() - 32);
		addMenuItem(zurueckButton);
		setOnMenuItemClickListener(this);
		
		
		ball2 = new AnimatedSprite(MainActivity.CAMERA_WIDTH/2-25, 450, MainActivity.getSharedInstance().kugelGruenTextureRegion, MainActivity.getSharedInstance().getVertexBufferObjectManager());
		this.attachChild(ball2);
		ball2.animate(300);
		

		
		
		this.registerUpdateHandler(new IUpdateHandler() {

			@Override
			public void onUpdate(float pSecondsElapsed) {
				
				
				if(direction2) {
					ball2.setY(ball2.getY()+1);
					if(ball2.getY() >= MainActivity.CAMERA_HEIGHT-80 && newHScore) {
						direction2 =false;
					}
				}
				else if(direction2==false) {
					ball2.setY(ball2.getY()-1);
					if(ball2.getY() <= 450 && newHScore) {
						direction2 =true;
					}
				}
				
			
				
			}

			@Override
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		switch (pMenuItem.getID()) {
		case 1:
			MainActivity.getSharedInstance().setCurrentScene(
					new MainMenuScene());
			return true;
		default:
			break;
		}
		return false;
	}

}
