package com.example.demo9;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText et;
    TextView tv;
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //�������л�ȡ��Щ�����ע��ID��ȷ
        et=(EditText)findViewById(R.id.editText1);
        tv=(TextView)findViewById(R.id.textView1);
        button=(Button)findViewById(R.id.button1);
        
        //����ť�����¼�
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//��ʵû����
				String str =et.getText().toString();
				//���ɰ�������
				Bundle bundle= new Bundle();
				//������з��붫��
				bundle.putString("key", "��");
				//����ʹ�߶���
				Intent in = new Intent();
				//ʹ��Я������
				in.putExtras(bundle);
				//����������������ȥ
				in.setClass(MainActivity.this, A.class);
				//��ת��forResult�����ܶ����Ҫ����
				startActivityForResult(in,20);
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //�ص��ĵط��������� 1.�ߵ�ʱ��Я�������� 2.����ʱЯ�������� 3.Я��������
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    	String str=data.getExtras().getString("key");
    	System.out.println(requestCode+":"+resultCode+":"+str);
    	tv.setText(str);
    }
    
}