package com.saku.uidemo.data;

import java.io.Serializable;
import java.util.List;

/**
 * User: Missa
 * Date: 2016-11-22
 * Time: 15:59
 * Description:
 */
public class GeneralProduct implements Serializable {
    public List<ProductCompositeInfo> products;
    public List<LicenseCondition> licenseConditions;
    public int orderTimeType;
    public String limitTip;
}




