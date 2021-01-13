public class ArrayDemo {
    public static void main(String[] args) {
        int[][] arrs = new int[6][7];
        arrs[0][2]=1;
        arrs[0][3]=1;
        arrs[1][2]=2;
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t",arrs[i][j]);
                if (arrs[i][j]!=0){
                    sum++;
                }
            }
            System.out.println();
        }

        int[][] spar = new int[sum+1][3];
        spar[0][0]=6;
        spar[0][1]=7;
        spar[0][2]=sum;
        int count = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (arrs[i][j]!=0){
                    count++;
                    spar[count][0]=i;
                    spar[count][1]=j;
                    spar[count][2]=arrs[i][j];
                }
            }
        }

        System.out.println("***********************************");
        for (int[] a:spar) {
            for (int as:a) {
                System.out.printf("%d\t",as);
            }
            System.out.println();
        }
    }
}
