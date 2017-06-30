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
        String a = (String) map01.get(null);
        System.out.println(a);


    }

}
