package com.caa.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.caa.R;

public class NumberPickerView extends LinearLayout{

	private RelativeLayout view_number_picker_up_layout, view_number_picker_middle_layout, view_number_picker_down_layout;
	private TextView view_number_picker_up_text, view_number_picker_middle_text, view_number_picker_down_text;
	
	private TextView[] textViews = new TextView[3];
	private static int[] numbers = {0, 0, 0};
	
	private float x = 0;
	private float y = 0;
	private float lastX=0;
	private float lastY=0;
	
	private float onTouchVelocity = 0;
	
	private VelocityTracker tracker = null;
	private static boolean flingUp = false;
	private static boolean flingDown = false;
	
	private static float vThreshold = (float) 1.5;
	private static float threshold = 30;
	
	public NumberPickerView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		initView(context);
	}
	
	public NumberPickerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		initView(context);
	}
	
	public NumberPickerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
		initView(context);
	}

	private void initView(Context context)
	{
		View.inflate(context, R.layout.view_number_picker, this);
		
		view_number_picker_up_layout = (RelativeLayout) findViewById(R.id.view_number_picker_up_layout);
		view_number_picker_middle_layout = (RelativeLayout) findViewById(R.id.view_number_picker_middle_layout); 
		view_number_picker_down_layout = (RelativeLayout) findViewById(R.id.view_number_picker_down_layout);
		view_number_picker_up_text = (TextView) findViewById(R.id.view_number_picker_up_text);
		view_number_picker_middle_text = (TextView) findViewById(R.id.view_number_picker_middle_text);
		view_number_picker_down_text = (TextView) findViewById(R.id.view_number_picker_down_text);
		
		view_number_picker_middle_text.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
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
					onTouchVelocity = tracker.getYVelocity();
			        Log.v("Kite", "the y velocity is "+onTouchVelocity);
			        if(Math.abs(onTouchVelocity)>=vThreshold)
			        {
			        	if(onTouchVelocity>0)
			        	{
			        		flingDown = true;
			        		flingUp = false;
			        	}
			        	else
			        	{
			        		flingDown = false;
			        		flingUp = true;
			        	}
			        }
			        else
			        {
			        	flingUp = false;
			        	flingDown = false;
			        	
			        	float diffX = x-lastX;
						float diffY = y-lastY;
						
						if(Math.abs(diffY)>threshold)
						{
							if(diffY>0)
							{
//								stopRotating();
								rotateDown();
							}
							else
							{
//								stopRotating();
								rotateUp();
							}
							
							lastX = x;
						}
			        }
			        
					break;
					
				case MotionEvent.ACTION_UP:
					
					if(flingUp)
					{
//						flingUp(onTouchVelocity);	
					}
					else if(flingDown)
					{
//						flingUp(onTouchVelocity);
					}
					
					
					break;
				}
				
				return true;
			}
			
		});
	}
	
	private void rotateDown(){
		for(int i=0; i<3; i++)
		{
			numbers[i] = (numbers[i]+1)%10;
		}
		
		for(int i=0; i<3; i++)
		{
			textViews[i].setText(numbers[i]);
		}
	}
	
	private void rotateUp(){
		for(int i=0; i<3; i++)
		{
			numbers[i] = (numbers[i]+10-1)%10;
		}
		
		for(int i=0; i<3; i++)
		{
			textViews[i].setText(numbers[i]);
		}
	}
}
