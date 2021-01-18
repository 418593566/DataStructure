package sort;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 * -->总共排序arr.length-1次
 * 相邻之间的两个元素进行比较
 * 每次会把最大的提出
 * 剩余的在进行比较 直至比完
 */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        BubbleSorting sto = new BubbleSorting();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sim.format(date);
        System.err.println("开始时间:"+s+"...");
        sto.bubbleStor(arr);
       // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String s2 = sim.format(date2);
        System.err.println("结束时间:"+s2);


    }


    public void bubbleStor(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
