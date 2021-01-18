package VietNam;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检测是否属于越南ip
 */
public class selectVietNamIp {
    static final String REGEX = "((\\d{1,3}).){3}\\d{1,3}-((\\d{1,3}).){3}\\d{1,3}";

    public static void main(String[] args) throws Exception {
        Map<Long, Long> map = new HashMap<>();
        long[] key = new long[524];

        File file = new File("d:/ip.txt/");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String ssip = "";
        String[] s = null;
        long l1 = 0;
        long l = 0;
        int count = 0;

        while ((ssip=reader.readLine())!=null) {
            Pattern p = Pattern.compile(REGEX);//编译正则表达式
            Matcher m = p.matcher(ssip); // 获取 matcher 对
            while (m.find()) {//如果有匹配到
                String str = m.group();
                s = str.split("-");

                for (int i = 0; i < s.length; i++) {
                    l = ipToLong(s[0]);
                    l1 = ipToLong(s[1]);
                    key[count] = l;
                }
                map.put(l, l1);
                count++;
            }
        }
        paixu(key);


        Senter(map, key, "1.52.0.0");
    }


    public static long ipToLong(String ip) {
        String[] ipArray = ip.split("\\.");
        List ipNums = new ArrayList();
        for (int i = 0; i < 4; ++i) {
            ipNums.add(Long.valueOf(Long.parseLong(ipArray[i].trim())));
        }
        long IPNumTotal = ((Long) ipNums.get(0)).longValue() * 256L * 256L * 256L
                + ((Long) ipNums.get(1)).longValue() * 256L * 256L + ((Long) ipNums.get(2)).longValue() * 256L
                + ((Long) ipNums.get(3)).longValue();

        return IPNumTotal;
    }

    /**
     * 排序
     * @param key
     */
    public static void paixu(long[] key) {
        boolean flag = false;
        for (int i = 0; i < key.length - 1; i++) {
            for (int j = 0; j < key.length - 1 - i; j++) {
                if (key[j] > key[j + 1]) {
                    flag =true;
                    long temp = key[j];
                    key[j] = key[j + 1];
                    key[j + 1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }

    public static void Senter(Map map, long[] arr, String ip) {

        String Rege = "((\\d{1,3}).){3}\\d{1,3}";
        Pattern p = Pattern.compile(Rege);//编译正则表达式
        Matcher m = p.matcher(ip); // 获取 matcher 对
        if (!m.matches()) {
            throw new RuntimeException("输入有误...");
        }
        long l = ipToLong(ip);


        long count1 = getCount(0, arr.length - 1, arr, l);
        long count2=0;
        if(map.containsKey(count1)){
            count2 = (long) map.get(count1);
        }
        if (l <= count2 && l >= count1) {
            System.out.println(ip+"是越南的ip...");
        }else{
            throw new RuntimeException("该"+ip+"不属于越南ip");
        }
    }

    public static long getCount(int left, int right, long[] arr, long resVal) {
        int mai = (left + right) / 2;
        long maiVal = arr[mai];
        if (left > right) {
            return maiVal;
        }
        if (resVal > maiVal) {
            return getCount(mai + 1, right, arr, resVal);
        } else if (resVal < maiVal) {
            return getCount(left, mai - 1, arr, resVal);
        } else {
            return maiVal;
        }
    }
}
