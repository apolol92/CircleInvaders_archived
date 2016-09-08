package com.example.bubble_table;


import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Splash extends Activity {
	AdView adView;
	TextView clickText;
	Thread timer;
	@Override
	protected void onCreate(Bundle b) {
		// TODO Auto-generated method stub
		super.onCreate(b);
		setContentView(R.layout.splash);
		//Hintergrundfarbe
		View view = this.getWindow().getDecorView();
	    view.setBackgroundColor(Color.BLACK);
	    
	    clickText = (TextView)findViewById(R.id.textView1);
	    clickText.setTextColor(Color.WHITE);
	    clickText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Splash.this, MainActivity.class);
				startActivity(intent);
			}
		});
	
		
		adView = (AdView)findViewById(R.id.ad);
		adView.loadAd(new AdRequest());
		

		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// ourSong.release();
		finish();
	}



}