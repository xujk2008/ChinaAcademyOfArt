package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.caa.views.JumpNumImageView;

public class NumJumpActivity extends Activity{

	private JumpNumImageView num_jump_imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_num_jump);
		
		num_jump_imageView = (JumpNumImageView) findViewById(R.id.num_jump_imageView);
		List<Integer> imageList = new ArrayList<Integer>();
		imageList.add(R.drawable.num_0);
		imageList.add(R.drawable.num_1);
		imageList.add(R.drawable.num_2);
		imageList.add(R.drawable.num_3);
		imageList.add(R.drawable.num_4);
		imageList.add(R.drawable.num_5);
		imageList.add(R.drawable.num_6);
		imageList.add(R.drawable.num_7);
		imageList.add(R.drawable.num_8);
		imageList.add(R.drawable.num_9);
		num_jump_imageView.init(imageList, 1000, 2000);
		num_jump_imageView.startJumping();
	}

}
