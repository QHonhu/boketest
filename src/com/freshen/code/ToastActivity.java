package com.freshen.code;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity {
	Button b1,b2,b3,b4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toastlayout);
		b1=(Button) findViewById(R.id.toast_bt1);
		b1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast toast=new Toast(ToastActivity.this);
				toast.setDuration(3000);
				TextView tv=new TextView(ToastActivity.this);
				tv.setText("构造Toast，显示3秒");
				toast.setView(tv);				
				toast.show();
				Toast.makeText(ToastActivity.this, "静态方法", Toast.LENGTH_SHORT).show();
			}}
		);
		b2=(Button) findViewById(R.id.toast_bt2);
		b2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				View toastView =LayoutInflater.from(ToastActivity.this)
					.inflate(R.layout.toastinterfacelayout, null);
				//设置 布局中的控件 内容
				TextView tv=(TextView) toastView.findViewById(R.id.toast_msg);
				tv.setText("自定义Toast信息");
				ImageView iv=(ImageView) toastView.findViewById(R.id.toast_img);
				iv.setImageResource(R.drawable.android01);
				Toast toast=new Toast(ToastActivity.this);
				toast.setView(toastView);//设置Toast视图
				toast.setDuration(Toast.LENGTH_LONG);
				toast.show();
			}}
		);
	}
}
