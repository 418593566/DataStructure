public class test5 {
    public static void main(String[] args) {
        int[][] arrs = new int[6][7];
        arrs[0][2]=1;
        arrs[1][2]=1;
        arrs[2][2]=1;
        int sum=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t",arrs[i][j]);
                if (arrs[i][j]!=0){
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println(sum);

        int[][] sparses = new int[sum+1][3];
        sparses[0][0]=6;
        sparses[0][1]=7;
        sparses[0][2]=sum;
        int count=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (arrs[i][j] != 0) {
                    count++;
                    sparses[count][0]=i;
                    sparses[count][1]=j;
                    sparses[count][2]=arrs[i][j];
                }
            }
        }

        for (int[] as:sparses) {
            for (int a:as) {
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }

    }
}
