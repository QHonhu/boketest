package com.freshen.code;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

public class NotificationActivity extends Activity {
	Button b1;
	NotificationManager nmanager;
	Notification notification;
	int notificationID=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificationlayout);
		b1=(Button) findViewById(R.id.notification_bt1);
		b1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//sendNotification();
				sendCustomNotification();
			}}
		);
	}
	//发送自定义通知
	public void sendCustomNotification(){
		//1.获得NotificationManager
		nmanager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		//2.创建Notification
		notification =new Notification(
			R.drawable.folder_open,
			"收到文件",
			System.currentTimeMillis()
			);
		RemoteViews rv=new RemoteViews(getPackageName(),R.layout.notificationinterfacelayout);
		rv.setImageViewResource(R.id.notification_img, R.drawable.savefile);
		rv.setTextViewText(R.id.notification_title, "催眠曲.mp3");
		rv.setProgressBar(R.id.notification_progressbar, 100, 20, false);
		notification.contentView=rv;
		//3.设置属性，这些属性会在展开状态栏后显示
		Intent intent =new Intent(this,ToastActivity.class);	//转向其他
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK); 
		PendingIntent pIntent=PendingIntent.getActivity(this, 0, intent, 0);
		notification.contentIntent=pIntent;
		//4.将Notification发给Manager
		nmanager.notify(notificationID++, notification);
	}
	//发送通知
	public void sendNotification(){
		//1.获得NotificationManager
		nmanager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		//2.创建Notification
		notification =new Notification(
			R.drawable.folder_open,
			"收到文件",
			System.currentTimeMillis()
			);
		//可选属性
		notification.defaults|=Notification.DEFAULT_SOUND;
		notification.flags |=Notification.FLAG_INSISTENT;
		
		
		//3.设置属性，这些属性会在展开状态栏后显示
		Intent intent =new Intent(this,ToastActivity.class);	//转向其他
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK); 
		PendingIntent pIntent=PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "接收文件", "文件已经下载完成", pIntent);
		//4.将Notification发给Manager
		nmanager.notify(notificationID++, notification);
	}
	
}
