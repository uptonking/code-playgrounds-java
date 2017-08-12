package yao.io;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by yaoooo on 8/7/17.
 */
public class FileStreamingOut {

    public static void main(String[] args) {


        String filePath = "newFile.txt";
        String contents = "so sick, are you ok.Java 5+中的Executor接口定义一个执行线程的工具。它的子类型即线程池接口是ExecutorService。要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，因此在工具类Executors面提供了一些静态工厂方法，生成一些常用的线程池，如下所示：\n" +
                "- newSingleThreadExecutor：创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。\n" +
                "- newFixedThreadPool：创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。\n" +
                "- newCachedThreadPool：创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。\n" +
                "- newScheduledThreadPool：创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。\n" +
                "- newSingleThreadExecutor：创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求。";

        try (
//                FileOutputStream os = new FileOutputStream(filePath)
                FileWriter os = new FileWriter(filePath)
        ) {


//            byte[] cbyte = contents.getBytes();
            char[] cbyte = contents.toCharArray();


            int hasRead = 0;

            while (hasRead < cbyte.length) {

                if (hasRead + 64 > cbyte.length) {
                    os.write(cbyte, hasRead, cbyte.length - hasRead - 1);
                } else {
                    os.write(cbyte, hasRead, 64);

                }

                System.out.println("================ " + (hasRead / 64 + 1));

                hasRead = hasRead + 64;

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
