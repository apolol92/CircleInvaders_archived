package com.example.bubble_table;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Uhr extends AnimatedSprite {

	public Uhr(float pX, float pY) {
		super(pX, pY, 30, 30,
				MainActivity.getSharedInstance().uhrTextureRegion, MainActivity
						.getSharedInstance().getVertexBufferObjectManager());
		this.animate(400);
	}

}
