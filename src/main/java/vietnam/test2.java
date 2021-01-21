package vietnam;

import java.io.*;
import java.nio.charset.Charset;

public class test2 {
    public static boolean ipIsValid(String ipSection, String ip) {
        if (ipSection == null)
            throw new NullPointerException("IP段不能为空！");
        if (ip == null)
            throw new NullPointerException("IP不能为空！");
        ipSection = ipSection.trim();
        ip = ip.trim();
        final String REGX_IP = "((\\d{1,3}).){3}\\d{1,3}-((\\d{1,3}).){3}\\d{1,3}";
        final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
        if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
            return false;
        int idx = ipSection.indexOf('-');
        String[] sips = ipSection.substring(0, idx).split("\\.");
        String[] sipe = ipSection.substring(idx + 1).split("\\.");
        String[] sipt = ip.split("\\.");
        long ips = 0L, ipe = 0L, ipt = 0L;
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(sips[i]);
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);
        }
        if (ips > ipe) {
            long t = ips;
            ips = ipe;
            ipe = t;
        }
        return ips <= ipt && ipt <= ipe;
    }
    public static void main(String[] args) throws Exception {

        File file = new File("D:/ip.txt/");
        FileInputStream fileInputStream = new FileInputStream(file);
        int available = fileInputStream.available();
        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);
        fileInputStream.close();
        String s = new String(bytes, Charset.forName("utf-8"));
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s);
        }
        if (ipIsValid("s", "223.27.111.254")) {
            System.out.println("ip属于该网段");
        } else
            System.out.println("ip不属于该网段");
    }

}
