package yao.keys;

/**
 * Created by yaoo on 6/20/17.
 */
public class MainClass {

    public static void main(String[] args){
        OuterClass out=new OuterClass();
        OuterClass.InnerClass in = out.new InnerClass() ;
    }
}
