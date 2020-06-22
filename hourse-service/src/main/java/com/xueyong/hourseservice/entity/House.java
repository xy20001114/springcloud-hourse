package com.xueyong.hourseservice.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xueyong
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_house")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 省ID
     */
    private Integer province;

    /**
     * 市ID
     */
    private Integer city;

    /**
     * 区/县ID
     */
    private Integer county;

    /**
     * 小区名称
     */
    private String community;

    /**
     * 几室
     */
    private Integer room;

    /**
     * 几厅
     */
    private Integer hall;

    /**
     * 几卫
     */
    private Integer toilet;

    /**
     * 房屋朝向
     */
    private String orientation;

    /**
     * 装修类型
     */
    private Integer decorate;

    /**
     * 每月租金
     */
    private BigDecimal rent;

    /**
     * 图片
     */
    private String pic;

    /**
     * 房屋介绍
     */
    private String introduction;
    /**
     * 面积
     */
    private Integer mianji;

}
