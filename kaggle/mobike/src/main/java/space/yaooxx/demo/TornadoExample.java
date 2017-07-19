package space.yaooxx.demo;

import com.github.lwhite1.tablesaw.api.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lwhite1.tablesaw.api.QueryHelper.column;
import static java.lang.System.out;

/**
 * Tablesaw get started tutorial
 * Created by yaoooo on 7/16/17.
 */
public class TornadoExample {

    public static void main(String[] args) {

        Table tornadoes = null;

        try {
//            tornadoes = Table.createFromCsv("/root/Documents/dataseed/runtime/tornadoes_1950-2014.csv");
//            tornadoes = Table.createFromCsv("/root/Documents/play/mobike/source/test.csv");
            tornadoes = Table.createFromCsv("/root/Documents/play/mobike/source/train.csv");
        } catch (IOException e) {
            out.println(e.getMessage());
        }

        out.println(tornadoes.getClass());
        //显示文件名+行列数
        out.println(tornadoes.toString());
        //显示列名数组
        out.println(tornadoes.columnNames());
        //显示行列数的反法shape()
        out.println(tornadoes.shape());
        //显示数据字段+类型
        out.println(tornadoes.structure().print());
        //显示前N行
        out.println(tornadoes.first(3).print());
        //显示统计信息
        out.println(tornadoes.column("biketype").summary().print());
//        out.println(tornadoes.column("orderid").countUnique());
        out.println(tornadoes.selectWhere(column("orderid").isEqualTo(5)).rowCount());

//        List<Integer> startloc = new ArrayList<>();
//        for (Integer loc : tornadoes.intColumn("userid")) {
//            System.out.println(loc.toString());
//        }


//        tornadoes.selectWhere(column("biketype").isEqualTo(2)).exportToCsv("res/bike2.csv");

    }

}
