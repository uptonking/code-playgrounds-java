package yao.collectionx;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by yaoooo on 8/6/17.
 */
public class CollectionTraverse {

    public static void main(String[] args) {

//        Collection<String> books = new HashSet<>();
        Collection books = new HashSet();

        books.add("aaa");
        books.add("bbb");
        books.add("ccc");

//        books.forEach(obj -> System.out.println(obj));
        books.forEach(System.out::println);

    }

}

