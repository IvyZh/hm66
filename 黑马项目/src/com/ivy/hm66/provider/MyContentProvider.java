package com.ivy.hm66.provider;

import com.ivy.hm66.db.MyOpenHelper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

	private SQLiteDatabase db;
	private String authority = "com.ivy.hm66.provider";
	private int PERSON_CODE = 0;
	private int CAR_CODE = 1;
	
	private UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	{
		matcher.addURI(authority, "person", PERSON_CODE);
		matcher.addURI(authority, "car", CAR_CODE);
	}

	@Override
	public boolean onCreate() {
		
		MyOpenHelper openHelper = new MyOpenHelper(getContext());
		db = openHelper.getWritableDatabase();
		
		return false;
	}
	
	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
		if(matcher.match(uri)==CAR_CODE){
			cursor = db.query("car", projection, selection, selectionArgs, null, null, sortOrder);
		}else if(matcher.match(uri)==PERSON_CODE){
			cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
		}else{
	        throw new IllegalArgumentException();
	    }
		return cursor;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		System.out.println("--uri--insert--"+uri.toString());
		
		if(matcher.match(uri)==CAR_CODE){
			 db.insert("car", null, values);
		}else if(matcher.match(uri)==PERSON_CODE){
			 db.insert("person", null, values);
			 getContext().getContentResolver().notifyChange(uri, null);
		}else{
	        throw new IllegalArgumentException();
	    }
		return uri ;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int i = 0;
		if(matcher.match(uri)==CAR_CODE){
			i = db.delete("car", selection, selectionArgs);
		}else if(matcher.match(uri)==PERSON_CODE){
			i = db.delete("person", selection, selectionArgs);
			getContext().getContentResolver().notifyChange(uri, null);
		}else{
	        throw new IllegalArgumentException();
	    }
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int i = 0;
		if(matcher.match(uri)==CAR_CODE){
			db.update("car", values, selection, selectionArgs);
		}else if(matcher.match(uri)==PERSON_CODE){
			db.update("person", values, selection, selectionArgs);
			getContext().getContentResolver().notifyChange(uri, null);
		}else{
	        throw new IllegalArgumentException();
	    }
		return i;
		
	}

}
