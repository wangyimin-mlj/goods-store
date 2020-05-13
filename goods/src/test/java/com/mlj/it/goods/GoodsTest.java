package com.mlj.it.goods;

import com.mlj.it.goods.mongodb.document.Category;
import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class GoodsTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void testInsert() throws Exception {
        List<String> imgs = new ArrayList<>();
        imgs.add("10.com");
        imgs.add("12.com");
        List<Category> categoryList = new ArrayList<Category>();

        categoryList.add(new Category("66666",1));
        categoryList.add(new Category("1122233",2));

        Goods goods = new Goods();
        goods.setGoodsSn("123123");
        goods.setName("vvvtttt");
        goods.setCategoryList(categoryList);
        goods.setImgs(imgs);


        System.out.println(goods);
        // goodsDao.insert(goods);
    }

    @Test
    public void  saveSpec(){
        // goodsDao.savettt();
    }

    @Test
    public void create(){
        List<String> imgs = new ArrayList<>();
        imgs.add("10.com");
        imgs.add("12.com");
        List<Category> categoryList = new ArrayList<Category>();

        categoryList.add(new Category("66666",1));
        categoryList.add(new Category("1122233",2));

        Goods goods = new Goods();
        goods.setGoodsSn("6672112789");
        goods.setName("vvvtttt");
        goods.setCategoryList(categoryList);
        goods.setImgs(imgs);

        goodsService.create(goods);
    }
}
