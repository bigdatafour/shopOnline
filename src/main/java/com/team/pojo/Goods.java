package com.team.pojo;

/**
 * 这是商品品类，属性goodsName用于接收前端用户传来的喜爱商品名
 */
public class Goods {
    private int goodsid;
    private String goodsName;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
