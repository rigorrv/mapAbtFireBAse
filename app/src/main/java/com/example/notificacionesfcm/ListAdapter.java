package com.example.notificacionesfcm;

/**
 * Created by Juned on 1/30/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter
{

    String colorText;

    Context context;

    public static List<Subject> subject_list;

    public ListAdapter(List<Subject> listValue, Context context)
    {
        this.context = context;
        this.subject_list = listValue;




    }

    @Override
    public int getCount()
    {


        if(this.subject_list == null){

            //error
        }else {
            return this.subject_list.size();

        }

        return 0;
    }

    @Override
    public Object getItem(int position)
    {
        return this.subject_list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {


        ViewItem viewItem = null;
        if(convertView == null)
        {


            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            if(MainActivity.LocationSection == 1) {
                drawable.setStroke(3, Color.parseColor("#AC3A38"));
                 colorText = "#E5A4A3";
            }
            if(MainActivity.LocationSection == 2) {
                drawable.setStroke(3, Color.parseColor("#CE6B3F"));
                 colorText = "#F7BB9D";

            }
            if(MainActivity.LocationSection == 3) {
                drawable.setStroke(3, Color.parseColor("#A9AA24"));
                 colorText = "#E1E195";

            }
            if(MainActivity.LocationSection == 4) {
                drawable.setStroke(3, Color.parseColor("#3B9250"));
                 colorText = "#A3D3AF";

            }
            if(MainActivity.LocationSection == 5) {
                drawable.setStroke(3, Color.parseColor("#387CA1"));
                 colorText = "#A0C7DB";

            }
            if(MainActivity.LocationSection == 6) {
                drawable.setStroke(3, Color.parseColor("#24578F"));
                 colorText = "#96B4D7";

            }
            if(MainActivity.LocationSection == 7) {
                drawable.setStroke(3, Color.parseColor("#5D458D"));
                 colorText = "#B5A7D0";

            }
            if(MainActivity.LocationSection == 8) {
                drawable.setStroke(3, Color.parseColor("#861A6E"));
                 colorText = "#CE8FC0";

            }
            drawable.setCornerRadius(20);
            drawable.setColor(Color.parseColor(MapsActivity.ColorSelectionDark));

            viewItem = new ViewItem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.listview_items, null);

            viewItem.SubNameTextView = (TextView)convertView.findViewById(R.id.SubjectNameTextView);

            viewItem.SubFullFormTextView = (TextView)convertView.findViewById(R.id.SubjectFullFormTextView);
            convertView.setTag(viewItem);

            viewItem.SubNameTextViewInfo = (TextView)convertView.findViewById(R.id.SubjectNameTextViewInfo);

            viewItem.SubFullFormTextViewInfo = (TextView)convertView.findViewById(R.id.SubjectFullFormTextViewInfo);

            //I add this
            viewItem.hourMeeting = (TextView)convertView.findViewById(R.id.hourMeeting);

            viewItem.distanceMeeting = (TextView)convertView.findViewById(R.id.distanceMeeting);

            convertView.setTag(viewItem);

            viewItem.ButtonsMap = (LinearLayout) convertView.findViewById(R.id.ButtonsMap);
            viewItem.ButtonsMap.setBackgroundColor(Color.parseColor(MapsActivity.ColorSelectionDark));
            viewItem.ButtonsMap.setBackgroundDrawable(drawable);
            //viewItem.ButtonsMap.setBackgroundColor(Color.parseColor(MapsActivity2.ColorSelectionDark));



        }
        else
        {
            viewItem = (ViewItem) convertView.getTag();
        }

        viewItem.SubNameTextView.setText(subject_list.get(position).Subject_Name);

        viewItem.SubFullFormTextView.setText(subject_list.get(position).Subject_Full_Form);


        if(MainActivity.sort.contains("1")) {
            //condition for time
            viewItem.hourMeeting.setText(subject_list.get(position).hourSubj);
            viewItem.hourMeeting.setTypeface(null, Typeface.BOLD);
            viewItem.hourMeeting.setTextColor(Color.parseColor("#FFFFFF"));


            viewItem.distanceMeeting.setText(subject_list.get(position).distanceSubj);
            viewItem.distanceMeeting.setTextColor(Color.parseColor(colorText));
        }


        if(MainActivity.sort.contains("2")) {
            //condition for Distance

            //I add this
            viewItem.hourMeeting.setText(subject_list.get(position).hourSubj);
            viewItem.hourMeeting.setTextColor(Color.parseColor(colorText));


            viewItem.distanceMeeting.setText(subject_list.get(position).distanceSubj);
            viewItem.distanceMeeting.setTypeface(null, Typeface.BOLD);
            viewItem.distanceMeeting.setTextColor(Color.parseColor("#ffffff"));
        }



        return convertView;
    }
}

class ViewItem
{
    TextView SubNameTextView;
    TextView SubFullFormTextView;
    TextView SubNameTextViewInfo;
    TextView SubFullFormTextViewInfo;
    LinearLayout ButtonsMap;

    //I add this
    TextView hourMeeting;
    TextView distanceMeeting;

}



