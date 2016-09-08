package com.example.bubble_table;

import org.andengine.engine.handler.IUpdateHandler;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.text.Text;

import android.R.anim;

public class HowToScene extends MenuScene implements IOnMenuItemClickListener {
	int counter = 0;
	Text howText;
	
	AnimatedSprite animation;

	public HowToScene() {
		super(MainActivity.getSharedInstance().mCamera);

		this.registerUpdateHandler(new IUpdateHandler() {

			@Override
			public void onUpdate(float pSecondsElapsed) {
				switch (counter) {
				case 0:
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"This is your ball..", MainActivity
									.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//animation
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().kugelGruenTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 300:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"You can move it with your Motion sensors..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//animation
					break;
				case 600:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"BUT.. DON'T move it out of screen..", MainActivity
									.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					break;
				case 900:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"You can get points(+5) by collecting stars.",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().sternTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 1200:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"You only have a limited time for it.\nYou can see your 'remaining time' in the top\nleft corner.",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					break;
				case 1500:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"You can increase your remaining time\nby collecting watches.",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().uhrTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(200);
					break;
				case 1800:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"Be careful..", MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					animation.setVisible(false);
					animation.detachSelf();
					break;
				case 2100:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"There are other balls..", MainActivity
									.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);

					break;
				case 2400:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"They want to kick you out of screen..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					break;
				case 2700:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"Fireballs kick you..", MainActivity
									.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().kugelRotTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 3000:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"Aquaballs kick stronger and\nslow you a little bit..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().kugelAquaTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 3300:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"Flashballs kick you and decrease\nyour points by 1..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().kugelGelbTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 3600:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"Purpleballs kick you and decrease\nyour remaining time by 2..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().kugelLilaTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 3900:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"You can shoot on balls to decrease\ntheir number and earn also points(2).\nBut you have to collect ammo..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().bulletTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					animation.animate(400);
					break;
				case 4200:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"If there too many balls, you can\nuse shields to be save for a while..",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					
					animation.setVisible(false);
					animation.detachSelf();
					animation = new AnimatedSprite(
							MainActivity.CAMERA_WIDTH / 2 - 25,
							howText.getHeight() + 10,
							MainActivity.getSharedInstance().ShieldTextureRegion,
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(animation);
					
					break;
				case 4500:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(
							0,
							0,
							MainActivity.getSharedInstance().mFont,
							"I will try to add more and more\nfeatures over the time :*",
							MainActivity.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					//Animation
					animation.setVisible(false);
					animation.detachSelf();
					break;
				case 4800:
					howText.setVisible(false);
					howText.detachSelf();
					howText = new Text(0, 0,
							MainActivity.getSharedInstance().mFont,
							"And now have fun :)", MainActivity
									.getSharedInstance()
									.getVertexBufferObjectManager());
					HowToScene.this.attachChild(howText);
					break;
				}

				counter++;
			}

			@Override
			public void reset() {
				// TODO Auto-generated method stub

			}

		});

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
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
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
