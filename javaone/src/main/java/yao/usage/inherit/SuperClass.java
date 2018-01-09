package yao.usage.inherit;

/**
 * Created by yaoo on 4/28/17.
 */
public class SuperClass {
    private int number;


    public SuperClass() {
        this.number = 0;
    }


    public SuperClass(int number) {
        this.number = number;
    }


    public int getNumber() {
        number++;
        return number;
    }
}
