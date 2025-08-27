package w0827;

public class dArray {
    public static void main(String[] args) {
        int dArr[][] = {{1, 2}, {3,4,5}, {6}};

        for(int i=0; i<dArr.length; i++) {
            for(int j=0; j<dArr[i].length; j++) {
                System.out.print(dArr[i][j]);
            }
            System.out.println();
        }
    }
}
