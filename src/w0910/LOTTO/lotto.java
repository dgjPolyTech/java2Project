package w0910.LOTTO;

import java.util.ArrayList;

public class lotto {
    public static void main(String args[]){
        int num = 0;
        int count = 0;

        //
        ArrayList<Integer> resultArr = new ArrayList<>();
        getNum getNum = new getNum();

        // 값이 맞지 않으면, 다시 이곳으로 돌아옴.
        refindNum:
        while(true){
            int inputNum = 0;
            int randNum = 0;
            randNum = getNum.getNumber(45);

            if(resultArr.size() > 0){
                for(int i : resultArr){
                    if(i == randNum){
                        continue refindNum;
                    }
                    else{
                        inputNum = randNum;
                    }
                }
            } else {
                inputNum = randNum;
            }
            resultArr.add(inputNum);

            if(resultArr.size() > 5){
                break;
            }
        }

        System.out.println(resultArr);
    }
}
