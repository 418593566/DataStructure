package DataStructure.sparseArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test2 {

    public static List readTxtFile(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!lineTxt.startsWith("#"))
                        list.add(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到文件");
            }
        } catch (Exception e) {
            System.out.println("出错了");
            e.printStackTrace();
        }
        return list;
    }


    public static String[][] createArray(String filePath) {
        List<String> list = readTxtFile(filePath);
        String array[][] = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = new String[3];
            String linetxt = list.get(i);

            System.err.println(linetxt);

            String[] myArray = linetxt.replaceAll("\\s+", "@").split("@");

            for (int i1 = 0; i1 < myArray.length; i1++) {
                System.out.println(myArray[i1]);
            }
            for (int j = 0; j < myArray.length; j++) {
                if (j < 3) {
                    array[i][j] = myArray[j];
                }
            }
        }
        return array;
    }

    public static void printArray(String array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j != array[i].length - 1) {
                    //System.out.print("array[" + i + "][" + j + "]=" + array[i][j] + ",");
                    System.out.print(array[i][j]);
                } else {
                    //System.out.print("array[" + i + "][" + j + "]=" + array[i][j]);
                    System.out.println(array[i][j]);
                }

            }
            System.out.println();
        }
    }


    public static void main(String args[]) {
        String array[][] = createArray("D:/test/ts.txt");
        printArray(array);

    }
}
