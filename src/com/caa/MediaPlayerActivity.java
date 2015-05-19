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
 * @description ͨ��SurfaceView/SurfaceHolderʵ���Լ��Ĳ�����
 * @author chenzheng_java
 * @since 2011/03/23
 * @description �������һ�²���˵�������ǿ���ͨ��mediaplayer���OnPreparedListener
 * 	�Լ�OnCompletionListener���¼���׼���ò����Լ�������ɺ�Ĳ������п��ơ�
 * ʹ��SurfaceView�Լ�SurfaceHolder������Ƶ����ʱ���ṹ�������ģ�
 * 1�����ȣ����ǴӲ����ļ��л�ȡһ��surfaceView
 * 2��ͨ��surfaceView.getHolder()������ȡ����������Ӧ��surfaceHolder
 * 3����srufaceHolder����һЩĬ�ϵ����ã���addCallback()��setType()
 * 4��ͨ��mediaPlayer.setDisplay()��������Ƶ�����벥��������������
 *//*
public class MediaPlayerActivity extends Activity {

	MediaPlayer mediaPlayer ; // ���������ڲ�ʵ����ͨ��MediaPlayer
	SurfaceView surfaceView ;// װ����Ƶ������
	SurfaceHolder surfaceHolder;// ����surfaceView�����ԣ��ߴ硢��ʽ�ȣ�����
	boolean isPause ; // �Ƿ��Ѿ���ͣ��
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);
		surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
		*//**
		 * ��ȡ�뵱ǰsurfaceView��������Ǹ���surefaceHolder
		 *//*
		surfaceHolder = surfaceView.getHolder();
		*//**
		 * ע�ᵱsurfaceView�������ı������ʱӦ��ִ�еķ���
		 *//*
		surfaceHolder.addCallback(new SurfaceHolder.Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				Log.i("֪ͨ", "surfaceHolder��������");
				if(mediaPlayer!=null)
				mediaPlayer.release();
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				Log.i("֪ͨ", "surfaceHolder��create��");
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				Log.i("֪ͨ", "surfaceHolder���ı���");
			}
		});
		
		*//**
		 *  �����������ΪSurfaceHolder.SURFACE_TYPE_PUSH_BUFFERSŶ����˼
		 *  �Ǵ���һ��push��'surface'����Ҫ���ص���ǲ����л���
		 *//*
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	
	*//***
	 * @param targetButton ���û�����İ�ť
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
	 * ����
	 *//*
	private void play(){
		
		mediaPlayer = new MediaPlayer();
		// ���ö�ý��������
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		// ��������չʾmediaPlayer������
		mediaPlayer.setDisplay(surfaceHolder);
		try {
			mediaPlayer.setDataSource("/data/jinsha.3gp");
			mediaPlayer.prepare();
			mediaPlayer.start();
			isPause = false;
		} catch (Exception e) {
			Log.i("֪ͨ", "���Ź����г����˴���Ŷ");
		}
	}
	
	*//**
	 * ��ͣ
	 *//*
	private void pause(){
		Log.i("֪ͨ", "�������ͣ��ť");
		if(isPause==false){
			mediaPlayer.pause();
			isPause=true;
		}else{
			mediaPlayer.start();
			isPause=false;
		}
		
		
	}
	
	*//**
	 * ����
	 *//*
	private void reset(){
		Log.i("֪ͨ", "�����reset��ť");
		// ��ת����Ƶ���ʼ
		mediaPlayer.seekTo(0);
		mediaPlayer.start();
	}
	
	*//**
	 * ֹͣ
	 *//*
	private void stop(){
		Log.i("֪ͨ", "�����stop��ť");
		mediaPlayer.stop();
		mediaPlayer.release();
		
	}
	
	
}*/