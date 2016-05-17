package com.ivy.hm66;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ivy.hm66.activity.ButtonClickActivity;
import com.ivy.hm66.activity.CallDemoActivity;
import com.ivy.hm66.activity.LinearLayoutActivity;
import com.ivy.hm66.activity.RWinRomActivity;
import com.ivy.hm66.activity.RWinSDCardActivity;
import com.ivy.hm66.activity.SDCardStorageActivity;
import com.ivy.hm66.activity.SendSMSActivity;

public class MainActivity extends Activity {

	private String[] itemNames={"电话拨号器","按钮四种点击事件","短信发送器","线性布局","内部存储的读取","SDCard的读取",
			"获取SDCard存储情况"
	
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView mListView = (ListView) findViewById(R.id.lv_main);
		
		MainAdapter adapter = new MainAdapter();
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivityByPos(position);
			}});
	}

	/**
	 * 根据点击位置，来开启不同的界面(子项目)
	 * @param position
	 */
	protected void startActivityByPos(int position) {
		
		switch (position) {
		case 0:
			startActivity(CallDemoActivity.class);
			break;
		case 1:
			startActivity(ButtonClickActivity.class);
			break;
		case 2:
			startActivity(SendSMSActivity.class);
			break;
		case 3:
			startActivity(LinearLayoutActivity.class);
			break;
		case 4:
			startActivity(RWinRomActivity.class);
			break;
		case 5:
			startActivity(RWinSDCardActivity.class);
			break;
		case 6:
			startActivity(SDCardStorageActivity.class);
			break;
		}
		
	}
	
	/**
	 * 开启某个新的Activity
	 * @param cls
	 */
	private void startActivity(Class cls){
		Intent intent = new Intent(MainActivity.this, cls);
		startActivity(intent);
	}
	
	

	class MainAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return itemNames.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView==null){
				holder = new ViewHolder();
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main, null);
				holder.tvProjectName = (TextView) convertView.findViewById(R.id.tv_project_name);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.tvProjectName.setText((position+1)+"."+itemNames[position]);
						
			return convertView;
		}
		
	}
	
	class ViewHolder{
		TextView tvProjectName;
	}
}
