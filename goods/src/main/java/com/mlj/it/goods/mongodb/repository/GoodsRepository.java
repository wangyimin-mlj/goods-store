package com.mlj.it.goods.mongodb.repository;

import com.mlj.it.goods.mongodb.document.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *  商品
 */

public interface GoodsRepository extends MongoRepository<Goods, String> {

}
