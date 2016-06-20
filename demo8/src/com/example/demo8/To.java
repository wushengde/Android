package com.example.demo8;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class To extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to);
        //接待使者对象
        Intent in =this.getIntent();
        //获取包裹
        Bundle bundle = in.getExtras();
        //从包裹中获取数据
        String name = bundle.getString("name");
        String pass = bundle.getString("pass");
        EditText et1 = (EditText)findViewById(R.id.editText1);
        EditText et2 = (EditText)findViewById(R.id.editText2);
        et1.setText(name);
        et2.setText(pass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
