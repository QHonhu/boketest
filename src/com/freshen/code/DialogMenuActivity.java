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
	GridView gv;	//�Ի�����ͼ��Ҫ�Ŀؼ�
	AlertDialog dialog;	//�Ի���
	List<Map<String,Object>>  data;	//gv��Ҫ������
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//��ʼ���Ի���,������ʾ�Ի���
		initDialog();
	}
	//��ʼ�� �Ի���
	public void initDialog(){
		dialog=new AlertDialog.Builder(this).create();
		View dialogView =LayoutInflater.from(this).inflate(R.layout.gridviewdialog, null);
		//���öԻ������
		dialog.setView(dialogView);
		//��ȡ�Ի�������ϵ�GridView�ؼ�
		gv=(GridView) dialogView.findViewById(R.id.dialog_gridview);
		gv.setAdapter(createMenuAdapter());
		gv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(DialogMenuActivity.this, "��ѡ����ǵ�"+arg2+"���˵�", Toast.LENGTH_LONG)
					.show();
			}}
		);
		//ע��˴���Ҫ����show
	}
	//����GridView������������
	public SimpleAdapter createMenuAdapter(){
		data =new ArrayList<Map<String,Object>>();
		int [] icons={android.R.drawable.ic_menu_edit,android.R.drawable.ic_menu_delete,
				android.R.drawable.ic_menu_add,android.R.drawable.ic_menu_save,
				android.R.drawable.ic_menu_search,android.R.drawable.ic_menu_slideshow,
				android.R.drawable.ic_menu_share,android.R.drawable.ic_menu_manage};
		String []titles={"�༭","ɾ��","���","����",
				"����","��Ϊ����","����","����"};
//		Map<String,Object> item1=new HashMap<String,Object>();
//		item1.put("icon", android.R.drawable.ic_menu_edit);
//		item1.put("title","�༭");
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
