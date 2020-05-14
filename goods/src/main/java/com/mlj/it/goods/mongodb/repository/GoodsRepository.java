package com.mlj.it.goods.mongodb.repository;

import com.mlj.it.goods.mongodb.document.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  商品
 */
public interface GoodsRepository extends MongoRepository<Goods, String> {
    /**
     * 分页所有数据
     */
    Page<Goods> findAll(Pageable pagebal);


}
