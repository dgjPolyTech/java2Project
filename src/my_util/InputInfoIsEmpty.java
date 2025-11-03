package my_util;

import java.util.Scanner;

// mvc 모델에서, 입력값이 빈 값이면 기존 정보로 유지해주는 클래스
// @param <- 특정 변수의 역할을 설명하는데 특화된 주석.
/*
    @param sc: 입력값 받는 스캐너 객체
    @pram inputCol: 사용자가 입력해야하는 행(col)(수정할 (col) 입력의 col)

*/
public class InputInfoIsEmpty {
    // nextLine으로 입력받고 빈 값인지 판단
    public static String InputStringIsEmpty(Scanner sc, String inputCol, String originValue){
        System.out.print("수정할 \""+inputCol+"\" 정보를 입력해주십시오.: ");

        String userInput = sc.nextLine();

        //사용자 입력값이 비었을 경우, 기존 사용자 정보를 그대로 사용한다.
        if(userInput.isEmpty()){
            userInput = originValue;
        }

        return userInput;
    }

    // 숫자 값을 입력 받고 유효한 값인 지 판단.
    public static int InputNumberIsEmpty(Scanner sc, String inputCol, int originValue){

        int returnNumber;

        while(true) {
            System.out.print("수정할 \""+inputCol+"\" 정보를 입력해 주십시오.: ");

            // input 자체는 똑같이 string(nextLine)으로 받는다.(isEmpty 사용 위함)
            String userInput = sc.nextLine();

            //사용자 입력값이 비었을 경우, 기존 사용자 정보를 그대로 사용한다.
            if (userInput.isEmpty()) {
                returnNumber = originValue;
                break;
            } else {
                // 입력값이 들어왔을 경우, int로 변환(parseInt) 해준다.
                try {
                    // 정상적으로 들어왔다면, 해당 값을 int로 parsing 해준다.
                    returnNumber = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자 값을 입력해주십시오. (현재 입력값: " + userInput + ")");
                }

            }
        }

        return returnNumber;

    }
}
