package com.saku.uidemo.data;

import java.io.Serializable;

/**
 * User: Missa
 * Date: 2016-11-22
 * Time: 16:42
 * Description:
 */
public class ProductCompositeInfo implements Serializable {
    public boolean otherLocCanDeliver;
    public ProductBaseInfo productBaseInfo;
    public boolean canDeliver;
    public ProductPriceInfo productPriceInfo;
}
