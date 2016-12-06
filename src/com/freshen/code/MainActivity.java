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
        registerForContextMenu(tv);//为TextView控件注册ContextMenu
    }
	
	//相应ContextMenu菜单项点击
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		tv.setText(item.getTitle()+" 选择执行。");
		return super.onContextItemSelected(item);
	}
	//创建ContextMenu菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderIcon(android.R.drawable.ic_menu_manage);
		menu.setHeaderTitle("请选择操作:");
		menu.add(Menu.NONE, Menu.FIRST, Menu.FIRST,"分享");
		menu.add(Menu.NONE, Menu.FIRST+1, Menu.FIRST+1,"删除");
		menu.add(Menu.NONE, Menu.FIRST+2, Menu.FIRST+2,"重命名");
		
//		Log.i("print", v.getClass()+"");
//		Log.i("print", v.getId()+"");
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		tv.append("onCreateOptionMenu run.\n");
		menu.add(Menu.NONE, Menu.FIRST, Menu.FIRST, "新建").setIcon(android.R.drawable.ic_menu_add);
		menu.add(Menu.NONE, Menu.FIRST+1, Menu.FIRST+1, "保存").setIcon(android.R.drawable.ic_menu_save);
		menu.add(Menu.NONE, Menu.FIRST+2, Menu.FIRST+2, "删除").setIcon(android.R.drawable.ic_menu_delete);
		//menu.add(Menu.NONE, Menu.FIRST+3, Menu.FIRST+3, "历史").setIcon(android.R.drawable.ic_menu_recent_history);
		//menu.add(Menu.NONE, Menu.FIRST+4, Menu.FIRST+4, "信息").setIcon(android.R.drawable.ic_menu_info_details);
		//menu.add(Menu.NONE, Menu.FIRST+5, Menu.FIRST+5, "帮助").setIcon(android.R.drawable.ic_menu_help);
		//menu.add(Menu.NONE, Menu.FIRST+6, Menu.FIRST+6, "更多").setIcon(android.R.drawable.ic_menu_more);
		SubMenu sm=menu.addSubMenu(Menu.NONE, Menu.FIRST+7, Menu.FIRST+7, "查看");
		sm.add(Menu.NONE, Menu.FIRST+3, Menu.FIRST+3, "历史");
		sm.add(Menu.NONE, Menu.FIRST+4, Menu.FIRST+4, "信息");
		sm.add(Menu.NONE, Menu.FIRST+5, Menu.FIRST+5, "帮助");
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
		tv.append("onOptionsItemSelected run."+item.getTitle()+"选中. \n");
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