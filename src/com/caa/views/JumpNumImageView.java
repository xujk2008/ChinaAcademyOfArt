package com.caa.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class JumpNumImageView extends ImageView{

	private List<Integer> imageList = new ArrayList<Integer>();
	private int duration = 2000;
	private boolean shake = false;
	private int stage = 1000;
	private JumpAnimation animation;
	private int imageIndex = 0;
	private int lastTime = 0;
	
	public JumpNumImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public JumpNumImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public JumpNumImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public void init(List<Integer> imageList, int stage, int duration, boolean shake)
	{
		this.imageList = imageList;
		this.shake = shake;
		this.stage = stage;
		this.duration = duration;
		
		animation = new JumpAnimation();
		animation.setDuration(duration);
		animation.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				JumpNumImageView.this.clearAnimation();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void init(List<Integer> imageList, int stage, int duration)
	{
		this.imageList = imageList;
		this.shake = false;
		this.stage = stage;
		this.duration = duration;
		
		animation = new JumpAnimation();
		animation.setDuration(duration);
		animation.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				JumpNumImageView.this.clearAnimation();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void startJumping()
	{
		this.imageIndex = 0;
		this.startAnimation(animation);
	}
	
	public void stopJumping()
	{
		this.imageIndex = 0;
		this.clearAnimation();
	}
	
	public class JumpAnimation extends Animation {
    	
    	public JumpAnimation() {

    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);
    		
    		int curTime = (int)(interpolatedTime*duration);
    		
    		if (curTime<stage) {
    			imageIndex = (int)(((float)curTime/stage)*(imageList.size()-1));
    		} else {
    			if(shake)
    			{
    				if((curTime-lastTime)>=800)
    				{
    					Random random = new Random();
        				int randomInt = random.nextInt(3);
        				
        				imageIndex = imageList.size()-3+randomInt;
        				
        				lastTime = curTime;
    				}
    				else
    				{
    					return;
    				}
    			}
    			else
    			{
    				imageIndex = imageList.size()-1;
    			}
    		}
    		
    		Log.v("Kite", "imageIndex is " + imageIndex);
    		JumpNumImageView.this.setImageResource(imageList.get(imageIndex));
    	}
    }
}
