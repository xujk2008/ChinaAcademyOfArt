package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ScanActivity extends Activity{

	private RelativeLayout scan_root;
	
	private ImageView scan_height;
	
	private ImageView scan_people_text_indicator_00, scan_people_text_00;
	private ImageView scan_people_text_indicator_01, scan_people_text_01;
	private ImageView scan_people_text_indicator_02, scan_people_text_02;
	private ImageView scan_people_text_indicator_03, scan_people_text_03;
	private ImageView scan_people_text_indicator_04, scan_people_text_04;
	
	private ImageView scan_ruler, scan_indicator;
	
	private ImageView scan_people;
	private ImageView scan_people_mask;
	
	private ImageView scan_circle_ruler;
	private ImageView scan_weight;
	
	private List<Integer> scan_height_imageList = new ArrayList<Integer>();
	private List<Integer> scan_weight_imageList = new ArrayList<Integer>();
	
	private static boolean showAnim = true;
	
	private static final int DURATION = 3000, SCALE_DURATION = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);
		
		scan_root = (RelativeLayout) findViewById(R.id.scan_root);
		scan_root.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.INVISIBLE);
				scan_people_text_01.setVisibility(View.INVISIBLE);
				scan_people_text_02.setVisibility(View.INVISIBLE);
				scan_people_text_03.setVisibility(View.INVISIBLE);
				scan_people_text_04.setVisibility(View.INVISIBLE);
			}
			
		});
		
		scan_height = (ImageView) findViewById(R.id.scan_height);
		scan_height_imageList.add(R.drawable.scan_height_00);
		scan_height_imageList.add(R.drawable.scan_height_01);
		scan_height_imageList.add(R.drawable.scan_height_02);
		scan_height_imageList.add(R.drawable.scan_height_03);
		scan_height_imageList.add(R.drawable.scan_height_04);
		scan_height_imageList.add(R.drawable.scan_height_05);
		scan_height_imageList.add(R.drawable.scan_height_06);
		scan_height_imageList.add(R.drawable.scan_height_07);
		scan_height_imageList.add(R.drawable.scan_height_08);
		scan_height_imageList.add(R.drawable.scan_height_09);
		scan_height_imageList.add(R.drawable.scan_height_10);
		scan_height_imageList.add(R.drawable.scan_height_11);
		scan_height_imageList.add(R.drawable.scan_height_12);
		scan_height_imageList.add(R.drawable.scan_height_13);
		scan_height_imageList.add(R.drawable.scan_height_14);
		scan_height_imageList.add(R.drawable.scan_height_15);
		scan_height_imageList.add(R.drawable.scan_height_16);
		scan_height_imageList.add(R.drawable.scan_height_17);
		scan_height_imageList.add(R.drawable.scan_height_18);
		scan_height_imageList.add(R.drawable.scan_height_16);
		
		scan_people_text_indicator_00 = (ImageView) findViewById(R.id.scan_people_text_indicator_00);
		scan_people_text_00 = (ImageView) findViewById(R.id.scan_people_text_00);
		scan_people_text_indicator_01 = (ImageView) findViewById(R.id.scan_people_text_indicator_01);
		scan_people_text_01 = (ImageView) findViewById(R.id.scan_people_text_01);
		scan_people_text_indicator_02 = (ImageView) findViewById(R.id.scan_people_text_indicator_02);
		scan_people_text_02 = (ImageView) findViewById(R.id.scan_people_text_02);
		scan_people_text_indicator_03 = (ImageView) findViewById(R.id.scan_people_text_indicator_03);
		scan_people_text_03 = (ImageView) findViewById(R.id.scan_people_text_03);
		scan_people_text_indicator_04 = (ImageView) findViewById(R.id.scan_people_text_indicator_04);
		scan_people_text_04 = (ImageView) findViewById(R.id.scan_people_text_04);
		
		scan_people_text_indicator_00.setVisibility(View.INVISIBLE);
		scan_people_text_00.setVisibility(View.INVISIBLE);
		scan_people_text_indicator_01.setVisibility(View.INVISIBLE);
		scan_people_text_01.setVisibility(View.INVISIBLE);
		scan_people_text_indicator_02.setVisibility(View.INVISIBLE);
		scan_people_text_02.setVisibility(View.INVISIBLE);
		scan_people_text_indicator_03.setVisibility(View.INVISIBLE);
		scan_people_text_03.setVisibility(View.INVISIBLE);
		scan_people_text_indicator_04.setVisibility(View.INVISIBLE);
		scan_people_text_04.setVisibility(View.INVISIBLE);
		
		scan_people_text_indicator_00.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.VISIBLE);
				scan_people_text_01.setVisibility(View.INVISIBLE);
				scan_people_text_02.setVisibility(View.INVISIBLE);
				scan_people_text_03.setVisibility(View.INVISIBLE);
				scan_people_text_04.setVisibility(View.INVISIBLE);
			}
			
		});
		
		scan_people_text_indicator_01.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.INVISIBLE);
				scan_people_text_01.setVisibility(View.VISIBLE);
				scan_people_text_02.setVisibility(View.INVISIBLE);
				scan_people_text_03.setVisibility(View.INVISIBLE);
				scan_people_text_04.setVisibility(View.INVISIBLE);
			}
			
		});
		
		scan_people_text_indicator_02.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.INVISIBLE);
				scan_people_text_01.setVisibility(View.INVISIBLE);
				scan_people_text_02.setVisibility(View.VISIBLE);
				scan_people_text_03.setVisibility(View.INVISIBLE);
				scan_people_text_04.setVisibility(View.INVISIBLE);
			}
			
		});
		
		scan_people_text_indicator_03.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.INVISIBLE);
				scan_people_text_01.setVisibility(View.INVISIBLE);
				scan_people_text_02.setVisibility(View.INVISIBLE);
				scan_people_text_03.setVisibility(View.VISIBLE);
				scan_people_text_04.setVisibility(View.INVISIBLE);
			}
			
		});
		
		scan_people_text_indicator_04.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.INVISIBLE);
				scan_people_text_01.setVisibility(View.INVISIBLE);
				scan_people_text_02.setVisibility(View.INVISIBLE);
				scan_people_text_03.setVisibility(View.INVISIBLE);
				scan_people_text_04.setVisibility(View.VISIBLE);
			}
			
		});
		
		scan_ruler = (ImageView) findViewById(R.id.scan_ruler);
		scan_indicator = (ImageView) findViewById(R.id.scan_indicator);
		
		scan_people = (ImageView) findViewById(R.id.scan_people);
		scan_people.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scan_people_text_00.setVisibility(View.INVISIBLE);
				scan_people_text_01.setVisibility(View.INVISIBLE);
				scan_people_text_02.setVisibility(View.INVISIBLE);
				scan_people_text_03.setVisibility(View.INVISIBLE);
				scan_people_text_04.setVisibility(View.INVISIBLE);
			}
			
		});
		scan_people_mask = (ImageView) findViewById(R.id.scan_people_mask);
		
		scan_circle_ruler = (ImageView) findViewById(R.id.scan_circle_ruler);
		
		scan_weight = (ImageView) findViewById(R.id.scan_weight);
		scan_weight_imageList.add(R.drawable.scan_weight_00);
		scan_weight_imageList.add(R.drawable.scan_weight_01);
		scan_weight_imageList.add(R.drawable.scan_weight_02);
		scan_weight_imageList.add(R.drawable.scan_weight_03);
		scan_weight_imageList.add(R.drawable.scan_weight_04);
		scan_weight_imageList.add(R.drawable.scan_weight_05);
		scan_weight_imageList.add(R.drawable.scan_weight_06);
		scan_weight_imageList.add(R.drawable.scan_weight_07);
		scan_weight_imageList.add(R.drawable.scan_weight_08);
		scan_weight_imageList.add(R.drawable.scan_weight_09);
		scan_weight_imageList.add(R.drawable.scan_weight_10);
		scan_weight_imageList.add(R.drawable.scan_weight_11);
		scan_weight_imageList.add(R.drawable.scan_weight_12);
		scan_weight_imageList.add(R.drawable.scan_weight_13);
		scan_weight_imageList.add(R.drawable.scan_weight_14);
		scan_weight_imageList.add(R.drawable.scan_weight_15);
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
		if(!showAnim)
		{
			return;
		}
		
		final ScaleAnimation scan_people_text_indicator_anim = new ScaleAnimation(0, 1.0f, 0, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scan_people_text_indicator_anim.setInterpolator(new OvershootInterpolator());
		scan_people_text_indicator_anim.setDuration(SCALE_DURATION);
		scan_people_text_indicator_anim.setFillAfter(true);
		
		int[] scan_people_coords = {0, 0};
		scan_people.getLocationOnScreen(scan_people_coords);
		
		scan_people_mask.setVisibility(View.VISIBLE);
		TranslateAnimation scan_people_mask_anim = new TranslateAnimation(0, 0, 0, scan_people_coords[1]+scan_people.getHeight());
		scan_people_mask_anim.setDuration(DURATION);
		scan_people_mask_anim.setFillAfter(true);
		scan_people_mask_anim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				scan_people_mask.setVisibility(View.GONE);
				
				scan_people_text_indicator_00.setVisibility(View.VISIBLE);
				scan_people_text_indicator_00.startAnimation(scan_people_text_indicator_anim);
				scan_people_text_indicator_01.setVisibility(View.VISIBLE);
				scan_people_text_indicator_01.startAnimation(scan_people_text_indicator_anim);
				scan_people_text_indicator_02.setVisibility(View.VISIBLE);
				scan_people_text_indicator_02.startAnimation(scan_people_text_indicator_anim);
				scan_people_text_indicator_03.setVisibility(View.VISIBLE);
				scan_people_text_indicator_03.startAnimation(scan_people_text_indicator_anim);
				scan_people_text_indicator_04.setVisibility(View.VISIBLE);
				scan_people_text_indicator_04.startAnimation(scan_people_text_indicator_anim);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		scan_people_mask.startAnimation(scan_people_mask_anim);
		
		int[] scan_ruler_coords = {0, 0};
		scan_ruler.getLocationOnScreen(scan_ruler_coords);
		TranslateAnimation scan_indicator_anim = new TranslateAnimation(0, 0, scan_ruler_coords[1]+scan_ruler.getHeight(), 0);
		scan_indicator_anim.setInterpolator(new OvershootInterpolator());
		scan_indicator_anim.setDuration(DURATION);
		scan_indicator_anim.setFillAfter(true);
		scan_indicator.startAnimation(scan_indicator_anim);
		
		RotateAnimation scan_circle_ruler_anim = new RotateAnimation(0, -85.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scan_circle_ruler_anim.setInterpolator(new OvershootInterpolator());
		scan_circle_ruler_anim.setDuration(DURATION);
		scan_circle_ruler_anim.setFillAfter(true);
		scan_circle_ruler.startAnimation(scan_circle_ruler_anim);
		
		JumpAnimation scan_height_anim = new JumpAnimation(scan_height, scan_height_imageList);
		scan_height_anim.setDuration(DURATION);
		scan_height.startAnimation(scan_height_anim);
		
		JumpAnimation scan_weight_anim = new JumpAnimation(scan_weight, scan_weight_imageList);
		scan_weight_anim.setDuration(DURATION);
		scan_weight.startAnimation(scan_weight_anim);
	}
	
	private class JumpAnimation extends Animation {
    	
		private ImageView imageView;
		private List<Integer> imageList;
		private int curNum = 0;
		
    	public JumpAnimation(ImageView imageView, List<Integer> imageList) {
    		this.imageView = imageView;
    		this.imageList = imageList;
    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);
    		if (interpolatedTime < 1.0f) {
    			curNum = (int)(interpolatedTime * (float)(imageList.size()-1));
    		} else {
    			curNum = (imageList.size()-1);
    		}
    		
			imageView.setImageResource(imageList.get(curNum));
    	}
    }
}
