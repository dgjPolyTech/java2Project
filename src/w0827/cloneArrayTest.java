package w0827;

import java.util.Arrays;

public class cloneArrayTest {
    public static void main(String[] args) {
        // 얕은 복사 => 복제가 아닌 경우(= 같은 배열을 참조한다.)
        String[] originArr1 = {"김치찌개", "잔치국수", "감자탕", "돈부리"};
        String[] originArr2 = originArr1;

        originArr1[1] = "라구파스타";
        originArr2[2] = "치즈 돈까스";

        System.out.println(Arrays.toString(originArr1));
        System.out.println(Arrays.toString(originArr2));

        // 깊은 복사 => 복제인 경우(= 값만 같고 다른 배열이다.) 깊은 복사
        String[] originArr = {"다니엘", "민지", "혜인", "해린"};
        String[] cloneArr = originArr.clone();

        cloneArr[1] = "장원영";
        cloneArr[2] = "리즈";

        System.out.println(Arrays.toString(originArr));
        System.out.println(Arrays.toString(cloneArr));
    }
}
