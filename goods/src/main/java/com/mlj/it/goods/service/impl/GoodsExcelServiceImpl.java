package com.mlj.it.goods.service.impl;

import com.mlj.it.goods.excel.bo.GoodsExcel;
import com.mlj.it.goods.mongodb.document.Goods;
import com.mlj.it.goods.mongodb.repository.GoodsRepository;
import com.mlj.it.goods.service.GoodsExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wym
 */
@Service
@Slf4j
public class GoodsExcelServiceImpl implements GoodsExcelService {
    @Resource
    private GoodsRepository goodsRepository;

    @Override
    public void saveAll(List<GoodsExcel> goodsExcels) {
        // List<Goods> goodsList = new ArrayList<>();
        // for (GoodsExcel goodsExcel : goodsExcels){
        //     Goods goods = new Goods();
        //     String class1 = goodsExcel.getClass1();
        //     if(class1 == null || class1 == ""){
        //
        //     }
        //     String class2 = goodsExcel.getClass2();
        //     if(class2 == null || class2 == ""){
        //
        //     }
        //     String class3 = goodsExcel.getClass3();
        //     if(class3 == null || class3 == ""){
        //
        //     }
        //     String name = goodsExcel.getName();
        //     if(name != null){
        //         goods.setName(name);
        //     }
        //     String supplier = goodsExcel.getSupplier();
        //     if(supplier != null){
        //         goods.setSupplier(supplier);
        //     }
        //     String type = goodsExcel.getType();
        //     if(type != null){
        //         goods.setType(type);
        //     }
        //     String colors = goodsExcel.getColors();
        //     if(colors != null){
        //         goods.setColor(colors);
        //     }
        //     String img = goodsExcel.getImg();
        //     if(img != null){
        //         // goods.setImgs(img);
        //     }
        //     String price = goodsExcel.getPrice();
        //     if(price != null){
        //         goods.setPrice(Integer.valueOf(price));
        //     }
        //     String ext = goodsExcel.getExt();
        //     if(ext != null){
        //         goods.setExt(ext);
        //     }
        //     goodsList.add(goods);
        // }
        //
        // List<Goods> goodsList1 = goodsRepository.saveAll(goodsList);
        // log.info(goodsList1.toString());
    }
}
