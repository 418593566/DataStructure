package file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取img的所有文件
 */
public class test4 {

    public static List<String> getFiles(String path) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        if (file.isDirectory()){
            File[] listFiles = file.listFiles();
            System.out.println(listFiles.length);
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()){
                    list.addAll(getFiles(path));
                }else {
                    //System.err.println(listFiles[i].getPath());
                    list.add(listFiles[i].getName());
                }
            }
        }
        return list;
    }




    public static void main(String[] args) throws IOException {
        String path = "D:/img";
        List<String> list = getFiles(path);
        for (String s:list) {
            System.out.println(s);
        }

    }
}
