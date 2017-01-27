package com.kumar.sooraj.wastetracker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Sooraj on 1/7/2017.
 */

public class image_adapter_3 extends ArrayAdapter<Integer> {
    Integer[] colors;
    public image_adapter_3(Context context, Integer[] colors){
        super(context,android.R.layout.simple_spinner_item, colors);
        Log.v("got after super TUESDAY", "");
        this.colors = colors;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getImageForPosition(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getImageForPosition(position);
    }

    private View getImageForPosition(int position) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(colors[position]);
        imageView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return imageView;
    }
}
