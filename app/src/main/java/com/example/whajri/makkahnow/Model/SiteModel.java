package com.example.whajri.makkahnow.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class SiteModel implements Parcelable {
    private int mSiteImage;

    private int mIndicator;

    protected SiteModel(Parcel in) {
        mSiteImage = in.readInt();
        mIndicator = in.readInt();
    }

    public static final Creator<SiteModel> CREATOR = new Creator<SiteModel>() {
        @Override
        public SiteModel createFromParcel(Parcel in) {
            return new SiteModel(in);
        }

        @Override
        public SiteModel[] newArray(int size) {
            return new SiteModel[size];
        }
    };

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
        parcel.writeInt(mSiteImage);
        parcel.writeInt(mIndicator);
    }
}