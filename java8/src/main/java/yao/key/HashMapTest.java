package yao.key;

import java.util.HashMap;

/**
 * Created by yaoo on 6/30/17.
 */
public class HashMapTest {

    public static void main(String[] args){

        System.out.println("====begin====");
        HashMap map01 = new HashMap();

        map01.put(null,"showtime");
        map01.put(1,"hello01");
        map01.put("2","hello02");
        map01.put(3L,"hello03");
        String a = (String) map01.get(null);
        System.out.println(a);
        System.out.println(map01.get(1));
        System.out.println(map01.get("2"));
        //下面的3输出null
        System.out.println(map01.get(3));
        System.out.println(map01.get(3L));


    }

}
