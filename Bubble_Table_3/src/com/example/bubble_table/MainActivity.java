package com.example.bubble_table;

import java.io.IOException;
import java.util.Random;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.view.RenderSurfaceView;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;



import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends SimpleBaseGameActivity {
	// Gameconfig Konstanden & Variablen
	public static int CAMERA_WIDTH = 480;
	public static int CAMERA_HEIGHT = 800;
	public static Camera mCamera;
	public static Scene mCurrentScene;
	public static Scene mOldScene;
	public static MainActivity instance;
	public static Random rndGenerator = new Random();
	public Font mFont;
	public Sound klick;
	




	// KugelGruenAnimation
	public BitmapTextureAtlas kugelGruenTexture;
	public TiledTextureRegion kugelGruenTextureRegion;

	// KugelGelbAnimation
	public BitmapTextureAtlas kugelGelbTexture;
	public TiledTextureRegion kugelGelbTextureRegion;

	// KugelLilaAnimation
	public BitmapTextureAtlas kugelLilaTexture;
	public TiledTextureRegion kugelLilaTextureRegion;

	// KugelLilaAnimation
	public BitmapTextureAtlas kugelAquaTexture;
	public TiledTextureRegion kugelAquaTextureRegion;

	// Spielvariablen
	public int punkte, remaining_time, level;
	public boolean played = false;

	public void loadkugelGruenTexture() {
		kugelGruenTexture = new BitmapTextureAtlas(getTextureManager(), 150, 50);
		kugelGruenTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(kugelGruenTexture, getAssets(),
						"KugelGruenAnimation.png", 0, 0, 3, 1);
		kugelGruenTexture.load();
	}

	public void unloadkugelGruenTexture() {
		kugelGruenTexture.unload();
	}

	// kugelRotAnimation
	public BitmapTextureAtlas kugelRotTexture;
	public TiledTextureRegion kugelRotTextureRegion;

	public void loadkugelRotTexture() {
		kugelRotTexture = new BitmapTextureAtlas(getTextureManager(), 150, 50);
		kugelRotTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(kugelRotTexture, getAssets(),
						"KugelRotAnimation.png", 0, 0, 3, 1);
		kugelRotTexture.load();
	}

	public void unloadkugelRotTexture() {
		kugelRotTexture.unload();
	}

	public void loadkugelGelbTexture() {
		kugelGelbTexture = new BitmapTextureAtlas(getTextureManager(), 150, 50);
		kugelGelbTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(kugelGelbTexture, getAssets(),
						"KugelGelbAnimation.png", 0, 0, 3, 1);
		kugelGelbTexture.load();
	}

	public void unloadkugelGelbTexture() {
		kugelRotTexture.unload();
	}

	public void loadkugelLilaTexture() {
		kugelLilaTexture = new BitmapTextureAtlas(getTextureManager(), 150, 50);
		kugelLilaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(kugelLilaTexture, getAssets(),
						"KugelLilaAnimation.png", 0, 0, 3, 1);
		kugelLilaTexture.load();
	}

	public void unloadkugelLilaTexture() {
		kugelRotTexture.unload();
	}

	public void loadkugelAquaTexture() {
		kugelAquaTexture = new BitmapTextureAtlas(getTextureManager(), 150, 50);
		kugelAquaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(kugelAquaTexture, getAssets(),
						"KugelAquaAnimation.png", 0, 0, 3, 1);
		kugelAquaTexture.load();
	}

	public void unloadkugelAquaTexture() {
		kugelAquaTexture.unload();
	}

	// uhrAnimation
	public BitmapTextureAtlas uhrTexture;
	public TiledTextureRegion uhrTextureRegion;

	public void loadUhrTexture() {
		uhrTexture = new BitmapTextureAtlas(getTextureManager(), 240, 30);
		uhrTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(uhrTexture, getAssets(),
						"UhrAnimation.png", 0, 0, 8, 1);
		uhrTexture.load();
	}

	public void unloadUhrTexture() {
		uhrTexture.unload();
	}

	// sternAnimation
	public BitmapTextureAtlas sternTexture;
	public TiledTextureRegion sternTextureRegion;

	public void loadSternTexture() {
		sternTexture = new BitmapTextureAtlas(getTextureManager(), 160, 40);
		sternTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(sternTexture, getAssets(), "stern2.png",
						0, 0, 4, 1);
		sternTexture.load();
	}

	public void unloadSternTexture() {
		sternTexture.unload();
	}

	// bulletAnimation
	public BitmapTextureAtlas bulletTexture;
	public TiledTextureRegion bulletTextureRegion;

	public void loadbulletTexture() {
		bulletTexture = new BitmapTextureAtlas(getTextureManager(), 75, 15);
		bulletTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(bulletTexture, getAssets(), "Bullet.png",
						0, 0, 5, 1);
		bulletTexture.load();
	}

	public void unloadbulletTexture() {
		bulletTexture.unload();
	}

	// ShieldAnimation
	public BitmapTextureAtlas ShieldTexture;
	public TiledTextureRegion ShieldTextureRegion;

	public void loadShieldTexture() {
		ShieldTexture = new BitmapTextureAtlas(getTextureManager(), 80, 80);
		ShieldTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(ShieldTexture, getAssets(), "Shield.png",
						0, 0, 1, 1);
		ShieldTexture.load();
	}

	public void unloadShieldTexture() {
		ShieldTexture.unload();
	}

	@Override
	public EngineOptions onCreateEngineOptions() {
		instance = this;
		mCamera = new Camera(0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engineOptions = new EngineOptions(true,
				ScreenOrientation.PORTRAIT_FIXED, new FillResolutionPolicy(),
				mCamera);
		// Sounds erlauben
		engineOptions.getAudioOptions().setNeedsSound(true);
		engineOptions.getAudioOptions().setNeedsMusic(true);
		return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		loadkugelGruenTexture();
		loadkugelRotTexture();
		loadkugelGelbTexture();
		loadkugelLilaTexture();
		loadkugelAquaTexture();
		loadUhrTexture();
		loadSternTexture();
		loadbulletTexture();
		loadShieldTexture();

		mFont = FontFactory.createFromAsset(this.getFontManager(),
				this.getTextureManager(), 256, 256, this.getAssets(),
				"fonts/GameFont.ttf", 24, true, android.graphics.Color.WHITE);
		mFont.load();

		try {

			this.klick = SoundFactory.createSoundFromAsset(getSoundManager(),
					this, "sounds/klick.mp3");

		} catch (IOException ex) {

		}
		

	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		mCurrentScene = new MainMenuScene();
		return mCurrentScene;
	}

	public static MainActivity getSharedInstance() {
		return instance;
	}

	public void setCurrentScene(Scene scene) {
		mOldScene = mCurrentScene;
		mCurrentScene = scene;
		getEngine().setScene(mCurrentScene);
	}

	@Override
	public synchronized void onGameDestroyed() {
		// TODO Auto-generated method stub
		super.onGameDestroyed();
		unloadkugelGruenTexture();
		unloadkugelAquaTexture();
		unloadkugelGelbTexture();
		unloadkugelLilaTexture();
		unloadkugelRotTexture();
		unloadSternTexture();
		unloadUhrTexture();
		unloadbulletTexture();
		unloadShieldTexture();
		klick = null;
		mFont.unload();
		

		this.finish();

	}
	


}
