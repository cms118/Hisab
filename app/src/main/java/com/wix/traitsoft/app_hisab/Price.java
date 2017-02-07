package com.wix.traitsoft.app_hisab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Price extends DialogFragment {

    TextView textView;
    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_price, container, false);

        MainActivity mainActivity=new MainActivity();
        double d;
        d=mainActivity.getPrice();

        textView=(TextView)view.findViewById(R.id.pricetext);
        textView.setText(""+d);

        button=(Button)view.findViewById(R.id.priceok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });




        return view;
    }

}

