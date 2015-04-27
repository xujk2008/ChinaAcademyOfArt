package com.caa.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class FingerPrintImageView extends ImageView{

	public FingerPrintImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FingerPrintImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FingerPrintImageView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	private List<Integer> imageList = new ArrayList<Integer>();
	private Runnable ascRunnable, desRunnable;
	private boolean ascending = true;
	private static int imageIndex = 0;
	
	private static Rect rect;
	
	private static final int DEFAUL_INTERVAL = 60;
	
	public void setImageList(List<Integer> imageList)
	{
		this.imageList = imageList;
		this.setImageResource(imageList.get(0));
		imageIndex = 0;
		ascending = true;
		
		ascRunnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				FingerPrintImageView.this.showAsc();
				
				FingerPrintImageView.this.postDelayed(this, DEFAUL_INTERVAL);
			}
			
		};
		
		desRunnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				FingerPrintImageView.this.showDes();
				
				FingerPrintImageView.this.postDelayed(this, DEFAUL_INTERVAL);
			}
			
		};
	}
	
	public void setDsc()
	{
		ascending = false;
	}
	
	private void showImageByIndex(int index)
	{
		imageIndex = index;
		this.setImageResource(imageList.get(imageIndex));
	}
	
	public void showAsc()
	{
		int index = (imageIndex+1)%imageList.size();
		showImageByIndex(index);
	}
	
	public void showDes()
	{
		int index = (imageIndex-1+imageList.size())%imageList.size();
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
				this.post(ascRunnable);
			}
			else
			{
				this.post(desRunnable);
			}
			
			break;
			
		case MotionEvent.ACTION_MOVE:
			
			if(!rect.contains(this.getLeft() + (int) event.getX(), this.getTop() + (int) event.getY()))
			{
				
				this.removeCallbacks(ascRunnable);
				this.removeCallbacks(desRunnable);
				this.setImageResource(imageList.get(0));
				
				Log.v("Kite", "move out");
	        }
			
			break;
			
		case MotionEvent.ACTION_UP:
			
			this.removeCallbacks(ascRunnable);
			this.removeCallbacks(desRunnable);
			this.setImageResource(imageList.get(0));
			
			break;
		}
		
		return true;
	}
	
}
