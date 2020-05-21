package com.mlj.it.goods;

import com.mlj.it.goods.excel.bo.GoodsExcel;
import com.mlj.it.goods.excel.common.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author wym
 */
@SpringBootTest
@Slf4j
public class GoodsExcelTest {
    @Test
    public void simpleRead() throws FileNotFoundException {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：

        String fileName = "C:\\Users\\84694\\Desktop\\goodsdemo.xlsx";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        List<GoodsExcel> goodsExcels = EasyExcel.readExcel(new BufferedInputStream(fileInputStream), GoodsExcel.class);

        log.info(goodsExcels.toString());
    }
}
