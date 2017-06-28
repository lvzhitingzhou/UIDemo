package com.saku.uidemo.data;

import java.io.Serializable;
import java.util.List;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LJ on 2016/5/13.
 */
public class ProductBaseInfo implements Serializable {
    public int productId;
    public int subProductId;
    public int cityId;
    public String name;
    public String appName;
    public boolean preSale;
    public String desc;
    public String desc2;
    public String desc3;
    public String desc4;  // 确认订单- 车辆等级 eg: 舒适型
    public String seatNumDesc;
    public String displacementDesc;
    public String transmissionDesc;
    public String imageUrl;
    public String slogan;
    public int typeId;
    public int levelId;
    public int lisenceType;
    public String lisenceName;
    public StorageInfo storageInfo;
    public String specialTitle; // 惊喜产品标题 4.4.10
    public String specialUrl;  // 惊喜产品H5链接  4.4.10
    public List<ProductDetailImage> images;
    public List<String> tags;
    public boolean special;  //是否是惊喜产品
    public List<ProductTag> level2Tags;

    // 选车型页面 用户 点击展开或关闭view的状态
    private boolean isCarTypeOpen = false;   // 车型图片layout是否打开
    private boolean isDailyRentalOpen = false;  // 每日租金layout是否打开
    private int lastDotPos = 0;  // 上一个选中的点的位置
    private String activityText = "";
    private String couponText = "";
//    private String finalPrice = "";

    private boolean isActListOpen;

    private String processedDesc2 = "";

    public boolean isActListOpen() {
        return isActListOpen;
    }

    public void setActListOpen(boolean actListOpen) {
        isActListOpen = actListOpen;
    }

    public boolean isCarTypeOpen() {
        return isCarTypeOpen;
    }

    public boolean isDailyRentalOpen() {
        return isDailyRentalOpen;
    }

    public int getLastDotPos() {
        return lastDotPos;
    }

    public void setCarTypeOpen(boolean carTypeOpen) {
        isCarTypeOpen = carTypeOpen;
    }

    public void setDailyRentalOpen(boolean dailyRentalOpen) {
        isDailyRentalOpen = dailyRentalOpen;
    }

    public void setLastDotPos(int lastDotPos) {
        this.lastDotPos = lastDotPos;
    }


    public String getActivityText() {
        return activityText;
    }

    public void setActivityText(String activityText) {
        this.activityText = activityText;
    }

    public String getCouponText() {
        return couponText;
    }

    public void setCouponText(String couponText) {
        this.couponText = couponText;
    }


//    public String getFinalPrice() {
//        return finalPrice;
//    }
//
//    public void setFinalPrice(String finalPrice) {
//        this.finalPrice = finalPrice;
//    }

    public String getProcessedDesc2() {
        return processedDesc2;
    }

    public void setProcessedDesc2(String processedDesc2) {
        this.processedDesc2 = processedDesc2;
    }

}
