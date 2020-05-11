package com.mlj.it.goods.mongodb.repository;

import com.mlj.it.goods.mongodb.document.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoodsRepository  extends MongoRepository<Goods,String> {
    List<Goods> findByNameOOrderByAdd_timeDesc(String name);
}
