package sparse.sparseArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public  class FileLet {
    public  String[][] getFile(String pathName) throws Exception {
        File file = new File(pathName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        List<String[]> list = new ArrayList<String[]>();
        while ((str = br.readLine()) != null) {
            int s = 0;
            String[] arr = str.split(" ");

            list.add(arr);
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).length)
                max = list.get(i).length;
        }
        String[][] array = new String[list.size()][max];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                array[i][j] = list.get(i)[j];
            }
        }
        return array;
    }
}
