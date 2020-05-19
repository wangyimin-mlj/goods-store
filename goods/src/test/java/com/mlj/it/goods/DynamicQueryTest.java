package com.mlj.it.goods;

import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.service.GoodsService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wym
 */
@Slf4j
@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    private GoodsService goodsService;
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void findByCon(){
        ObjectId objectId = new ObjectId("5ebe6871e5cf832ee0fb44d3");
        List<Goods> ym = goodsService.findByCon("ym", objectId);
        log.info(ym.toString());
    }

    @Test
    public void findBySn(){
        ObjectId objectId = new ObjectId("5ebe6871e5cf832ee0fb44d3");

        List<Goods> ym = goodsService.findBySN("343453535","ym" ,objectId);
        log.info(ym.toString());
    }

    @Test
    public void findByImg(){
        String img = "10.com";
        String img2 = "13.com";
        List<Goods> byImgs = goodsService.findByImgs(img,img2);
        log.info(byImgs.toString());
    }

    @Test
    public void findOrder(){
        List<Goods> allOrder = goodsService.findAllOrder("price", "goods_sn");
        log.info(allOrder.toString());
    }

    @Test
    public void xxxxx(){
        Query query = new Query();
        //动态拼接查询条件
        Criteria criteria1 = Criteria.where("good_sn").is("343453535");
        Criteria criteria2 = Criteria.where("name").is("yym");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(criteria1);
        objects.add(criteria2);

        query.addCriteria((CriteriaDefinition) objects);

        //计算总数
        long total = mongoTemplate.count(query, Goods.class);

        //查询结果集
        List<Goods> studentList = mongoTemplate.find(query, Goods.class);

        log.info(studentList.toString());
    }
}
