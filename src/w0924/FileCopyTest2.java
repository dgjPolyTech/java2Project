package w0924;

import java.io.*;

public class FileCopyTest2 {
    public static void throwsTest(){

    }

    // throws 사용하면, 코드 내에 try-catch문을 여러개 쓸 필요가 없다.
    // 다만 이러면 어디서 오류가 낫는지 알 수 없는게 단점이다.
    public static void copyFile() throws FileNotFoundException, IOException{

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;

        // 파일 리더 사용 시 반드시 예외처리 해줘야 한다.(=파일이 없으면 실행 자체가 안될 수 있어서)
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

        System.out.println("파일을 찾지 못했습니다.");

        System.out.println("읽어올 수 없습니다.");



        br.close();
        fw.close();
        System.out.println("복사가 완료되었습니다.");

        System.out.println("reader와 writer가 close되지 못했습니다.");


    }

    public static void main(String[] args){
        try{
            // 이렇게 호출한 곳에서 예외처리를 하면, 어떤 오류가 발생했는지 알 수 있다.
            copyFile();
        } catch(FileNotFoundException e){
            System.out.println("파일 찾을 수 없습니다.");
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
