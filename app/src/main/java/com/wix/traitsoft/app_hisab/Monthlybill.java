package com.wix.traitsoft.app_hisab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.id;
import static com.wix.traitsoft.app_hisab.BlankFragment.i;
import static com.wix.traitsoft.app_hisab.MainActivity.j;

public class Monthlybill extends AppCompatActivity {

    Button new_bill, edit_bill, generate_bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthlybill);


        new_bill = (Button) findViewById(R.id.new_bill);
        edit_bill = (Button) findViewById(R.id.edit_bill);
        generate_bill = (Button) findViewById(R.id.generate_bill);

        new_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                try{

                    SQLiteDatabase database = openOrCreateDatabase("cms", MODE_PRIVATE, null);
                    SQLiteDatabase database1 = openOrCreateDatabase("cms", MODE_PRIVATE, null);

                    database.execSQL("Create Table if not exists abc(id integer primary key autoincrement, data varchar,price double)");
                    database1.execSQL("Create Table if not exists monthly(id integer primary key autoincrement, data varchar,price double)");

                //database1.execSQL("DROP TABLE IF EXISTS monthly");

                    Cursor cursor=database.rawQuery("Select * FROM abc",null);
                    cursor.moveToFirst();
                    int count = cursor.getCount();

                    int id=1;

                    Cursor cursor1=database1.rawQuery("Select * FROM monthly",null);
                    if(cursor1.getCount()>0)
                    {
                        cursor1.moveToLast();
                        id = cursor.getCount();
                        id++;
                    }

                //Toast.makeText(Monthlybill.this,"id",Toast.LENGTH_LONG).show();



                    if(count>=0)
                    {
                        for(int i=0;i<count;i++)
                        {
                            String str=cursor.getString(1);
                            double d = cursor.getDouble(2);
                            Toast.makeText(Monthlybill.this,"qwerty",Toast.LENGTH_LONG).show();
                            database1.execSQL("Insert INTO monthly values('"+id+"','"+str+"','"+d+"')");
                            id++;
                        }
                    }

                    cursor.close();
                    cursor1.close();
                    database.close();
                    database1.close();

                    Toast.makeText(Monthlybill.this,"this is working fine",Toast.LENGTH_LONG).show();


                }catch (Exception e){

                }

               try {

                    SQLiteDatabase database = openOrCreateDatabase("cms", MODE_PRIVATE, null);  //make an object to open table1

                    database.execSQL("Create Table if not exists abc(id integer primary key autoincrement, data varchar,price double)");
                    database.execSQL("DROP TABLE IF EXISTS abc");
                   database.close();


                } catch (Exception e) {

                }

                Intent intent = new Intent(Monthlybill.this, MainActivity.class);
                startActivity(intent);


            }
        });

        edit_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("key","cms");
                startActivity(i);
            }
        });

        generate_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("key","cmsmonth");
                startActivity(i);

            }
        });


    }


}
