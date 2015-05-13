package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.caa.common.Utils;
import com.caa.views.RotateImageViewWithAnimation;

public class ProductActivity extends Activity{

	private RelativeLayout product_top;
	private ImageView product_g, product_f;
	private ImageView product_last_button, product_next_button;
	private ImageView product_360;
	private SeekBar product_seekbar;
	private ImageView product_health_1, product_target_1, product_human_1, product_intelligence_1;
	private ImageView product_designs;
	
	private static int product_designs_index = 0;
	
	private static boolean showAnim = true;
	
	private static final int SEEK_BAR_MAX = 100;
	private static final int F_G_DURATION = 2000, CHARACTER_DURATION = 1500, ALPHA_DURATION = 1000, SCALE_DUARATION = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		
		product_top = (RelativeLayout) findViewById(R.id.product_top);
		
		product_g = (ImageView) findViewById(R.id.product_g);
		product_f = (ImageView) findViewById(R.id.product_f);
		
		product_last_button = (ImageView) findViewById(R.id.product_last_button);
		product_next_button = (ImageView) findViewById(R.id.product_next_button);
		
		product_360 = (ImageView) findViewById(R.id.product_360);
		
		product_seekbar = (SeekBar) findViewById(R.id.product_seekbar);
		
		product_health_1 = (ImageView) findViewById(R.id.product_health_1);
		product_target_1 = (ImageView) findViewById(R.id.product_target_1);
		product_human_1 = (ImageView) findViewById(R.id.product_human_1);
		product_intelligence_1 = (ImageView) findViewById(R.id.product_intelligence_1);
		
		product_designs = (ImageView) findViewById(R.id.product_designs);
		
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
		List<Integer> imageList = new ArrayList<Integer>();
		imageList.add(R.drawable.product_0);
		imageList.add(R.drawable.product_1);
		imageList.add(R.drawable.product_2);
		imageList.add(R.drawable.product_3);
		imageList.add(R.drawable.product_4);
		imageList.add(R.drawable.product_5);
		imageList.add(R.drawable.product_6);
		imageList.add(R.drawable.product_7);
		imageList.add(R.drawable.product_8);
		imageList.add(R.drawable.product_9);
		imageList.add(R.drawable.product_10);
		imageList.add(R.drawable.product_11);
		imageList.add(R.drawable.product_12);
		imageList.add(R.drawable.product_13);
		imageList.add(R.drawable.product_14);
		imageList.add(R.drawable.product_15);
		imageList.add(R.drawable.product_16);
		imageList.add(R.drawable.product_17);
		imageList.add(R.drawable.product_18);
		imageList.add(R.drawable.product_19);
		imageList.add(R.drawable.product_20);
		imageList.add(R.drawable.product_21);
		imageList.add(R.drawable.product_22);
		imageList.add(R.drawable.product_23);
		imageList.add(R.drawable.product_24);
		imageList.add(R.drawable.product_25);
		imageList.add(R.drawable.product_26);
		imageList.add(R.drawable.product_27);
		imageList.add(R.drawable.product_28);
		imageList.add(R.drawable.product_29);
		imageList.add(R.drawable.product_30);
		imageList.add(R.drawable.product_31);
		imageList.add(R.drawable.product_32);
		imageList.add(R.drawable.product_33);
		imageList.add(R.drawable.product_34);
		imageList.add(R.drawable.product_35);
		
		final List<Integer> finalImageList = imageList;
		
		product_seekbar.setMax(SEEK_BAR_MAX);
		product_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				float percentage = (float)progress/SEEK_BAR_MAX;
				int index = (int)(percentage*(finalImageList.size()-1));
				product_360.setImageResource(finalImageList.get(index));
				
