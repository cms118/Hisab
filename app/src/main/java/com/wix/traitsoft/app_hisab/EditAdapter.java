package com.wix.traitsoft.app_hisab;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.y;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.media.CamcorderProfile.get;

/**
 * Created by Asus on 12-12-2016.
 */

public class EditAdapter extends RecyclerView.Adapter<EditAdapter.MyViewHolder> {

    private List<Information> itemlist;
    //private final OnClickListener mOnClickListener = new MyOnClickListener();

    public class MyViewHolder extends RecyclerView.ViewHolder {



        Button b1;
        EditText ed,ed1;
        CheckBox cb;

        public MyViewHolder(View view) {
            super(view);
            b1 = (Button) view.findViewById(R.id.bsi);
            ed = (EditText) view.findViewById(R.id.editem);
            cb = (CheckBox) view.findViewById(R.id.cb1);
            ed1 = (EditText) view.findViewById(R.id.ednum);
        }

       /* public void onClick(View view) {
            Toast.makeText(view.getContext(), "position = " + getPosition(), Toast.LENGTH_LONG).show();
        }*/

    }


    public EditAdapter(List<Information> itemlist) {
        this.itemlist = itemlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = itemlist.get(position);
        int a=current.getBut();

        double b=current.getnum();

        holder.b1.setText(""+a);
        holder.ed.setText(current.getEdit());
        holder.cb.isChecked();
        holder.ed1.setText(""+b);
    }





    @Override
    public int getItemCount() {
        return itemlist.size();
    }
}
