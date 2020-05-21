package com.mlj.it.goods.mongodb.document.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 商品图片pojo
 * @author wym
 */
@Data
public class GoodImgs {

    /**
     * 原图url
     */
    @Field("original_img")
    private String originalImg;

    /**
     * 缩略图url
     */
    @Field("small_img")
    private String smallImg;


}
