package com.wix.traitsoft.app_hisab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Monthly_bill extends Fragment {

    Button new_bill,edit_bill,generate_bill;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_monthly_bill, container, false);

        new_bill = (Button)view.findViewById(R.id.new_bill);
        edit_bill = (Button)view.findViewById(R.id.edit_bill);
        generate_bill = (Button)view.findViewById(R.id.generate_bill);

        new_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        edit_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        generate_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

}