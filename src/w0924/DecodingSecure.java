// 과제 있는 것을 깜박하고 있었습니다. 교수님...
// 쉬는 시간이랑 막간 활용해서 급히 제출 드립니다. 늦게 제출 드려 죄송합니다...
package w0924;

import java.io.*;

public class DecodingSecure {
    public static void main(String[] args){
        FileReader fr = null; // decoding 해야 할 파일 읽기(read)
        BufferedReader br = null; // 버퍼에 담아 한 줄 한 줄 읽기 위한 용도.
        FileWriter fw = null; // decoding 파일에 내용 입력
        String decodingOutStr = "";

        try {
            fr = new FileReader("D:/FileTest/secure1.txt");
            br = new BufferedReader(fr); // 한줄 씩 버퍼에 담아 읽는다.
            fw = new FileWriter("D:/FileTest/decoding1.txt");

            String line;

            while((line=br.readLine()) != null){

                System.out.println("라인"+ line);
                for(int i=0; i<line.length(); i++){
                    int code = line.charAt(i);
                    code -= 100;
                    decodingOutStr += (char)code;
                }
                System.out.println("해독된 문장: "+ decodingOutStr);
                fw.write(decodingOutStr+"\n");
            }

        } catch(FileNotFoundException e){
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            fw.close();
            fr.close();
        } catch(IOException e){
            System.out.println("파일 작성 완료. 종료합니다.");
        }
    }
}
