package com.caa.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.caa.R;

public class JumpNumImageView extends LinearLayout{

	private View mainView;
	private ImageView jump_num_image1, jump_num_image2, jump_num_image3, jump_num_image4;
	private List<Integer> imageList = new ArrayList<Integer>();
	private int target = 0;
	private int duration = 2000;
	private JumpAnimation animation;
	private int curNum = 0;
	
	private OnJumpCompleteListener onJumpCompleteListener = null;
	
	public JumpNumImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		mainView = LayoutInflater.from(context).inflate(R.layout.view_jump_num, this);
		jump_num_image1 = (ImageView) mainView.findViewById(R.id.jump_num_image1);
		jump_num_image2 = (ImageView) mainView.findViewById(R.id.jump_num_image2);
		jump_num_image3 = (ImageView) mainView.findViewById(R.id.jump_num_image3);
		jump_num_image4 = (ImageView) mainView.findViewById(R.id.jump_num_image4);
	}

	public JumpNumImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		mainView = LayoutInflater.from(context).inflate(R.layout.view_jump_num, this);
		jump_num_image1 = (ImageView) mainView.findViewById(R.id.jump_num_image1);
		jump_num_image2 = (ImageView) mainView.findViewById(R.id.jump_num_image2);
		jump_num_image3 = (ImageView) mainView.findViewById(R.id.jump_num_image3);
		jump_num_image4 = (ImageView) mainView.findViewById(R.id.jump_num_image4);
	}

	public JumpNumImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
		mainView = LayoutInflater.from(context).inflate(R.layout.view_jump_num, this);
		jump_num_image1 = (ImageView) mainView.findViewById(R.id.jump_num_image1);
		jump_num_image2 = (ImageView) mainView.findViewById(R.id.jump_num_image2);
		jump_num_image3 = (ImageView) mainView.findViewById(R.id.jump_num_image3);
		jump_num_image4 = (ImageView) mainView.findViewById(R.id.jump_num_image4);
	}

	public interface OnJumpCompleteListener
	{
		public void onJumpComplete();
	};
	
	public void setOnJumpCompleteListener(OnJumpCompleteListener onJumpCompleteListener)
	{
		this.onJumpCompleteListener = onJumpCompleteListener;
	}
	
	public void init(List<Integer> imageList, int target, int duration)
	{
		this.imageList = imageList;
		setImage(0, 0, 0, 0);
		
		this.target = target;
		this.duration = duration;
		
		animation = new JumpAnimation();
		animation.setDuration(duration);
		animation.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				JumpNumImageView.this.clearAnimation();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private void setImage(int num1, int num2, int num3, int num4)
	{
		jump_num_image1.setImageResource(imageList.get(num1));
		jump_num_image2.setImageResource(imageList.get(num2));
		jump_num_image3.setImageResource(imageList.get(num3));
		jump_num_image4.setImageResource(imageList.get(num4));
	}
	
	public void startJumping()
	{
		curNum = 0;
		this.startAnimation(animation);
	}
	
	public class JumpAnimation extends Animation {
    	
    	public JumpAnimation() {

    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);
    		if (interpolatedTime < 1.0f) {
    			curNum = (int)(interpolatedTime * (float)(target));
    		} else {
    			curNum = target;
    		}
    		int num1=curNum/1000;
			int num2 = curNum%1000/100;
			int num3 = curNum%100/10;
			int num4 = curNum%10;
			setImage(num1, num2, num3, num4);
    	}
    }
}
