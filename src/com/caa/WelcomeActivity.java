package com.caa;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.caa.common.Utils;

public class WelcomeActivity extends Activity{

	private ImageView welcome_button;
	private RelativeLayout welcome_sign1, welcome_sign2, welcome_sign3;
	private ImageView welcome_text1, welcome_text2, welcome_text3;
	private RelativeLayout welcome_sign4, welcome_sign5, welcome_sign6, welcome_sign7;
	private ImageView welcome_text4, welcome_text5, welcome_text6, welcome_text7;
	private ImageView welcome_text_1, welcome_text_2, welcome_text_3;
	
	private static final int SCALE_DURATION = 260, SIGN_TRANSLATE_DURATION = 650, TEXT_TRANSLATE_DURATION = 500;
	
	private static boolean showAnim = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		welcome_button = (ImageView) findViewById(R.id.welcome_button);
		
		welcome_sign1 = (RelativeLayout) findViewById(R.id.welcome_sign1);
		welcome_sign2 = (RelativeLayout) findViewById(R.id.welcome_sign2);
		welcome_sign3 = (RelativeLayout) findViewById(R.id.welcome_sign3);
		welcome_text1 = (ImageView) findViewById(R.id.welcome_text1);
		welcome_text2 = (ImageView) findViewById(R.id.welcome_text2);
		welcome_text3 = (ImageView) findViewById(R.id.welcome_text3);
		
		welcome_sign4 = (RelativeLayout) findViewById(R.id.welcome_sign4);
		welcome_sign5 = (RelativeLayout) findViewById(R.id.welcome_sign5);
		welcome_sign6 = (RelativeLayout) findViewById(R.id.welcome_sign6);
		welcome_sign7 = (RelativeLayout) findViewById(R.id.welcome_sign7);
		welcome_text4 = (ImageView) findViewById(R.id.welcome_text4);
		welcome_text5 = (ImageView) findViewById(R.id.welcome_text5);
		welcome_text6 = (ImageView) findViewById(R.id.welcome_text6);
		welcome_text7 = (ImageView) findViewById(R.id.welcome_text7);
		
