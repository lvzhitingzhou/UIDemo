package com.saku.uidemo.data.listdata;

import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.ProductPriceInfo;
import com.saku.uidemo.utils.SetUtils;

/**
 * 中间的数据
 *
 */
public class MiddleData implements ItemData {
    public String specialTitle; // 惊喜产品标题 4.4.10
    public String specialUrl;  // 惊喜产品H5链接  4.4.10

    public boolean special;  //是否是惊喜产品
    public String desc3;    // 非惊喜型产品， 车型点击展示和关闭

    public int imageSize; // 几种车型随机展开

    // 选车型页面 用户 点击展开或关闭view的状态
    private boolean isCarTypeOpen = false;   // 车型图片layout是否打开
    private boolean isDailyRentalOpen = false;  // 每日租金layout是否打开
    private int lastDotPos = 0;  // 上一个选中的点的位置

    public MiddleData(ProductBaseInfo productBaseInfo) {
        this.specialTitle = productBaseInfo.specialTitle;
        this.specialUrl = productBaseInfo.specialUrl;
        this.special = productBaseInfo.special;
        this.desc3 = productBaseInfo.desc3;
        if (SetUtils.notEmpty(productBaseInfo.images)){
            this.imageSize = productBaseInfo.images.size();
        }
    }


    public boolean isCarTypeOpen() {
        return isCarTypeOpen;
    }

    public void setCarTypeOpen(boolean carTypeOpen) {
        isCarTypeOpen = carTypeOpen;
    }

    public boolean isDailyRentalOpen() {
        return isDailyRentalOpen;
    }

    public void setDailyRentalOpen(boolean dailyRentalOpen) {
        isDailyRentalOpen = dailyRentalOpen;
    }

    public int getLastDotPos() {
        return lastDotPos;
    }

    public void setLastDotPos(int lastDotPos) {
        this.lastDotPos = lastDotPos;
    }


}
