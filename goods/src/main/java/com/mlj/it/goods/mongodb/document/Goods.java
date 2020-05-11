package com.mlj.it.goods.mongodb.document;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//商品表
@Document
public class Goods {
    @Id
    @NonNull
    private String goodsSn;
    @NonNull
    private String name;

    //TODO 复杂分类
    private String categoryId;
    private Boolean isOnSale;
    private Date addTime;
    private String price;

    @NonNull
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(@NonNull String goodsSn) {
        this.goodsSn = goodsSn;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsSn='" + goodsSn + '\'' +
                ", name='" + name + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", isOnSale=" + isOnSale +
                ", addTime=" + addTime +
                ", price='" + price + '\'' +
                '}';
    }
}
