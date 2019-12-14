package com.team.pojo;

/**
 * 广告类，用于统计用户点击广告数量
 */
public class Advertisement {
    //区域城市名
    private String city_name;
    //用户点击某广告的名字
    private String ad;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
