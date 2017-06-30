package com.saku.uidemo.data.listdata;

import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.ProductDetailImage;
import com.saku.uidemo.data.ProductPriceInfo;
import com.saku.uidemo.data.ProductTag;
import com.saku.uidemo.data.SpecialFront;
import com.saku.uidemo.data.StorageInfo;

import java.util.List;

/**
 * 最顶上的数据
 *
 */
public class BaseInfoData implements ItemData {
    public int productId;
    public int subProductId;
    public int cityId;
    public String name;
    public String appName;
    public String desc;
    public String desc2;    // 沪牌|混动|5座

    public String desc4;  // 确认订单- 车辆等级 eg: 舒适型
    public String imageUrl;
    public int lisenceType;
    public String lisenceName;
    public StorageInfo storageInfo;


    public List<String> tags;   // 主图上的标签

    public List<ProductTag> level2Tags;

    public String averagePrice;
    public String actualAveragePrice;
    public String specialName; // 活动名
    public String recommendSpecialDesc;
    public int recommendSpecialDay;
    public String couponReducedMoney;
    public List<SpecialFront> specials;  // 其他的活动列表
    public int specialShowNums;



    private String activityText = "";
    private String couponText = "";
    private boolean isActListOpen;
    private String processedDesc2 = "";


    public BaseInfoData(ProductBaseInfo productBaseInfo, ProductPriceInfo productPriceInfo) {
        this.productId = productBaseInfo.productId;
        this.subProductId = productBaseInfo.subProductId;
        this.cityId = productBaseInfo.cityId;
        this.name = productBaseInfo.name;
        this.appName = productBaseInfo.appName;
        this.desc = productBaseInfo.desc;
        this.desc2 = productBaseInfo.desc2;    // 沪牌|混动|5座

        this.desc4 = productBaseInfo.desc4;  // 确认订单- 车辆等级 eg: 舒适型
        this.imageUrl = productBaseInfo.imageUrl;
        this.lisenceType = productBaseInfo.lisenceType;
        this.lisenceName = productBaseInfo.lisenceName;
        this.storageInfo = productBaseInfo.storageInfo;
        this.tags = productBaseInfo.tags;   // 主图上的标签
        this.level2Tags = productBaseInfo.level2Tags;
        this.averagePrice = productPriceInfo.averagePrice;
        this.actualAveragePrice = productPriceInfo.actualAveragePrice;
        this.specialName = productPriceInfo.specialName; // 活动名
        this.recommendSpecialDesc = productPriceInfo.recommendSpecialDesc;
        this.recommendSpecialDay = productPriceInfo.recommendSpecialDay;
        this.couponReducedMoney = productPriceInfo.couponReducedMoney;
        this.specials = productPriceInfo.specials;  // 其他的活动列表
        this.specialShowNums = productPriceInfo.specialShowNums;
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

    public boolean isActListOpen() {
        return isActListOpen;
    }

    public void setActListOpen(boolean actListOpen) {
        isActListOpen = actListOpen;
    }

    public String getProcessedDesc2() {
        return processedDesc2;
    }

    public void setProcessedDesc2(String processedDesc2) {
        this.processedDesc2 = processedDesc2;
    }
}
