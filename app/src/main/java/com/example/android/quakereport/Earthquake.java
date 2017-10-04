package com.example.android.quakereport;

/**
 * Created by W10 on 8/5/2017.
 */

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mTime;
    private String mUrl;

    public Earthquake() {
        mMagnitude = 0;
        mLocation = "NA";
        mTime = 0;
        mUrl = "NA";
    }

    public Earthquake(double magnitude, String location, long time, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTime = time;
        mUrl = url;
    }

    /* getter and setter methods */
    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmLocation() { return mLocation; }

    public void setmLocation(String mMainLocation) {
        this.mLocation = mLocation;
    }

    public long getmTime() {
        return mTime;
    }

    public void setmTime(long mTime) {
        this.mTime = mTime;
    }

    public String getmUrl() { return mUrl; }

    public void setmUrl(String mUrl) { this.mUrl = mUrl; }
}
