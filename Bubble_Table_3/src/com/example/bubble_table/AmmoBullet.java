package com.example.bubble_table;

import org.andengine.entity.sprite.AnimatedSprite;

public class AmmoBullet extends AnimatedSprite{

	public AmmoBullet(float pX, float pY) {
		super(pX, pY, 20, 20, MainActivity.getSharedInstance().bulletTextureRegion, MainActivity.getSharedInstance().getVertexBufferObjectManager());
		this.animate(400);
	}

}
