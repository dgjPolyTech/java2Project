package w0924;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileTest {
    public static void main(String[] args){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("D:/FileTest/dolphin.jpg");
            fos = new FileOutputStream("D:/FileTest/CopyImageFile.jpg");
            int ch;

            // 파일과 상호작용하는 메서드는 모두 예외처리를 해줘야 한다고 보면 된다.
            // -1은 더이상 읽을게 없다는 의미이기도 하다.
            while((ch = fis.read()) != -1){
                // 이미지 파일은 1byte씩 입력받아 1byte씩 출력해줘야 한다.
                fos.write(ch);
            }

            System.out.println("복사가 완료되었습니다.");
        } catch (FileNotFoundException e) {
            // 기본적으로는 아래와 같은 문구 뜨는데, 그냥 메시지만 뜨게 하는게 낫다.
            //throw new RuntimeException(e);
            System.out.println("File Not Found");
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Reading Chracter Error");
        }

        try {
            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
