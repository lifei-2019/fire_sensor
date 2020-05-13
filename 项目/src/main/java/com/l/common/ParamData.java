package com.l.common;

public class ParamData {
    public static Param param;

    static {
        param = new Param();
        param.setFactor(2.3);
        param.setMinHeight(1.15);
        param.setArea(10);
        param.setInterval(2);
        param.setBuildHeight(3);
    }
}
