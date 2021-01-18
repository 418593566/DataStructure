package sort;

import java.util.Arrays;

/**
 * 希尔排序   交换法   移动法
 * 把数组arr[].length/2  分组进行插入排序 每组两个数据
 * arr[].length/2的结果/2分租 进行插入排序
 * 直至分为一组  进行简单的插入排序
 */
public class ShellSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 1, 0, 3, 6, 4, 2, 7, 5,2};
        ShellSorting ss = new ShellSorting();
        ss.shellSort(arr);
        System.out.println(Arrays.toString(arr));
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
    public void shellSort2(int[] arr){
            
    }
}
