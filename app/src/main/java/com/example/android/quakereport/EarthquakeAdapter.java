package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by W10 on 8/5/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakeList){
        super(context, 0, earthquakeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        double magnitude = currentEarthquake.getmMagnitude();
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(formatMagnitude(magnitude));

        String location = currentEarthquake.getmLocation();
        String offsetLocation = "Near the";
        String primaryLocation = location;
        if (location.contains("of")) {
            offsetLocation = location.substring(0, location.indexOf("of") + 2);
            primaryLocation = location.substring(location.indexOf("of") + 3);
        }
        TextView offsetLocationView = (TextView) listItemView.findViewById(R.id.offsetlocation);
        offsetLocationView.setText(offsetLocation);

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primarylocation);
        primaryLocationView.setText(primaryLocation);

        long timeInMillisec = currentEarthquake.getmTime();
        String dateToDisplay = formatDate(timeInMillisec);
        String timeToDisplay = formatTime(timeInMillisec);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        dateView.setText(dateToDisplay);
        timeView.setText(timeToDisplay);



        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }
    private String formatMagnitude(double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMagnitude = formatter.format(magnitude);
        return formattedMagnitude;
    }
    private String formatDate(long millisec){
        Date dateObject = new Date(millisec);
        SimpleDateFormat formatter = new SimpleDateFormat("MMM DD,yyyy");
        String formattedDate = formatter.format(dateObject);
        return formattedDate;
    }
    private String formatTime(long millisec){
        Date dateObject = new Date(millisec);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM a");
        String formattedTime = formatter.format(dateObject);
        return formattedTime;
    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResId ;
        int magnitudeColor; // We need to convert magnitudeColorResId to magnitudeColor integer.
        switch ((int)magnitude){
            case 0 :
            case 1 :
                magnitudeColorResId = R.color.magnitude1;
                break;
            case 2 :
                magnitudeColorResId = R.color.magnitude2;
                break;
            case 3 :
                magnitudeColorResId = R.color.magnitude3;
                break;
            case 4 :
                magnitudeColorResId = R.color.magnitude4;
                break;
            case 5 :
                magnitudeColorResId = R.color.magnitude5;
                break;
            case 6 :
                magnitudeColorResId = R.color.magnitude6;
                break;
            case 7 :
                magnitudeColorResId = R.color.magnitude7;
                break;
            case 8 :
                magnitudeColorResId = R.color.magnitude8;
                break;
            case 9 :
                magnitudeColorResId = R.color.magnitude9;
                break;
            default :
                magnitudeColorResId = R.color.magnitude10plus;
                break;
        }
        magnitudeColor = ContextCompat.getColor(getContext(), magnitudeColorResId);
        return magnitudeColor;
    }
}
