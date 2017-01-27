package com.kumar.sooraj.wastetracker;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Sooraj on 1/6/2017.
 */

public class image_adapter extends ArrayAdapter<Integer> {
    Integer[] images;
    public image_adapter(Context context, Integer[] images){
        super(context,android.R.layout.simple_spinner_dropdown_item, images );
        Log.v("got after the super", "");
        this.images = images;
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
        imageView.setBackgroundResource(images[position]);
        imageView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return imageView;
    }
}
