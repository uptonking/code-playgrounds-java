package yao.container;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by yaoooo on 8/6/17.
 */
public class CollectionTraverse {

    public static void main(String[] args) {

        Collection books = new HashSet();

        books.add("红花会");
        books.add("啊之");
        books.add("PG One");

        books.forEach(obj -> System.out.println(obj));
//        books.forEach(System.out::println);

    }

}

