package file;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class test3 {

    /**
     *
     * @param url 访问路径
     * @return
     */
    public  Document getDocument (String url){
        try {
            //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {

        String filePath = "D:\\tt.txt\\";

        test3 t = new test3();
        Document doc = t.getDocument("https://www.qmsjmfb.com/");
        // 获取目标HTML代码
        Elements elements1 = doc.select("[class=name_show]");
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
