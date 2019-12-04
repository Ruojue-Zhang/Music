package com.example.yujian.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;



public class MusicService extends Service{
    private final IBinder iBinder = new MusicBinder();

    private MediaPlayer mediaPlayer = new MediaPlayer();;


    public class MusicBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public void prepare(String path){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(path);//获取路径
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,"未找到该音乐文件",Toast.LENGTH_SHORT).show();
        }
    }

    public void start(){
        mediaPlayer.start();
    }

    public void stop(){
        mediaPlayer.stop();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public int getDuration(){
        return mediaPlayer.getDuration();//获取总时长
    }

    public int getCurrentPosition(){
        return mediaPlayer.getCurrentPosition();
    }

    public void seekTo(int msec){
        mediaPlayer.seekTo(msec);//指定位置播放
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener){
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }

}
