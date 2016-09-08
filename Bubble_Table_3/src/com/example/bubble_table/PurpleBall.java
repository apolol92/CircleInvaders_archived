package com.example.bubble_table;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class PurpleBall extends AnimatedSprite {
	Body body;
	public float xVel, yVel;


	public PurpleBall() {
		super(-100, -100, MainActivity.rndGenerator.nextInt(30) + 20,
				MainActivity.rndGenerator.nextInt(30) + 20, MainActivity
						.getSharedInstance().kugelLilaTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		float rndSize = MainActivity.rndGenerator.nextInt(30) + 20;
		this.setWidth(rndSize);
		this.setHeight(rndSize);
		// Position setzen X
		if (MainActivity.rndGenerator.nextInt(2) == 1) {
			this.setX(-MainActivity.rndGenerator.nextInt(200) - 50);
		} else {
			this.setX(MainActivity.rndGenerator.nextInt(200) + MainActivity.CAMERA_WIDTH);
		}
		// Position setzen Y
		if (MainActivity.rndGenerator.nextInt(2) == 1) {
			this.setY(-MainActivity.rndGenerator.nextInt(200) - 50);
		} else {
			this.setY(MainActivity.rndGenerator.nextInt(200) + MainActivity.CAMERA_HEIGHT);
		}
		this.animate(400);
		body = PhysicsFactory.createCircleBody(GameScene.physicsWorld, this,
				BodyType.DynamicBody,
				PhysicsFactory.createFixtureDef(0f, 1.5f, 0));
		calc_new_vel();
		GameScene.physicsWorld.registerPhysicsConnector(new PhysicsConnector(
				this, body));

	}

	void calc_new_vel() {
		xVel = GameScene.MyBall.getX() - this.getX()+ MainActivity.rndGenerator.nextFloat()+ MainActivity.rndGenerator.nextInt(100);
		xVel /= 50;
		yVel = GameScene.MyBall.getY() - this.getY() + MainActivity.rndGenerator.nextFloat()+ MainActivity.rndGenerator.nextInt(100);
		yVel /= 50;
		body.setLinearVelocity(xVel, yVel);

	}
}
