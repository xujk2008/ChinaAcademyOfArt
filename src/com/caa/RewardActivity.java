package com.caa;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.caa.common.Utils;

public class RewardActivity extends Activity{

	private View reward_mask;
	private RelativeLayout reward_dialog_layout;
	private ImageView reward_dialog_avatar_light;
	private ImageView reward_dialog_layout_background;
	private ImageView reward_dialog_layout_close;
	private LinearLayout reward_grey_star_layout;
	private ImageView reward_dialog_layout_green_star1, reward_dialog_layout_green_star2, reward_dialog_layout_green_star3;
	private ImageView reward_dialog_layout_text;
	private ImageView reward_dialog_layout_end;
	
	private static boolean showAnim = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reward);
		
		reward_mask = (View) findViewById(R.id.reward_mask);
		reward_dialog_layout = (RelativeLayout) findViewById(R.id.reward_dialog_layout);
		reward_dialog_avatar_light = (ImageView) findViewById(R.id.reward_dialog_avatar_light);
		reward_dialog_layout_background = (ImageView) findViewById(R.id.reward_dialog_layout_background);
		reward_dialog_layout_close = (ImageView) findViewById(R.id.reward_dialog_layout_close);
		reward_grey_star_layout = (LinearLayout) findViewById(R.id.reward_grey_star_layout);
		
		reward_dialog_layout_green_star1 = (ImageView) findViewById(R.id.reward_dialog_layout_green_star1);
		reward_dialog_layout_green_star2 = (ImageView) findViewById(R.id.reward_dialog_layout_green_star2);
		reward_dialog_layout_green_star3 = (ImageView) findViewById(R.id.reward_dialog_layout_green_star3);
		reward_dialog_layout_text = (ImageView) findViewById(R.id.reward_dialog_layout_text);
		reward_dialog_layout_end = (ImageView) findViewById(R.id.reward_dialog_layout_end);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		initAnimation();
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
	
	private void initAnimation()
	{
		if(!showAnim)
		{
			return;
		}
		
		DisplayMetrics dm = new DisplayMetrics();
		(RewardActivity.this).getWindowManager().getDefaultDisplay().getMetrics(dm);
		dm = RewardActivity.this.getApplicationContext().getResources()
				.getDisplayMetrics();
		Utils.screenWidth = dm.widthPixels;
		Utils.screenHeight = dm.heightPixels;
		Utils.density = dm.density;
		
		reward_dialog_layout_close.setVisibility(View.INVISIBLE);
		reward_dialog_layout_end.setVisibility(View.INVISIBLE);
		
		int[] reward_dialog_layout_green_star_coords = {0, 0};
		reward_dialog_layout_green_star1.getLocationOnScreen(reward_dialog_layout_green_star_coords);
		
		reward_dialog_layout_green_star3.setVisibility(View.INVISIBLE);
		final TranslateAnimation reward_dialog_layout_green_star3_anim = new TranslateAnimation(0, 0, -1*reward_dialog_layout_green_star_coords[1], 0);
		reward_dialog_layout_green_star3_anim.setInterpolator(new BounceInterpolator());
		reward_dialog_layout_green_star3_anim.setDuration(1000);
		reward_dialog_layout_green_star3_anim.setFillAfter(true);
		reward_dialog_layout_green_star3_anim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_green_star3.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_close.setVisibility(View.VISIBLE);
				reward_dialog_layout_end.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		reward_dialog_layout_green_star2.setVisibility(View.INVISIBLE);
		final TranslateAnimation reward_dialog_layout_green_star2_anim = new TranslateAnimation(0, 0, -1*reward_dialog_layout_green_star_coords[1], 0);
		reward_dialog_layout_green_star2_anim.setInterpolator(new BounceInterpolator());
		reward_dialog_layout_green_star2_anim.setDuration(1000);
		reward_dialog_layout_green_star2_anim.setFillAfter(true);
		reward_dialog_layout_green_star2_anim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_green_star2.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_green_star3.startAnimation(reward_dialog_layout_green_star3_anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		reward_dialog_layout_green_star1.setVisibility(View.INVISIBLE);
		final TranslateAnimation reward_dialog_layout_green_star1_anim = new TranslateAnimation(0, 0, -1*reward_dialog_layout_green_star_coords[1], 0);
		reward_dialog_layout_green_star1_anim.setInterpolator(new BounceInterpolator());
		reward_dialog_layout_green_star1_anim.setDuration(1000);
		reward_dialog_layout_green_star1_anim.setFillAfter(true);
		reward_dialog_layout_green_star1_anim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_green_star1.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_green_star2.startAnimation(reward_dialog_layout_green_star2_anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		reward_grey_star_layout.setVisibility(View.INVISIBLE);
		reward_dialog_layout_text.setVisibility(View.INVISIBLE);
		final AlphaAnimation reward_dialog_layout_text_anim = new AlphaAnimation(0.0f, 1.0f);
		reward_dialog_layout_text_anim.setDuration(800);
		reward_dialog_layout_text_anim.setFillAfter(true);
		reward_dialog_layout_text_anim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_text.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout_green_star1.startAnimation(reward_dialog_layout_green_star1_anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		int[] reward_dialog_coords = {0, 0};
		reward_dialog_layout.getLocationOnScreen(reward_dialog_coords);
		reward_dialog_layout.setVisibility(View.INVISIBLE);
		final TranslateAnimation reward_dialog_anim = new TranslateAnimation(0, 0, Utils.screenHeight-reward_dialog_coords[1], 0);
		reward_dialog_anim.setDuration(2000);
		reward_dialog_anim.setFillAfter(true);
		reward_dialog_anim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				reward_grey_star_layout.setVisibility(View.VISIBLE);
				reward_dialog_layout_text.startAnimation(reward_dialog_layout_text_anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		reward_mask.setVisibility(View.INVISIBLE);
		TranslateAnimation maskAnim = new TranslateAnimation(0, 0, reward_mask.getHeight(), 0);
		maskAnim.setDuration(2000);
		maskAnim.setFillAfter(true);
		maskAnim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				reward_mask.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				reward_dialog_layout.startAnimation(reward_dialog_anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		reward_mask.startAnimation(maskAnim);
	}
}