		welcome_text_1 = (ImageView) findViewById(R.id.welcome_text_1);
		welcome_text_2 = (ImageView) findViewById(R.id.welcome_text_2);
		welcome_text_3 = (ImageView) findViewById(R.id.welcome_text_3);
	}

	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		initAnim();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		showAnim = true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		showAnim = false;
	}

	private void initAnim()
	{
		DisplayMetrics dm = new DisplayMetrics();
		(WelcomeActivity.this).getWindowManager().getDefaultDisplay().getMetrics(dm);
		dm = WelcomeActivity.this.getApplicationContext().getResources()
				.getDisplayMetrics();
		Utils.screenWidth = dm.widthPixels;
		Utils.screenHeight = dm.heightPixels;
		Utils.density = dm.density;
		
		if(!showAnim)
		{
			return;
		}
		
		welcome_text_3.setVisibility(View.INVISIBLE);
		int[] text_coords3 = {0, 0};
		welcome_text_3.getLocationOnScreen(text_coords3);
		final TranslateAnimation textTranslate3 = new TranslateAnimation(text_coords3[1], 0, 0, 0);
		textTranslate3.setDuration(TEXT_TRANSLATE_DURATION);
		textTranslate3.setInterpolator(new OvershootInterpolator());
		
		welcome_text_2.setVisibility(View.INVISIBLE);
		int[] text_coords2 = {0, 0};
		welcome_text_2.getLocationOnScreen(text_coords2);
		final TranslateAnimation textTranslate2 = new TranslateAnimation(text_coords2[1], 0, 0, 0);
		textTranslate2.setDuration(TEXT_TRANSLATE_DURATION);
		textTranslate2.setInterpolator(new OvershootInterpolator());
		textTranslate2.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text_3.setVisibility(View.VISIBLE);
				welcome_text_3.startAnimation(textTranslate3);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_text_1.setVisibility(View.INVISIBLE);
		int[] text_coords1 = {0, 0};
		welcome_text_1.getLocationOnScreen(text_coords1);
		final TranslateAnimation textTranslate1 = new TranslateAnimation(text_coords1[1], 0, 0, 0);
		textTranslate1.setDuration(TEXT_TRANSLATE_DURATION);
		textTranslate1.setInterpolator(new OvershootInterpolator());
		textTranslate1.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text_2.setVisibility(View.VISIBLE);
				welcome_text_2.startAnimation(textTranslate2);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_sign7.setVisibility(View.INVISIBLE);
		welcome_text7.setVisibility(View.GONE);
		final ScaleAnimation signScale7 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale7.setDuration(SCALE_DURATION);
		signScale7.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text_1.setVisibility(View.VISIBLE);
				welcome_text_1.startAnimation(textTranslate1);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords7 = {0, 0};
		welcome_sign7.getLocationOnScreen(coords7);
		final TranslateAnimation signTranslate7 = new TranslateAnimation(0, 0, -coords7[0], 0);
		signTranslate7.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate7.setInterpolator(new BounceInterpolator());
		signTranslate7.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text7.setVisibility(View.VISIBLE);
				welcome_text7.startAnimation(signScale7);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_sign6.setVisibility(View.INVISIBLE);
		welcome_text6.setVisibility(View.GONE);
		final ScaleAnimation signScale6 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale6.setDuration(SCALE_DURATION);
		signScale6.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_sign7.setVisibility(View.VISIBLE);
				welcome_sign7.startAnimation(signTranslate7);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords6 = {0, 0};
		welcome_sign6.getLocationOnScreen(coords6);
		final TranslateAnimation signTranslate6 = new TranslateAnimation(0, 0, -coords6[0], 0);
		signTranslate6.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate6.setInterpolator(new BounceInterpolator());
		signTranslate6.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text6.setVisibility(View.VISIBLE);
				welcome_text6.startAnimation(signScale6);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_sign5.setVisibility(View.INVISIBLE);
		welcome_text5.setVisibility(View.GONE);
		final ScaleAnimation signScale5 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale5.setDuration(SCALE_DURATION);
		signScale5.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_sign6.setVisibility(View.VISIBLE);
				welcome_sign6.startAnimation(signTranslate6);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords5 = {0, 0};
		welcome_sign5.getLocationOnScreen(coords5);
		final TranslateAnimation signTranslate5 = new TranslateAnimation(0, 0, -coords5[0], 0);
		signTranslate5.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate5.setInterpolator(new BounceInterpolator());
		signTranslate5.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text5.setVisibility(View.VISIBLE);
				welcome_text5.startAnimation(signScale5);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_sign4.setVisibility(View.INVISIBLE);
		welcome_text4.setVisibility(View.GONE);
		final ScaleAnimation signScale4 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale4.setDuration(SCALE_DURATION);
		signScale4.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_sign5.setVisibility(View.VISIBLE);
				welcome_sign5.startAnimation(signTranslate5);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords4 = {0, 0};
		welcome_sign4.getLocationOnScreen(coords4);
		final TranslateAnimation signTranslate4 = new TranslateAnimation(0, 0, -coords4[0], 0);
		signTranslate4.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate4.setInterpolator(new BounceInterpolator());
		signTranslate4.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text4.setVisibility(View.VISIBLE);
				welcome_text4.startAnimation(signScale4);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});

		welcome_sign3.setVisibility(View.INVISIBLE);
		welcome_text3.setVisibility(View.GONE);
		final ScaleAnimation signScale3 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale3.setDuration(SCALE_DURATION);
		signScale3.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_sign4.setVisibility(View.VISIBLE);
				welcome_sign4.startAnimation(signTranslate4);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords3 = {0, 0};
		welcome_sign3.getLocationOnScreen(coords3);
		final TranslateAnimation signTranslate3 = new TranslateAnimation(0, 0, -coords3[0], 0);
		signTranslate3.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate3.setInterpolator(new BounceInterpolator());
		signTranslate3.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text3.setVisibility(View.VISIBLE);
				welcome_text3.startAnimation(signScale3);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_sign2.setVisibility(View.INVISIBLE);
		welcome_text2.setVisibility(View.GONE);
		final ScaleAnimation signScale2 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale2.setDuration(SCALE_DURATION);
		signScale2.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_sign3.setVisibility(View.VISIBLE);
				welcome_sign3.startAnimation(signTranslate3);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords2 = {0, 0};
		welcome_sign2.getLocationOnScreen(coords2);
		final TranslateAnimation signTranslate2 = new TranslateAnimation(0, 0, -coords2[0], 0);
		signTranslate2.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate2.setInterpolator(new BounceInterpolator());
		signTranslate2.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text2.setVisibility(View.VISIBLE);
				welcome_text2.startAnimation(signScale2);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		welcome_text1.setVisibility(View.GONE);
		final ScaleAnimation signScale1 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		signScale1.setDuration(SCALE_DURATION);
		signScale1.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_sign2.setVisibility(View.VISIBLE);
				welcome_sign2.startAnimation(signTranslate2);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] coords1 = {0, 0};
		welcome_sign1.getLocationOnScreen(coords1);
		TranslateAnimation signTranslate1 = new TranslateAnimation(0, 0, -coords1[0], 0);
		signTranslate1.setDuration(SIGN_TRANSLATE_DURATION);
		signTranslate1.setInterpolator(new BounceInterpolator());
		signTranslate1.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				welcome_text1.setVisibility(View.VISIBLE);
				welcome_text1.startAnimation(signScale1);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		welcome_sign1.startAnimation(signTranslate1);
	}
}
