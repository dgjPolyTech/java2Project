package w0917;

import java.io.*;

public class FileWriteTest01 {
    public static void main(String[] args){
        FileWriter fw = null;
        String line = null;

        try {
            fw = new FileWriter("D://FileTest/MyData2.txt");
            line = "루피";
            fw.write(line+"\n");

            line = "조로";
            fw.write(line+"\n");

            line = "상디";
            fw.write(line+"\n");
        } catch (IOException e) {
            System.out.println("FileWriter Generation Error");
        }

        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("FileWriter close Error");
        }
    }
}
