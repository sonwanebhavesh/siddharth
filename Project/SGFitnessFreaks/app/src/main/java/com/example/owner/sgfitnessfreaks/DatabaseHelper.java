package com.example.owner.sgfitnessfreaks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vaishnavi marawar on 4/26/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_Name="FaircrmInfo.db";
    public static final String TABLE_NAME="FaircrmDetails";
    public static final String COL_1="Brandf";
    public static final String COL_2="Productf";
    public static final String COL_3="Costf";
    public static final String COL_4="Availablef";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(Brandf TEXT,Productf TEXT,Costf INTEGER,Availablef INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean inserdataf(String brandf,String productf,String costf,String availablef)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,brandf);
        contentValues.put(COL_2,productf);
        contentValues.put(COL_3,costf);
        contentValues.put(COL_4,availablef);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String brandf,String productf,String costf,String availablef)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,brandf);
        contentValues.put(COL_2,productf);
        contentValues.put(COL_3,costf);
        contentValues.put(COL_4,availablef);
        db.update(TABLE_NAME,contentValues,"Brandf=?",new String[] {brandf});
        return true;
    }
    public Integer deleteData(String brandf)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"Brandf=?",new String[] {brandf});
    }
}
