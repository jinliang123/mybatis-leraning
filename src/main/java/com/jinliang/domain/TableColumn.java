package com.jinliang.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 *
 * @author liang.jin@hand-china.com 2018/09/13 14:25
 */
public class TableColumn {
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 字段长度
     */
    private int fieldLength;
    /**
     * 字段精度
     */
    private int fieldDecimalLength;
    /**
     * 字段是否为空
     */
    private boolean fieldIsNull;
    /**
     * 字段是否是主键
     */
    private boolean fieldIsPrimaryKey;
    /**
     * 字段是否自增
     */
    private boolean fieldIsAutoIncrement;
    /**
     * 字段默认值
     */
    private String fieldDefaultValue;
    /**
     * 字段类型长度 0 不指定长度 1 指定长度 2 带有精度类型
     */
    private int fileTypeLength;
    /**
     * 是否是唯一索引
     */
    private boolean fieldIsUnique;
    /**
     * 字段备注
     */
    private String fieldComment;


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public int getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }

    public int getFieldDecimalLength() {
        return fieldDecimalLength;
    }

    public void setFieldDecimalLength(int fieldDecimalLength) {
        this.fieldDecimalLength = fieldDecimalLength;
    }

    public boolean isFieldIsNull() {
        return fieldIsNull;
    }

    public void setFieldIsNull(boolean fieldIsNull) {
        this.fieldIsNull = fieldIsNull;
    }

    public boolean isFieldIsPrimaryKey() {
        return fieldIsPrimaryKey;
    }

    public void setFieldIsPrimaryKey(boolean fieldIsPrimaryKey) {
        this.fieldIsPrimaryKey = fieldIsPrimaryKey;
    }

    public boolean isFieldIsAutoIncrement() {
        return fieldIsAutoIncrement;
    }

    public void setFieldIsAutoIncrement(boolean fieldIsAutoIncrement) {
        this.fieldIsAutoIncrement = fieldIsAutoIncrement;
    }

    public String getFieldDefaultValue() {
        return fieldDefaultValue;
    }

    public void setFieldDefaultValue(String fieldDefaultValue) {
        this.fieldDefaultValue = fieldDefaultValue;
    }

    public int getFileTypeLength() {
        return fileTypeLength;
    }

    public void setFileTypeLength(int fileTypeLength) {
        this.fileTypeLength = fileTypeLength;
    }

    public boolean isFieldIsUnique() {
        return fieldIsUnique;
    }

    public void setFieldIsUnique(boolean fieldIsUnique) {
        this.fieldIsUnique = fieldIsUnique;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }
}
