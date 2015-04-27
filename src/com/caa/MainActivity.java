package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.caa.views.JumpNumView;
import com.caa.views.RotateImageView;
import com.caa.views.RotateImageViewWithAnimation;

public class MainActivity extends Activity {

	private RotateImageViewWithAnimation main_image;
	private JumpNumView main_jumpNum;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_image = (RotateImageViewWithAnimation) findViewById(R.id.main_image);
        
        List<Integer> imageList = new ArrayList<Integer>();
//        imageList.add(R.drawable.angry_1);
//        imageList.add(R.drawable.angry_2);
//        imageList.add(R.drawable.angry_3);
//        imageList.add(R.drawable.angry_4);
//        imageList.add(R.drawable.sad_1);
//        imageList.add(R.drawable.sad_2);
//        imageList.add(R.drawable.sad_3);
//        imageList.add(R.drawable.sad_4);
//        imageList.add(R.drawable.happy_1);
//        imageList.add(R.drawable.happy_2);
//        imageList.add(R.drawable.happy_3);
//        imageList.add(R.drawable.happy_4);
//        imageList.add(R.drawable.neutral_1);
//        imageList.add(R.drawable.neutral_2);
//        imageList.add(R.drawable.neutral_3);
//        imageList.add(R.drawable.neutral_4);
        
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
        
        main_image.setImageList(imageList);
//        main_image.startRotating();
        
        main_jumpNum = (JumpNumView) findViewById(R.id.main_jumpNum);
        main_jumpNum.showNumberWithAnimation(100000, 10000);
    }

}
