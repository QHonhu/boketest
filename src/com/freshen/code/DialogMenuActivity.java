package com.freshen.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class DialogMenuActivity extends Activity {
	GridView gv;	//对话框视图需要的控件
	AlertDialog dialog;	//对话框
	List<Map<String,Object>>  data;	//gv需要的数据
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//初始化对话框,但不显示对话框
		initDialog();
	}
	//初始化 对话框
	public void initDialog(){
		dialog=new AlertDialog.Builder(this).create();
		View dialogView =LayoutInflater.from(this).inflate(R.layout.gridviewdialog, null);
		//设置对话框界面
		dialog.setView(dialogView);
		//获取对话框界面上的GridView控件
		gv=(GridView) dialogView.findViewById(R.id.dialog_gridview);
		gv.setAdapter(createMenuAdapter());
		gv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(DialogMenuActivity.this, "您选择的是第"+arg2+"个菜单", Toast.LENGTH_LONG)
					.show();
			}}
		);
		//注意此处不要调用show
	}
	//创建GridView的数据适配器
	public SimpleAdapter createMenuAdapter(){
		data =new ArrayList<Map<String,Object>>();
		int [] icons={android.R.drawable.ic_menu_edit,android.R.drawable.ic_menu_delete,
				android.R.drawable.ic_menu_add,android.R.drawable.ic_menu_save,
				android.R.drawable.ic_menu_search,android.R.drawable.ic_menu_slideshow,
				android.R.drawable.ic_menu_share,android.R.drawable.ic_menu_manage};
		String []titles={"编辑","删除","添加","保存",
				"查找","设为背景","分享","设置"};
//		Map<String,Object> item1=new HashMap<String,Object>();
//		item1.put("icon", android.R.drawable.ic_menu_edit);
//		item1.put("title","编辑");
//		data.add(item1);
		for(int i=0;i<icons.length;i++){
			Map<String,Object> item=new HashMap<String,Object>();
			item.put("icon", icons[i]);
			item.put("title", titles[i]);
			data.add(item);
		}
		SimpleAdapter sa =new SimpleAdapter(this,
				data,
				R.layout.gridviewdialog_item_1,
				new String[]{"icon","title"},
				new int[]{R.id.gridviewdialog_img,R.id.gridviewdialog_tv});
		return sa;
	}
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		dialog.show();
		return false;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("test");
		return super.onCreateOptionsMenu(menu);
	}
}
