package com.example.bubble_table;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Stern extends AnimatedSprite{

	public Stern() {
		super(MainActivity.rndGenerator.nextInt(MainActivity.CAMERA_WIDTH-40), MainActivity.rndGenerator.nextInt(MainActivity.CAMERA_HEIGHT-40), 40, 40, MainActivity.getSharedInstance().sternTextureRegion, MainActivity.getSharedInstance().getVertexBufferObjectManager());
		this.animate(300 + MainActivity.rndGenerator.nextInt(600));
	}

}
