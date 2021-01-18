package sort;

import java.util.Arrays;

/**
 * 插入排序
 *     将数组arr[0]当作有序数组
 *     再扫描 arr[i+1] ...arr[n-1]
 *     插入到有序
 */
public class insertSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{22,11,56,44,1};
        insertSorting isg = new insertSorting();
        isg.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //值
            int minValue = arr[i];
            //值的前一个下标
            int minIndex = i - 1;
            //条件
            //   minIndex >= 0  前一个有序 小于等于0
            //   arr[minIndex] > minValue  有序的值 相比较 无序的值
            while (minIndex >= 0 && arr[minIndex] > minValue) {
                //把被比较的后一个值 = 比较
                arr[minIndex+1] = arr[minIndex];
                //如果被比较的值 前面还有值 再进行比较
                //直到 满足退出while的条件
                //arr[0]
                minIndex--;
            }
            //while结束 说明插入的位置找到了
            //给arr[0] = 比较后小的值
            arr[minIndex+1] = minValue;
        }
    }
}
