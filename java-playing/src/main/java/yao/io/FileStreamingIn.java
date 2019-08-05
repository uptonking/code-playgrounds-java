package yao.io;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yaoooo on 8/7/17.
 */
public class FileStreamingIn {

    public static void main(String[] args) {


        String filePath = "/root/Documents/repo/play201X/java8/src/main/java/yao/old/sort/README.md";

        try (
                FileInputStream is = new FileInputStream(filePath)
//                FileReader is = new FileReader(filePath)
        ) {

            byte[] buf = new byte[256];
//            char[] buf = new char[256];

            int hasRead = 0;

            while ((hasRead = is.read(buf)) > 0) {

                System.out.println(new String(buf, 0, hasRead));
                System.out.println("================");

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
