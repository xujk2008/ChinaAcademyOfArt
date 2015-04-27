package com.caa.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.caa.R;

public class JumpNumView extends TextView {

	public JumpNumView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public JumpNumView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public JumpNumView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	private final int DEFAULT_DURATION = 1500;
	
	int duration = 1500;
	float number;

	public void showNumberWithAnimation(float number) {
		// 修改number属性，会调用setNumber方法
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "number",
				0, number);
		objectAnimator.setDuration(duration);
		// 加速器，从慢到快到再到慢
		objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
		objectAnimator.start();
	}
	
	public void showNumberWithAnimation(float number, int duration) {
		this.duration = duration;
		
		showNumberWithAnimation(number);
		
		this.duration = DEFAULT_DURATION;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
		setText(String.format("%1$07.1f", number));
	}
}
