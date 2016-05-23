package com.ivy.hm66;

import java.util.Collections;

import org.apache.http.client.HttpClient;

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

import com.ivy.hm66.activity.ArraySimpleAdapterActivity;
import com.ivy.hm66.activity.ButtonClickActivity;
import com.ivy.hm66.activity.CallDemoActivity;
import com.ivy.hm66.activity.CreateXMLActivity;
import com.ivy.hm66.activity.HtmlWatcherActivity;
import com.ivy.hm66.activity.HttpClientActivity;
import com.ivy.hm66.activity.LinearLayoutActivity;
import com.ivy.hm66.activity.NetImageActivity;
import com.ivy.hm66.activity.NewsActivity;
import com.ivy.hm66.activity.PullXmlActivity;
import com.ivy.hm66.activity.RWinRomActivity;
import com.ivy.hm66.activity.RWinSDCardActivity;
import com.ivy.hm66.activity.SDCardStorageActivity;
import com.ivy.hm66.activity.SendSMSActivity;
import com.ivy.hm66.activity.SharedPreferenceActivity;
import com.ivy.hm66.activity.ShowDataActivity;
import com.ivy.hm66.activity.ShowDataActivity2;
import com.ivy.hm66.activity.SmartImageViewActivity;
import com.loopj.android.image.SmartImageView;

public class MainActivity extends Activity {

	private String[] itemNames={"电话拨号器","按钮四种点击事件","短信发送器","线性布局","内部存储的读取","SDCard的读取",
			"获取SDCard存储情况","SharedPrefrence存储","创建XML文件","解析XML文件","TextView显示数据库数据","ListView显示数据库数据",
			"ArrayAdapter&SimpleAdapter","网络图片查看器","SmartImageView显示图片","Html源文件查看器",
			"Fake新闻客户端","Get方式提交表单（空）","POST方式提交表单（空）","HttpClient框架方式提交表单（空）",
	
	};
	
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
		case 7:
			startActivity(SharedPreferenceActivity.class);
			break;
		case 8:
			startActivity(CreateXMLActivity.class);
			break;
		case 9:
			startActivity(PullXmlActivity.class);
			break;
		case 10:
			startActivity(ShowDataActivity.class);
			break;
		case 11:
			startActivity(ShowDataActivity2.class);
			break;
		case 12:
			startActivity(ArraySimpleAdapterActivity.class);
			break;
		case 13:
			startActivity(NetImageActivity.class);
			break;
		case 14:
			startActivity(SmartImageViewActivity.class);
			break;
		case 15:
			startActivity(HtmlWatcherActivity.class);
			break;
		case 16:
			startActivity(NewsActivity.class);
			break;
		case 17://get方式提交表单
			break;
		case 18://post方式提交表单
			break;
		case 19://HttpClient框架方式提交表单（空）
			startActivity(HttpClientActivity.class);
			break;
		case 20://async-http
			break;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ListView mListView = (ListView) findViewById(R.id.lv_main);
		
		MainAdapter adapter = new MainAdapter();
		mListView.setAdapter(adapter);
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivityByPos(position);
			}});
		
		// 为了方便测试最新项目，把ListView滑到最底部。 为什么直接写没有效果，放到View.post方法里面就可以了？
		
		mListView.post(new Runnable() {
			@Override
			public void run() {
				mListView.smoothScrollToPosition(itemNames.length-1);
			}
		});
		
		
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
