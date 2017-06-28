package com.saku.uidemo.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LJ on 2016/5/13.
 */
public class ProductPriceInfo implements Serializable {
    public String averagePrice;
    public String actualAveragePrice;
    public List<DatePrice> datePrices;
    public String specialName; // 活动名
    public String recommendSpecialDesc;
    public int recommendSpecialDay;
    public String couponReducedMoney;
    public List<SpecialFront> specials;  // 其他的活动列表
    public int specialShowNums;
}
