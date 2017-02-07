package com.wix.traitsoft.app_hisab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import static android.R.attr.id;
import static android.content.Context.MODE_PRIVATE;
import static com.wix.traitsoft.app_hisab.MainActivity.totalprice;

/**
 * Created by Asus on 06-02-2017.
 */

public class Database {

    int id=1;

    public void prepareData(String str,double d) {

        SQLiteDatabase database=openOrCreateDatabase("cms",MODE_PRIVATE,null);
        database.execSQL("Create Table if not exists abc(id integer primary key autoincrement,data1 varchar,price double)");
        try{
            Cursor resultSet = database.rawQuery("Select * from abc",null);
            resultSet.moveToLast();
            id=resultSet.getInt(0);
            id++;
            resultSet.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
}
