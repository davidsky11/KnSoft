package com.kn.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "ACCOUNT";
	private static final String DETAILS_CREATE_SQL = "CREATE TABLE IF NOT EXISTS details ('_id' integer not null autoincrement , 'details_date' data, 'account_id' integer, 'type_id' integer, 'details_money' double, primary key('_id'))";
	private static final String DETAILS_DROP_SQL = "DROP TABLE details IF NOT EXISTS";
	private static final String USER_CREATE_SQL = "CREATE TABLE IF NOT EXISTS user ('_id' integer not null autoincrement, 'username' text, 'password' text, primary key('_id'))";
	private static final String USER_DROP_SQL = "DROP TABLE user IF NOT EXISTS";
	private static final int VERSION = 1;
	private SQLiteDatabase database;

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}
	
	public void close() {

	}

	public void onCreate(SQLiteDatabase database) {
		this.database = database;
		database.execSQL(DETAILS_CREATE_SQL);
		database.execSQL(USER_CREATE_SQL);
	}

	public void onUpgrade(SQLiteDatabase database, int old_version,
			int new_version) {
		this.database = database;
		database.execSQL(DETAILS_DROP_SQL);
		database.execSQL(USER_DROP_SQL);
	}

	public <T> void save(T t) {
		this.database = getWritableDatabase();
		new ContentValues();
	}
}
