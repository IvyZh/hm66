package com.ivy.hm66.activity.test;

import com.ivy.hm66.activity.MyOpenHelper;
import com.ivy.hm66.activity.utils.FileUtil;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class Test extends AndroidTestCase {
	private MyOpenHelper oh;
	private SQLiteDatabase db;
	//This method is called before a test is executed. 
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		 oh = new MyOpenHelper(getContext());
		 db = oh.getWritableDatabase();
	}

	//This method is called after a test is executed. 
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		db.close();
	}
	/**
	 * 测试数据库创建
	 */
	public void testCreateDB(){
		System.out.println("testCreateDB...");
		// getContext() 获取一个虚拟上下文
//		MyOpenHelper oh = new MyOpenHelper(getContext());
//		SQLiteDatabase db = oh.getWritableDatabase();
	}
	
	
	//============================================================================
	
	
	/**
	 * 测试插入数据
	 */
	public void testAdd(){
//		MyOpenHelper oh = new MyOpenHelper(getContext());
//		SQLiteDatabase db = oh.getWritableDatabase();
		db.execSQL("insert into person(name,phone,salary) values(?,?,?)",new Object[]{"zhangsan","10086",5000});
		db.execSQL("insert into person(name,phone,salary) values(?,?,?)",new Object[]{"lisi","10010",6000});
		db.execSQL("insert into person(name,phone,salary) values(?,?,?)",new Object[]{"wangwu","10001",7000});
		
//		db.close();
	}
	
	/**
	 * 删除数据
	 */
	public void testDelete(){
//		MyOpenHelper oh = new MyOpenHelper(getContext());
//		SQLiteDatabase db = oh.getWritableDatabase();
		db.execSQL("delete from person where name = ?", new Object[]{"wangwu"});
		
//		db.close();
	}
	
	/**
	 * 修改
	 */
	public void testUpdate(){
		db.execSQL("update person set salary = ? where name = ? ",new Object[]{6200,"lisi"});
	}
	
	
	/**
	 * 查询
	 */
	public void testSelect(){
		Cursor cursor = db.rawQuery("select * from person ", null);
		
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
			System.out.println(name+":"+phone+":"+salary);
			
		}
	}
	
	//============================================================================
	
	public void insertApi(){
		ContentValues values = new ContentValues();
		values.put("name", "zhaoliu");
		values.put("phone", "110");
		values.put("salary", "6000");
		
		long id = db.insert("person", null, values);
		System.out.println(id);//返回主键
	}
	public void deleteApi(){
		int numbers = db.delete("person", "_id = ?", new String[]{"4"});//返回影响的行数
	}
	public void updateApi(){
		ContentValues values = new ContentValues();
		values.put("salary", "8888");
		int numbers = db.update("person", values , "_id = ?", new String[]{"3"});//返回影响的行数
	}
	public void selectApi(){
		Cursor cursor = db.query("person", null, null, null, null, null, null);
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
			System.out.println(name+":"+phone+":"+salary);
			
		}
	}
	//============================================================================
	
	
	public void transaction(){
		try {
			db.beginTransaction();//开启事务
			
			ContentValues values = new ContentValues();
			values.put("salary", 4000);
			db.update("person", values , "name = ?", new String[]{"zhangsan"});
			
			values.clear();//清空数据
			values.put("salary", 7000);
			db.update("person", values , "name = ?", new String[]{"lisi"});
			
//			int i = 9/0;
			//设置事务执行成功，提交时，如果代码没有执行过，就会回滚
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.endTransaction();//关闭事务，提交数据
		}
	}
	
	//============================================================================
	
	/**
	 * 模拟插入50条数据
	 */
	public void addFakeData(){
		for (int i = 0;i<50;i++) {
			ContentValues values = new ContentValues();
			values.put("name", "张"+i);
			values.put("phone", "1000"+i);
			values.put("salary", "3000"+i);
			db.insert("person", null, values);
		}
	}
	
	public void test(){
		String string = FileUtil.rFromSdcard("smss.xml");
		if(string!=null){
			System.out.println(string);
		}else{
			System.out.println("文件不存在");
		}		
	}
}
