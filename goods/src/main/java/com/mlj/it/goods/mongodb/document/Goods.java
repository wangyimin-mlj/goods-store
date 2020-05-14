package com.mlj.it.goods.mongodb.document;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("goods")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id;

    @Field("goods_sn")
    private String goodsSn;

    @Field("name")
    @Indexed(unique = true)
    private String name;

    @Field("price")
    private Integer price;

    @Field("is_del")
    private Integer isDel;

    @Field("category_list")
    private List<Category> categoryList;

    @Field("imgs")
    private List<String> imgs;

}
