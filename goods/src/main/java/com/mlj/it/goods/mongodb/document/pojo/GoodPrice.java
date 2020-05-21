package com.mlj.it.goods.mongodb.document.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 商品价格表
 * @author wym
 */
@Data
public class GoodPrice {

    /**
     * 含税价格
     */
    @Field("tax_price")
    private Integer taxPrice;

    /**
     * 零售价格
     */
    @Field("retail_price")
    private Integer retailPrice;
}
