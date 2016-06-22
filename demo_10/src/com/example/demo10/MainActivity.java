package com.example.demo10;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//listview��Ҫ��ʾ������
	String all[]={
			"aaa",
			"bbb",
			"ccc",
			"ddd",
			"eee"
			
	};
	ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView1);
        
        //����---��Adapter ---��ListView
        //����1��������������ʾ
        //����2��ÿһ�����������ʾ
        //����3������
        ArrayAdapter aa = new ArrayAdapter(this,R.layout.aaa,all); 
        lv.setAdapter(aa);
        //listview�¼���������
        lv.setOnItemClickListener(new OnItemClickListener() {

        	//arg1-->������Ǹ����  arg2 arg3 --->����ĵڼ���
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				System.out.println(arg2+":"+arg3);
				System.out.println(all[arg2]);
				TextView tv = (TextView)arg1;
				Toast.makeText(MainActivity.this,tv.getText().toString(),1).show();
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