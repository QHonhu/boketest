package com.freshen.code;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
/*本Activity仅为测试不同Dialog的使用
 * 重复性代码较多，如果用于开发可以将对话框创建封装一下
 * */
public class DialogListActivity extends Activity {
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	ProgressDialog pd;
	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialoglistlayout);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		b5=(Button) findViewById(R.id.button5);
		b6=(Button) findViewById(R.id.button6);
		b7=(Button) findViewById(R.id.button7);
		b8=(Button) findViewById(R.id.button8);
		//创建监听器并注册给控件
		BtClickListener listener=new BtClickListener();
		b1.setOnClickListener(listener);
		b2.setOnClickListener(listener);
		b3.setOnClickListener(listener);
		b4.setOnClickListener(listener);
		b5.setOnClickListener(listener);
		b6.setOnClickListener(listener);
		b7.setOnClickListener(listener);
		b8.setOnClickListener(listener);
		
		handler=new Handler();
	}
	//创建简单对话框
	public void createCommonDialog(View v){
		//创建Builder
		AlertDialog.Builder  builder =new AlertDialog.Builder(this);
		//设置对话框的标题和图标
		builder.setIcon(android.R.drawable.ic_delete);
		builder.setTitle("删除信息");
		//设置信息
		builder.setMessage("请确认是否删除 "+v.getId());
		//左边按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		//右边按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//自定义创建 列表模式对话框
	public void createListDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("请选择送货时间");
		builder.setIcon(android.R.drawable.ic_menu_directions);
		//设置列表,并注入监听器
		final String []ss={"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
		builder.setItems(ss, new  DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogListActivity.this,"您选择的时间是"+ss[which], Toast.LENGTH_SHORT)
					.show();
			}}
		);
		//左边按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		//右边按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//创建复选模式对话框
	public void createMultipleDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("请选择曾用手机品牌");
		builder.setIcon(android.R.drawable.ic_menu_gallery);
		//设置列表,并注入监听器
		final String []ss={"联想","三星","苹果","诺基亚","黑莓","摩托罗拉","其他"};
		final List <String>item=new ArrayList<String>();
		builder.setMultiChoiceItems(ss,new boolean[]{false,false,false,false,false,false,false}, new  DialogInterface.OnMultiChoiceClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which,
					boolean isChecked) {
				if(isChecked){
					item.add(ss[which]);//将选中的数据添加入列表
				}else{
					if(item.contains(ss[which]))item.remove(ss[which]);
				}
			}}
		);
		//左边按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogListActivity.this, "您选择的是"+item.toString(),Toast.LENGTH_LONG)
					.show();
			}
		});
		//右边按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//创建单选模式对话框
	public void createSingleDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("您的年龄");
		builder.setIcon(android.R.drawable.ic_secure);
		//设置列表,并注入监听器
		final String []ss={"总角之年","弱冠之年","而立之年","不惑之年","知命之年","耳顺之年"};
		builder.setSingleChoiceItems(ss,2, new  DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogListActivity.this, "您选择的是 "+ss[which],Toast.LENGTH_LONG)
				.show();
			}}
		);
		//左边按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		//右边按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//创建进度条对话框
	public void createProgressDialog(){
		pd =new ProgressDialog(this);
		pd.setIcon(android.R.drawable.ic_menu_upload);
		pd.setTitle("下载");
		pd.setMessage("文件下载中，请稍后……");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setMax(100);
		pd.show();
		//子线程修改进度
		//new Thread(new MyThread()).start();
		//ProgressDialog.show(this, "文件下载", "文件正在下载，请稍后……");
		
	}
	//日期选择对话框
	public void createDatePickerDialog(){
		Calendar c=Calendar.getInstance();
		DatePickerDialog dpd=new DatePickerDialog(this,
				new OnDateSetListener(){
					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
					}},
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH),
				c.get(Calendar.DAY_OF_MONTH));
		dpd.setIcon(android.R.drawable.ic_dialog_alert);
		dpd.setTitle("请选择日期");
		dpd.show();
	}
	//时间选择器
	public void createTimePickerDialog(){
		TimePickerDialog tpd =new TimePickerDialog(
				this,
				new OnTimeSetListener(){
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						setTitle("选定时间："+hourOfDay+":"+minute);
					}},
				18,16,true
		);
		tpd.setTitle("请选择时间");
		tpd.show();
	}
	//创建自定义对话框
	public void createLoginDialog(){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("用户登录");
		builder.setIcon(android.R.drawable.ic_menu_myplaces);
		//
		LayoutInflater inflater =LayoutInflater.from(this);
		View loginView=inflater.inflate(R.layout.logindialoglayout, null);
		final EditText name;
		final EditText pwd;
		name=(EditText) loginView.findViewById(R.id.login_name);
		pwd=(EditText) loginView.findViewById(R.id.login_password);
		builder.setView(loginView);
		builder.setPositiveButton("登录",new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String n=name.getText().toString();
				String p=pwd.getText().toString();
				Toast.makeText(DialogListActivity.this, "登录信息："+n+" "+p, Toast.LENGTH_LONG)
					.show();
			}}
		);
		builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.show();
	}
	class MyThread implements Runnable{
		@Override
		public void run() {
			int pro=0;
			while(pd.getProgress()<pd.getMax()){
				try {
					Thread.sleep(100);
					handler.post(new Runnable(){
						@Override
						public void run() {
							pd.setProgress(pd.getProgress()+2);
						}}
					);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	class BtClickListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.button1){
				//创建简单对话框
				createCommonDialog(v);
			}else if(v.getId()==R.id.button2){
				//创建简单对话框
				createListDialog(v);
			}else if(v.getId()==R.id.button3){
				//创建简单对话框
				createMultipleDialog(v);
			}else if(v.getId()==R.id.button4){
				//创建简单对话框
				createSingleDialog(v);
			}else if(v.getId()==R.id.button5){
				//创建进度条对话框
				createProgressDialog();
			}else if(v.getId()==R.id.button6){
				//创建日期选择对话框
				createDatePickerDialog();
			}else if(v.getId()==R.id.button7){
				//创建时间选择对话框
				createTimePickerDialog();
			}else if(v.getId()==R.id.button8){
				//创建自定义对话框
				createLoginDialog();
			}
		}
	}
}
