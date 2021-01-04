package file;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class test {

        private String u;
        private String encoding;

        public static void main(String[] args) throws Exception {
            String url = "https://www.qmsjmfb.com/";
            test client = new test(url, "utf-8");
            client.run();
        }

        public test(String u, String encoding) {
            this.u = u;
            this.encoding = encoding;
        }

        public void run() throws Exception {

            File fp = new File("D:/tt.txt/");
            URL url = new URL(u);
            // 根据链接（字符串格式），生成一个URL对象
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();// 打开URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream(), encoding));
            // 得到输入流，即获得了网页的内容
            String line;
            while ((line = reader.readLine()) != null) {
                addfile(line, fp);
            }

        }

        public void addfile(String line, File fp) throws IOException //追加文件
        {
            try {
                String str = "\r\n";
                FileOutputStream af = new FileOutputStream(fp, true);

                af.write(line.getBytes());
                af.write(str.getBytes());

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("写入失败!");
                e.printStackTrace();
            }
        }
    }
