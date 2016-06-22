package com.example.demo_12;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.����һ��aaa.xml
        //���ַ����࣬����һ������xml�ļ��������γ�һ��view����
        LayoutInflater inflater = this.getLayoutInflater();
        //����xml�γ�view
        View view = inflater.inflate(R.layout.aaa, null);
        //�ҵ�view���������
        
        Button button=(Button)view.findViewById(R.id.button1);
        TextView tv =(TextView)view.findViewById(R.id.textView1);
        tv.setText("�廪��ѧ");
        
        //������ʾ�����
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        //�����ǵ�xml��Ӧ��view������ʾ����
        builder.setView(view);
        //������ʾ�򣬷���dialog����
        final Dialog dlg =builder.show();
        //����ť���¼�
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dlg.dismiss();
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