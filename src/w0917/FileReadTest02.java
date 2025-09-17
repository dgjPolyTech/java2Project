package w0917;

import java.io.*;

public class FileReadTest02 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();

        BufferedReader br = null;
        String line = null;

        try{
            br = new BufferedReader(new FileReader("D://FileTest/MyData1.txt"));
            int idx = 0;
            // 파일에서 한 줄 읽었는데(line = br.readLine()) 이것이 null 값이 아닌 동안(즉, 파일 끝나기 전까지) while 반복
            while((line = br.readLine()) != null){
                line = br.readLine();
                idx++;
                sb.append(idx+": "+line + "\n");
            }
        } catch(FileNotFoundException e){
            System.out.println("File not Found");
        } catch(IOException e){
            System.out.println("Line read Error");
        }

        try {
            br.close();
        } catch (IOException e) {
            System.out.println("Closing file Error");
            throw new RuntimeException(e);
        }

        //sb.reverse();// 결과물 반대로 함.
        System.out.println(sb);
    }
}
