package com.example.demo6;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ma=this;
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        
        //匿名内部类：一般用来传入参数
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ma.setContentView(R.layout.aaa);
			}
		});
        button2.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		ma.setContentView(R.layout.bbb);
        	}
        });
        button3.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		ma.setContentView(R.layout.ccc);
        	}
        });
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
