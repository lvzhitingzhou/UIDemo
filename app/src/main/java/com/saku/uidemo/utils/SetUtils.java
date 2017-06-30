package com.saku.uidemo.utils;

import java.util.List;

public class SetUtils {

    public static boolean notEmpty(List list) {
        return !(list == null || list.isEmpty());
    }

    public static boolean isEmpty(List list) {
        return (list == null || list.isEmpty());
    }
}
