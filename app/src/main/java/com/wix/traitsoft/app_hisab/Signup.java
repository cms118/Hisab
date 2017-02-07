package com.wix.traitsoft.app_hisab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    Button b1;  //Button for signup
    EditText ed1,ed2,ed3;       //Differnt fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        b1=(Button)findViewById(R.id.signup1);  //Button for signup
        ed1=(EditText)findViewById(R.id.eduser1);   //username
        ed2=(EditText)findViewById(R.id.edpasswd1);     //password
        ed3=(EditText)findViewById(R.id.edmobile1);     //mobile no.


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=ed1.getText().toString();
                String str2=ed2.getText().toString();
                String str3=ed3.getText().toString();

                if(str1.equals("")||str2.equals("")||str3.equals("")){      //If any field is empty then a toast pops up
                    Toast.makeText(Signup.this,"Please Fill The Details",Toast.LENGTH_LONG).show();
                }

                else{
                    SQLiteDatabase database=openOrCreateDatabase("cms",MODE_PRIVATE,null);      //open the database


                    database.execSQL("Create Table if not exists nit(name Varchar,Password Varchar,Mobile Varchar)");   //open the table

                    String str="Select * FROM nit WHERE name == '"+str1+"'";    //string for sql query
                    Cursor cursor=database.rawQuery(str,null);
                    if(cursor.getCount()==0) {

                        /*

                        If the value is nonzero then it ensures that a user with the username provided is already registered

                         */
                        database.execSQL("Insert Into nit values ('" + str1 + "','" + str2 + "', '"+str3+"')");
                        Toast.makeText(Signup.this, "Database Updated", Toast.LENGTH_LONG).show();
                        Intent intent =new Intent(Signup.this,Login.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(Signup.this,"Username Already Exists",Toast.LENGTH_LONG).show();     //username already exists
                        ed1.setText("");
                        ed2.setText("");
                    }
                    cursor.close();
                    database.close();
                }
            }
        });

    }
}
