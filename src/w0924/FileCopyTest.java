package w0924;

import java.io.*;

public class FileCopyTest {
    public static void main(String[] args){
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;

        // 파일 리더 사용 시 반드시 예외처리 해줘야 한다.(=파일이 없으면 실행 자체가 안될 수 있어서)
        try {
            fr = new FileReader("D:/FileTest/MyData1.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("D:/FileTest/CopyFile1.txt");

            String line;

            // readLine 사용 시에도 예외 처리를 미리 해줘야 한다.
            // 이미 try-catch문 안에 있으니까, 우클릭 > add Catch만 해줘도 됨.
            while((line = br.readLine()) != null){
                // 쓰기 모드로 연 파일에 한 줄씩 글을 적는다.(null값 나올떄까지)
                fw.write(line+"\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다.");
        } catch (IOException e) {
            System.out.println("읽어올 수 없습니다.");
        }

        try {
            br.close();
            fw.close();
            System.out.println("복사가 완료되었습니다.");
        } catch(IOException e){
            System.out.println("reader와 writer가 close되지 못했습니다.");
        }

    }
}
