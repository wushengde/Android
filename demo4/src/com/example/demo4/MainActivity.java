package com.example.demo4;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv =(TextView)findViewById(R.id.textView1);
        TextView message=(TextView)findViewById(R.id.textView2);
        DisplayMetrics dm = new DisplayMetrics();
        //getWindowManager---->获取窗口管理器
        //getDefaultDisplay---->获取窗口显示部分
        //getMetrics---->获取分辨率
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        
        //把分辨率转换为字符串
        String st="此手机的分辨率为：";
        message.setText(st);
        String str = dm.heightPixels+"*"+dm.widthPixels;
        tv.setText(str);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
