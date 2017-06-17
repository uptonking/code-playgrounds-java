package yao.tutorial.stream;

import java.io.*;

/**
 * Created by yaoo on 6/17/17.
 */
public class ProcessStream {

    public static void bufferInputStream(String strPath) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(strPath);
            // 在FileInputStream节点流的外面套接一层处理流BufferedInputStream
            BufferedInputStream bis = new BufferedInputStream(fis);
            int c = 0;
            System.out.println((char) bis.read());
            System.out.println((char) bis.read());
            bis.mark(100);// 在第100个字符处做一个标记
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c);
            }
            System.out.println();
            bis.reset();// 重新回到原来标记的地方
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c);
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    public static void bufferWriter(String strPath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(strPath));
            //在节点流FileWriter的外面再套一层处理流BufferedWriter
            String s = null;
            for (int i = 0; i < 100; i++) {
                s = String.valueOf(Math.random());//“Math.random()”将会生成一系列介于0～1之间的随机数。
                // static String valueOf(double d)这个valueOf()方法的作用就是把一个double类型的数转换成字符串
                //valueOf()是一个静态方法，所以可以使用“类型.静态方法名”的形式来调用
                bw.write(s);//把随机数字符串写入到指定文件中
                bw.newLine();//调用newLine()方法使得每写入一个随机数就换行显示
            }
            bw.flush();//调用flush()方法清空缓冲区

            BufferedReader br = new BufferedReader(new FileReader(strPath));
            //在节点流FileReader的外面再套一层处理流BufferedReader
            while ((s = br.readLine()) != null) {
                //使用BufferedReader处理流里面提供String readLine()方法读取文件中的数据时是一行一行读取的
                //循环结束的条件就是使用readLine()方法读取数据返回的字符串为空值后则表示已经读取到文件的末尾了。
                System.out.println(s);

            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void inputStreamToWriter() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            //System.in这里的in是一个标准的输入流，用来接收从键盘输入的数据
            BufferedReader br = new BufferedReader(isr);
            String s = null;
            s = br.readLine();//使用readLine()方法把读取到的一行字符串保存到字符串变量s中去
            while (s != null) {
                System.out.println(s.toUpperCase());//把保存在内存s中的字符串打印出来
                s = br.readLine();//在循环体内继续接收从键盘的输入
                if (s.equalsIgnoreCase("exit")) {
                    //只要输入exit循环就结束，就会退出
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dataInOutStream() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //在调用构造方法时，首先会在内存里面创建一个ByteArray字节数组
        DataOutputStream dos = new DataOutputStream(baos);
        //在输出流的外面套上一层数据流，用来处理int，double类型的数
        try {
            dos.writeDouble(Math.random());//把产生的随机数直接写入到字节数组ByteArray中
            dos.writeBoolean(true);//布尔类型的数据在内存中就只占一个字节
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            //打印能够输出的总字节数
            System.out.println(bais.available());
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readDouble());//先写进去的就先读出来，调用readDouble()方法读取出写入的随机数
            System.out.println(dis.readBoolean());//后写进去的就后读出来，这里面的读取顺序不能更改位置，否则会打印出不正确的结果
            dos.close();
            bais.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStream() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("D:/java/log.txt");
            ps = new PrintStream(fos);//在输出流的外面套接一层打印流，用来控制打印输出
            if (ps != null) {
                System.setOut(ps);//这里调用setOut()方法改变了输出窗口，以前写System.out.print()默认的输出窗口就是命令行窗口.
                //但现在使用System.setOut(ps)将打印输出窗口改成了由ps指定的文件里面，通过这样设置以后，打印输出时都会在指定的文件内打印输出
                //在这里将打印输出窗口设置到了log.txt这个文件里面，所以打印出来的内容会在log.txt这个文件里面看到
            }
            for (char c = 0; c <= 60000; c++) {
                System.out.print(c + "\t");//把世界各国的文字打印到log.txt这个文件中去
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}





