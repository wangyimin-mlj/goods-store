package com.mlj.it.goods.excel.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author wym
 */
@Data
public class GoodsExcel extends BaseRowModel {
    @ExcelProperty(  value = "一级分类", index = 0)
    private String class1;

    @ExcelProperty( value = "二级分类", index = 1)
    private String class2;

    @ExcelProperty( value = "三级分类", index = 2)
    private String class3;

    @ExcelProperty( value = "商品名字", index = 3)
    private String name;

    @ExcelProperty( value = "供货商", index = 4)
    private String supplier;

    @ExcelProperty( value = "型号", index = 5)
    private String type;

    @ExcelProperty( value = "价格", index = 6)
    private String price;

    @ExcelProperty( value = "颜色", index = 7)
    private String colors;

    @ExcelProperty( value = "图片", index = 8 , converter = StringImageConverter.class)
    private String img;

    @ExcelProperty( value = "扩展", index = 9 )
    private String ext;
}
