package vietnam;


import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;

public class Transition {
    public static void main(String[] args) throws Exception {
        IpThod thod = new IpThod();
        //long ipToLong = thod.getIpToLong();
        //System.out.println(ipToLong);

        File file = new File("D:/ip.txt/");
        FileInputStream fis = new FileInputStream(file);
        int leng = fis.available();
        byte[] bytes = new byte[leng];
        fis.read(bytes);
        String str = new String(bytes,Charset.forName("utf-8"));
        String[] ip = str.split(" ");
        for (String s : ip) {
            long ip1 = thod.getIpToLong(s);
            System.out.println(ip1);
        }
    }
}

class IpThod{

    public long getIpToLong(String str) throws Exception {
        String[] ip = str.split("\\.");

        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);
    }
}
