package w0903;

import java.util.Scanner;

public class plusMethod {
    // 사용자 정의 메소드.
    public static int plus(int a, int b){
        int result = a+b;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        while(true){
            System.out.println("값을 입력해주세요.(종료: -1)");

            num1 = sc.nextInt();

            if (num1 == -1) {
                System.out.println("종료합니다.");
                break;
            }

            num2 = sc.nextInt();

            if (num2 == -1) {
                System.out.println("종료합니다.");
                break;
            }

            int res = plus(num1, num2);

            System.out.println(num1+" + "+num2+" = "+res);
        }
    }
}
