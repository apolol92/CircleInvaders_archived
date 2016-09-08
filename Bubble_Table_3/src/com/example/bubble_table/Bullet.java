package com.example.bubble_table;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

public class Bullet extends AnimatedSprite {
	boolean active;

	public Bullet(float pX, float pY) {
		super(GameScene.MyBall.getX() + GameScene.MyBall.getWidth() / 2,
				GameScene.MyBall.getY() + GameScene.MyBall.getHeight() / 2, 15,
				15, MainActivity.getSharedInstance().bulletTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		this.animate(300);
		active = true;
		MoveModifier moveMod = new MoveModifier(0.5f, GameScene.MyBall.getX()
				+ GameScene.MyBall.getWidth() / 2, pX, GameScene.MyBall.getY()
				+ GameScene.MyBall.getHeight() / 2, pY) {
			
			@Override
			protected void onModifierStarted(IEntity pItem) {
				// TODO Auto-generated method stub
				super.onModifierStarted(pItem);
			}

			@Override
			protected void onModifierFinished(IEntity pItem) {
				// TODO Auto-generated method stub
				super.onModifierFinished(pItem);
				Bullet.this.setVisible(false);	
				//Bullet.this.detachSelf();
				active = false;

			}

			@Override
			protected void onManagedUpdate(float pSecondsElapsed, IEntity pItem) {
				// TODO Auto-generated method stub
				super.onManagedUpdate(pSecondsElapsed, pItem);
				//Wenn aktiv und wenn es eine Kugel berührt, wird diese zerstört..
				if (active) {
					for(int i = 0; i < GameScene.AquaBalls.size(); i++) {
						if(Bullet.this.collidesWith(GameScene.AquaBalls.get(i))) {
							GameScene.AquaBalls.get(i).setVisible(false);
							GameScene.physicsWorld.destroyBody(GameScene.AquaBalls.get(i).body);
							GameScene.AquaBalls.remove(i);
							active = false;
							Bullet.this.setVisible(false);		
							MainActivity.getSharedInstance().punkte+=3;
						}
					}
					for(int i = 0; i < GameScene.FireBalls.size(); i++) {
						if(Bullet.this.collidesWith(GameScene.FireBalls.get(i))) {
							GameScene.FireBalls.get(i).setVisible(false);
							GameScene.physicsWorld.destroyBody(GameScene.FireBalls.get(i).body);
							GameScene.FireBalls.remove(i);
							active = false;
							Bullet.this.setVisible(false);			
							MainActivity.getSharedInstance().punkte+=3;
						}
					}
					for(int i = 0; i < GameScene.FlashBalls.size(); i++) {
						if(Bullet.this.collidesWith(GameScene.FlashBalls.get(i))) {
							GameScene.FlashBalls.get(i).setVisible(false);
							GameScene.physicsWorld.destroyBody(GameScene.FlashBalls.get(i).body);
							GameScene.FlashBalls.remove(i);
							active = false;
							Bullet.this.setVisible(false);		
							MainActivity.getSharedInstance().punkte+=3;
						}
					}
					for(int i = 0; i < GameScene.PurpleBalls.size(); i++) {
						if(Bullet.this.collidesWith(GameScene.PurpleBalls.get(i))) {
							GameScene.PurpleBalls.get(i).setVisible(false);
							GameScene.physicsWorld.destroyBody(GameScene.PurpleBalls.get(i).body);
							GameScene.PurpleBalls.remove(i);
							active = false;
							Bullet.this.setVisible(false);		
							MainActivity.getSharedInstance().punkte+=3;
						}
					}
				}			

			}

		};
		this.registerEntityModifier(moveMod);
		
	}

}
