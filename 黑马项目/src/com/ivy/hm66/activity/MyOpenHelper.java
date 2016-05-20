package com.ivy.hm66.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		super(context, "person.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("数据库创建了...");
		db.execSQL("create table person(_id integer primary key autoincrement,name char(10),phone char(20),salary integer(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("数据库更新了...");
	}

}
