package w0924;

public class ArrayArithmeticExceptionTest {
    public static void main(String[] args){
        int arr[] = {10, 20, 30};

        try{
            arr[0] = arr[2] / 8;
            arr[3] = 40;

            for(int i=0; i<arr.length; i++){
                System.out.println(arr[i] + "\t");
            }
        }catch(ArithmeticException e) { // 아리스매틱: 불가능한 연산을 한 경우 발생하는 예외처리
            System.out.println("배열의 인덱스 번호가 범위를 벗어난 것 같습니다.");
        }catch(ArrayIndexOutOfBoundsException e){ // 배열 범위 벗어난 경우 발생하는 예외처리
            // ArrayIndex와 Arithmetic은 서로 상속 관계가 아니므로 순서는 상관이 없다.
            System.out.println("나누는 수는 0일 수 없습니다.");
        }catch(Exception e){
            System.out.println("임의의 예외가 발생했습니다.");
        }finally{
            System.out.println("프로그램이 종료됩니다.");
        }

    }
}
