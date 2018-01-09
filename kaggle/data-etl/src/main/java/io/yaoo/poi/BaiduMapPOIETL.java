package io.yaoo.poi;

import com.mysql.jdbc.PreparedStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 导入百度地图poi数据
 */
public class BaiduMapPOIETL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        //使用数据信息
        int rowCount = 0;

//        String filePath = "/root/Documents/dataseed/poi/bd-poi-sample.sql";
        String filePath = "/run/media/root/WIN/active/dataseed/2017/baidu-poi-mysql.sql";
        List<String> poiList = new ArrayList<>(80_000_000);

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            String line = "";
            String lineNoTail = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                lineNoTail = line.substring(0, line.length() - 1);
                poiList.add(lineNoTail.substring(27));
                rowCount++;
                if (rowCount % 10000 == 0) {
                    out.println("====读到的条数是：" + rowCount);
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

//        poiList.forEach(out::println);


        final String url = "jdbc:mysql://127.0.0.1/dataseed?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        final String name = "com.mysql.jdbc.Driver";
        final String user = "root";
        final String password = "111111";
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url, user, password);//获取连接


        if (conn != null) {
            out.println("获取连接成功");

            //插入数据
            insert(conn, poiList);

        } else {
            out.println("获取连接失败");
        }

    }

    public static void insert(Connection conn, List<String> list) {

        // 开始时间
        Long begin = new Date().getTime();

        // sql前缀
//        String prefix = "INSERT INTO mobike_tracks_train (orderid,userid,bikeid,biketype,starttime,geohashed_start_loc,geohashed_end_loc,startLng,startLat,endLng,endLat,distance) VALUES ";
//        String prefix = "INSERT INTO bd_nb () VALUES ";
        String prefix = "INSERT INTO bd_nb (name,tag,address,phone1,phone2,lng,lat,city,city_code,province,district,road,street) VALUES ";

        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句

            int rowCount = list.size();

            ///每3条插入一次
            int commitSize = 10_000;

            for (int r = 0; r < rowCount; r++) {


                suffix.append(list.get(r) + ",");

                if (r == 0) {
                    continue;
                }

                if ((r % commitSize == 0) || (r == rowCount - 1)) {

                    // 构建完整SQL
                    String sql = prefix + suffix.substring(0, suffix.length() - 1);
//                    out.println(sql);
                    // 添加执行SQL
                    pst.addBatch(sql);
                    // 执行操作
                    pst.executeBatch();
                    // 提交事务
                    conn.commit();
                    out.println("====插入的条数是：" + r);

                    // 清空上一次添加的数据
                    suffix = new StringBuffer();
                }


            }


            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();

        // 耗时
        out.println("条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        out.println("插入完成");
    }


}
