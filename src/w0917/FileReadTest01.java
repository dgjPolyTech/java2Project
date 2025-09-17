package w0917;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest01 {
    public static void main(String[] args){
        // 그냥 이런 식으로 쓰면 오류가 발생한다. FileReader가 참조하는 위치에 값이 없을 수도 있기 때문이다.
        // 때문에 아래처럼 파일이 없을 때를 대비한 예외처리가 필요한데, try-catch나 throws를 사용해야한다.
        //BufferReader br = new BufferedReader(new FileReader("D:/FileTest/MyData1.txt"));

        BufferedReader br = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader("D:/FileTest/MyData1.txt"));

            while(true){
                line = br.readLine();

                if(line == null){
                    break;
                } else {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e){
            // 파일을 찾지 못한 상황에서의 예외 처리
            System.out.println("현재 경로에 파일을 찾을 수 없습니다.");
            return; // 이 return 문구 쓰면 그냥 프로그램이 종료되어, 오류 메시지가 안뜸.
        } catch (IOException e) {
            // IOException은 그냥 "기타 예외 사항"을 모두 포함하는 거라고 보면 됨.
            // 따라서 위의 FIleNotFound 같은 걸 위에 써야 구체적인 오류를 알 수 있음.
            // 부모 클래스인 IOException이 아래에 있어야함(단순히 권고 수준이 아니라, 위에 쓰면 오류 남;)
            System.out.println("파일을 한 줄 씩 읽는 동안 오류가 발생했습니다.");
            return;
        }

        try {
            br.close();
        } catch(IOException e){
            System.out.println("BufferReader를 닫는데 문제가 발생했습니다.");
        }

    }
}
