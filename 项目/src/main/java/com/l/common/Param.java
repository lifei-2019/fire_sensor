package com.l.common;

/**
 * 变量参数
 */
public class Param {

    /**
     * 增长因子
     */
    private double factor;
    /**
     * 最低高度
     */
    private double minHeight;
    /**
     * 面积
     */
    private double area;
    /**
     * 时间间隔
     */
    private double interval;

    /**
     * 房屋高度
     */
    private double buildHeight;

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public double getBuildHeight() {
        return buildHeight;
    }

    public void setBuildHeight(double buildHeight) {
        this.buildHeight = buildHeight;
    }
}
