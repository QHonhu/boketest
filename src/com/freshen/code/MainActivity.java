package com.freshen.code;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tv;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv=(TextView) findViewById(R.id.tv_menu);
        registerForContextMenu(tv);//ΪTextView�ؼ�ע��ContextMenu
    }
	
	//��ӦContextMenu�˵�����
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		tv.setText(item.getTitle()+" ѡ��ִ�С�");
		return super.onContextItemSelected(item);
	}
	//����ContextMenu�˵�
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderIcon(android.R.drawable.ic_menu_manage);
		menu.setHeaderTitle("��ѡ�����:");
		menu.add(Menu.NONE, Menu.FIRST, Menu.FIRST,"����");
		menu.add(Menu.NONE, Menu.FIRST+1, Menu.FIRST+1,"ɾ��");
		menu.add(Menu.NONE, Menu.FIRST+2, Menu.FIRST+2,"������");
		
//		Log.i("print", v.getClass()+"");
//		Log.i("print", v.getId()+"");
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		tv.append("onCreateOptionMenu run.\n");
		menu.add(Menu.NONE, Menu.FIRST, Menu.FIRST, "�½�").setIcon(android.R.drawable.ic_menu_add);
		menu.add(Menu.NONE, Menu.FIRST+1, Menu.FIRST+1, "����").setIcon(android.R.drawable.ic_menu_save);
		menu.add(Menu.NONE, Menu.FIRST+2, Menu.FIRST+2, "ɾ��").setIcon(android.R.drawable.ic_menu_delete);
		//menu.add(Menu.NONE, Menu.FIRST+3, Menu.FIRST+3, "��ʷ").setIcon(android.R.drawable.ic_menu_recent_history);
		//menu.add(Menu.NONE, Menu.FIRST+4, Menu.FIRST+4, "��Ϣ").setIcon(android.R.drawable.ic_menu_info_details);
		//menu.add(Menu.NONE, Menu.FIRST+5, Menu.FIRST+5, "����").setIcon(android.R.drawable.ic_menu_help);
		//menu.add(Menu.NONE, Menu.FIRST+6, Menu.FIRST+6, "����").setIcon(android.R.drawable.ic_menu_more);
		SubMenu sm=menu.addSubMenu(Menu.NONE, Menu.FIRST+7, Menu.FIRST+7, "�鿴");
		sm.add(Menu.NONE, Menu.FIRST+3, Menu.FIRST+3, "��ʷ");
		sm.add(Menu.NONE, Menu.FIRST+4, Menu.FIRST+4, "��Ϣ");
		sm.add(Menu.NONE, Menu.FIRST+5, Menu.FIRST+5, "����");
		sm.setHeaderIcon(android.R.drawable.ic_menu_manage);
		sm.setIcon(android.R.drawable.ic_menu_more);
		return true;
	}
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		tv.append("onMenuOpened run.\n");
		return super.onMenuOpened(featureId, menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		tv.append("onOptionsItemSelected run."+item.getTitle()+"ѡ��. \n");
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		tv.append("onOptionsMenuClosed run.\n");
		super.onOptionsMenuClosed(menu);
	}
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		tv.append("onPrepareOptionMenu run.\n");
		return super.onPrepareOptionsMenu(menu);
	}
}