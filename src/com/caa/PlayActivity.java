package com.caa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.caa.common.Utils;
import com.caa.views.JumpNumImageView;

public class PlayActivity extends Activity{

	private SurfaceView play_surface;
	private SurfaceHolder surfaceHolder;
	private MediaPlayer mediaPlayer;
	private boolean isPause;
	private int indicator_start = 0;
	private int indicator_distance = 0;
	
	private Handler handler = new Handler();
    private Runnable updateThread;
    
    private ImageView play_media_sound, play_media_control, play_media_stop;
    
    private List<Integer> play_distance_imageList = new ArrayList<Integer>();
    private List<Integer> play_calories_imageList = new ArrayList<Integer>();
    private List<Integer> play_speed_imageList = new ArrayList<Integer>();
    private List<Integer> play_heart_imageList = new ArrayList<Integer>();
    private List<Integer> play_resistance_imageList = new ArrayList<Integer>();
    private List<Integer> play_cadence_imageList = new ArrayList<Integer>();
    private List<Integer> play_avg_left_imageList = new ArrayList<Integer>();
    private List<Integer> play_max_left_imageList = new ArrayList<Integer>();
    private List<Integer> play_avg_right_imageList = new ArrayList<Integer>();
    private List<Integer> play_max_right_imageList = new ArrayList<Integer>();
    
    private JumpNumImageView play_distance;
    private JumpNumImageView play_calories;
    private JumpNumImageView play_speed;
    private JumpNumImageView play_heart;
    private JumpNumImageView play_resistance;
    private JumpNumImageView play_cadence;
    private JumpNumImageView play_avg_left;
    private JumpNumImageView play_max_left;
    private JumpNumImageView play_avg_right;
    private JumpNumImageView play_max_right;
	
	private HorizontalScrollView play_scroll1, play_scroll2;
	private ImageView play_scroll_image1, play_scroll_image2;
	
	private ImageView play_progress_indicator;
	
	private LinearLayout play_wave_layout;
	private List<ImageView> wave_list = new ArrayList<ImageView>();
	private int waveHeight = 0;
	private Random random = null;
	
	private static boolean showAnim = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		play_surface = (SurfaceView) findViewById(R.id.play_surface);
		
		play_media_sound = (ImageView) findViewById(R.id.play_media_sound);
		play_media_sound.setTag(0);
		play_media_control = (ImageView) findViewById(R.id.play_media_control);
		play_media_control.setTag(0);
		play_media_stop = (ImageView) findViewById(R.id.play_media_stop);
		
		play_distance = (JumpNumImageView) findViewById(R.id.play_distance);
		play_calories = (JumpNumImageView) findViewById(R.id.play_calories);
		play_speed = (JumpNumImageView) findViewById(R.id.play_speed);
		play_heart = (JumpNumImageView) findViewById(R.id.play_heart);
		play_resistance = (JumpNumImageView) findViewById(R.id.play_resistance);
		play_cadence = (JumpNumImageView) findViewById(R.id.play_cadence);
		play_avg_left = (JumpNumImageView) findViewById(R.id.play_avg_left);
		play_max_left = (JumpNumImageView) findViewById(R.id.play_max_left);
		play_avg_right = (JumpNumImageView) findViewById(R.id.play_avg_right);
		play_max_right = (JumpNumImageView) findViewById(R.id.play_max_right);
		
		play_scroll1 = (HorizontalScrollView) findViewById(R.id.play_scroll1);
		play_scroll2 = (HorizontalScrollView) findViewById(R.id.play_scroll2);
		play_scroll_image1 = (ImageView) findViewById(R.id.play_scroll_image1);
		play_scroll_image2 = (ImageView) findViewById(R.id.play_scroll_image2);
		
		play_progress_indicator = (ImageView) findViewById(R.id.play_progress_indicator);
		
		play_wave_layout = (LinearLayout) findViewById(R.id.play_wave_layout);
		for(int i=0; i<50; i++)
		{
			ImageView view = new ImageView(PlayActivity.this);
			view.setImageResource(R.drawable.play_wave);
			play_wave_layout.addView(view);
			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)view.getLayoutParams();
			params.weight = 1;
			view.setLayoutParams(params);
			
