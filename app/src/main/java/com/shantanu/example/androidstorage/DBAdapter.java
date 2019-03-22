package com.shantanu.example.androidstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    public DBAdapter openDB()
    {
        try {
            db=helper.getWritableDatabase();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this;
    }

    public void closeDB()
    {
        try {
            helper.close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public long add(String name,String pos,String num)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME,name);
            cv.put(Constants.ADDRESS, pos);
            cv.put(Constants.PHONE, num);

            return db.insert(Constants.TABLE_NAME,Constants.ROW_ID,cv);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    //RETRIEVE
    public Cursor getAllEmployees()
    {
        String[] columns={Constants.ROW_ID,Constants.NAME,Constants.ADDRESS,Constants.PHONE};

        return db.query(Constants.TABLE_NAME,columns,null,null,null,null,null);

    }

    //delete
    public int deleteItem(Employee id) {

        int b = 0;
        try {

            b = db.delete(Constants.TABLE_NAME, Constants.ROW_ID + " = '" + id + "'", null);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return b;
    }


}
