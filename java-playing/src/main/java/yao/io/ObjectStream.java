package yao.io;

import java.io.*;

public class ObjectStream {

    public static void writeReadObjectStream(String oPath) {
        T t = new T();
        t.k = 8;// 把k的值修改为8
        try {
            FileOutputStream fos = new FileOutputStream(oPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // ObjectOutputStream流专门用来处理Object的，在fos流的外面套接ObjectOutputStream流就可以直接把一个Object写进去
            oos.writeObject(t);// 直接把一个t对象写入到指定的文件里面
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream(oPath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // ObjectInputStream专门用来读一个Object的
            T tRead = (T) ois.readObject();
            // 直接把文件里面的内容全部读取出来然后分解成一个Object对象，并使用强制转换成指定类型T
            System.out.print(tRead.i + "\t" + tRead.j + "\t" + tRead.d + "\t"
                    + tRead.k);
            System.out.println();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * 凡是要将一个类的对象序列化成一个字节流就必须实现Serializable接口
 * Serializable接口中没有定义方法，Serializable接口是一个标记性接口，用来给类作标记，只是起到一个标记作用。
 * 这个标记是给编译器看的，编译器看到这个标记之后就可以知道这个类可以被序列化 如果想把某个类的对象序列化，就必须得实现Serializable接口
 */
class T implements Serializable {
    // Serializable的意思是可以被序列化的
    int i = 10;
    int j = 9;
    double d = 2.3;
//    int k = 15;
     transient int k = 15;
    // 在声明变量时如果加上transient关键字，那么这个变量就会被当作是透明的，即不存在。
}
