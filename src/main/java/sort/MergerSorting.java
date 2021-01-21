package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序  (分 治)
 * 分：把数组分为一个一个的
 * 治：合并  两边都是有序的
 * 合并的次数是arer.length-1次  没合并一次就copy到arr
 */
public class MergerSorting {
    public static void main(String[] args) {
        //int[] arr = new int[]{22,54,8,9,54,0,15,2};
        int[] arr = new int[100000000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100000000);
        }
        MergerSorting mst = new MergerSorting();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
        mst.partSort(arr,0,arr.length-1,temp);
        Date date1 = new Date();
        System.err.println("结束时间："+format.format(date1));
    }

    /**
     * 分阶段
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public void partSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左分离
            partSort(arr, left, mid, temp);
            //向右分离
            partSort(arr, mid + 1, right, temp);
            mergeSort(arr, left, right, mid, temp);
        }
    }

    /**
     * 治阶段
     * 合并最后一次就将temp copy到arr
     *
     * @param arr   原始数组
     * @param left  左索引
     * @param right 右索引
     * @param mid   中间索引
     * @param temp  暂存放数据的数组
     */
    public void mergeSort(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;   //temp[]的索引
        //将数据存放如temp
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //将剩余的数据依次添加到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //将temp copy到arr
        //不是一次性copy arr.length个
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
