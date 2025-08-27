package w0827;

import java.util.Arrays;
import java.util.Collections;

public class arrSort {
    public static void main(String[] args) {
        int[] arr = {77, 55, 33, 44, 11, 22, 66, 88, 99};
        String[] strArr = {"인공지능", "소프트웨어", "한국", "대학", "폴리텍", "1학년", "2학년", "하이테크"};

        Arrays.sort(arr);

        for(int i : arr){
            System.out.print(i + "\t");
        }

        System.out.println();

        // 문자 배열의 경우, 첫 글자를 기준으로 숫자 > ㄱ~ㅎ 순으로 출력됨.
        // 다만 아래는 문자 배열을 내림차순으로 정렬하는 것으로, 때문에 반대로 ㅎ~ㄱ > 숫자(10~1) 순으로 출력됨.
        Arrays.sort(strArr, Collections.reverseOrder());

        for(String str : strArr){
            System.out.print(str + " ");
        }
    }
}
