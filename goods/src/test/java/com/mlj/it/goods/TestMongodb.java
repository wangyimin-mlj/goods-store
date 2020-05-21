package com.mlj.it.goods;

import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.mongodb.document.pojo.GoodCategory;
import com.mlj.it.goods.mongodb.document.pojo.GoodPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author wym
 */
@SpringBootTest
public class TestMongodb {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void test1(){
        GoodCategory goodCategory = new GoodCategory();
        goodCategory.setCategoryName("一级分类-电脑");
        goodCategory.setLevel(GoodCategory.FIRST_LEVEL);
        GoodCategory goodCategory2 = new GoodCategory();
        goodCategory2.setCategoryName("一级分类-相机");
        goodCategory2.setLevel(GoodCategory.FIRST_LEVEL);
        ArrayList<GoodCategory> goodCategories = new ArrayList<>();
        goodCategories.add(goodCategory);
        goodCategories.add(goodCategory2);

        GoodPrice goodPrice = new GoodPrice();
        goodPrice.setRetailPrice(500);

        Goods goods = new Goods();
        goods.setGoodsSn("6666");
        goods.setGoodCategorys(goodCategories);
        goods.setGoodName("飞机");
        goods.setGoodPrice(goodPrice);

        mongoTemplate.insert(goods,"goods");

    }
}
