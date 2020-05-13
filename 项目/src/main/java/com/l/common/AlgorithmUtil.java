package com.l.common;

import com.l.bean.Fire;

/**
 * 算法工具类
 */
public class AlgorithmUtil {

    public static void algorithm(Fire fire, Param param) {

        // 温度
        double fireTemp = fire.getFireTemp();
        // 湿度
        double fireHum = fire.getFireHum();
        // 浓度
        double fireFog = fire.getFireFog();

        // 比例因子
        double factor = param.getFactor();
        // 最低高度
        double minHeight = param.getMinHeight();
        // 面积
        double area = param.getArea();
        // 时间间隔
        double interval = param.getInterval();
        // 房屋高度
        double buildHeight = param.getBuildHeight();

        double g = 10;

        double num1 = g * factor * fireFog * fireTemp* fireTemp/ (fireHum  * area * area * area);

        double num2 = Math.pow(num1, (double) 1 / 3);

        double num3 = Math.pow(interval, (double) 5 / 3);

        double num4 = 0.075 * num2 * num3;

        double num5 = Math.pow(buildHeight, (double) -2 / 3);

        double endNum = Math.pow((num4 - num5), (double) 3 / 2);

        if (minHeight > endNum) {
            fire.setState(true);
        }

        //System.out.println(endNum);

    }

    public static void main(String[] args) {
        Fire fire = new Fire();
        fire.setFireTemp(28);
        fire.setFireHum(62);
        fire.setFireFog(50);
        Param param = new Param();
        param.setFactor(2.3);
        param.setMinHeight(1.15);
        param.setArea(0.1);
        param.setInterval(2);
        param.setBuildHeight(3);
        algorithm(fire, param);
    }

}
