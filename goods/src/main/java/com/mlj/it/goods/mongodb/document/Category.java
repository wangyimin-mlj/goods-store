package com.mlj.it.goods.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 分类表
 * @author wym
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("category")
public class Category {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    /**
     * 分类名字
     */
    @Field("category_name")
    private String categoryName;

    /**
     * 分类父id
     */
    @Field("pid")
    private Integer pid;

    /**
     * 分类级别
     */
    @Field("level")
    private Integer level;

    /**
     * 子列表
     */
    @Field("child_category")
    private List<Category> childCategory;

}
