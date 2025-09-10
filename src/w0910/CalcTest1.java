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

        System.out.println("");
        int result = calc.plus(num1, num2);
        System.out.println(result);
    }
}
