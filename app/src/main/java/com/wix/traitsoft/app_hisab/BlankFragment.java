package com.wix.traitsoft.app_hisab;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;
import static android.content.Context.MODE_PRIVATE;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class BlankFragment extends DialogFragment {

    EditText editText,ed1;

    Button add,cancel;

    public static int i=1;


    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank2, container, false);

        editText=(EditText)view.findViewById(R.id.fraged);
        ed1=(EditText)view.findViewById(R.id.fragnum);

        add=(Button)view.findViewById(R.id.fragadd);
        cancel=(Button)view.findViewById(R.id.fragcancel);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=editText.getText().toString();
                String str1=ed1.getText().toString();
                if(str.equals("")){
                    editText.setError("Please fill it");
                }
                else if(str1.equals("")){
                    ed1.setError("Please fill it");
                }
                else{
                    double d= Double.parseDouble(ed1.getText().toString());
                    MainActivity mainActivity=(MainActivity)getActivity();
                    mainActivity.prepareData(str,d);
                    int id=0;

                    SQLiteDatabase database=getActivity().openOrCreateDatabase("cms",MODE_PRIVATE,null);
                    database.execSQL("Create Table if not exists abc(id integer primary key autoincrement,data1 varchar,price double)");
                    try{
                    Cursor resultSet = database.rawQuery("Select * from abc",null);
                    resultSet.moveToLast();
                    id=resultSet.getInt(0);
                    id++;
                        Toast.makeText(getActivity(),id,Toast.LENGTH_LONG).show();
                    resultSet.close();
                    }
                    catch (Exception e) {

                    }

                    if(id==0)
                        id=1;

                    database.execSQL("Insert INTO abc values('"+id+"','"+str+"','"+d+"')");
                    dismiss();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });
        return view;
    }

}
