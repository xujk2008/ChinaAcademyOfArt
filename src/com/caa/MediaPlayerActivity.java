/*package com.caa;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
*//**
 * @description 通过SurfaceView/SurfaceHolder实现自己的播放器
 * @author chenzheng_java
 * @since 2011/03/23
 * @description 这里进行一下补充说明，我们可以通过mediaplayer添加OnPreparedListener
 * 	以及OnCompletionListener等事件对准备好播放以及播放完成后的操作进行控制。
 * 使用SurfaceView以及SurfaceHolder进行视频播放时，结构是这样的：
 * 1、首先，我们从布局文件中获取一个surfaceView
 * 2、通过surfaceView.getHolder()方法获取与该容器想对应的surfaceHolder
 * 3、对srufaceHolder进行一些默认的设置，如addCallback()和setType()
 * 4、通过mediaPlayer.setDisplay()方法将视频播放与播放容器链接起来
 *//*
public class MediaPlayerActivity extends Activity {

	MediaPlayer mediaPlayer ; // 播放器的内部实现是通过MediaPlayer
	SurfaceView surfaceView ;// 装在视频的容器
	SurfaceHolder surfaceHolder;// 控制surfaceView的属性（尺寸、格式等）对象
	boolean isPause ; // 是否已经暂停了
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);
		surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
		*//**
		 * 获取与当前surfaceView相关联的那个的surefaceHolder
		 *//*
		surfaceHolder = surfaceView.getHolder();
		*//**
		 * 注册当surfaceView创建、改变和销毁时应该执行的方法
		 *//*
		surfaceHolder.addCallback(new SurfaceHolder.Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				Log.i("通知", "surfaceHolder被销毁了");
				if(mediaPlayer!=null)
				mediaPlayer.release();
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				Log.i("通知", "surfaceHolder被create了");
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				Log.i("通知", "surfaceHolder被改变了");
			}
		});
		
		*//**
		 *  这里必须设置为SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS哦，意思
		 *  是创建一个push的'surface'，主要的特点就是不进行缓冲
		 *//*
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	
	*//***
	 * @param targetButton 被用户点击的按钮
	 *//*
	public void buttonClick(View targetButton){
		int buttonId = targetButton.getId();
		switch (buttonId) {
		case R.id.button_play:
			play();
			break;
		case R.id.button_pause:
			pause();
			break;
		case R.id.button_reset:
			reset();
			break;
		case R.id.button_stop:
			stop();
			break;
		default:
			break;
		}
		
	}
	
	*//**
	 * 播放
	 *//*
	private void play(){
		
		mediaPlayer = new MediaPlayer();
		// 设置多媒体流类型
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		// 设置用于展示mediaPlayer的容器
		mediaPlayer.setDisplay(surfaceHolder);
		try {
			mediaPlayer.setDataSource("/data/jinsha.3gp");
			mediaPlayer.prepare();
			mediaPlayer.start();
			isPause = false;
		} catch (Exception e) {
			Log.i("通知", "播放过程中出现了错误哦");
		}
	}
	
	*//**
	 * 暂停
	 *//*
	private void pause(){
		Log.i("通知", "点击了暂停按钮");
		if(isPause==false){
			mediaPlayer.pause();
			isPause=true;
		}else{
			mediaPlayer.start();
			isPause=false;
		}
		
		
	}
	
	*//**
	 * 重置
	 *//*
	private void reset(){
		Log.i("通知", "点击了reset按钮");
		// 跳转到视频的最开始
		mediaPlayer.seekTo(0);
		mediaPlayer.start();
	}
	
	*//**
	 * 停止
	 *//*
	private void stop(){
		Log.i("通知", "点击了stop按钮");
		mediaPlayer.stop();
		mediaPlayer.release();
		
	}
	
	
}*/