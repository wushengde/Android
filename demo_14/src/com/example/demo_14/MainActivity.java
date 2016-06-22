package com.example.demo_14;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
/*        //播放视频
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/e.MP4");   
        //调用系统自带的播放器  
            Intent intent = new Intent(Intent.ACTION_VIEW);  
            Log.v("URI:::::::::", uri.toString());  
            intent.setDataAndType(uri, "video/mp4");  
            startActivity(intent);*/
        
         Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/e.MP4");     
         //调用系统自带的播放器
         Intent intent = new Intent(Intent.ACTION_VIEW);
         Log.v("URI:::::::::", uri.toString());
         intent.setDataAndType(uri, "video/mp4");  
         startActivity(intent);
        
/*        Intent it = new Intent(Intent.ACTION_VIEW);
        Uri uri =Uri.parse("file:///sdcard/a.mp3");
        Uri uri2 = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/a.mp3");
        System.out.println(uri.toString());
        System.out.println(uri2.toString());
        it.setDataAndType(uri,"audio/mp3");
        startActivity(it);*/
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
