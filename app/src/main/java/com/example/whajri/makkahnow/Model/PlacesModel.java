package com.example.whajri.makkahnow.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PlacesModel implements Parcelable {
    private int mPlaceImage;
    private int mIndicator;
    private int mLevelNumber;

    public PlacesModel(int mPlaceImage, int mIndicator, int mLevelNumber) {
        this.mPlaceImage = mPlaceImage;
        this.mIndicator = mIndicator;
        this.mLevelNumber = mLevelNumber;
    }

    protected PlacesModel(Parcel in) {
        mPlaceImage = in.readInt();
        mIndicator = in.readInt();
        mLevelNumber = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPlaceImage);
        dest.writeInt(mIndicator);
        dest.writeInt(mLevelNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlacesModel> CREATOR = new Creator<PlacesModel>() {
        @Override
        public PlacesModel createFromParcel(Parcel in) {
            return new PlacesModel(in);
        }

        @Override
        public PlacesModel[] newArray(int size) {
            return new PlacesModel[size];
        }
    };

    public void setmPlaceImage(int mPlaceImage) {
        this.mPlaceImage = mPlaceImage;
    }

    public void setmIndicator(int mIndicator) {
        this.mIndicator = mIndicator;
    }

    public void setmLevelNumber(int mLevelNumber) {
        this.mLevelNumber = mLevelNumber;
    }

    public int getmPlaceImage() {
        return mPlaceImage;
    }

    public int getmIndicator() {
        return mIndicator;
    }

    public int getmLevelNumber() {
        return mLevelNumber;
    }
}
