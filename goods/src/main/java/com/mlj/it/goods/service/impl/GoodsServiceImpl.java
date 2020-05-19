package com.mlj.it.goods.service.impl;

import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.mongodb.repository.GoodsRepository;
import com.mlj.it.goods.mongodb.template.BuildQuery;
import com.mlj.it.goods.mongodb.template.GoodsCriteria;
import com.mlj.it.goods.service.GoodsService;
import com.mlj.it.goods.util.MongoPageable;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsRepository goodsRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public long count() {
        long count = goodsRepository.count();
        return count;
    }

    @Override
    public Goods create(Goods goods) {
        Goods insert = null;
        try{
            insert = goodsRepository.insert(goods);
        } catch (Exception e){
            String message = e.getMessage();
            log.info(message);
        }

        return insert;
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public List<Goods> findAll() {
        List<Goods> all = goodsRepository.findAll();

        return all;
        //return null;
    }

    @Override
    public Goods findOne() {
        List<Goods> all = goodsRepository.findAll();
        if(all.isEmpty()){
            return null;
        }
        return all.get(0);
    }

    @Override
    public Page<Goods> findAllByCon() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "price"));

        MongoPageable mongoPageable = new MongoPageable();
        mongoPageable.setSort(Sort.by(orders));
        Page<Goods> all = goodsRepository.findAll(mongoPageable);
        return all;
    }

    @Override
    public Boolean updateBatchByGoodIds(List<String> ids) {
        Iterable<Goods> allById = goodsRepository.findAllById(ids);
        for(Goods goods : allById){
            goods.setIsDel(2);
        }
        goodsRepository.saveAll(allById);
        
        return true;
    }

    /**
     * 根据条件查找
     * @param name
     * @param id
     * @return
     */
    @Override
    public List<Goods> findByCon(String name , ObjectId id){
        GoodsCriteria goodsCriteria = new GoodsCriteria();
        goodsCriteria.andIdEqualTo(id);
        goodsCriteria.andNameLike(name);
        Query query = BuildQuery.getQuery(goodsCriteria.getOredCriteria());
        List<Goods> goods = mongoTemplate.find(query, Goods.class);
        return goods;
    }

    @Override
    public List<Goods> findBySN(String goodsn , String name ,ObjectId id){
        GoodsCriteria goodsCriteria = new GoodsCriteria();
        goodsCriteria.andNameLike(name);
        goodsCriteria.andGoodSnEqualTo(goodsn);
        GoodsCriteria goodsCriteria1 = new GoodsCriteria();
        goodsCriteria1.andNameLike(name);
        goodsCriteria1.andIdEqualTo(id);
        Query query = BuildQuery.getQuery(goodsCriteria.getOredCriteria(),goodsCriteria1.getOredCriteria());
        List<Goods> goods = mongoTemplate.find(query, Goods.class);
        return goods;
    }

    @Override
    public List<Goods> findByImgs(String imgs,String imgs2){
        GoodsCriteria goodsCriteria = new GoodsCriteria();
        goodsCriteria.andImgEqualTo(imgs);
        goodsCriteria.andImgEqualTo(imgs2);
        Query query = BuildQuery.getQuery(goodsCriteria.getOredCriteria());
        List<Goods> goods = mongoTemplate.find(query, Goods.class);
        return goods;
    }

    @Override
    public List<Goods> findAllOrder(String sort1, String sort2){
        GoodsCriteria goodsCriteria = new GoodsCriteria();
        Query query = BuildQuery.getQuery(goodsCriteria.getOredCriteria());

        BuildQuery.setSort(query, Sort.Direction.DESC,sort1);
        BuildQuery.setSort(query, Sort.Direction.DESC,sort2);

        List<Goods> goods = mongoTemplate.find(query, Goods.class);
        return goods;


    }
}
