package com.mlj.it.goods.service;

import com.mlj.it.goods.excel.bo.GoodsExcel;

import java.util.List;

public interface GoodsExcelService {
    void saveAll(List<GoodsExcel> goodsExcels);
}
