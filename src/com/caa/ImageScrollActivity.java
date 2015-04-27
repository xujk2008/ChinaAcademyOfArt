package com.caa;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ImageScrollActivity extends Activity{

	private ImageView image_scroll_image;
	private SeekBar image_scroll_seekbar;
	
	private static final int SEEK_BAR_MAX = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_image_scroll);
		
		image_scroll_image = (ImageView) findViewById(R.id.image_scroll_image);
		List<Integer> imageList = new ArrayList<Integer>();
		imageList.add(R.drawable.angry_1);
		imageList.add(R.drawable.angry_2);
		imageList.add(R.drawable.angry_3);
		imageList.add(R.drawable.angry_4);
		imageList.add(R.drawable.sad_1);
		imageList.add(R.drawable.sad_2);
		imageList.add(R.drawable.sad_3);
		imageList.add(R.drawable.sad_4);
		imageList.add(R.drawable.happy_1);
		imageList.add(R.drawable.happy_2);
		imageList.add(R.drawable.happy_3);
		imageList.add(R.drawable.happy_4);
		imageList.add(R.drawable.neutral_1);
		imageList.add(R.drawable.neutral_2);
		imageList.add(R.drawable.neutral_3);
		imageList.add(R.drawable.neutral_4);
		
		final List<Integer> finalImageList = imageList;
		
		image_scroll_seekbar = (SeekBar) findViewById(R.id.image_scroll_image_seekbar);
		image_scroll_seekbar.setMax(SEEK_BAR_MAX);
		image_scroll_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				float percentage = (float)progress/SEEK_BAR_MAX;
				int index = (int)(percentage*(finalImageList.size()-1));
				image_scroll_image.setImageResource(finalImageList.get(index));
				
				Log.v("Kite", "progress is " + progress + " index is " + index + " imageId is " + finalImageList.get(index));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
