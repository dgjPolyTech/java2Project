package w0910;

import java.util.Scanner;
import java.util.List;

public class Calc1 {
    public static int plus(int num1, int num2){
        return num1 + num2;
    }

    public static int plus(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }

    public static int plus(int arr[]){
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        return sum;
    }

    // List는 배열과 달리 길이가 가변적이다. 원하는 만큼만 넣을 수가 있다.
    public int plus(List<Integer> nums){
        int result = 0;

        for (int num : nums){
            result += num;
        }
//        for(int i=0; i<arr.length; i++){
//            sum += arr[i];
//        }

        return result;
    }
}
