package com.example.demo_11;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int allId[]={R.id.imageView1,R.id.textView1,R.id.textView2,R.id.checkBox1};
	//与上面的对应
	//别名数组
	String allName[]={"aaa","bbb","ccc","ddd"};
	int photo[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
	String name[]={"路飞","乔巴","山治","索隆"};
	String number[]={"028-142589","028-3692587","028-1473695","028-3691472"};
	boolean check[]={true,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //多个数组---》Map---》ArrayList
        
        ArrayList al=new ArrayList();
        for(int i=0;i<4;i++){
        	HashMap map = new HashMap();
        	map.put("aaa", photo[i]);
        	map.put("bbb", name[i]);
        	map.put("ccc", number[i]);
        	map.put("ddd", check[i]);
        	al.add(map);
        }
        
        //数据和组件之间进行交互的桥梁
        //1：显示的顶级容器，2：listview显示的格式，3：别名，4：ID
        SimpleAdapter sa = new SimpleAdapter(this,al,R.layout.each,allName,allId){
        	
        	//重写GetView的方法，为了处理checkbox的事件
        	public View getView(int position,View convertView,ViewGroup parent){
        		System.out.println("bbbbbbb");
        		//当前点击的view
        		View view =super.getView(position, convertView, parent);
        		//每一项的数据
        		final HashMap hm=(HashMap)this.getItem(position);
        		//找到checkbox
        		CheckBox check=(CheckBox)view.findViewById(R.id.checkBox1);
        		//设置checkbox的点击事件
        		check.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View parent) {
						hm.put("ddd", ((CheckBox)parent).isChecked());
					}
				});
        		
        		
        		return view;
        	}
        };
        //找到listview
        ListView lv = (ListView)findViewById(R.id.listView1);
        //给listview添加数据
        lv.setAdapter(sa);
       
        //listview的点击消息
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				//获取被点击的item所对应的数据
				//找到当前的哪一行
				HashMap<String,Object> map =(HashMap<String,Object>)parent.getItemAtPosition(position);
				//下面是其他事物逻辑
				System.out.println("aaaaaaaaaaa");
				String name =(String)map.get("bbb");
				String code=(String)map.get("ccc");
				String check=((Boolean)map.get("ddd"))?"yes":"no";
				//放在标题上显示被点击的item中的数据
				MainActivity.this.setTitle(name+":"+code+":"+check);
				
				//第二种找到控件的形式
				TextView tv1=(TextView)view.findViewById(R.id.textView1);
				TextView tv2=(TextView)view.findViewById(R.id.textView2);
				
				String all=tv1.getText().toString()+":"+tv2.getText().toString();
				Toast.makeText(MainActivity.this,all,1).show();
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
