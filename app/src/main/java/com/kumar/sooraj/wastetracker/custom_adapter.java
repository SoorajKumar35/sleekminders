package com.kumar.sooraj.wastetracker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sooraj on 12/29/2016.
 */

class custom_adapter extends BaseAdapter {

    ArrayList<reminder> list;
    Context c;
    public custom_adapter(Context context, ArrayList<reminder> rems){
        this.c = context;
        list = rems;
    }
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.reminder_row_2, parent, false);
        TextView title = (TextView)row.findViewById(R.id.new_reminder_row_2_title);
        TextView dandt = (TextView)row.findViewById(R.id.new_reminder_row_2_Date);
        TextView address = (TextView)row.findViewById(R.id.new_reminder_row_2_addr);
        final reminder data = list.get(position);
        if(data.title == null){
            data.title = "reminder";
        }
        title.setText(data.title);
        dandt.setText(data.hour + ":" + data.min + " " + data.day + "/" + data.month + "/" + data.year);
        address.setText(data.address);

   /*     TextView title = (TextView)row.findViewById(R.id.new_reminder_row_2_title);
        TextView dandt = (TextView)row.findViewById(R.id.new_reminder_row_2_Date);
        TextView address = (TextView)row.findViewById(R.id.new_reminder_row_2_addr);
        reminder data = list.get(position);
        title.setText(data.title);
        dandt.setText(data.hour + ":" + data.min + " " + data.day + "/" + data.month + "/" + data.year);
        address.setText(data.address);*/
        String color = data.color;
        Log.v(color, "");
        if(color == "blue")
        {
            title.setBackgroundResource(R.color.blue);
            dandt.setBackgroundResource(R.color.blue);
            address.setBackgroundResource(R.color.blue);
        }
        else if(color == "red")
        {
            title.setBackgroundResource(R.color.red);
            dandt.setBackgroundResource(R.color.red);
            address.setBackgroundResource(R.color.red);
        }
        else if(color == " yellow")
        {
            title.setBackgroundResource(R.color.yellow);
            dandt.setBackgroundResource(R.color.yellow);
            address.setBackgroundResource(R.color.yellow);
        }
        else if(color == "white")
        {
            title.setBackgroundResource(R.color.white);
            dandt.setBackgroundResource(R.color.white);
            address.setBackgroundResource(R.color.white);
        }
        else if(color == "green")
        {
            title.setBackgroundResource(R.color.green);
            dandt.setBackgroundResource(R.color.green);
            address.setBackgroundResource(R.color.green);
        }
        else if(color == "orange")
        {
            title.setBackgroundResource(R.color.orange);
            dandt.setBackgroundResource(R.color.orange);
            address.setBackgroundResource(R.color.orange);
        }
        return row;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
