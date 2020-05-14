package com.mlj.it.goods;

import com.mlj.it.goods.mongodb.document.Category;
import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

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
        goods.setPrice(99);
        goods.setIsDel(1);

        // System.out.println(goods);
        Goods goods1 = goodsService.create(goods);
        log.info(goods1.toString());
    }

    /**
     * 看修改字段类型 ，会不会有影响
     * 有影响，会报转换错误 [java.lang.Integer] to type [java.lang.Boolean]
     */
    @Test
    public void testInsert2() throws Exception {
        List<String> imgs = new ArrayList<>();
        imgs.add("4545.com");
        imgs.add("4545.com");
        List<Category> categoryList = new ArrayList<Category>();

        categoryList.add(new Category("tianshi",1));
        categoryList.add(new Category("mogui",2));

        Goods goods = new Goods();
        goods.setGoodsSn("343453535");
        goods.setName("yym");
        goods.setCategoryList(categoryList);
        goods.setImgs(imgs);
        goods.setPrice(150);
        //看修改字段类型 ，会不会有影响
        goods.setIsDel(1);

        // System.out.println(goods);
        Goods goods1 = goodsService.create(goods);
        log.info(goods1.toString());
    }


    //查找所有的goods
    @Test
    public void findGoodsAll(){
        List<Goods> all = goodsService.findAll();
        for (Goods good: all) {
            System.out.println(good);
        }
    }

    @Test
    public void deleteOne(){
    }

    @Test
    public void findOne(){
        Goods good = goodsService.findOne();
        System.out.println(good);
    }
}
