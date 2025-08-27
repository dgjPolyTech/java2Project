package w0827;

import java.util.Arrays;
import java.util.Collections;

public class arrReverseTest {
    public static void main(String[] args) {
        String[] memberArr = {"루피", "나미", "상디", "우솝", "조로"};
        System.out.println("처음배열: "+ Arrays.toString(memberArr));

        Collections.reverse(Arrays.asList(memberArr));

        System.out.println("역순배열: "+ Arrays.toString(memberArr));
    }
}
