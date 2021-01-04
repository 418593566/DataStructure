package DataStructure;

public class test3 {
    public static void main(String[] args) {
        int[][] arr = new int[6][7];
        arr[1][3]=2;
        arr[0][2]=1;
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.printf("%6d",arr[i][i1]);
            }
            System.out.println();
        }
    }
}
