package yao.usage.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试泛型列表中的类型
 *
 * @author jinyaoo
 * @date 19-6-18
 */
public class GenericTypeInfo {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        // java.util.ArrayList
        System.out.println(strList.getClass().getName());

        /// ============================ 测试二维链表 ======================= ///
        List<List<String>> strListList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<String> curRow = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                curRow.add("第 " + (i + 1) + "行, 第 " + (j + 1) + "列");
            }
            strListList.add(curRow);
        }
        // java.util.ArrayList
        System.out.println(strListList.getClass().getName());
        // java.util.ArrayList
        System.out.println(strListList.get(0).getClass().getName());

    }


}
