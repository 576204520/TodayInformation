package com.news.today.todayinformation.main.shanghai.dto;

import java.util.ArrayList;

/**
 * Created by anson on 2018/12/4.
 */
public class ShanghaiBean {
    private int mType = IShanghaiItemType.VERTICAL;
    private String mDec;
    private boolean isHaveImage;
    private ArrayList<ShanghaiBean> mData;

    public int getmType() {
        return mType;
    }

    public ShanghaiBean setmType(int mType) {
        this.mType = mType;
        return this;
    }

    public String getmDec() {
        return mDec;
    }

    public ShanghaiBean setmDec(String mDec) {
        this.mDec = mDec;
        return this;
    }

    public boolean isHaveImage() {
        return isHaveImage;
    }

    public ShanghaiBean setHaveImage(boolean haveImage) {
        isHaveImage = haveImage;
        return this;
    }

    public ArrayList<ShanghaiBean> getmData() {
        return mData;
    }

    public ShanghaiBean setmData(ArrayList<ShanghaiBean> mData) {
        this.mData = mData;
        return this;
    }

    public interface IShanghaiItemType{
        int VERTICAL = 0;
        int HORIZONTAL = 1;
    }

}
