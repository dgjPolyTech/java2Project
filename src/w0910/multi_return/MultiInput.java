package w0910.multi_return;

import java.util.Scanner;

public class MultiInput {
    public int[] inputScoeres(){
        int[] scores = new int[3];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            System.out.println("정수 "+(i+1)+"입력:");
            scores[i] = sc.nextInt();
        }

        sc.close();

        return scores;
    }
}