				Log.v("Kite", "progress is " + progress + " index is " + index + " imageId is " + finalImageList.get(index));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		});
		product_seekbar.setProgress(SEEK_BAR_MAX/2);
		
		DisplayMetrics dm = new DisplayMetrics();
		(ProductActivity.this).getWindowManager().getDefaultDisplay().getMetrics(dm);
		dm = ProductActivity.this.getApplicationContext().getResources()
				.getDisplayMetrics();
		Utils.screenWidth = dm.widthPixels;
		Utils.screenHeight = dm.heightPixels;
		Utils.density = dm.density;
		
		if(!showAnim)
		{
			return;
		}
		
		int[] product_top_coords = {0, 0};
		product_top.getLocationOnScreen(product_top_coords);
		int top = product_top_coords[1]+product_top.getHeight();
		
		int[] product_f_coords = {0, 0};
		product_f.getLocationOnScreen(product_f_coords);
		int distance = product_f_coords[1]-top;
		
		TranslateAnimation product_f_anim = new TranslateAnimation(0, 0, 0, -distance);
		product_f_anim.setDuration(F_G_DURATION);
		product_f_anim.setFillAfter(true);
		product_f.startAnimation(product_f_anim);
		
		TranslateAnimation product_g_anim = new TranslateAnimation(0, 0, 0, distance);
		product_g_anim.setDuration(F_G_DURATION);
		product_g_anim.setFillAfter(true);
		product_g.startAnimation(product_g_anim);
		
		int[] product_health_1_coords = {0, 0};
		product_health_1.getLocationOnScreen(product_health_1_coords);
		TranslateAnimation product_health_1_anim = new TranslateAnimation(Utils.screenWidth-product_health_1_coords[0], 0, 0, 0);
		product_health_1_anim.setDuration(CHARACTER_DURATION);
		product_health_1_anim.setFillAfter(true);
		product_health_1_anim.setInterpolator(new OvershootInterpolator());
		product_health_1.startAnimation(product_health_1_anim);
		
		int[] product_target_1_coords = {0, 0};
		product_target_1.getLocationOnScreen(product_target_1_coords);
		TranslateAnimation product_target_1_anim = new TranslateAnimation(Utils.screenWidth-product_target_1_coords[0], 0, 0, 0);
		product_target_1_anim.setDuration(CHARACTER_DURATION);
		product_target_1_anim.setFillAfter(true);
		product_target_1_anim.setInterpolator(new OvershootInterpolator());
		product_target_1.startAnimation(product_target_1_anim);
		
		int[] product_human_1_coords = {0, 0};
		product_human_1.getLocationOnScreen(product_human_1_coords);
		TranslateAnimation product_human_1_anim = new TranslateAnimation(Utils.screenWidth-product_human_1_coords[0], 0, 0, 0);
		product_human_1_anim.setDuration(CHARACTER_DURATION);
		product_human_1_anim.setFillAfter(true);
		product_human_1_anim.setInterpolator(new OvershootInterpolator());
		product_human_1.startAnimation(product_human_1_anim);
		
		int[] product_intelligence_1_coords = {0, 0};
		product_intelligence_1.getLocationOnScreen(product_intelligence_1_coords);
		TranslateAnimation product_intelligence_1_anim = new TranslateAnimation(Utils.screenWidth-product_intelligence_1_coords[0], 0, 0, 0);
		product_intelligence_1_anim.setDuration(CHARACTER_DURATION);
		product_intelligence_1_anim.setFillAfter(true);
		product_intelligence_1_anim.setInterpolator(new OvershootInterpolator());
		product_intelligence_1.startAnimation(product_intelligence_1_anim);
		
		final List<Integer> product_designs_list = new ArrayList<Integer>();
		product_designs_list.add(R.drawable.product_total);
		product_designs_list.add(R.drawable.product_spinning_bike);
		product_designs_list.add(R.drawable.product_apple_watch);
		
		final ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f,  Animation.RELATIVE_TO_SELF, 0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);
		final AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.0f);
		
		scaleAnim.setDuration(SCALE_DUARATION);
		scaleAnim.setFillAfter(true);
		scaleAnim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
				product_designs.startAnimation(alphaAnim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		alphaAnim.setDuration(ALPHA_DURATION);
		alphaAnim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
				product_designs_index = (product_designs_index+1)%product_designs_list.size();
				product_designs.setImageResource(product_designs_list.get(product_designs_index));
				
				product_designs.startAnimation(scaleAnim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		product_designs.startAnimation(scaleAnim);
	}
}
