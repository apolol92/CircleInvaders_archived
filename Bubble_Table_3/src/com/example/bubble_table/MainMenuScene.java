package com.example.bubble_table;


import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.andengine.entity.sprite.AnimatedSprite;




public class MainMenuScene extends MenuScene implements
		IOnMenuItemClickListener {
	final int MENU_START = 0, MENU_HIGHSCORE = 1, MENU_HOWTO = 2;
	
	void createBackground() {
		AnimatedSprite ball1 = new AnimatedSprite(MainActivity.getSharedInstance().CAMERA_WIDTH/2+100,  MainActivity.CAMERA_HEIGHT/2, 25, 25,
				MainActivity.getSharedInstance().kugelAquaTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		ball1.animate(300);
		this.attachChild(ball1);
		AnimatedSprite ball2 = new AnimatedSprite(MainActivity.getSharedInstance().CAMERA_WIDTH/2-125, MainActivity.CAMERA_HEIGHT/2, 25, 25,
				MainActivity.getSharedInstance().kugelAquaTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		ball2.animate(300);
		this.attachChild(ball2);
		AnimatedSprite ball3 = new AnimatedSprite(MainActivity.getSharedInstance().CAMERA_WIDTH/2+100,  MainActivity.CAMERA_HEIGHT/2-25, 25, 25,
				MainActivity.getSharedInstance().kugelGruenTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		ball3.animate(300);
		this.attachChild(ball3);
		AnimatedSprite ball4 = new AnimatedSprite(MainActivity.getSharedInstance().CAMERA_WIDTH/2-125,  MainActivity.CAMERA_HEIGHT/2-25, 25, 25,
				MainActivity.getSharedInstance().kugelGruenTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		ball4.animate(300);
		this.attachChild(ball4);
		AnimatedSprite ball5 = new AnimatedSprite(MainActivity.getSharedInstance().CAMERA_WIDTH/2+100,  MainActivity.CAMERA_HEIGHT/2+25, 25, 25,
				MainActivity.getSharedInstance().kugelGruenTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		ball5.animate(300);
		this.attachChild(ball5);
		AnimatedSprite ball6 = new AnimatedSprite(MainActivity.getSharedInstance().CAMERA_WIDTH/2-125,  MainActivity.CAMERA_HEIGHT/2+25, 25, 25,
				MainActivity.getSharedInstance().kugelGruenTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		ball6.animate(300);
		this.attachChild(ball6);
	}
	
	
	
	public MainMenuScene() {
		super(MainActivity.getSharedInstance().mCamera);
		createBackground();
		IMenuItem startButton = new TextMenuItem(MENU_START,
				MainActivity.getSharedInstance().mFont, "Start Game",
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		startButton.setPosition(
				MainActivity.getSharedInstance().mCamera.getWidth() / 2
						- startButton.getWidth() / 2,
				MainActivity.CAMERA_HEIGHT / 2 - startButton.getHeight());
		addMenuItem(startButton);
		IMenuItem highscoreButton = new TextMenuItem(MENU_HIGHSCORE,
				MainActivity.getSharedInstance().mFont, "Highscore",
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		highscoreButton.setPosition(
				MainActivity.getSharedInstance().mCamera.getWidth() / 2
						- highscoreButton.getWidth() / 2,
				MainActivity.CAMERA_HEIGHT / 2);
		addMenuItem(highscoreButton);
		IMenuItem HowToButton = new TextMenuItem(MENU_HOWTO,
				MainActivity.getSharedInstance().mFont, "How to play",
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		HowToButton.setPosition(
				MainActivity.getSharedInstance().mCamera.getWidth() / 2
						- HowToButton.getWidth() / 2,
				MainActivity.CAMERA_HEIGHT / 2 + HowToButton.getHeight());
		addMenuItem(HowToButton);
		setOnMenuItemClickListener(this);
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		switch (pMenuItem.getID()) {
		case MENU_START:
			// TODO: STOP UPDATER
			MainActivity.getSharedInstance().setCurrentScene(new GameScene());
			return true;
		case MENU_HIGHSCORE:
			// TODO: STOP UPDATER
			MainActivity.getSharedInstance().setCurrentScene(
					new HighscoreScene());
			return true;
		case MENU_HOWTO:
			// TODO: STOP UPDATER
			MainActivity.getSharedInstance().setCurrentScene(new HowToScene());
			return true;
		default:
			break;
		}
		return false;
	}
}