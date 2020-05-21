package com.mlj.it.goods.mongodb.document.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 商品skus pojo
 * @author wym
 */
@Data
// Todo 联合索引
public class GoodSkus {

    /**
     * sku id
     */
    @Field("id")
    private Integer id;

    /**
     * 颜色
     */
    @Field("color")
    private String color;

    /**
     * 类型
     */
    @Field("type")
    private String type;
}
