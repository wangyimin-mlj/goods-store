package com.mlj.it.goods.excel.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.mlj.it.goods.excel.bo.GoodsExcel;
import com.mlj.it.goods.service.impl.GoodsExcelServiceImpl;
import com.mongodb.util.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wym
 */
@Slf4j
public class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T>{

    private List<T> rows = new ArrayList<>();

    /**
     * object是每一行数据映射的对象
     * @param object
     * @param context
     */
    @Override
    public void invoke(T object, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        System.out.println(object);
        rows.add(object);
        //根据自己业务做处理
        doSomething(object);
    }

    private void doSomething(T object) {
        //1、入库调用接口
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

        log.info("read {} rows %n", rows.size());
    }

    public List<T> getRows() {

        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


    // /**
    //  * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
    //  */
    // private static final int BATCH_COUNT = 5;
    // List<GoodsExcel> list = new ArrayList<GoodsExcel>();
    // /**
    //  * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
    //  */
    // private GoodsExcelServiceImpl goodsExcelServiceImpl;
    // public ExcelListener() {
    //     // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    //     goodsExcelServiceImpl = new GoodsExcelServiceImpl();
    // }
    //
    // /**
    //  * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
    //  * @param goodsExcelServiceImpl
    //  */
    // public ExcelListener(GoodsExcelServiceImpl goodsExcelServiceImpl) {
    //     this.goodsExcelServiceImpl = goodsExcelServiceImpl;
    // }
    //
    //
    // @Override
    // public void invoke(GoodsExcel data, AnalysisContext context) {
    //     log.info("解析到一条数据:{}",data.toString());
    //     list.add(data);
    //     // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
    //     if (list.size() >= BATCH_COUNT) {
    //         saveData();
    //         // 存储完成清理 list
    //         list.clear();
    //     }
    // }
    //
    // /**
    //  * 所有数据解析完成了 都会来调用
    //  *
    //  * @param context
    //  */
    // @Override
    // public void doAfterAllAnalysed(AnalysisContext context) {
    //     // 这里也要保存数据，确保最后遗留的数据也存储到数据库
    //     saveData();
    //     log.info("所有数据解析完成！");
    // }
    //
    // /**
    //  * 加上存储数据库
    //  */
    // private void saveData() {
    //     log.info("{}条数据，开始存储数据库！", list.size());
    //     goodsExcelServiceImpl.saveAll(list);
    //     log.info("存储数据库成功！");
    // }
    //
    // public List<GoodsExcel> getRows(){
    //     return list;
    // }
}
