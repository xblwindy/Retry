package com.wx.retry.common;

import java.util.List;

public class PageJson<T> {

    private int code;
    private String msg;
    private int count;
    private List<T> data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    public List<T> getData() {
        return data;
    }

}
