package com.ivy.hm66.activity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ivy.hm66.MainActivity;
import com.ivy.hm66.R;
import com.ivy.hm66.activity.cons.Constant;
import com.ivy.hm66.activity.domain.News;
import com.loopj.android.image.SmartImageView;

/**
 * 演示 新闻客户端 界面
 * 
 * @author Ivy
 */
public class NewsActivity extends Activity {
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
			case 0:
				Toast.makeText(NewsActivity.this, "请求失败", 0).show();
				break;
			case 1:
				ListView lv = (ListView) findViewById(R.id.lv);
				MyAdapter adapter = new MyAdapter();
				lv.setAdapter(adapter);
				break;
			}
			
		};
	};

	private List<News> newsList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fakenews);
		
		
		
		
	}
	
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return newsList.size();
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			News news = newsList.get(position);
			ViewHolder holder;
			if(convertView==null){
				convertView = View.inflate(NewsActivity.this, R.layout.item_news, null);
				holder = new ViewHolder();
				holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
				holder.tvComments = (TextView) convertView.findViewById(R.id.tv_comment);
				holder.tvDetail = (TextView) convertView.findViewById(R.id.tv_detail);
				holder.siv = (SmartImageView) convertView.findViewById(R.id.siv);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.tvTitle.setText(news.getTitle());
			holder.tvComments.setText(news.getComments()+"条评论");
			holder.tvDetail.setText(news.getDetail());
			holder.siv.setImageUrl(Constant.HOST_news_img+news.getImageUrl());
			return convertView;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}
	}
	
	class ViewHolder{
		TextView tvTitle;
		TextView tvComments;
		TextView tvDetail;
		SmartImageView siv;
		
		
	}

	public void click(View v) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				String path = Constant.HOST_news;
				System.out.println(path);
				
				try {
					//1.通过地址构造url对象
					URL url = new URL(path);
					//2.打开连接器
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					//3. 设置一下请求属性
					//设置请求方式，注意大写
					conn.setRequestMethod("GET");
					//设置连接超时
					conn.setConnectTimeout(8000);
					//设置读取时间超时
					conn.setReadTimeout(8000);
					//4. 发送请求
					conn.connect();
					//5.获得响应码
					if(conn.getResponseCode()==200){
						//6.取得流信息
						InputStream is = conn.getInputStream();
						
						//7. 把流解析成xml文件
						getXmlFromIs(is);
						handler.sendEmptyMessage(1);
					
//						Message msg = Message.obtain();
//						msg.obj = text;
//						msg.what = 1;
//						handler.sendMessage(msg);
						
					}else{
//						Message msg = Message.obtain();
//						msg.what = 0;
//						handler.sendMessage(msg);
						handler.sendEmptyMessage(0);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
					handler.sendEmptyMessage(0);
				}
			
			}
		}).start();
	}
	
	public void getXmlFromIs(InputStream is){
		try {
			XmlPullParser parser = Xml.newPullParser();
			parser.setInput(is, "utf-8");
			int type = parser.getEventType();
			News news = null;
			while(type!=XmlPullParser.END_DOCUMENT){
				switch (type) {
				case XmlPullParser.START_TAG:
					if("newslist".equals(parser.getName())){
						newsList = new ArrayList<News>();
					}else if("news".equals(parser.getName())){
						news = new News();
					}else if("title".equals(parser.getName())){
						news.setTitle(parser.nextText());
					}else if("detail".equals(parser.getName())){
						news.setDetail(parser.nextText());
					}else if("comment".equals(parser.getName())){
						news.setComments(parser.nextText());
					}else if("image".equals(parser.getName())){
						news.setImageUrl(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if("news".equals(parser.getName())){
						newsList.add(news);
					}
					break;

				}
				type = parser.next();
			}
			
			for (News newss : newsList) {
				System.out.println(newss);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
