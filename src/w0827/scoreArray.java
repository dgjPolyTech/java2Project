package w0827;

import java.util.Scanner;

public class scoreArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("김연아 선수 경기 끝났습니다~~ 짝짝짞");

        int idx = 0;

        int[] sArray = new int[5];

        while(idx < 5) {
            System.out.println((idx+1)+"번 심사위원은 점수를 매겨주세요.");
            int score = sc.nextInt();
            if(score < 0 || score > 10) {
                System.out.println("값은 0 이상 10 이하여야 합니다. ");
                continue;
            }
            sArray[idx] = score;
            idx++;
        }

        int sum = 0;

        for(int i = 0; i < sArray.length; i++) {
            sum += sArray[i];
        }

        double avg = sum / sArray.length;

        System.out.println("평균 점수: "+avg);
        sc.close();
    }
}
