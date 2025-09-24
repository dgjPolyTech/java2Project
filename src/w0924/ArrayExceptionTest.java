package w0924;

public class ArrayExceptionTest {
    public static void main(String[] args){
        // 배열 범위를 벗어나서 오류가 발생한다. 예외처리 알아보기 위해 일부러 오류 발생 시킴
        int[] arr = {10, 20, 30};

        try{
            arr[3] = 40;

            for(int i =0; i< arr.length; i++){
                System.out.println(arr[i] + '\t');
            }
        } catch(ArrayIndexOutOfBoundsException e) {// 배열의 범위를 벗어난 경우 사용하는 예외.
            System.out.println("배열의 인덱스 번호가 범위를 벗어난 것 같습니다.\n");
        }
    }
}
