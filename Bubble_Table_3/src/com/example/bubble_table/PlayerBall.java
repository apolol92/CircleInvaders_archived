package com.example.bubble_table;

import org.andengine.entity.sprite.AnimatedSprite;

import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class PlayerBall extends AnimatedSprite {
	Body body;
	public int ammo;
	AnimatedSprite PlayerShield;

	public PlayerBall(float pX, float pY) {
		super(pX, pY, 50, 50,
				MainActivity.getSharedInstance().kugelGruenTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		this.animate(400);
		ammo = 0;
		PlayerShield = new AnimatedSprite(pX - 25f, pY - 25f, 100, 100,
				MainActivity.getSharedInstance().ShieldTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		PlayerShield.setVisible(false);

		body = PhysicsFactory.createCircleBody(GameScene.physicsWorld, this,
				BodyType.DynamicBody,
				PhysicsFactory.createFixtureDef(0f, 1f, 0));
		GameScene.physicsWorld.registerPhysicsConnector(new PhysicsConnector(
				this, body));
		GameScene.physicsWorld.setContactListener(new ContactListener() {

			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {

			}

			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				MainActivity.getSharedInstance().klick.play();
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				for (int i = 0; i < GameScene.FlashBalls.size(); i++) {
					if (contact.getFixtureA().getBody()
							.equals(GameScene.FlashBalls.get(i).body)
							&& contact.getFixtureB().getBody()
									.equals(PlayerBall.this.body)) {
						// Minus Punkte
						MainActivity.getSharedInstance().punkte--;

					} else if (contact.getFixtureB().getBody()
							.equals(GameScene.FlashBalls.get(i).body)
							&& contact.getFixtureA().getBody()
									.equals(PlayerBall.this.body)) {
						// Minus Punkte
						MainActivity.getSharedInstance().punkte--;

					}
				}
				for (int i = 0; i < GameScene.PurpleBalls.size(); i++) {
					if (contact.getFixtureA().getBody()
							.equals(GameScene.PurpleBalls.get(i).body)
							&& contact.getFixtureB().getBody()
									.equals(PlayerBall.this.body)) {
						// Minus Zeit
						MainActivity.getSharedInstance().remaining_time--;

					} else if (contact.getFixtureB().getBody()
							.equals(GameScene.PurpleBalls.get(i).body)
							&& contact.getFixtureA().getBody()
									.equals(PlayerBall.this.body)) {
						// Minus Zeit
						MainActivity.getSharedInstance().remaining_time--;

					}
				}

			}

			@Override
			public void endContact(Contact contact) {
				// TODO Auto-generated method stub
				for (int i = 0; i < GameScene.AquaBalls.size(); i++) {

					if (contact.getFixtureA().getBody()
							.equals(GameScene.AquaBalls.get(i).body)
							&& contact.getFixtureB().getBody()
									.equals(PlayerBall.this.body)) {
						// Verlangsame Geschwindigkeit
						PlayerBall.this.body.setLinearVelocity(0, 0);

					} else if (contact.getFixtureB().getBody()
							.equals(GameScene.AquaBalls.get(i).body)
							&& contact.getFixtureA().getBody()
									.equals(PlayerBall.this.body)) {
						// Verlangsame Geschwindigkeit
						PlayerBall.this.body.setLinearVelocity(
								PlayerBall.this.body.getLinearVelocity().x
										+ PlayerBall.this.body
												.getLinearVelocity().x
										/ -PlayerBall.this.body
												.getLinearVelocity().x,
								PlayerBall.this.body.getLinearVelocity().y
										+ PlayerBall.this.body
												.getLinearVelocity().y
										/ -PlayerBall.this.body
												.getLinearVelocity().y);

					}
				}
			}

			@Override
			public void beginContact(Contact contact) {

			}
		});

	}

}
