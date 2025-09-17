package w0917;

import java.util.Scanner;

public class pwGenerator {

    public static boolean checkPassword(String password){
        if(password.length() < 8){
            System.out.println("비밀번호는 최소 8자리 이상이어야 합니다.");
            return false;
        }

        for(int i=0; i < password.length(); i++){
            char ch = password.charAt(i);

            if(!Character.isAlphabetic(ch)){
                System.out.println("비밀번호는 영어 혹은 한글만 사용가능합니다.");
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String pass;

        while(true){
            System.out.println("비밀번호를 입력해주십시오.(영문/한글만 가능, 최소 8자리 이상)");
            pass = sc.nextLine();

            if(checkPassword(pass)){
                System.out.println("비밀번호 생성이 완료되었습니다.");
               break;
            }
        }

        sc.close();
    }
}
