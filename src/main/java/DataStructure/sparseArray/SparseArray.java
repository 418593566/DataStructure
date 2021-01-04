package DataStructure.sparseArray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        int[][] arrs = new int[6][7];
        arrs[1][2] = 1;
        arrs[2][3] = 2;
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t", arrs[i][j]);
                if (arrs[i][j] != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("sum：" + sum);

        int[][] sparse = new int[sum + 1][3];
        sparse[0][0]=6;
        sparse[0][1]=7;
        sparse[0][2]=sum;
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (arrs[i][j] != 0) {
                    count++;
                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=arrs[i][j];
                }
            }
        }
        for (int i = 0; i < sparse.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparse[i][0],sparse[i][1],sparse[i][2]);
        }
        System.out.println();
        for (int[] aa:sparse) {
            for (int a:aa) {
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }

        String dat = "D:\\test";
        String name = "ts.txt";
        File file = new File(dat);
        if (!file.exists()){
            file.mkdir();
        }
        File file1 = new File(dat,name);
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = new FileWriter(file1);

        for (int i = 0; i < sum+1; i++) {
            for (int j = 0; j < 3; j++) {
                fw.write(sparse[i][j]+"\t");
            }
            fw.write("\r\n");
        }
        fw.close();
    }
}
