package com.saku.uidemo.data.listdata;

import com.saku.uidemo.data.DatePrice;
import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.ProductDetailImage;
import com.saku.uidemo.data.ProductPriceInfo;

import java.util.List;

public class DailyPriceData implements ItemData {
    public List<DatePrice> datePrices;

    public DailyPriceData(ProductPriceInfo productPriceInfo) {
        this.datePrices = productPriceInfo.datePrices;
    }
}
