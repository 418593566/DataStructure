package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 * -->扫描数组 找到最小的 然后与第一个元素
 * 替换位置
 * arr[1] 从下一个位置开始找
 * arr[0] -- arr[n-1]  找到最小
 * arr[1] -- arr[n-1]  找到最小
 * .......
 * 找n-1次得到 从小到大的结果
 */
public class SelectSorting {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        SelectSorting sog = new SelectSorting();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        System.out.println("开始时间:"+format.format(date)+"...");
        sog.selectSort(arr);
        System.out.println(Arrays.toString(arr)+"\n");
        Date date2 = new Date();
        System.err.println("结束时间："+format.format(date2));
    }

    public void selectSort(int arr[]) {

        for (int x = 0; x < arr.length - 1; x++) {
            //下标
            int minIndex = x;
            //值
            int min = arr[x];
            for (int i = x + 1; i < arr.length; i++) {
                if (min > arr[i]) {   //说明不是最小值
                    //'.'arr[i]比min小
                    min = arr[i];
                    minIndex = i;
                }
            }
            if (minIndex != x) {   //说明没有找到比min小的
                //将最小值  交换下标
                arr[minIndex] = arr[x];
                //替换值err
                arr[x] = min;
            }
        }
    }
}
