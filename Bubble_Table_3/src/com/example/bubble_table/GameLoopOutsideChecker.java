package com.example.bubble_table;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;

public class GameLoopOutsideChecker implements ITimerCallback {

	@Override
	public void onTimePassed(TimerHandler pTimerHandler) {
		// Schaue ob Feuerball auﬂerhalb ist..
		for (int i = 0; i < GameScene.FireBalls.size(); i++) {
			if(GameScene.FireBalls.get(i).getX() - GameScene.MyBall.getX() > MainActivity.CAMERA_WIDTH) {
				GameScene.FireBalls.get(i).calc_new_vel();
			}
			else if(GameScene.FireBalls.get(i).getX() - GameScene.MyBall.getX() < -200) {
				GameScene.FireBalls.get(i).calc_new_vel();
			}
			if(GameScene.FireBalls.get(i).getY() - GameScene.MyBall.getY() >  MainActivity.CAMERA_HEIGHT) {
				GameScene.FireBalls.get(i).calc_new_vel();
			}
			else if(GameScene.FireBalls.get(i).getY() - GameScene.MyBall.getY() <  -200) {
				GameScene.FireBalls.get(i).calc_new_vel();
			}
		}
		for (int i = 0; i < GameScene.FlashBalls.size(); i++) {
			if(GameScene.FlashBalls.get(i).getX() - GameScene.MyBall.getX() > MainActivity.CAMERA_WIDTH) {
				GameScene.FlashBalls.get(i).calc_new_vel();
			}
			else if(GameScene.FlashBalls.get(i).getX() - GameScene.MyBall.getX() < -300) {
				GameScene.FlashBalls.get(i).calc_new_vel();
			}
			if(GameScene.FlashBalls.get(i).getY() - GameScene.MyBall.getY() >  MainActivity.CAMERA_HEIGHT) {
				GameScene.FlashBalls.get(i).calc_new_vel();
			}
			else if(GameScene.FlashBalls.get(i).getY() - GameScene.MyBall.getY() <  -300) {
				GameScene.FlashBalls.get(i).calc_new_vel();
			}
		}
		for (int i = 0; i < GameScene.PurpleBalls.size(); i++) {
			if(GameScene.PurpleBalls.get(i).getX() - GameScene.MyBall.getX() > MainActivity.CAMERA_WIDTH) {
				GameScene.PurpleBalls.get(i).calc_new_vel();
			}
			else if(GameScene.PurpleBalls.get(i).getX() - GameScene.MyBall.getX() < -400) {
				GameScene.PurpleBalls.get(i).calc_new_vel();
			}
			if(GameScene.PurpleBalls.get(i).getY() - GameScene.MyBall.getY() >  MainActivity.CAMERA_HEIGHT) {
				GameScene.PurpleBalls.get(i).calc_new_vel();
			}
			else if(GameScene.PurpleBalls.get(i).getY() - GameScene.MyBall.getY() <  -400) {
				GameScene.PurpleBalls.get(i).calc_new_vel();
			}
		}
		for (int i = 0; i < GameScene.AquaBalls.size(); i++) {
			if(GameScene.AquaBalls.get(i).getX() - GameScene.MyBall.getX() > MainActivity.CAMERA_WIDTH) {
				GameScene.AquaBalls.get(i).calc_new_vel();
			}
			else if(GameScene.AquaBalls.get(i).getX() - GameScene.MyBall.getX() < -500) {
				GameScene.AquaBalls.get(i).calc_new_vel();
			}
			if(GameScene.AquaBalls.get(i).getY() - GameScene.MyBall.getY() >  MainActivity.CAMERA_HEIGHT) {
				GameScene.AquaBalls.get(i).calc_new_vel();
			}
			else if(GameScene.AquaBalls.get(i).getY() - GameScene.MyBall.getY() <  -500) {
				GameScene.AquaBalls.get(i).calc_new_vel();
			}
		}
		if(GameScene.MyBall.getX()+GameScene.MyBall.getWidth()<0 || GameScene.MyBall.getX()-GameScene.MyBall.getWidth() > MainActivity.CAMERA_WIDTH) {
			//TODO: VERLOREN
			GameScene.backMusic.stop();
			GameScene.backMusic.release();
			GameScene.backMusic = null;
			MainActivity.getSharedInstance().setCurrentScene(new HighscoreScene());
		}
		if(GameScene.MyBall.getY()+GameScene.MyBall.getHeight()<0 || GameScene.MyBall.getY()-GameScene.MyBall.getHeight() > MainActivity.CAMERA_HEIGHT) {
			//TODO: VERLOREN
			GameScene.backMusic.stop();
			GameScene.backMusic.release();
			GameScene.backMusic = null;
			MainActivity.getSharedInstance().setCurrentScene(new HighscoreScene());
			
		}

	}
}
