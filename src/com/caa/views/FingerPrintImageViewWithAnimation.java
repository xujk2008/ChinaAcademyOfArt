package com.caa.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class FingerPrintImageViewWithAnimation extends ImageView{

	public FingerPrintImageViewWithAnimation(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FingerPrintImageViewWithAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FingerPrintImageViewWithAnimation(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	private List<Integer> imageList = new ArrayList<Integer>();
	private AscAnimation ascAnimation;
	private DesAnimation desAnimation;
	private boolean ascending = true;
	private static int imageIndex = 0;
	
	private static Rect rect;
	
	private boolean animationComplete = false;
	private int duration = 2000;
	
	public void setImageList(List<Integer> imageList)
	{
		this.imageList = imageList;
		this.setImageResource(imageList.get(0));
		imageIndex = 0;
		ascending = true;
		
		ascAnimation = new AscAnimation();
		ascAnimation.setDuration(duration);
		
		desAnimation = new DesAnimation();
		desAnimation.setDuration(duration);
	}
	
	public void setDsc()
	{
		ascending = false;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
		
		ascAnimation.setDuration(duration);
		ascAnimation.setDuration(duration);
	}
	
	private void showImageByIndex(int index)
	{
		imageIndex = index;
		this.setImageResource(imageList.get(imageIndex));
	}
	
	public void showAsc(float interpolatedTime)
	{
		int index = (int)((interpolatedTime)*(imageList.size()-1));
		showImageByIndex(index);
		
		Log.v("Kite", "index is " + index);
	}
	
	public void showDes(float interpolatedTime)
	{
		int index = (int)((1-interpolatedTime)*(imageList.size()-1));
		showImageByIndex(index);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			
			rect = new Rect(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
			
			if(ascending)
			{
				this.startAnimation(ascAnimation);
			}
			else
			{
				this.startAnimation(desAnimation);
			}
			
			break;
			
		case MotionEvent.ACTION_MOVE:
			
			if(!rect.contains(this.getLeft() + (int) event.getX(), this.getTop() + (int) event.getY()) && !animationComplete)
			{
				
				this.clearAnimation();
				this.setImageResource(imageList.get(0));
				
				Log.v("Kite", "move out");
	        }
			
			break;
			
		case MotionEvent.ACTION_UP:
			
			if(!animationComplete)
			{
				this.clearAnimation();
				this.setImageResource(imageList.get(0));
			}
			
			break;
		}
		
		return true;
	}
	
	public class AscAnimation extends Animation {
    	/**
    	 * Initializes expand collapse animation, has two types, collapse (1) and expand (0).
    	 * @param view The view to animate
    	 * @param type The type of animation: 0 will expand from gone and 0 size to visible and layout size defined in xml.
    	 * 1 will collapse view and set to gone
    	 */
    	public AscAnimation() {
    		this.setAnimationListener(new AnimationListener(){

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					animationComplete = false;
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					animationComplete = true;
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
    			
    		});
    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);

    		if(interpolatedTime<1.0f)
    		{
    			Log.v("Kite", "interpolatedTime is " + interpolatedTime);
    			
    			showAsc(interpolatedTime);
    		}
    		else
    		{
    			showAsc(1);
    		}
    	}
    }
	
	public class DesAnimation extends Animation {
    	/**
    	 * Initializes expand collapse animation, has two types, collapse (1) and expand (0).
    	 * @param view The view to animate
    	 * @param type The type of animation: 0 will expand from gone and 0 size to visible and layout size defined in xml.
    	 * 1 will collapse view and set to gone
    	 */
    	public DesAnimation() {
    		this.setAnimationListener(new AnimationListener(){

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					animationComplete = false;
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					animationComplete = true;
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
    			
    		});
    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);
    		
    		showDes(interpolatedTime);
    	}
    }
}
