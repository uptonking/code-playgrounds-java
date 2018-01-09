package yao.usage.compare;

import java.util.Arrays;

/**
 * Created by yaoo on 4/28/17.
 */
public class StudentSortTest {

    public static void main(String[] args) throws Exception {
        StudentComparable1[] stu = {
                new StudentComparable1("张三", 22, 80f),
                new StudentComparable1("李四", 23, 83f),
                new StudentComparable1("王五", 21, 80f)
        };
        Arrays.sort(stu);   //进行排序操作


        for (int i = 0; i < stu.length; i++) {
            StudentComparable1 s = stu[i];
            System.out.println(s);
        }

        Student[] stu1 = {
                new Student("张三", 22,80f),
                new Student("李四", 23,83f),
                new Student("王五", 21,80f)};
        Arrays.sort(stu1, new StudentComparator());

        for (int i = 0; i < stu.length; i++) {
            Student s1 = stu1[i];
            System.out.println(s1);
        }


    }
}
