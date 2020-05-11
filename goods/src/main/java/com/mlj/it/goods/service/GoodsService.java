package com.mlj.it.goods.service;

import com.mlj.it.goods.mongodb.document.Goods;

import java.util.List;

public interface GoodsService {
    int create(Goods goods);

    int delete(List<String> ids);

    List<Goods> list(String name);
}
