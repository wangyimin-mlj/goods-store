package com.mlj.it.goods.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 付款方式
 * @author wym
 */
@Data
public class PayType {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    /**
     * 付款类型名字
     */
    @Field("type_name")
    private String typeName;

    /**
     * 单据状态
     */
    @Field("receipt_status")
    private String receiptStatus;

    /**
     * 计算起始日期
     */
    @Field("begin_date")
    private String beginDate;

    /**
     * 月增加
     */
    @Field("add_month")
    private String addMonth;

    /**
     * 日增加
     */
    @Field("add_day")
    private String addDay;
}
