package com.caa.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class RotateImageViewWithAnimation extends ImageView{

	public RotateImageViewWithAnimation(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		imageIndex = 0;
	}
	
	public RotateImageViewWithAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		imageIndex = 0;
	}

	public RotateImageViewWithAnimation(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		imageIndex = 0;
	}

	private float x = 0;
	private float y = 0;
	float lastX=0;
	float lastY=0;
	private float onTouchVelocity = 0;
	private List<Integer> imageList = new ArrayList<Integer>();
	private static int imageIndex = 0;
	
	private static float threshold = 30;
	private static float vThreshold = (float) 1.5;
	private static final int DEFAUL_INTERVAL = 60;
	
	private Runnable rotateRunnable;
	private int touchWidth;
	
	private VelocityTracker tracker = null;
	private static boolean flingRight = false;
	private static boolean flingLeft = false;
	
	private FlingRightAnimation flingRightAnimation;
	private FlingLeftAnimation flingLeftAnimation;
	
	public void setImageList(List<Integer> imageList)
	{
		this.imageList = imageList;
		imageIndex = 0;
		this.setImageResource(imageList.get(imageIndex));
		
		rotateRunnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				RotateImageViewWithAnimation.this.rotateRight();
				
				RotateImageViewWithAnimation.this.postDelayed(this, DEFAUL_INTERVAL);
			}
        	
        };
        
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        touchWidth = wm.getDefaultDisplay().getWidth();
        threshold = touchWidth/imageList.size()/(float)2.0;
	}
	
	private void setTouchWidth(int touchWidth)
	{
		this.touchWidth = touchWidth;
        threshold = touchWidth/imageList.size()/(float)2.5;
	}
	
	private void showImageByIndex(int index)
	{
		imageIndex = index;
		this.setImageResource(imageList.get(imageIndex));
	}
	
	public void rotateRight()
	{
		int index = (imageIndex+1)%imageList.size();
		showImageByIndex(index);
	}
	
	public void rotateLeft()
	{
		int index = (imageIndex-1+imageList.size())%imageList.size();
		showImageByIndex(index);
	}
	
	private int getFlingDuration(float velocity)
	{
		return (int)(velocity/9.0*2000);
	}
	
	private void flingRight(float velocity)
	{
		float absVelocity = Math.abs(velocity);
		int duration = getFlingDuration(absVelocity);
		if(flingRightAnimation==null)
		{
			flingRightAnimation = new FlingRightAnimation();
		}
		flingRightAnimation.setDuration(duration);
		
		this.startAnimation(flingRightAnimation);
	}
	
	private void flingLeft(float velocity)
	{
		float absVelocity = Math.abs(velocity);
		int duration = getFlingDuration(absVelocity);
		if(flingLeftAnimation==null)
		{
			flingLeftAnimation = new FlingLeftAnimation();
		}
		flingLeftAnimation.setDuration(duration);
		
		this.startAnimation(flingLeftAnimation);
	}
	
	public void startRotating()
	{
		this.post(rotateRunnable);
	}
	
	public void stopRotating()
	{
		this.removeCallbacks(rotateRunnable);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		x = event.getRawX();
		y = event.getRawY();
		
		Log.v("Kite", "x: " + x + " y: " + y);
		
		switch(event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			
			lastX = x;
			lastY = y;
			
			if(tracker == null){    
				tracker = VelocityTracker.obtain();    
	        }else{    
	        	tracker.clear();    
	        }    
			tracker.addMovement(event);  
			
			break;
			
		case MotionEvent.ACTION_MOVE:
			
			tracker.addMovement(event);    
	        //设置单位，1000 表示每秒多少像素（pix/second),1代表每微秒多少像素（pix/millisecond)。   
			tracker.computeCurrentVelocity(1);    
	        //从左向右划返回正数，从右向左划返回负数  
			onTouchVelocity = tracker.getXVelocity();
	        Log.v("Kite", "the x velocity is "+onTouchVelocity);
	        if(Math.abs(onTouchVelocity)>=vThreshold)
	        {
	        	if(onTouchVelocity>0)
	        	{
	        		flingLeft = false;
	        		flingRight = true;
	        	}
	        	else
	        	{
	        		flingLeft = true;
	        		flingRight = false;
	        	}
	        }
	        else
	        {
	        	flingRight = false;
	        	flingLeft = false;
	        	
	        	float diffX = x-lastX;
				float diffY = y-lastY;
				
				if(Math.abs(diffX)>threshold)
				{
					if(diffX>0)
					{
						stopRotating();
						rotateRight();
					}
					else
					{
						stopRotating();
						rotateLeft();
					}
					
					lastX = x;
				}
	        }
	        
			break;
			
		case MotionEvent.ACTION_UP:
			if(flingRight)
			{
				flingRight(onTouchVelocity);	
			}
			else if(flingLeft)
			{
				flingLeft(onTouchVelocity);
			}
			
			
			break;
		}
		
		return true;
	}
	
	public class FlingRightAnimation extends Animation {
		
		private float countDiff = 0;
		
    	public FlingRightAnimation() {
    		countDiff = 0;
    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);
    		if (interpolatedTime < 1.0f) {
    			float countPre =  (1-interpolatedTime) * (float)2.0;
    			countDiff += countPre;
    			
    			if((int)(countDiff)>=1)
    			{
    				rotateRight();
    				countDiff = 0;
    			}
    		} else {
    			countDiff = 0;
    		}
    	}
    }
	
	public class FlingLeftAnimation extends Animation {
		
		private float countDiff = 0;
		
    	public FlingLeftAnimation() {
    		countDiff = 0;
    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);
    		if (interpolatedTime < 1.0f) {
    			float countPre =  (1-interpolatedTime) * (float)2.0;
    			countDiff += countPre;
    			
    			if((int)(countDiff)>=1)
    			{
    				rotateLeft();
    				countDiff = 0;
    			}
    		} else {
    			countDiff = 0;
    		}
    	}
    }
}
