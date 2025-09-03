package w0903;

import java.util.Random;

public class UserMethod1 {
    public static void outputDice(String userName){
        System.out.println(userName+"님이 주사위를 던지셨습니다.");
        Random rand = new Random();
        int diceNum = rand.nextInt(6)+1; // rand.nextInt는 0부터 5까지 반환하므로, +1을 해줘야 함.
        System.out.println("주사위 숫자: "+diceNum);
    }

    public static void main(String[] args) {
        outputDice("리즈");
        outputDice("다니엘");
        outputDice("원영");
        outputDice("유진");
    }
}
