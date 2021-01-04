package DataStructure.sparseArray;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test3 {

    public static void main(String[] args) throws Exception {
        List<Object> list = new ArrayList<>();
        File file = new File("D:/test/ts.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String str = null;
        int sti = 0;
        while((str=reader.readLine())!=null){
            System.out.println(str);
            sti = Integer.parseInt(str);
            list.add(sti);
        }
        reader.close();
        System.out.println();

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        Integer[][] arrs = new Integer[list.size()][3];

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (j<3){
                    //arrs[count][0]= list.get(i);
                    count++;
                }
            }
        }

//        for (Integer[] a:arrs) {
//            for (int as:a) {
//                System.out.printf("%d\t",as);
//            }
//            System.out.println();
//        }

    }
}
