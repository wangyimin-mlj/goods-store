package com.mlj.it.goods.mongodb.document;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String goodsSn;

    private String name;

    private List<Category> categoryList;
    // private List<Spec> specList;
    private List<String> imgs;

}
