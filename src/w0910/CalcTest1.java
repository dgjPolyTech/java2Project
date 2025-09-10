package w0910;

import java.util.Scanner;

public class CalcTest1 {
    public static void main(String[] args) {
        Calc1 calc = new Calc1();
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 수 입력: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 수 입력: ");
        int num2 = sc.nextInt();
        System.out.print("세 번째 수 입력: ");
        int num3 = sc.nextInt();

        int arr[] = {num1, num2, num3};

        System.out.print("결과: ");
        int result = calc.plus(arr);
        System.out.println(result);
    }
}
