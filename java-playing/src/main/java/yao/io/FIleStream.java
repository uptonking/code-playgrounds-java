package yao.io;

import java.io.*;

/**
 * Created by yaoo on 6/17/17.
 */
public class FIleStream {

    public static void readFileByByte(String strFilePath) {
        // 使用变量b来装调用read()方法时返回的整数
        int b = 0;
        // 使用FileInputStream流来读取有中文的内容时，读出来的是乱码，因为使用InputStream流里面的read()方法读取内容时是一个字节一个字节地读取的，而一个汉字是占用两个字节的，所以读取出来的汉字无法正确显示。
        FileInputStream in = null;
        try {
            in = new FileInputStream(strFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("系统找不到指定文件！");
            System.exit(-1);// 系统非正常退出
        }
        long num = 0;// 使用变量num来记录读取到的字符数
        try {// 调用read()方法时会抛异常，所以需要捕获异常
            while ((b = in.read()) != -1) {
                // 调用int read() throws Exception方法时，返回的是一个int类型的整数
                // 循环结束的条件就是返回一个值-1，表示此时已经读取到文件的末尾了。
                System.out.print((char) b);
                num++;
            }
            in.close();// 关闭输入流
            System.out.println();
            System.out.println("总共读取了" + num + "个字节的文件");
        } catch (IOException e1) {
            System.out.println("文件读取错误！");
        }

    }

    public static void readFileByChar(String strFilePath) {
        // 使用变量b来装调用read()方法时返回的整数
        int b = 0;
        //使用FileReader流来读取内容时，中英文都可以正确显示，因为Reader流里面的read()方法是一个字符一个字符地读取的，这样每次读取出来的都是一个完整的汉字，这样就可以正确显示了。
        FileReader in = null;
        try {
            in = new FileReader(strFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("系统找不到指定文件！");
            System.exit(-1);// 系统非正常退出
        }
        long num = 0;// 使用变量num来记录读取到的字符数
        try {// 调用read()方法时会抛异常，所以需要捕获异常
            while ((b = in.read()) != -1) {
                // 调用int read() throws Exception方法时，返回的是一个int类型的整数
                // 循环结束的条件就是返回一个值-1，表示此时已经读取到文件的末尾了。
//                System.out.print(b + "\t");
                System.out.print((char) b);
                num++;
            }
            in.close();// 关闭输入流
            System.out.println();
            System.out.println("总共读取了" + num + "个字符的文件");
        } catch (IOException e1) {
            System.out.println("文件读取错误！");
        }
    }


    public static void writeFileByByte(String inFilePath, String outFilePath) {
        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(inFilePath);
            out = new FileOutputStream(outFilePath);
            // 指明要写入数据的文件，如果指定的路径中不存在TestFileOutputStream1.java这样的文件，则系统会自动创建一个
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败");
            System.exit(-1);// 非正常退出
        } catch (IOException e1) {
            System.out.println("文件复制失败！");
            System.exit(-1);
        }
        System.out.println("文件里面的内容已经成功复制");
    }

    public static void writeFileByChar(String strFilePath) {
        // 使用FileWriter输出流从程序把数据写入到Uicode.dat文件中，使用FileWriter流向文件写入数据时是一个字符一个字符写入的
        FileWriter fw = null;
        try {
            fw = new FileWriter(strFilePath);
            //字符的本质是一个无符号的16位整数，字符在计算机内部占用2个字节
            //这里使用for循环把0～60000里面的所有整数都输出
            //这里相当于是把全世界各个国家的文字都0～60000内的整数的形式来表示
            for (int c = 0; c <= 60000; c++) {
                fw.write(c);
                //使用write(int c)把0～60000内的整数写入到指定文件内
                //调用write()方法时，我认为在执行的过程中应该使用了“(char)c”进行强制转换，即把整数转换成字符来显示
                //因为打开写入数据的文件可以看到，里面显示的数据并不是0～60000内的整数，而是不同国家的文字的表示方式
            }
            //使用FileReader(字符流)读取指定文件里面的内容读取，内容时是以一个字符为单位进行读取的
            int b = 0;
            long num = 0;
            FileReader fr = null;
            fr = new FileReader(strFilePath);
            while ((b = fr.read()) != -1) {
                System.out.print((char) b + "\t");
                num++;
            }
            System.out.println();
            System.out.println("总共读取了" + num + "个字符");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    public static void main(String[] args){
////        String filePath = "resources/stream.txt";
////        String filePath = "/root/Documents/repo/spark2017/java8/src/main/resources/stream.txt";
//        String filePath = FIleStream.class.getClassLoader().getResource("stream.txt").getPath();
////        readFileByByte(filePath);
//        readFileByChar(filePath);
//    }


}
