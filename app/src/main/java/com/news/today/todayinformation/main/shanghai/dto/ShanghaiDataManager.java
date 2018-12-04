package com.news.today.todayinformation.main.shanghai.dto;

import java.util.ArrayList;

/**
 * Created by anson on 2018/12/4.
 */
public class ShanghaiDataManager {

    private static ArrayList<ShanghaiBean> getVerData(int len) {
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setmType(ShanghaiBean.IShanghaiItemType.VERTICAL).setmDec("上海欢迎您").setHaveImage(false);
            data.add(bean);
        }
        return data;
    }

    private static ShanghaiBean getHorData(int len) {
        ShanghaiBean shanghaiBean = new ShanghaiBean();
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setmType(ShanghaiBean.IShanghaiItemType.VERTICAL).setmDec("上海是魔都").setHaveImage(true);
            data.add(bean);
        }
        shanghaiBean.setmData(data);
        shanghaiBean.setmType(ShanghaiBean.IShanghaiItemType.HORIZONTAL);
        return shanghaiBean;
    }

    public static ArrayList<ShanghaiBean> getData() {
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        data.addAll(getVerData(2));
        data.add(getHorData(10));
        data.addAll(getVerData(10));
        data.add(getHorData(10));
        return data;
    }

}