			wave_list.add(view);
		}
		
		initVideo();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		waveHeight = wave_list.get(0).getHeight();
		Log.v("Kite", "waveHeight is " + waveHeight);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		showAnim = true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		showAnim = false;
	}
	
	private void initAnimation(int duration)
	{
		if(!showAnim)
		{
			return;
		}
		
		ScrollAnimation play_scroll1_anim = new ScrollAnimation(play_scroll1, play_scroll_image1.getWidth(), 30);
		play_scroll1_anim.setInterpolator(new LinearInterpolator());
		play_scroll1_anim.setDuration(30*60*1000);
		play_scroll1_anim.setFillAfter(true);
		play_scroll1.startAnimation(play_scroll1_anim);
		
		ScrollAnimation play_scroll2_anim = new ScrollAnimation(play_scroll2, play_scroll_image2.getWidth(), 10);
		play_scroll2_anim.setInterpolator(new LinearInterpolator());
		play_scroll2_anim.setDuration(30*60*1000);
		play_scroll2_anim.setFillAfter(true);
		play_scroll2.startAnimation(play_scroll2_anim);
		
		play_distance_imageList.add(R.drawable.play_distance_0);
		play_distance_imageList.add(R.drawable.play_distance_1);
		play_distance_imageList.add(R.drawable.play_distance_2);
		play_distance_imageList.add(R.drawable.play_distance_3);
		play_distance_imageList.add(R.drawable.play_distance_4);
		play_distance_imageList.add(R.drawable.play_distance_5);
		play_distance_imageList.add(R.drawable.play_distance_6);
		play_distance_imageList.add(R.drawable.play_distance_7);
		play_distance.init(play_distance_imageList, 3000, duration);
		play_distance.startJumping();
		
		play_calories_imageList.add(R.drawable.play_calories_0);
		play_calories_imageList.add(R.drawable.play_calories_1);
		play_calories_imageList.add(R.drawable.play_calories_2);
		play_calories_imageList.add(R.drawable.play_calories_3);
		play_calories_imageList.add(R.drawable.play_calories_4);
		play_calories_imageList.add(R.drawable.play_calories_5);
		play_calories_imageList.add(R.drawable.play_calories_6);
		play_calories_imageList.add(R.drawable.play_calories_7);
		play_calories_imageList.add(R.drawable.play_calories_8);
		play_calories_imageList.add(R.drawable.play_calories_9);
		play_calories_imageList.add(R.drawable.play_calories_10);
		play_calories.init(play_calories_imageList, 3000, duration);
		play_calories.startJumping();
		
		play_speed_imageList.add(R.drawable.play_speed_0);
		play_speed_imageList.add(R.drawable.play_speed_1);
		play_speed_imageList.add(R.drawable.play_speed_2);
		play_speed_imageList.add(R.drawable.play_speed_3);
		play_speed_imageList.add(R.drawable.play_speed_4);
		play_speed_imageList.add(R.drawable.play_speed_5);
		play_speed_imageList.add(R.drawable.play_speed_6);
		play_speed_imageList.add(R.drawable.play_speed_7);
		play_speed_imageList.add(R.drawable.play_speed_8);
		play_speed.init(play_speed_imageList, 3000, duration, true);
		play_speed.startJumping();
		
		play_heart_imageList.add(R.drawable.play_heart_0);
		play_heart_imageList.add(R.drawable.play_heart_1);
		play_heart_imageList.add(R.drawable.play_heart_2);
		play_heart_imageList.add(R.drawable.play_heart_3);
		play_heart_imageList.add(R.drawable.play_heart_4);
		play_heart_imageList.add(R.drawable.play_heart_5);
		play_heart_imageList.add(R.drawable.play_heart_6);
		play_heart_imageList.add(R.drawable.play_heart_7);
		play_heart_imageList.add(R.drawable.play_heart_8);
		play_heart_imageList.add(R.drawable.play_heart_9);
		play_heart_imageList.add(R.drawable.play_heart_10);
		play_heart.init(play_heart_imageList, 3000, duration, true);
		play_heart.startJumping();
		
		play_resistance_imageList.add(R.drawable.play_resistance_0);
		play_resistance_imageList.add(R.drawable.play_resistance_1);
		play_resistance_imageList.add(R.drawable.play_resistance_2);
		play_resistance_imageList.add(R.drawable.play_resistance_3);
		play_resistance_imageList.add(R.drawable.play_resistance_4);
		play_resistance_imageList.add(R.drawable.play_resistance_5);
		play_resistance_imageList.add(R.drawable.play_resistance_6);
		play_resistance_imageList.add(R.drawable.play_resistance_7);
		play_resistance_imageList.add(R.drawable.play_resistance_8);
		play_resistance_imageList.add(R.drawable.play_resistance_9);
		play_resistance_imageList.add(R.drawable.play_resistance_10);
		play_resistance_imageList.add(R.drawable.play_resistance_11);
		play_resistance.init(play_resistance_imageList, 3000, duration, true);
		play_resistance.startJumping();
		
		play_cadence_imageList.add(R.drawable.play_cadence_0);
		play_cadence_imageList.add(R.drawable.play_cadence_1);
		play_cadence_imageList.add(R.drawable.play_cadence_2);
		play_cadence_imageList.add(R.drawable.play_cadence_3);
		play_cadence_imageList.add(R.drawable.play_cadence_4);
		play_cadence_imageList.add(R.drawable.play_cadence_5);
		play_cadence_imageList.add(R.drawable.play_cadence_6);
		play_cadence_imageList.add(R.drawable.play_cadence_7);
		play_cadence_imageList.add(R.drawable.play_cadence_8);
		play_cadence_imageList.add(R.drawable.play_cadence_9);
		play_cadence_imageList.add(R.drawable.play_cadence_10);
		play_cadence_imageList.add(R.drawable.play_cadence_11);
		play_cadence.init(play_cadence_imageList, 3000, duration, true);
		play_cadence.startJumping();
		
		play_avg_left_imageList.add(R.drawable.play_avg_left_0);
		play_avg_left_imageList.add(R.drawable.play_avg_left_1);
		play_avg_left_imageList.add(R.drawable.play_avg_left_2);
		play_avg_left.init(play_avg_left_imageList, 3000, duration, true);
		play_avg_left.startJumping();
		
		play_max_left_imageList.add(R.drawable.play_max_left_0);
		play_max_left_imageList.add(R.drawable.play_max_left_1);
		play_max_left_imageList.add(R.drawable.play_max_left_2);
		play_max_left.init(play_max_left_imageList, 3000, duration, true);
		play_max_left.startJumping();
		
		play_avg_right_imageList.add(R.drawable.play_avg_right_0);
		play_avg_right_imageList.add(R.drawable.play_avg_right_1);
		play_avg_right_imageList.add(R.drawable.play_avg_right_2);
		play_avg_right.init(play_avg_right_imageList, 3000, duration, true);
		play_avg_right.startJumping();
		
		play_max_right_imageList.add(R.drawable.play_max_right_0);
		play_max_right_imageList.add(R.drawable.play_max_right_1);
		play_max_right_imageList.add(R.drawable.play_max_right_2);
		play_max_right.init(play_max_right_imageList, 3000, duration, true);
		play_max_right.startJumping();
	}
	
	private void stopAnimation()
	{
		play_scroll1.clearAnimation();
		play_scroll2.clearAnimation();
		
		play_distance.stopJumping();
		play_calories.stopJumping();
		play_speed.stopJumping();
		play_heart.stopJumping();
		play_resistance.stopJumping();
		play_cadence.stopJumping();
		play_avg_left.stopJumping();
		play_max_left.stopJumping();
		play_avg_right.stopJumping();
		play_max_right.stopJumping();
	}
	
	public class ScrollAnimation extends Animation {
    	/**
    	 * Initializes expand collapse animation, has two types, collapse (1) and expand (0).
    	 * @param view The view to animate
    	 * @param type The type of animation: 0 will expand from gone and 0 size to visible and layout size defined in xml.
    	 * 1 will collapse view and set to gone
    	 */
		private HorizontalScrollView view;
		private int scrollDistance = 0;
		private int distanceTimes = 1;
		
    	public ScrollAnimation(HorizontalScrollView view, int scrollDistance, int distanceTimes) {
    		this.view = view;
    		this.scrollDistance = scrollDistance;
    		this.distanceTimes = distanceTimes;
    	}

    	@Override
    	protected void applyTransformation(float interpolatedTime, Transformation t) {
    		super.applyTransformation(interpolatedTime, t);

    		if(interpolatedTime<1.0f)
    		{
    			int scrollPos = (int)((scrollDistance*distanceTimes*interpolatedTime)%scrollDistance);
        		Log.v("Kite", distanceTimes + "scrollDistance is " + scrollDistance + " distanceTimes is " + distanceTimes + " interpolatedTime is " + interpolatedTime);
        		
        		view.scrollTo(scrollPos, 0);
    		}
    		else
    		{
    			view.scrollTo(0, 0);
    		}
    	}
    }
	
	private void initMediaButton()
	{
		play_media_sound.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int tag = (Integer)(play_media_sound.getTag());
				if(tag==0)
				{
					play_media_sound.setImageResource(R.drawable.play_media_sound);
					play_media_sound.setTag(1);
				}
				else
				{
					play_media_sound.setImageResource(R.drawable.play_media_mute);
					play_media_sound.setTag(0);
				}
			}
			
		});
		
		play_media_control.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int tag = (Integer)(play_media_control.getTag());
				if(tag==0)
				{
					mediaPlayer.pause();
					stopAnimation();
					play_media_control.setImageResource(R.drawable.play_media_start);
					play_media_control.setTag(1);
				}
				else if(tag==1)
				{
					mediaPlayer.start();
					play_media_control.setImageResource(R.drawable.play_media_pause);
					play_media_control.setTag(0);
					
					initAnimation(mediaPlayer.getDuration());
				}
				else
				{
					handler.post(updateThread);
					try {
						mediaPlayer.prepare();
						mediaPlayer.seekTo(0);
						mediaPlayer.start();
						initAnimation(mediaPlayer.getDuration());
						play_media_control.setImageResource(R.drawable.play_media_pause);
						play_media_control.setTag(0);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		play_media_stop.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mediaPlayer.stop();
				stopAnimation();
				
				play_media_control.setImageResource(R.drawable.play_media_start);
				play_media_control.setTag(2);
			}
			
		});
	}
	
	private void initVideo()
	{
		surfaceHolder = play_surface.getHolder();
		surfaceHolder.addCallback(new SurfaceHolder.Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				Log.i("通知", "surfaceHolder被销毁了");
				if(mediaPlayer!=null)
				mediaPlayer.release();
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				play();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				Log.i("通知", "surfaceHolder被改变了");
			}
		});
		
		/**
		 *  这里必须设置为SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS哦，意思
		 *  是创建一个push的'surface'，主要的特点就是不进行缓冲
		 */
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	
	private void play(){
		
		mediaPlayer = new MediaPlayer();
		
		initAnimation(mediaPlayer.getDuration());
		
		mediaPlayer.setOnPreparedListener(new OnPreparedListener(){

			@Override
			public void onPrepared(MediaPlayer mp) {
				// TODO Auto-generated method stub
				initMediaButton();
				handler.post(updateThread);
			}
			
		});
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener(){

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				handler.removeCallbacks(updateThread);
				mediaPlayer.seekTo(0);
				RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)play_progress_indicator.getLayoutParams();
				params.leftMargin = indicator_start;
				
				play_progress_indicator.setLayoutParams(params);
				
				play_media_control.setImageResource(R.drawable.play_media_start);
				play_media_control.setTag(2);
				stopAnimation();
			}
			
		});
		// 设置多媒体流类型
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		// 设置用于展示mediaPlayer的容器
		mediaPlayer.setDisplay(surfaceHolder);
		handler = new Handler();
	    updateThread = new Runnable() {
	        public void run() {
	            // 获得歌曲现在播放位置并设置成播放进度条的值
	            if (mediaPlayer != null) {
	            	moveIndicator(mediaPlayer.getCurrentPosition());
	            	shakeWaves();
	                // 每次延迟100毫秒再启动线程
	                handler.postDelayed(updateThread, 100);
	            }
	        }
	    };
		try {
			mediaPlayer.setDataSource("/storage/emulated/0/DCIM/Wildlife.wmv");
			mediaPlayer.prepare();
			mediaPlayer.start();
			isPause = false;
		} catch (Exception e) {
			
		}
	}
	
	private void shakeWaves()
	{
		for(int i=0; i<wave_list.size(); i++)
		{
			ImageView view = wave_list.get(i);
			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)view.getLayoutParams();
			if(random==null)
			{
				random = new Random();
			}
			
			int height = (int)(random.nextInt(waveHeight+1))+30;
			height = (height>waveHeight)?waveHeight:height;
			params.height = height;
			Log.v("Kite", "height is " + params.height);
			view.setLayoutParams(params);
		}
	}
	
	private void moveIndicator(int currentPosition)
	{
		if(Utils.screenWidth==0)
		{
			DisplayMetrics dm = new DisplayMetrics();
			(PlayActivity.this).getWindowManager().getDefaultDisplay().getMetrics(dm);
			dm = PlayActivity.this.getApplicationContext().getResources()
					.getDisplayMetrics();
			Utils.screenWidth = dm.widthPixels;
			Utils.screenHeight = dm.heightPixels;
			Utils.density = dm.density;
		}
		
		if(indicator_start==0 || indicator_distance==0)
		{
			int[] indicator_coords = new int[2];
			play_progress_indicator.getLocationOnScreen(indicator_coords);
			indicator_start = indicator_coords[0];
			indicator_distance = Utils.screenWidth-2*indicator_coords[0];
		}
		
		float percentage = (float)currentPosition/mediaPlayer.getDuration();
		int leftMargin = indicator_start+(int)(percentage*indicator_distance);
		
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)play_progress_indicator.getLayoutParams();
		params.leftMargin = leftMargin;
		
		play_progress_indicator.setLayoutParams(params);
	}
	
	private void pause(){
		
		if(isPause==false){
			mediaPlayer.pause();
			isPause=true;
		}else{
			mediaPlayer.start();
			isPause=false;
		}
	}
	
	private void reset(){
		// 跳转到视频的最开始
		mediaPlayer.seekTo(0);
		mediaPlayer.start();
	}
	
	private void stop(){
		mediaPlayer.stop();
		mediaPlayer.release();
		
	}
}
