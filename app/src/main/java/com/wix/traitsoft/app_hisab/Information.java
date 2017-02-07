package com.wix.traitsoft.app_hisab;

import android.widget.EditText;

import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.id.edit;

/**
 * Created by Asus on 09-12-2016.
 */

public class Information {
    private int but;
    private String edit;
    private boolean bool;
    private double num;

    EditText editText;

    public Information() {
    }

    public Information(int but, String edit,double num, boolean bool) {
        this.but = but;
        this.edit = edit;
        this.bool = bool;
        this.num=num;
    }


    public int getBut() {
        return but;
    }

    public void setBut(int name) {
        this.but = name;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public boolean getBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public double getnum() {
        return num;
    }
}
