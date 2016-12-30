package com.example.vcssolution.myapplication123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VCSSolution on 12/29/2016.
 */

public class Adapterclass {
    public static final String KEY_ID="id";
    public static final String KEY_NAME="name";
    public static final String KEY_EMAIL="email";
    public static final String DATABASE_NAME="MJDB";
    public static final String DATABASE_TABLE="contacts";
    public static final int DATABASE_VERSION=1;
//    public static final String DATABASE_CREATE="create table contacts(id integer primary key autoincrement,"+" name text not null, email text not null);";
    private final Context context;
    private SQLiteDatabase db;
    private subclass s;

    public Adapterclass(Context ctx) {
        this.context = ctx;
        s=new subclass(context);
    }
    public static class subclass extends SQLiteOpenHelper {
        public subclass(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
//            db.execSQL(DATABASE_CREATE);
            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DATABASE_TABLE + "("

                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"

                    + KEY_EMAIL + " TEXT" + ")";

            db.execSQL(CREATE_CONTACTS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    public void open()
    {
        db=s.getReadableDatabase();
    }
    public long insert(String s1,String s2)
    {
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,s1);
        cv.put(KEY_EMAIL,s2);
        return db.insert(DATABASE_TABLE,null,cv);
    }
    public long Update(int i,String s1,String s2)
    {
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,s1);
        cv.put(KEY_EMAIL,s2);
        return db.update(DATABASE_TABLE,cv,KEY_ID+"="+i,null);
    }
    public int delete(int i){
        return db.delete(DATABASE_TABLE,KEY_ID+"="+i,null);
    }
    public Cursor select(int i)
    {
        Cursor c;
        c=db.query(true,DATABASE_TABLE,new String[]{KEY_ID,KEY_NAME,KEY_EMAIL},KEY_ID+"="+i,null,null,null,null,null);
        return c;
    }
    public Cursor selectAll()
    {
        return db.query(DATABASE_TABLE,new String[]{KEY_ID,KEY_NAME,KEY_EMAIL},null,null,null,null,null);
    }
    public void close()
    {
        db.close();
    }
}
