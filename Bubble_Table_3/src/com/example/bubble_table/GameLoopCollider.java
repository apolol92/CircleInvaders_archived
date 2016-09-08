package com.example.bubble_table;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;

public class GameLoopCollider implements ITimerCallback {
	int timerShield = 0;
	@Override
	public void onTimePassed(TimerHandler pTimerHandler) {
		// Wenn MyBall mit Uhr kollidiert
		if (GameScene.MyBall.collidesWith(GameScene.uhr)
				&& GameScene.uhr.isVisible()) {
			MainActivity.getSharedInstance().remaining_time += 23; // Mehr Zeit
			GameScene.uhr.setVisible(false);
		}
		// Wenn MyBall mit ammoBullet kollidiert.. MEHR MUNI
		if (GameScene.MyBall.collidesWith(GameScene.ammoBullet)
				&& GameScene.ammoBullet.isVisible()) {
			GameScene.MyBall.ammo+=MainActivity.rndGenerator.nextInt(5)+1;
			GameScene.ammoBullet.setVisible(false);
		}
		// Wenn MyBall mit ammoBullet kollidiert.. MEHR MUNI
		if (GameScene.MyBall.collidesWith(GameScene.shieldActivator)
						&& GameScene.shieldActivator.isVisible()) {
			GameScene.MyBall.PlayerShield.setVisible(true);
			GameScene.shieldActivator.setVisible(false);
			timerShield=150;
		}
				
		if (GameScene.MyStars.size() < 1) {
			for (int i = 0; i < MainActivity.rndGenerator.nextInt(5) + 1; i++) {
				GameScene.MyStars.add(new Stern());
				MainActivity.getSharedInstance().mCurrentScene
						.attachChild(GameScene.MyStars.get(i));
			}
		}
		for (int i = 0; i < GameScene.MyStars.size(); i++) {
			if (GameScene.MyStars.get(i).collidesWith(GameScene.MyBall)) {
				// Mehr Punkte
				MainActivity.getSharedInstance().punkte += 5;
				// Diesen Stern entfernen
				GameScene.MyStars.get(i).setVisible(false);
				MainActivity.getSharedInstance().mCurrentScene
						.detachChild(GameScene.MyStars.get(i));
				GameScene.MyStars.remove(i);

			}
			
		}
		
		for(int i = 0; i < GameScene.AquaBalls.size(); i++) {
			if(GameScene.MyBall.PlayerShield.collidesWith(GameScene.AquaBalls.get(i))&&GameScene.MyBall.PlayerShield.isVisible()) {
				GameScene.AquaBalls.get(i).body.setLinearVelocity(-GameScene.AquaBalls.get(i).body.getLinearVelocity().x, -GameScene.AquaBalls.get(i).body.getLinearVelocity().y);
			}
		}
		for(int i = 0; i < GameScene.FireBalls.size(); i++) {
			if(GameScene.MyBall.PlayerShield.collidesWith(GameScene.FireBalls.get(i))&&GameScene.MyBall.PlayerShield.isVisible()) {
				GameScene.FireBalls.get(i).body.setLinearVelocity(-GameScene.FireBalls.get(i).body.getLinearVelocity().x, -GameScene.FireBalls.get(i).body.getLinearVelocity().y);
			}
		}
		for(int i = 0; i < GameScene.FlashBalls.size(); i++) {
			if(GameScene.MyBall.PlayerShield.collidesWith(GameScene.FlashBalls.get(i))&&GameScene.MyBall.PlayerShield.isVisible()) {
				GameScene.FlashBalls.get(i).body.setLinearVelocity(-GameScene.FlashBalls.get(i).body.getLinearVelocity().x, -GameScene.FlashBalls.get(i).body.getLinearVelocity().y);
			}
		}
		for(int i = 0; i < GameScene.PurpleBalls.size(); i++) {
			if(GameScene.MyBall.PlayerShield.collidesWith(GameScene.PurpleBalls.get(i))&&GameScene.MyBall.PlayerShield.isVisible()) {
				GameScene.PurpleBalls.get(i).body.setLinearVelocity(-GameScene.PurpleBalls.get(i).body.getLinearVelocity().x, -GameScene.PurpleBalls.get(i).body.getLinearVelocity().y);
			}
		}
		
		
		
		//Shield managen
		GameScene.MyBall.PlayerShield.setPosition(GameScene.MyBall.getX()-15f, GameScene.MyBall.getY()-15f);
		if(timerShield>0) {
			timerShield--;
		}
		else {
			GameScene.MyBall.PlayerShield.setVisible(false);
		}
		//------------------------
		

	}
}
