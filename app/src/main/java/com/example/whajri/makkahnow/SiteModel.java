package com.example.whajri.makkahnow;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class SiteModel implements Parcelable {
    private int mSiteImage;

    private int mIndicator;

    public int getmSiteImage() {
        return mSiteImage;
    }

    public int getmIndicator() {
        return mIndicator;
    }

    public SiteModel(int mSiteImage, int mIndicator) {
        this.mSiteImage = mSiteImage;
        this.mIndicator = mIndicator;
    }

    public void setmSiteImage(int mSiteImage) {

        this.mSiteImage = mSiteImage;
    }

    public void setmIndicator(int mIndicator) {
        this.mIndicator = mIndicator;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}