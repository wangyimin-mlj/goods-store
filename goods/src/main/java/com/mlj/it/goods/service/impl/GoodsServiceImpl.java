package com.mlj.it.goods.service.impl;

import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.mongodb.repository.GoodsRepository;
import com.mlj.it.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public int create(Goods goods) {
        goods.setAddTime(new Date());
        Goods saveGood = goodsRepository.save(goods);
        log.info(saveGood.toString());
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        return 0;
    }

    @Override
    public List<Goods> list(String name) {
        return null;
    }
}
