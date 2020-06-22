package com.xueyong.hourseservice.enums;

public enum DecorateEnum {
    毛坯(1,"毛坯"),普通装修(2,"普通装修"),精装修(3,"精装修");
    private int id;
    private String name;

    DecorateEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
