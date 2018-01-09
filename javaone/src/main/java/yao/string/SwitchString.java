package yao.string;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SwitchString {


    public static void main(String... args) {

        String[] daysWeekArr = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

        String todayWeekInt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("e"));


        String todayWeek = daysWeekArr[Integer.valueOf(todayWeekInt) - 1];

        switch (todayWeek) {
            case "周一":
                ;
            case "周二":
                ;
            case "周三":
                ;
            case "周四":
                ;
            case "周五":
                System.out.println("今天是工作日");
                break;
            case "周六":
                ;
            case "周日":
                System.out.println("今天周末");
                break;
            default:
                System.out.println("不知道今天周几");

        }


    }

}
