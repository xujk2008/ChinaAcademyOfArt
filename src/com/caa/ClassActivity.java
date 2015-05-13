package com.caa;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class ClassActivity extends Activity{

	private ImageView class_last_button, class_next_button, dialog_class_close;
	private ImageView class_begin;
	
	private ImageView dialog_class_begin, dialog_class_preview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_class);
		
		class_last_button = (ImageView) findViewById(R.id.class_last_button);
		class_next_button = (ImageView) findViewById(R.id.class_next_button);
		
		class_begin = (ImageView) findViewById(R.id.class_begin);
		class_begin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog();
			}
			
		});
	}

	private void showDialog()
	{

		// TODO Auto-generated method stub
		final Dialog user_name_edit_dialog = new Dialog(
				ClassActivity.this);
		user_name_edit_dialog.show();

		Window window = user_name_edit_dialog.getWindow();
		window.setBackgroundDrawable(new ColorDrawable(0));
		window.setContentView(R.layout.dialog_class);

		dialog_class_begin = (ImageView) window
				.findViewById(R.id.dialog_class_begin);
		dialog_class_begin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user_name_edit_dialog.cancel();
			}

		});
		
		dialog_class_preview = (ImageView) window
				.findViewById(R.id.dialog_class_preview);
		dialog_class_preview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user_name_edit_dialog.cancel();
			}
		});
		
		dialog_class_close = (ImageView) window
				.findViewById(R.id.dialog_class_close);
		dialog_class_close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user_name_edit_dialog.cancel();
			}

		});
	}
}
