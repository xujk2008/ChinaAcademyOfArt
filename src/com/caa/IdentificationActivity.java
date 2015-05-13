package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.caa.views.TouchSenseImageView;
import com.caa.views.TouchSenseImageView.OnTouchCompleteListener;
import com.caa.views.TouchSenseImageView.OnTouchSenseListener;
import com.caa.views.TouchSenseImageView.OnTouchStartListener;

public class IdentificationActivity extends Activity{

	private ImageView indentification_percentage, indentification_print;
	private ImageView indentification_last_button, indentification_next_button;
	private TouchSenseImageView indentification_finger;
	private ImageView indentification_finger_inner, indentification_finger_outter;
	
	private List<Integer> print_list = new ArrayList<Integer>();
	private List<Integer> percentage_list = new ArrayList<Integer>();
	
	private static final float HOLO_INTERVAL = (float)(1.0/8);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_indentification);
		
		indentification_percentage = (ImageView) findViewById(R.id.indentification_percentage);
		indentification_print = (ImageView) findViewById(R.id.indentification_print);
		indentification_last_button = (ImageView) findViewById(R.id.indentification_last_button);
		indentification_next_button = (ImageView) findViewById(R.id.indentification_next_button);
		indentification_finger = (TouchSenseImageView) findViewById(R.id.indentification_finger);
		indentification_finger_inner = (ImageView) findViewById(R.id.indentification_finger_inner);
		indentification_finger_outter = (ImageView) findViewById(R.id.indentification_finger_outter);
		
		print_list.add(R.drawable.indentification_print_0);
		print_list.add(R.drawable.indentification_print_1);
		print_list.add(R.drawable.indentification_print_2);
		print_list.add(R.drawable.indentification_print_3);
		print_list.add(R.drawable.indentification_print_4);
		
		percentage_list.add(R.drawable.indentification_0);
		percentage_list.add(R.drawable.indentification_15);
		percentage_list.add(R.drawable.indentification_30);
		percentage_list.add(R.drawable.indentification_85);
		percentage_list.add(R.drawable.indentification_100);
		
		init();
	}

	private void init()
	{
		indentification_finger_inner.setVisibility(View.INVISIBLE);
		indentification_finger_outter.setVisibility(View.INVISIBLE);
		
		indentification_print.setImageResource(print_list.get(0));
		indentification_percentage.setImageResource(percentage_list.get(0));
		
		indentification_finger.setDuration(1600);
		indentification_finger.setOnTouchSenseListener(new OnTouchSenseListener(){

			@Override
			public void onTouchSense(float interpolatedTime) {
				// TODO Auto-generated method stub
				int index = (int)((interpolatedTime)*(print_list.size()-1));
				
				showHolo(interpolatedTime);
				
				indentification_print.setImageResource(print_list.get(index));
				indentification_percentage.setImageResource(percentage_list.get(index));
			}
			
		});
		
		indentification_finger.setOnTouchStartListener(new OnTouchStartListener(){

			@Override
			public void onTouchStart() {
				// TODO Auto-generated method stub
				indentification_finger_inner.setVisibility(View.INVISIBLE);
				indentification_finger_outter.setVisibility(View.INVISIBLE);
				
				indentification_print.setImageResource(print_list.get(0));
				indentification_percentage.setImageResource(percentage_list.get(0));
			}
			
		});
		
		indentification_finger.setOnTouchCompleteListener(new OnTouchCompleteListener(){

			@Override
			public void onTouchComplete() {
				// TODO Auto-generated method stub
				indentification_finger_inner.setVisibility(View.INVISIBLE);
				indentification_finger_outter.setVisibility(View.INVISIBLE);
				
				indentification_print.setImageResource(print_list.get(print_list.size()-1));
				indentification_percentage.setImageResource(percentage_list.get(percentage_list.size()-1));
			}
			
		});
	}
	
	private void showHolo(float interpolatedTime)
	{
		int count = (int)(interpolatedTime/HOLO_INTERVAL);
		
		if(count%3==0)
		{
			indentification_finger_inner.setVisibility(View.VISIBLE);
			indentification_finger_outter.setVisibility(View.INVISIBLE);
		}
		else if(count%3==1)
		{
			indentification_finger_inner.setVisibility(View.INVISIBLE);
			indentification_finger_outter.setVisibility(View.VISIBLE);
		}
		else
		{
			indentification_finger_inner.setVisibility(View.INVISIBLE);
			indentification_finger_outter.setVisibility(View.INVISIBLE);
		}
	}
}
