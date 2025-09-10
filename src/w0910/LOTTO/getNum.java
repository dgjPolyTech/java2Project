package w0910.LOTTO;

import java.util.Random;

public class getNum {
    public int getNumber(int max){
        int num = 0;
        Random random = new Random();

        num = random.nextInt(max) + 1;

        return num;
    }
}
