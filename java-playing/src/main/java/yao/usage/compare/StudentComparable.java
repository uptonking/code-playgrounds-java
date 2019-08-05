package yao.usage.compare;

/**
 * Created by yaoo on 4/28/17.
 */
public class StudentComparable  implements Comparable<StudentComparable> {

    private String name;
    private int age;
    private float score;

    public StudentComparable(String name,int age,float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    /**
     * 比较学生成绩和年龄的方法，成绩由高到低，年龄由低到高
     * @param stu
     * @return
     */
    public int compareTo(StudentComparable stu) {
        //先比较分数
        if(this.score>stu.score){
            return -1;
        }else if(this.score<stu.score){
            return 1;
        }else{
            //再比较年龄
            if(this.age>stu.age){
                return 1;
            }else if(this.age<stu.age){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public String toString(){
        return "姓名："+this.name+", 年龄："+this.age+", 成绩："+this.score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

}
