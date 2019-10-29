package com.jcohy.scis.common;

public class Data {

    private String label;
    private Integer value;

    public Data() {
    }

    public Data(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
}
