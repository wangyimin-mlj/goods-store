package com.mlj.it.goods.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 分类表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("category")
public class Category {
    private String categoryName;

    private Integer level;
}
