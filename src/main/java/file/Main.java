package file;

import work.TransApi;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable{

    private static final String APP_ID = "20201223000653958";
    private static final String SECURITY_KEY = "2tpCsHMi5o_t8jNtO1Wr";

    public static void main(String[] args) throws Exception {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        Main mm = new Main();
        mm.run();
    }


    @Override
    public void run() {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        List<String> list = new ArrayList();
        byte[] bytes = null;
        File testFile = new File("D:/tt.txt/");
        FileInputStream fis = null;
        int length = 0;
        try {
            fis = new FileInputStream(testFile);
            length = fis.available();
            bytes = new byte[length];
            fis.read(bytes);
            fis.close();
            String s = new String(bytes,Charset.forName("utf-8"));
            String[] s1 = s.split(" ");
            for (int i=0;i < s1.length;i++) {
                list.add(s1[i]);
                String str = api.getTransResult(s1[i], "auto", "vie");
                System.out.println(list.get(i));
                    if(!list.contains(s1[i])) {
                       list.add(s1[i]);
                        //String str = api.getTransResult(s1[i], "auto", "vie");
                        //System.out.println(str);
                        System.out.println(list.get(i));
                    }
                System.out.println(list.get(i));
            }
           // System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
