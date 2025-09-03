package w0903;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RockGame {
    public static void main(String[] args) {
        String[] result = new String[10000];

        // A 컴퓨터와 B 컴퓨터의 현재 가위/바위/보를 저장할 수 있는 지역 변수 선언
        String comA, comB;
        
        // a승/b승/비긴 횟수를 저장
        int aWin, bWin, noWin;

        String[] strArr = {"가위", "바위", "보"};

        for(int i = 0; i < result.length; i++) {
            Random random = new Random();

            // java는 랜덤을 nextInt 이렇게 씀
            comA = strArr[random.nextInt(strArr.length)];
            comB = strArr[random.nextInt(strArr.length)];

            if(comA.equals("가위")) {
                if(comB.equals("가위")){
                    result[i] = "없음";
                }
                else if(comB.equals("바위")){
                    result[i] = "B";
                }
                else if(comB.equals("보")){
                    result[i] = "A";
                }
            } else if(comA.equals("바위")){
                if(comB.equals("가위")){
                    result[i] = "A";
                }
                else if(comB.equals("바위")){
                    result[i] = "없음";
                }
                else if(comB.equals("보")){
                    result[i] = "B";
                }
            } else if(comA.equals("보")){
                if(comB.equals("가위")){
                    result[i] = "B";
                }
                else if(comB.equals("바위")){
                    result[i] = "A";
                }
                else if(comB.equals("보")){
                    result[i] = "없음";
                }
            }
        }

        // asList(result) = result 배열을 리스트로 한다.(asList)
        aWin = Collections.frequency(Arrays.asList(result), "A");
        bWin = Collections.frequency(Arrays.asList(result), "B");
        noWin = Collections.frequency(Arrays.asList(result), "없음");

        // printf -> 메소드인데 반환값이 없다.(그냥 출력만 수행함)
        // equlas -> 메소드인데 반환값(boolean)이 있다. 반환값이 있더라도 무조건 변수에 값을 담을 필요는 없다.(당연하지만)
        System.out.println("A의 승리 횟수: "+aWin);
        System.out.println("B의 승리 횟수: "+bWin);
        System.out.println("비긴 횟수: "+noWin);
    }
}
