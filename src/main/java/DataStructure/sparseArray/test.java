package DataStructure.sparseArray;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

public class test {
    public static void main(String[] args) throws IOException {

        File file = new File("D:/test/ts.txt");
        FileReader fr = new FileReader(file);
        BufferedReader rd = new BufferedReader(fr);
        String line = null;
        while ((line=rd.readLine())!=null){
            System.out.println(line);
        }

//        while ((line=rd.readLine())!=null){
//            hang++;
//            System.out.println(line);
//        }
//        while (rd.ready()){
//            line = rd.readLine();
//            hang ++;
//            lie = line.length()-hang;
//            System.out.println(line);
//        }
//        System.out.println("****************************************************************");
//        int[][] sprase = new int[hang][lie];
//        for (int[] s:sprase) {
//            for (int ss:s) {
//                System.out.printf("%d\t",ss);
//            }
//            System.out.println();
//        }
    }

   // @Test
    public void test() throws Exception {
        File file = new File("D:/test/ts.txt");
        FileInputStream fis = new FileInputStream(file);
        int leng = 0;
        leng = fis.available();
        byte[] bytes = new byte[leng];
        fis.read(bytes);
        String s = new String(bytes, Charset.forName("utf-8"));

        String[] split = s.split(" ");
        fis.close();
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    @Test
    public void test2() throws Exception {
        FileLet let = new FileLet();
        String[][] sprase = let.getFile("D:/test/ts.txt");
        for (String[] as:sprase) {
            for (String str:as) {
                System.out.printf("%d\t",str);
            }
            System.out.println();
        }
    }
}
