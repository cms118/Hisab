package com.wix.traitsoft.app_hisab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Movie;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.id;
import static android.R.attr.value;
import static android.os.Build.VERSION_CODES.M;
import static com.wix.traitsoft.app_hisab.R.id.fab;
import static com.wix.traitsoft.app_hisab.R.id.fab1;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    private List<Information> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EditAdapter mAdapter;
    public static double totalprice=0;
    public static int j=1;

    final int t=10;
    FloatingActionButton fab,fab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        mAdapter = new EditAdapter(arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager=getSupportFragmentManager();
                BlankFragment blankFragment=new BlankFragment();
                blankFragment.show(fragmentManager,"");
            }
        });

        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                Price prices=new Price();
                prices.show(fragmentManager,"");
            }
        });

        String value="";

        Bundle extras = getIntent().getExtras();    //Intent receiving
        if (extras != null) {
             value = extras.getString("key");
        }

        assert value != null;
        if(value.equals("cms")) {       //Ensuring if the button clicked is to write on the existing bill
            totalprice=0.0;
            preparenewData();
        }

        if(value.equals("cmsmonth")) {       //Ensuring if the button clicked is to write on the monthly bill
            totalprice=0.0;
            preparenewDataformonth();
        }

    }


    int id=1;
    public void prepareData(String str,double d) {

        SQLiteDatabase database=openOrCreateDatabase("cms",MODE_PRIVATE,null);
        database.execSQL("Create Table if not exists abc(id integer primary key autoincrement,data1 varchar,price double)");
        try{
        Cursor resultSet = database.rawQuery("Select * from abc",null);
        resultSet.moveToLast();
        id=resultSet.getInt(0);
        id++;
            Toast.makeText(this,"id",Toast.LENGTH_LONG).show();
        resultSet.close();
        }
        catch (Exception e){

        }
        Information information = new Information(id,str,d,true);
        arrayList.add(information);
        totalprice+=d;
        mAdapter.notifyDataSetChanged();
        id++;
    }

    public void preparenewData(){
        SQLiteDatabase database=openOrCreateDatabase("cms",MODE_PRIVATE,null);

        database.execSQL("Create Table if not exists abc(id integer primary key autoincrement, data varchar,price double)");
        Cursor resultSet = database.rawQuery("Select * from abc",null);
        int count=resultSet.getCount();
        resultSet.moveToFirst();
        for(int i=0;i<count;i++)
        {
            int id=resultSet.getInt(0);// 1st column of database abc
            String data1=resultSet.getString(1);// 2nd column of database
            double price=resultSet.getDouble(2);// 3rd column of database
            Information information = new Information(id,data1,price,true);
            arrayList.add(information);
            mAdapter.notifyDataSetChanged();
            resultSet.moveToNext();
            totalprice+=price;
        }
        resultSet.close();
    }

    public void preparenewDataformonth(){
        SQLiteDatabase database=openOrCreateDatabase("cms",MODE_PRIVATE,null);

        database.execSQL("Create Table if not exists monthly(id integer primary key autoincrement, data varchar,price double)");
        Cursor resultSet = database.rawQuery("Select * from monthly",null);
        int count=resultSet.getCount();
        resultSet.moveToFirst();
        for(int i=0;i<count;i++)
        {
            int id=resultSet.getInt(0);// 1st column of database abc
            String data1=resultSet.getString(1);// 2nd column of database
            double price=resultSet.getDouble(2);// 3rd column of database
            Information information = new Information(id,data1,price,true);
            arrayList.add(information);
            mAdapter.notifyDataSetChanged();
            resultSet.moveToNext();
            totalprice+=price;
        }
        resultSet.close();
    }

    public double getPrice(){
        return totalprice;
    }
}
