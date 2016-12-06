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
/*��Activity��Ϊ���Բ�ͬDialog��ʹ��
 * �ظ��Դ���϶࣬������ڿ������Խ��Ի��򴴽���װһ��
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
		//������������ע����ؼ�
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
	//�����򵥶Ի���
	public void createCommonDialog(View v){
		//����Builder
		AlertDialog.Builder  builder =new AlertDialog.Builder(this);
		//���öԻ���ı����ͼ��
		builder.setIcon(android.R.drawable.ic_delete);
		builder.setTitle("ɾ����Ϣ");
		//������Ϣ
		builder.setMessage("��ȷ���Ƿ�ɾ�� "+v.getId());
		//��߰�ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		//�ұ߰�ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//�Զ��崴�� �б�ģʽ�Ի���
	public void createListDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("��ѡ���ͻ�ʱ��");
		builder.setIcon(android.R.drawable.ic_menu_directions);
		//�����б�,��ע�������
		final String []ss={"����һ","���ڶ�","������","������","������","������","������"};
		builder.setItems(ss, new  DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogListActivity.this,"��ѡ���ʱ����"+ss[which], Toast.LENGTH_SHORT)
					.show();
			}}
		);
		//��߰�ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		//�ұ߰�ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//������ѡģʽ�Ի���
	public void createMultipleDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("��ѡ�������ֻ�Ʒ��");
		builder.setIcon(android.R.drawable.ic_menu_gallery);
		//�����б�,��ע�������
		final String []ss={"����","����","ƻ��","ŵ����","��ݮ","Ħ������","����"};
		final List <String>item=new ArrayList<String>();
		builder.setMultiChoiceItems(ss,new boolean[]{false,false,false,false,false,false,false}, new  DialogInterface.OnMultiChoiceClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which,
					boolean isChecked) {
				if(isChecked){
					item.add(ss[which]);//��ѡ�е�����������б�
				}else{
					if(item.contains(ss[which]))item.remove(ss[which]);
				}
			}}
		);
		//��߰�ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogListActivity.this, "��ѡ�����"+item.toString(),Toast.LENGTH_LONG)
					.show();
			}
		});
		//�ұ߰�ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//������ѡģʽ�Ի���
	public void createSingleDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("��������");
		builder.setIcon(android.R.drawable.ic_secure);
		//�����б�,��ע�������
		final String []ss={"�ܽ�֮��","����֮��","����֮��","����֮��","֪��֮��","��˳֮��"};
		builder.setSingleChoiceItems(ss,2, new  DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogListActivity.this, "��ѡ����� "+ss[which],Toast.LENGTH_LONG)
				.show();
			}}
		);
		//��߰�ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		//�ұ߰�ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//
			}
		});
		builder.show();
	}
	//�����������Ի���
	public void createProgressDialog(){
		pd =new ProgressDialog(this);
		pd.setIcon(android.R.drawable.ic_menu_upload);
		pd.setTitle("����");
		pd.setMessage("�ļ������У����Ժ󡭡�");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setMax(100);
		pd.show();
		//���߳��޸Ľ���
		//new Thread(new MyThread()).start();
		//ProgressDialog.show(this, "�ļ�����", "�ļ��������أ����Ժ󡭡�");
		
	}
	//����ѡ��Ի���
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
		dpd.setTitle("��ѡ������");
		dpd.show();
	}
	//ʱ��ѡ����
	public void createTimePickerDialog(){
		TimePickerDialog tpd =new TimePickerDialog(
				this,
				new OnTimeSetListener(){
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						setTitle("ѡ��ʱ�䣺"+hourOfDay+":"+minute);
					}},
				18,16,true
		);
		tpd.setTitle("��ѡ��ʱ��");
		tpd.show();
	}
	//�����Զ���Ի���
	public void createLoginDialog(){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setTitle("�û���¼");
		builder.setIcon(android.R.drawable.ic_menu_myplaces);
		//
		LayoutInflater inflater =LayoutInflater.from(this);
		View loginView=inflater.inflate(R.layout.logindialoglayout, null);
		final EditText name;
		final EditText pwd;
		name=(EditText) loginView.findViewById(R.id.login_name);
		pwd=(EditText) loginView.findViewById(R.id.login_password);
		builder.setView(loginView);
		builder.setPositiveButton("��¼",new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String n=name.getText().toString();
				String p=pwd.getText().toString();
				Toast.makeText(DialogListActivity.this, "��¼��Ϣ��"+n+" "+p, Toast.LENGTH_LONG)
					.show();
			}}
		);
		builder.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
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
				//�����򵥶Ի���
				createCommonDialog(v);
			}else if(v.getId()==R.id.button2){
				//�����򵥶Ի���
				createListDialog(v);
			}else if(v.getId()==R.id.button3){
				//�����򵥶Ի���
				createMultipleDialog(v);
			}else if(v.getId()==R.id.button4){
				//�����򵥶Ի���
				createSingleDialog(v);
			}else if(v.getId()==R.id.button5){
				//�����������Ի���
				createProgressDialog();
			}else if(v.getId()==R.id.button6){
				//��������ѡ��Ի���
				createDatePickerDialog();
			}else if(v.getId()==R.id.button7){
				//����ʱ��ѡ��Ի���
				createTimePickerDialog();
			}else if(v.getId()==R.id.button8){
				//�����Զ���Ի���
				createLoginDialog();
			}
		}
	}
}
