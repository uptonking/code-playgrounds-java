package yao.compare;

/**
 * Created by yaoo on 4/28/17.
 */
public class StudentComparable1 extends Student implements Comparable<Student> {

    public StudentComparable1(String name, int age, float score) {
        super(name, age, score);
    }


    public int compareTo(Student stu) {

        if (super.score > stu.score) {
            return -1;
        } else if (super.score < stu.score) {
            return 1;
        } else {
            if (super.age > stu.age) {
                return 1;
            } else if (super.age < stu.age) {
                return -1;
            } else {
                return 0;
            }
        }

    }
}
