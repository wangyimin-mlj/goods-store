package com.mlj.it.goods.excel.common;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.mlj.it.goods.excel.bo.GoodsExcel;
import com.mlj.it.goods.excel.listen.ExcelListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wym
 */

public class EasyExcel {

    public static <T extends BaseRowModel> List<T> readExcel(InputStream is, final Class<? extends BaseRowModel> clazz){
        List<T> rowsList = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(is);
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = EasyExcelFactory.getReader(bis, listener);
            excelReader.read(new Sheet(1, 1, clazz));
            rowsList = listener.getRows();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsList;

    }
}
