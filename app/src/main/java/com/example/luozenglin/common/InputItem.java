package com.example.luozenglin.common;

import java.util.List;
import java.util.Map;

public class InputItem {
    private String value;
    private TYPE type;
    private List<TYPE> frontType;

    public static enum TYPE{
        NUM,        //'.'and'0-9'
        OPE_NUM,   //PI,e
        NUM_OPE,   //sin,lg,ln,root,
        OPE_OPE,    //倒数，阶乘，,%
        OPE,         //加减乘除 乘方
        LEFT_BRACKET,
        RIGHT_BRACKET,
    }

    public InputItem(){}

    public InputItem(String value, TYPE type){
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
