package com.kumar.sooraj.wastetracker;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sooraj on 12/28/2016.
 */

public class editsection extends Fragment {

    private static EditText ed_title;
    private static EditText ed_dandt;
    private static EditText ed_year;
    private static EditText ed_day;
    private static EditText ed_time;
    private static EditText ed_month;



    EditSectionListener activityCommander;

    public interface EditSectionListener
    {
        public void generatePrev(String title, String time, String month, String day, String year);
    }

    public void onClick(View view){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (EditSectionListener) context;
        }catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editsection, container,false);
        ed_title = (EditText)view.findViewById(R.id.ed_title);
        ed_year = (EditText)view.findViewById(R.id.ed_year);
        ed_day = (EditText)view.findViewById(R.id.ed_day);
        ed_time = (EditText)view.findViewById(R.id.ed_time);
        ed_month = (EditText)view.findViewById(R.id.ed_month);

        final Button b_create;
        final Button b_preview;
        b_create = (Button)view.findViewById(R.id.b_create);
        b_preview = (Button)view.findViewById(R.id.b_preview);

        b_preview.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );

        b_create.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                            Intent i = new Intent(getActivity(), trackerfront.class);
                            i.putExtra("title", ed_title.getText().toString());

                            i.putExtra("year", ed_year.getText().toString());
                            i.putExtra("time", ed_time.getText().toString());
                            i.putExtra("day", ed_day.getText().toString());
                            i.putExtra("month", ed_month.getText().toString());
                            Log.v("apples", "right before I start the activity");
                            startActivity(i);

                    }

                }
        );
        return view;
    }

    public void buttonClicked(View v)
    {
        activityCommander.generatePrev(ed_title.getText().toString(), ed_time.getText().toString(), ed_month.getText().toString(), ed_day.getText().toString(), ed_year.getText().toString());
    }


}
