package yao.tutorial.stream;

import java.io.*;

public class FilterInputStreamExample {
    public static void main(String[] args) throws Exception {

        FileInputStream is = null;
        FilterInputStream fis = null;

        try
        {

            is = new FileInputStream("data.txt");
            fis = new BufferedInputStream(is);

            int r;
            System.out.println();
            while ((r = fis.read()) != -1)
            {
                System.out.print((char)r);
            }
            System.out.println();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally
        {
            if(is!=null)
                is.close();
            if(fis!=null)
                fis.close();
        }
    }
}

class FilterOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/cp/text.txt");
        FileOutputStream fos = new FileOutputStream(file);

        FilterOutputStream filterOS = new FilterOutputStream(fos);
        byte[] b = "Hello World!".getBytes();
        for(int i=0;i<b.length;i++){
            filterOS.write(b[i]);
        }
        fos.close();
        System.out.println("Done");
    }
}

class FilterInputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/cp/text.txt");
        FileInputStream  fis = new FileInputStream(file);

        FilterInputStream filterIs = new BufferedInputStream(fis);
        int i =0;
        while((i=filterIs.read())!=-1){
            System.out.print((char)i);
        }
        fis.close();
        filterIs.close();
    }
}