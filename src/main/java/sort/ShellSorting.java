package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序   交换法   移动法    对插入的改进
 * 把数组arr[].length/2  分组进行插入排序 每组两个数据
 * arr[].length/2的结果/2分租 进行插入排序
 * 直至分为一组  进行简单的插入排序
 */
public class ShellSorting {
    public static void main(String[] args) {
        //int[] arr = new int[]{9, 8, 1, 0, 3, 5, 2};

        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        ShellSorting ss = new ShellSorting();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间:" + sf.format(date));
        ss.shellSort2(arr);
        Date d2 = new Date();
        System.err.println("结束:" + sf.format(d2));
    }

    //交换法
    public void shellSort(int[] arr) {
        int temp = 0;

        //   gap = arr.length / 2 ：分组
        //'.'分到最后是1组  .'.gap > 0
        //'.' 每次都是分2组 .'.gap /= 2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //将数据  分成gap(5)组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中的数据(5组，每组2个数据)
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //移动法
    public void shellSort2(int[] arr) {
        //分次都分两组 分到最后为一组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历每组的元素 进行插入
            for (int i = gap; i < arr.length; i++) {
                //保存待插入的下标
                int j = i;
                //记录要插入的数
                int temp = arr[j];
                //找到待插入的位置
                //arr[j] 后一个元素   arr[5]
                //arr[j - gap] 当前元素  arr[0]
                if (arr[j] < arr[j - gap]) {
                    //j - gap >= 0  还可以继续找位置
                    //如果当前数字小于前一个数字，即arr[5]<arr[0],则while循环，条件为，preIndex>=0且arr[5]<arr[0]满足，
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        //则把下标为preIndex的元素的下一个元素，即下标为preIndex+5对应元素的值赋值为下标为preIndex的元素对应的值，arr[5]=arr[0]
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //while结束后 找到插入位置
                    arr[j] = temp;
                }
            }
        }
    }
}
