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
	//�����Զ���֪ͨ
	public void sendCustomNotification(){
		//1.���NotificationManager
		nmanager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		//2.����Notification
		notification =new Notification(
			R.drawable.folder_open,
			"�յ��ļ�",
			System.currentTimeMillis()
			);
		RemoteViews rv=new RemoteViews(getPackageName(),R.layout.notificationinterfacelayout);
		rv.setImageViewResource(R.id.notification_img, R.drawable.savefile);
		rv.setTextViewText(R.id.notification_title, "������.mp3");
		rv.setProgressBar(R.id.notification_progressbar, 100, 20, false);
		notification.contentView=rv;
		//3.�������ԣ���Щ���Ի���չ��״̬������ʾ
		Intent intent =new Intent(this,ToastActivity.class);	//ת������
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK); 
		PendingIntent pIntent=PendingIntent.getActivity(this, 0, intent, 0);
		notification.contentIntent=pIntent;
		//4.��Notification����Manager
		nmanager.notify(notificationID++, notification);
	}
	//����֪ͨ
	public void sendNotification(){
		//1.���NotificationManager
		nmanager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		//2.����Notification
		notification =new Notification(
			R.drawable.folder_open,
			"�յ��ļ�",
			System.currentTimeMillis()
			);
		//��ѡ����
		notification.defaults|=Notification.DEFAULT_SOUND;
		notification.flags |=Notification.FLAG_INSISTENT;
		
		
		//3.�������ԣ���Щ���Ի���չ��״̬������ʾ
		Intent intent =new Intent(this,ToastActivity.class);	//ת������
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK); 
		PendingIntent pIntent=PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "�����ļ�", "�ļ��Ѿ��������", pIntent);
		//4.��Notification����Manager
		nmanager.notify(notificationID++, notification);
	}
	
}
