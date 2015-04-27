package com.caa.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.WindowManager;
import android.widget.ImageView;

public class RotateImageView extends ImageView{

	public RotateImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		imageIndex = 0;
	}
	
	public RotateImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		imageIndex = 0;
	}

	public RotateImageView(Context context, AttributeSet attrs, int defStyle) {
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
	private static final int FLING_TOTAL_TIME = 50;
	private static int flingCount=0;
	private static float flingVelocity = 0;
	
	public void setImageList(List<Integer> imageList)
	{
		this.imageList = imageList;
		imageIndex = 0;
		this.setImageResource(imageList.get(imageIndex));
		
		rotateRunnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				RotateImageView.this.rotateRight();
				
				RotateImageView.this.postDelayed(this, DEFAUL_INTERVAL);
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
	
	private int getFlingCount(float velocity)
	{
		return (int)(velocity/9.0*imageList.size());
	}
	
	private int getFlingInterval(float velocity)
	{
		return Math.min(26, (int)(DEFAUL_INTERVAL/velocity/2));
	}
	
	private void flingRight(float velocity)
	{
		final float absVelocity = Math.abs(velocity);
		
		flingCount = getFlingCount(absVelocity);
		
		flingVelocity = absVelocity;
		final float a = absVelocity/flingCount;
//		Log.v("Kite", "a is " + a);
		
		this.post(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if((flingCount--)<=0)
				{
					RotateImageView.this.removeCallbacks(this);
//					Log.v("Kite", "fling stopped");
				}
				else
				{
					RotateImageView.this.rotateRight();
					int flingInterval = getFlingInterval(flingVelocity);
					RotateImageView.this.postDelayed(this, flingInterval);
					
					flingVelocity -= a;
					
					Log.v("Kite", "flingCount is " + flingCount + " flingVelocity is " + flingVelocity + " flingInterval is " + flingInterval);
				}
			}
			
		});
	}
	
	private void flingLeft(float velocity)
	{
		final float absVelocity = Math.abs(velocity);
		
		flingCount = getFlingCount(absVelocity);
		
		flingVelocity = absVelocity;
		final float a = absVelocity/flingCount;
//		Log.v("Kite", "a is " + a);
		
		this.post(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if((flingCount--)<=0)
				{
					RotateImageView.this.removeCallbacks(this);
//					Log.v("Kite", "fling stopped");
				}
				else
				{
					RotateImageView.this.rotateLeft();
					int flingInterval = getFlingInterval(flingVelocity);
					RotateImageView.this.postDelayed(this, flingInterval);
					
					flingVelocity -= a;
					
					Log.v("Kite", "flingCount is " + flingCount + " flingVelocity is " + flingVelocity + " flingInterval is " + flingInterval);
				}
			}
			
		});
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
}
