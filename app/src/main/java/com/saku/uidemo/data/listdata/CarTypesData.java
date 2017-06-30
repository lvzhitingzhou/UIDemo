package com.saku.uidemo.data.listdata;

import com.saku.uidemo.data.DatePrice;
import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.ProductDetailImage;
import com.saku.uidemo.data.ProductPriceInfo;

import java.util.List;

public class CarTypesData implements ItemData {
    public List<ProductDetailImage> images;

    public CarTypesData(ProductBaseInfo productBaseInfo) {
        this.images = productBaseInfo.images;
    }
}
