package yao.usage.compare.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentEqualsTest {

    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", "chenssy1", 24));
        list.add(new Student("2", "chenssy2", 26));

        for(Student s:list){
            System.out.println(s);
        }

        Collections.sort(list);   //排序

        System.out.println("=====排序后=====");

        for(Student s:list){
            System.out.println(s);
        }


        Student student = new Student("2", "chenssy2", 26);

        //检索student在list中的位置
        int index1 = list.indexOf(student);
        int index2 = Collections.binarySearch(list, student);

        System.out.println("index1 = " + index1);
        System.out.println("index2 = " + index2);
    }

}
