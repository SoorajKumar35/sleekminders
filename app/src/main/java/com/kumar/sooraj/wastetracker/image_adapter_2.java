package com.kumar.sooraj.wastetracker;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by Sooraj on 1/7/2017.
 */

public class image_adapter_2 extends ArrayAdapter<intimgpair> {
    intimgpair[] pairs;
    public image_adapter_2(Context context, intimgpair[] pairs){
        super(context,android.R.layout.simple_spinner_item, pairs );
        Log.v("got after super TUESDAY", "");
        this.pairs = pairs;
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
        imageView.setBackgroundResource(pairs[position].drawableID);
        imageView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return imageView;
    }
}
