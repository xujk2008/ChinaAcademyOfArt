package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.caa.R;
import com.caa.views.FingerPrintImageView;
import com.caa.views.FingerPrintImageViewWithAnimation;

public class FingerPrintActivity extends Activity{

	private FingerPrintImageViewWithAnimation finger_print_view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_finger_print);
		
		finger_print_view = (FingerPrintImageViewWithAnimation) findViewById(R.id.finger_print_view);
		List<Integer> imageList = new ArrayList<Integer>();
		imageList.add(R.drawable.image_1);
        imageList.add(R.drawable.image_2);
        imageList.add(R.drawable.image_3);
        imageList.add(R.drawable.image_4);
        imageList.add(R.drawable.image_5);
        imageList.add(R.drawable.image_6);
        imageList.add(R.drawable.image_7);
        imageList.add(R.drawable.image_8);
        imageList.add(R.drawable.image_9);
        imageList.add(R.drawable.image_10);
        imageList.add(R.drawable.image_11);
        imageList.add(R.drawable.image_12);
        imageList.add(R.drawable.image_13);
        imageList.add(R.drawable.image_14);
        imageList.add(R.drawable.image_15);
        imageList.add(R.drawable.image_16);
        imageList.add(R.drawable.image_17);
        imageList.add(R.drawable.image_18);
        imageList.add(R.drawable.image_19);
        imageList.add(R.drawable.image_20);
        imageList.add(R.drawable.image_21);
        imageList.add(R.drawable.image_22);
        imageList.add(R.drawable.image_23);
        imageList.add(R.drawable.image_24);
        
		finger_print_view.setImageList(imageList);
	}

}
