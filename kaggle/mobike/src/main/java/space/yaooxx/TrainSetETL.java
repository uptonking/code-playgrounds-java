package space.yaooxx;

import com.github.lwhite1.tablesaw.api.DoubleColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.mysql.jdbc.PreparedStatement;
import space.yaooxx.geohash.GeoHashConverter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

public class TrainSetETL {

    private static Table bikeTracksTable = null;
    static List columns = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
//            bikeTracksTable = Table.createFromCsv("/root/Documents/play/mobike/train01.csv");
            bikeTracksTable = Table.createFromCsv("/root/Documents/play/mobike/source/train.csv");
        } catch (IOException e) {
            out.println(e.getMessage());
        }

//        bikeTracksTable = bikeTracksTable.first(8);

        //分析数据新增的字段
        DoubleColumn startLng = DoubleColumn.create("startLng");
        DoubleColumn startLat = DoubleColumn.create("startLat");
        DoubleColumn endLng = DoubleColumn.create("endLng");
        DoubleColumn endLat = DoubleColumn.create("endLat");
        //用来引用geohash还原的经纬度
        double[] lngLat;
        double dLng, dLat;
        for (String loc : bikeTracksTable.categoryColumn("geohashed_start_loc")) {
            lngLat = GeoHashConverter.decode(loc);
            dLng = Double.valueOf(String.format("%.8f", lngLat[1]));
            dLat = Double.valueOf(String.format("%.8f", lngLat[0]));
            //将经纬度添加到表格的列
            startLng.add(dLng);
            startLat.add(dLat);
        }

        for (String loc : bikeTracksTable.categoryColumn("geohashed_end_loc")) {
            lngLat = GeoHashConverter.decode(loc);
            dLng = Double.valueOf(String.format("%.8f", lngLat[1]));
            dLat = Double.valueOf(String.format("%.8f", lngLat[0]));
            endLng.add(Double.valueOf(dLng));
            endLat.add(Double.valueOf(dLat));
        }

        bikeTracksTable.addColumn(startLng);
        bikeTracksTable.addColumn(startLat);
        bikeTracksTable.addColumn(endLng);
        bikeTracksTable.addColumn(endLat);


        int rowCount = bikeTracksTable.rowCount();
        int colCount = bikeTracksTable.columnCount();
        columns = bikeTracksTable.columns();


        final String url = "jdbc:mysql://127.0.0.1/mobike_tracks";
        final String name = "com.mysql.jdbc.Driver";
        final String user = "root";
        final String password = "111111";
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url, user, password);//获取连接
        if (conn != null) {
            System.out.println("获取连接成功");
            //插入数据
            insert(conn, rowCount, colCount);
        } else {
            System.out.println("获取连接失败");
        }
    }


    public static void insert(Connection conn, int rowCount, int colCount) {
        // 开始时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO mobike_tracks_train (orderid,userid,bikeid,biketype,starttime,geohashed_start_loc,geohashed_end_loc,startLng,startLat,endLng,endLat,distance) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句

//            rowCount = 4;

            for (int r = 0; r < rowCount; r++) {

                int orderid = Integer.valueOf(bikeTracksTable.get(0, r));
                int userid = Integer.valueOf(bikeTracksTable.get(1, r));
                int bikeid = Integer.valueOf(bikeTracksTable.get(2, r));
                int biketype = Integer.valueOf(bikeTracksTable.get(3, r));
                String starttime = bikeTracksTable.get(4, r);
                starttime = starttime.substring(0, starttime.length() - 4);
                String geohashStartLoc = bikeTracksTable.get(5, r);
                String geohashEndLoc = bikeTracksTable.get(6, r);
                double startLng = Double.valueOf(bikeTracksTable.get(7, r));
                double startLat = Double.valueOf(bikeTracksTable.get(8, r));
                double endLng = Double.valueOf(bikeTracksTable.get(9, r));
                double endLat = Double.valueOf(bikeTracksTable.get(10, r));
                double distance = distHaversineRAD(startLat, startLng, endLat, endLng);

//                out.println(orderid + ", " + userid + ", " + bikeid + ", " + biketype + ", " + starttime + ", " + geohashStartLoc + ", " + startLng + ", " + startLat);

                suffix.append("(" + orderid + "," + userid + "," + bikeid + "," + biketype + ", str_to_date('" + starttime + "','%Y-%m-%dT%H:%i:%s') ,'" + geohashStartLoc + "' ,'" + geohashEndLoc + "'," + startLng + "," + startLat + "," + endLng + "," + endLat + "," + distance + "),");

                if ((r % 100000 == 0) || (r == rowCount - 1)) {
                    // 构建完整SQL
                    String sql = prefix + suffix.substring(0, suffix.length() - 1);
//                    out.println(sql);
                    // 添加执行SQL
                    pst.addBatch(sql);
                    // 执行操作
                    pst.executeBatch();
                    // 提交事务
                    conn.commit();
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
        System.out.println(bikeTracksTable.rowCount() + "条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        System.out.println("插入完成");
    }

    public static double distHaversineRAD(double lat1, double lon1, double lat2, double lon2) {
        double hsinX = Math.sin((lon1 - lon2) * 0.5);
        double hsinY = Math.sin((lat1 - lat2) * 0.5);
        double h = hsinY * hsinY +
                (Math.cos(lat1) * Math.cos(lat2) * hsinX * hsinX);
        return 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1 - h)) * 6367000;
    }


}