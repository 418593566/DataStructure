package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序
 *      1.找arr的中间值 prov
 *        通过left、right索引来找比 prov小的或大的 找到了
 *        而后进行替换
 *      2.然后把交换的 比中间值小的段
 *        再进行如上操作
 *        直到 只有一个
 */
public class QuickSorting {
    public static void main(String[] args) {
        //int[] arr = new int[]{9,8,7,6,3,2,1,10};
        int[] arr = new int[8000000];
        QuickSorting stn = new QuickSorting();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));

        stn.quickSort(arr, 0, arr.length - 1);
        Date date1 = new Date();
        System.err.println(format.format(date1));
    }

    public void quickSort(int[] arr, int left, int right) {
        int l = left;//左索引
        int r = right;//右索引
        int centre = arr[(left + right) / 2];  //中间值
        int temp = 0;
        //左边的值小于右边的值
        //当左索引大于右索引的时候就退出while
        //说明已经扫描完了
        while (l < r) {
            //左索引扫到的值大于中间值
            //就退出
            while (arr[l] < centre) {
                //索引往后移
                l += 1;
            }
            //右索引扫到的值小于中间值
            //就退出
            while (arr[r] > centre) {
                //索引前移
                r -= 1;
            }
            //如果左边的索引大于或等于右索引
            //说明已经扫描完毕
            if (l >= r) {
                break;
            }
            //没有满足上面的退出条件
            //将扫描的值 替换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换后 如果左索引扫到的值等于中间值
            if (arr[l] == centre) {
                //右索引前移  相等的话就没必要再比较右边了
                r -= 1;
            }
            if (arr[r] == centre) {
                l += 1;
            }
        }
        //如果左索引等于右索引
        if (l == r) {
            //左索引后移
            l += 1;
            //右索引前移
            r -= 1;
        }
        //
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
