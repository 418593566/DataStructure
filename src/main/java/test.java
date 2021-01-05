import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class test {
    public static void main(String[] args) throws Exception {
        int[][] arrs = new int[6][7];
        arrs[0][3] = 1;
        arrs[5][4] = 2;
        arrs[2][5] = 1;

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
        System.out.println(sum);

        int[][] sparte=new int[sum+1][3];
        sparte[0][0]=6;
        sparte[0][1]=7;
        sparte[0][2]=sum;
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (arrs[i][j]!=0){
                    count++;
                    sparte[count][0]=i;
                    sparte[count][1]=j;
                    sparte[count][2]=arrs[i][j];
                }
            }
        }
        for (int[] as: sparte) {
            for (int a: as) {
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }


        String dat="D:/goodv/";
        String name ="t.txt";
        File file = new File(dat);
        File file1 = new File(dat, name);
        if (!file.exists()){
            file.mkdir();
        }
        if (!file1.exists()){
            file1.createNewFile();
        }
        FileWriter fw = new FileWriter(file1);
        for (int i = 0; i < sum+1; i++) {
            for (int j = 0; j < 3; j++) {
                fw.write(sparte[i][j]+"\t");
            }
            fw.write("\r\n");
        }
        fw.close();
    }
}
