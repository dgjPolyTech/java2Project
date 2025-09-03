package w0903;

import java.util.Scanner;

public class Calc {
    static int calc(int a, int b, String c){
        int result = 0;

        switch (c){
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                if(b == 0){
                    System.out.println(a+"를 0으로 나눌 수 없습니다.");
                    result = a;
                    break;
                }
                result = a/b;
                break;
            default:
                System.out.println("알맞은 연산자를 입력하세요.");
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("첫번째 숫자를 입력하세요.");
            int num1 = sc.nextInt();

            System.out.println("두번째 숫자를 입력하세요.");
            int num2 = sc.nextInt();

            String choice;
            System.out.println("연산자를 입력하세요.");
            choice = sc.next();

            if(choice.equals("e")){
                System.out.println("프로그램 종료");
                break;
            }

//            while(true){
//                choice = sc.next();
//
//                if(choice.equals("+") || choice.equals("-") || choice.equals("*") || choice.equals("/")){
//                    break;
//                } else {
//                    System.out.println("알맞은 연산자를 입력하세요.");
//                }
//            }

            int result = calc(num1, num2, choice);

            System.out.println("결과: "+result);
        }

        sc.close();
    }
}
