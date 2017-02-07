package com.wix.traitsoft.app_hisab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class Login extends AppCompatActivity {

    Button b1,b2;       //Button for login and signup
    EditText ed1,ed2;    //Edit text for signin


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1=(Button)findViewById(R.id.login);    //login
        b2=(Button)findViewById(R.id.signup);   //signup
        ed1=(EditText)findViewById(R.id.eduser);    //user
        ed2=(EditText)findViewById(R.id.edpasswd);  //password

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=ed1.getText().toString();   //username
                String str2=ed2.getText().toString();   //password
                if(str1.equals("")||str2.equals("")){   //If any of the field is blank
                    Toast.makeText(Login.this,"Please Fill The Detais",Toast.LENGTH_LONG).show();
                }
                else{
                    SQLiteDatabase database=openOrCreateDatabase("cms",MODE_PRIVATE,null);  //Open the database

                    database.execSQL("Create Table if not exists nit(name Varchar,Password Varchar,Mobile Varchar)");   //Open the Table

                    String str="Select * FROM nit WHERE name=='"+str1+"' and Password=='"+str2+"'";     //Sql Query

                    Cursor cursor=database.rawQuery(str,null);
                    if(cursor.getCount()>0){
                        Intent intent=new Intent(Login.this,Monthlybill.class);     //Opens a new activity of monthly bill
                        startActivity(intent);
                        finish();

                    }

                    else{
                        Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                        ed1.setText("");
                        ed2.setText("");
                    }

                    cursor.close();
                    database.close();

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Signup.class);  //Opens the activity of signup
                startActivity(intent);
            }
        });

    }
}
