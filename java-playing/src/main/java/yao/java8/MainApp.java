package yao.java8;


import java.io.File;

/**
 * Created by yaoo on 3/6/18
 */
public class MainApp {

    public static void main(String[] args) {

//        File[] hiddenFiles = new File(".").listFiles();
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        for (File f : hiddenFiles) {
            System.out.println(f.getName());
        }
    }

}
