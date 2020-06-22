package com.xueyong.hourseservice.entity;

import lombok.Data;

import java.util.List;

@Data
public class HourseVo extends House {
    //几室几 厅几卫
    private String fangwutype;
    //装修类型
    private String zhuangxiutype;
    //省的名字
    private String provincename;
    //市的名字
    private String cityname;
    //区的名字
    private String countyname;
    //租金
    private Integer zujinid;
    private List<Integer> ids;

}
