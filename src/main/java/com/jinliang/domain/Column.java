package com.jinliang.domain;

/**
 * 列属性
 *
 * @author liang.jin@hand-china.com 2018/09/12 17:07
 */
public class Column {
    private String name;
    private String type;
    private int length;
    private int decimalLength;
    private boolean isNull;
    private boolean isKey;

    public Column() {
    }

    public Column(String name, String type, int length) {
        this.name = name;
        this.type = type;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDecimalLength() {
        return decimalLength;
    }

    public void setDecimalLength(int decimalLength) {
        this.decimalLength = decimalLength;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }
}
