package w0910;

import java.util.ArrayList;

public class CalcTest2 {
    public static void main(String args[]){
        int[] nums = {1, 3, 5, 7, 9, 11};

        Calc1 calc1 = new Calc1();
        int result = calc1.plus(nums);

        System.out.println("배열에 저장된 점수 값들의 합: "+result);

        // int형 배열들이 저장되는 리스트.
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(10);
        arrList.add(22);
        arrList.add(33);
        arrList.add(11);

        int result2 = calc1.plus(arrList);
        System.out.println("리스트에 저장된 값들의 합: "+result2);

    }
}
