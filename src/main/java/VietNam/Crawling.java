package VietNam;

import file.test3;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 爬取ip
 */
public class Crawling {

    public Document getDocument (String url){
        try {
            //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {

        String filePath = "D:\\ip.txt\\";

        test3 t = new test3();
        Document doc = t.getDocument("http://ip.t086.com/?ip=123.24.222.87");
        // 获取目标HTML代码
        Elements elements1 = doc.select("[class=iplist]");
        //今天
        Elements elements2 = elements1.select("li");
        String today = elements2.text();
        today.split("\"");
        System.out.println("名字： " + today);

        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(filePath, true);
            fwriter.write(today);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
    }
}
