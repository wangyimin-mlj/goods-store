package com.mlj.it.goods.mongodb.document;

import com.mlj.it.goods.mongodb.document.pojo.GoodCategory;
import com.mlj.it.goods.mongodb.document.pojo.GoodImgs;
import com.mlj.it.goods.mongodb.document.pojo.GoodPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表
 * @author wym
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("goods")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int IS_DELETED = Deleted.IS_DELETED.value();

    public static final int NOT_DELETED = Deleted.NOT_DELETED.value();

    @Id
    private ObjectId id;

    /**
     * 商品编号
     */
    @Field("goods_sn")
    private String goodsSn;

    /**
     * 商品名
     */
    @Field("good_name")
    private String goodName;

    /**
     * 商品分类
     */
    @Field("categorys")
    private List<GoodCategory> GoodCategorys;

    /**
     * 商品图片
     */
    @Field("imgs")
    private GoodImgs goodImgs;

    /**
     * 供货商
     */
    @Field("supplier_name")
    private String supplierName;

    /**
     * 供货商Id
     */
    @Field("supplier_id")
    private String supplierId;

    /**
     * 商品价格
     */
    @Field("good_price")
    private GoodPrice goodPrice;

    /**
     * 特点
     */
    @Field("feature")
    private String feature;

    /**
     * 是否删除
     */
    @Field("is_del")
    private Integer isDel;

    /**
     * 添加时间
     */
    @Field("add_time")
    private Long addTime;

    /**
     * 更新时间
     */
    @Field("update_time")
    private Long updateTime;


    public enum Deleted {
        NOT_DELETED(0, "未删除"),
        IS_DELETED(1, "已删除");

        private final int value;

        private final String name;


        Deleted(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int value() {
            return this.value;
        }
        public String getName() {
            return this.name;
        }
    }

}
