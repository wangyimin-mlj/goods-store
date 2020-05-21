package com.mlj.it.goods.mongodb.document.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 商品分类pojo
 * @author wym
 */
@Data
public class GoodCategory {

    // 1 一级分类
    public static final int FIRST_LEVEL = Classify.FIRST_LEVEL.value;
    //2 二级分类
    public static final int SECOND_LEVEL = Classify.SECOND_LEVEL.value;
    //3 三级分类
    public static final int THIRD_LEVEL = Classify.THIRD_LEVEL.value;

    /**
     * 分类等级
     */
    @Field("level")
    private Integer level;

    /**
     * 分类id
     */
    @Field("category_id")
    private Integer categoryId;

    /**
     * 分类名字
     */
    @Field("category_name")
    private String categoryName;

    public enum Classify{
        FIRST_LEVEL(1,"一级分类"),
        SECOND_LEVEL(2," 二级分类"),
        THIRD_LEVEL(3,"三级分类");
        private final int value;
        private final String name;
        Classify(int value, String name) {
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
