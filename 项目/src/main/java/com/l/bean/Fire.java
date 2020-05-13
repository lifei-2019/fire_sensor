package com.l.bean;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author l
 * @since 2019-04-14
 */
@TableName("fire")
public class Fire extends Model<Fire> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 温度
     */
    @TableField("fire_temp")
    private double fireTemp;
    /**
     * 湿度
     */
    @TableField("fire_hum")
    private double fireHum;
    /**
     * 浓度
     */
    @TableField("fire_fog")
    private double fireFog;

    /**
     * 状态
     */
    @TableField(exist = false)
    private boolean state;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getFireTemp() {
        return fireTemp;
    }

    public void setFireTemp(double fireTemp) {
        this.fireTemp = fireTemp;
    }

    public double getFireHum() {
        return fireHum;
    }

    public void setFireHum(double fireHum) {
        this.fireHum = fireHum;
    }

    public double getFireFog() {
        return fireFog;
    }

    public void setFireFog(double fireFog) {
        this.fireFog = fireFog;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Fire{" +
                "id=" + id +
                ", fireTemp=" + fireTemp +
                ", fireHum=" + fireHum +
                ", fireFog=" + fireFog +
                ", createTime=" + createTime +
                "}";
    }
}
