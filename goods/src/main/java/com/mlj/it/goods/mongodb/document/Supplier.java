package com.mlj.it.goods.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 供应商表
 * @author wym
 */
@Data
public class Supplier {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    /**
     * 供货商
     */
    @Field("name")
    private String name;

    /**
     * 供货商编号
     */
    @Field("supplier_sn")
    private String supplierSn;

    /**
     * 简介
     */
    @Field("brief")
    private String brief;

    /**
     * 税率
     */
    @Field("tax_rate")
    private Integer taxRate;

    /**
     * 付款方式
     */
    @Field("pay_type")
    private String payType;

    /**
     * 付款方式编号
     */
    @Field("pay_type_sn")
    private String pay_type_sn;
}
