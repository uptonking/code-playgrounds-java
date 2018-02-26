package space.yaooxx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lwhite1.tablesaw.api.DoubleColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import org.geojson.*;
import space.yaooxx.geohash.GeoHashConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lwhite1.tablesaw.api.QueryHelper.column;
import static java.lang.System.out;

/**
 * 单车轨迹的读取与转换
 * Created by yaoooo on 7/18/17.
 */
public class BikeTracksETL {

    public static void main(String[] args) {

        Table bikeTracksTable = null;

        try {
            bikeTracksTable = Table.createFromCsv("/root/Documents/play/mobike/source/test.csv");
//            bikeTracksTable = Table.createFromCsv("/root/Documents/play/mobike/source/train.csv");
//            bikeTracksTable = Table.createFromCsv("/root/Documents/play/mobike/train01.csv");
        } catch (IOException e) {
            out.println(e.getMessage());
        }

        bikeTracksTable.setName("mobike_tracks_test");


//        out.println(bikeTracksTable.structure().print());

        //table数据只取8行，用于开发测试
//        bikeTracksTable = bikeTracksTable.first(8);

        //分析数据新增的字段
        DoubleColumn startLng = DoubleColumn.create("startLng");
        DoubleColumn startLat = DoubleColumn.create("startLat");
        DoubleColumn endLng = DoubleColumn.create("endLng");
        DoubleColumn endLat = DoubleColumn.create("endLat");

//        //用来引用所有点构成的FeatureCollection
//        FeatureCollection bikeTracksColletion = new FeatureCollection();
//        //用来引用每个点的feature和geometry
//        Feature trackFeature;
//        GeoJsonObject trackGeometry;

        //用来引用geohash还原的经纬度
        double[] lngLat;
        double dLng, dLat;
        for (String loc : bikeTracksTable.categoryColumn("geohashed_start_loc")) {
            lngLat = GeoHashConverter.decode(loc);
            dLng = Double.valueOf(String.format("%.8f", lngLat[1]));
            dLat = Double.valueOf(String.format("%.8f", lngLat[0]));

//            trackFeature = new Feature();
//            trackGeometry = new Point(dLng, dLat);
//            trackFeature.setGeometry(trackGeometry);
//            bikeTracksColletion.add(trackFeature);

            //将经纬度添加到表格的列
            startLng.add(dLng);
            startLat.add(dLat);
        }

//        for (String loc : bikeTracksTable.categoryColumn("geohashed_end_loc")) {
//            lngLat = GeoHashConverter.decode(loc);
//            dLng = Double.valueOf(String.format("%.8f", lngLat[1]));
//            dLat = Double.valueOf(String.format("%.8f", lngLat[0]));
//            endLng.add(Double.valueOf(dLng));
//            endLat.add(Double.valueOf(dLat));
//        }


        bikeTracksTable.addColumn(startLng);
        bikeTracksTable.addColumn(startLat);
//        bikeTracksTable.addColumn(endLng);
//        bikeTracksTable.addColumn(endLat);


        //导出表中指定的列到csv
//        Table userStartEndTable = Table.create("mobike_user_lnglat", bikeTracksTable.column("userid"), startLng, startLat, endLng, endLat);
//        userStartEndTable.exportToCsv("res/mobike_user_lnglat.csv");
        bikeTracksTable.exportToCsv("res/mobike_tracks_test.csv");


////        String trackJson = "";
//        try {
////             trackJson = new ObjectMapper().writeValueAsString(bikeTracksCollection);
////            String trackJsonFile = "kaggle/mobike/src/main/resources/public/dataseeds/" + "mobike_testing.json";
//            String trackJsonFile = "kaggle/mobike/src/main/resources/public/dataseeds/" + "mobike_training.json";
//            new ObjectMapper().writer(new DefaultPrettyPrinter()).writeValue(new File(trackJsonFile), bikeTracksColletion);
//            new ObjectMapper().writeValue(new File(trackJsonFile), bikeTracksColletion);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        out.println(trackJson);


    }

}
