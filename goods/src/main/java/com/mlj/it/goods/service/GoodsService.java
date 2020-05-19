package com.mlj.it.goods.service;

import com.mlj.it.goods.mongodb.document.Goods;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GoodsService {
    long count();

    Goods create(Goods goods);

    int deleteByIds(List<String> ids);

    int deleteById(String id);

    List<Goods> findAll();

    Goods findOne();

    Page<Goods> findAllByCon();

    Boolean updateBatchByGoodIds(List<String> ids);

    List<Goods> findByCon(String name , ObjectId id);

    List<Goods> findBySN(String goodsn , String name ,ObjectId id);

    List<Goods> findByImgs(String imgs, String imgs2);

    List<Goods> findAllOrder(String sort1, String sort2);
}
