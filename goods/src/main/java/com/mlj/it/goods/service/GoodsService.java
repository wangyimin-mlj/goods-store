package com.mlj.it.goods.service;

import com.mlj.it.goods.mongodb.document.Goods;
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

}
