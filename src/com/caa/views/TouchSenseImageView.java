package com.caa.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class TouchSenseImageView extends ImageView{

	public TouchSenseImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		touchAnimation = new TouchAnimation();
		touchAnimation.setDuration(duration);
	}

	public TouchSenseImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		touchAnimation = new TouchAnimation();
		touchAnimation.setDuration(duration);
	}

	public TouchSenseImageView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		touchAnimation = new TouchAnimation();
		touchAnimation.setDuration(duration);
	}
	
	private TouchAnimation touchAnimation;
	
	private static Rect rect;
	
	private boolean animationComplete = false;
	private int duration = 2000;
	
	private OnTouchSenseListener onTouchSenseListener;
	private OnTouchStartListener onTouchStartListener;
	private OnTouchCompleteListener onTouchCompleteListener;
	
	public void setOnTouchSenseListener(OnTouchSenseListener onTouchSenseListener)
	{
		this.onTouchSenseListener = onTouchSenseListener;
	}
	
	public void setOnTouchStartListener(OnTouchStartListener onTouchStartListener)
	{
		this.onTouchStartListener = onTouchStartListener;
	}
	
	public void setOnTouchCompleteListener(OnTouchCompleteListener onTouchCompleteListener)
	{
		this.onTouchCompleteListener = onTouchCompleteListener;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
		
		touchAnimation.setDuration(duration);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			
			rect = new Rect(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
			
			this.startAnimation(touchAnimation);
			
			break;
			
		case MotionEvent.ACTION_MOVE:
			
			if(!rect.contains(this.getLeft() + (int) event.getX(), this.getTop() + (int) event.getY()) && !animationComplete)
			{
				
				this.clearAnimation();
				
				if(this.onTouchStartListener!=null)
				{
					this.onTouchStartListener.onTouchStart();
				}
				
				Log.v("Kite", "move out");
	        }
			
			break;
			
		case MotionEvent.ACTION_UP:
			
			if(!animationComplete)
			{
				this.clearAnimation();
				if(this.onTouchStartListener!=null)
				{
					this.onTouchStartListener.onTouchStart();
				}
			}
			
			break;
		}
		
		return true;
	}
	
	public class TouchAnimation extends Animation {
    	/**
    	 * Initializes expand collapse animation, has two types, collapse (1) and expand (0).
    	 * @param view The view to animate
    	 * @param type The type of animation: 0 will expand from gone and 0 size to visible and layout size defined in xml.
    	 * 1 will collapse view and set to gone
    	 */
    	public TouchAnimation() {
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
    			
    			if(TouchSenseImageView.this.onTouchSenseListener!=null)
				{
    				TouchSenseImageView.this.onTouchSenseListener.onTouchSense(interpolatedTime);
				}
    		}
    		else
    		{
    			if(TouchSenseImageView.this.onTouchCompleteListener!=null)
				{
    				TouchSenseImageView.this.onTouchCompleteListener.onTouchComplete();
				}
    		}
    	}
    }
	
	public interface OnTouchSenseListener
	{
		public void onTouchSense(float interpolatedTime);
	}
	
	public interface OnTouchStartListener
	{
		public void onTouchStart();
	}
	
	public interface OnTouchCompleteListener
	{
		public void onTouchComplete();
	}
}
