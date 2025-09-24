package w0924;

import java.io.*;

public class DecodingSecure {
    public static void main(String[] args){
        FileReader fr = null; // decoding 해야 할 파일 읽기(read)
        BufferedReader br = null; // 버퍼에 담아 한 줄 한 줄 읽기 위한 용도.
        FileWriter fw = null; // decoding 파일에 내용 입력
        String line = "";
        String decodingOutStr = "";

        try {
            fr = new FileReader("D:/FileTest/");
            fw = new FileWriter("D:/FileTest/decoding1.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
