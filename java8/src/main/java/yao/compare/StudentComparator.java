package yao.compare;

import java.util.Comparator;

/**
 * Created by yaoo on 4/28/17.
 */
public class StudentComparator implements Comparator<Student> {

    public int compare(Student stu1, Student stu2) {
        if (stu1.score > stu2.score) {
            return -1;
        } else if (stu1.score < stu2.score) {
            return 1;
        } else {
            if (stu1.age > stu2.age) {
                return 1;
            } else if (stu1.age < stu2.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
