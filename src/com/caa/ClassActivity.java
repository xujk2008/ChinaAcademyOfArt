package com.caa;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ClassActivity extends Activity{

	private ImageView class_last_button, class_next_button;
	private ImageView class_begin;
	
	private View class_mask;
	private RelativeLayout class_dialog;
	private ImageView class_dialog_close;
	private ImageView class_dialog_begin, class_dialog_preview;
	
	private static boolean dialogShown = false;
	
	private static final int DURATION  = 1000, ALPHA_DURATION = 500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_class);
		
		class_last_button = (ImageView) findViewById(R.id.class_last_button);
		class_next_button = (ImageView) findViewById(R.id.class_next_button);
		
		class_begin = (ImageView) findViewById(R.id.class_begin);
		class_begin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog();
			}
			
		});
		
		class_mask = (View) findViewById(R.id.class_mask);
		class_dialog = (RelativeLayout) findViewById(R.id.class_dialog);
		class_dialog_close = (ImageView) findViewById(R.id.class_dialog_close);
		class_dialog_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				hideDialog();
			}
		});
		class_dialog_begin = (ImageView) findViewById(R.id.class_dialog_begin);
		class_dialog_preview = (ImageView) findViewById(R.id.class_dialog_preview);
	}

	private void showDialog()
	{
		dialogShown = true;
		class_mask.setVisibility(View.VISIBLE);
		class_dialog.setVisibility(View.VISIBLE);
		class_dialog_close.setVisibility(View.INVISIBLE);
		class_dialog_begin.setVisibility(View.INVISIBLE);
		class_dialog_preview.setVisibility(View.INVISIBLE);
		
		ScaleAnimation dialog_scaleAnim = new ScaleAnimation(0, 1.0f, 0, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		dialog_scaleAnim.setDuration(ALPHA_DURATION);
		dialog_scaleAnim.setFillAfter(true);
		dialog_scaleAnim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				class_dialog_close.setVisibility(View.VISIBLE);
				class_dialog_begin.setVisibility(View.VISIBLE);
				class_dialog_preview.setVisibility(View.VISIBLE);
				
				AlphaAnimation alphaAnim = new AlphaAnimation(0, 1.0f);
				alphaAnim.setDuration(DURATION);
				
				class_dialog_close.startAnimation(alphaAnim);
				class_dialog_begin.startAnimation(alphaAnim);
				class_dialog_preview.startAnimation(alphaAnim);
			}
		});
		
		class_dialog.startAnimation(dialog_scaleAnim);
	}
	
	private void hideDialog()
	{
		ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 0, 1.0f, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnim.setDuration(DURATION);
		scaleAnim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				dialogShown = false;
				class_dialog.setVisibility(View.INVISIBLE);
				class_mask.setVisibility(View.INVISIBLE);
			}
		});
		
		class_dialog.startAnimation(scaleAnim);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode)
		{
		case KeyEvent.KEYCODE_BACK:
			
			if(dialogShown)
			{
				hideDialog();
				
				return true;
			}
			
			break;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	
}
