package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 堆排序 O(nlogn)
 * 完全二叉树
 * 大顶堆：每个结点的值都大于或等于其左右子结点的值
 * arr[i]>=arr[2*i+1] && arr[i]>=arr[2*i+2]
 * i对应第几个结点，i从0开始
 * 小顶堆：每个结点的值都小于或等于其左右子结点的值
 * arr[i]<=arr[2*i+1] && arr[i]<=arr[2*i+2]
 * <p>
 * 1.将无序序列建成一个(小/大)顶堆
 * 2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
 * 3.重新调整结构，十七满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整
 * 交换步骤，直到整个序列有序
 * <p>
 * 数组arr{4,23,3,44,5,6}
 * 对应的下标 0 , 1 , 2 ,3 , 4 , 5
 * 对应完全二叉树 列出
 * 找最后一个非叶子节点 当前结点与左右子节点比较 大的与当前结点交换
 * 找第二个非叶子结点  重复上面的步骤
 * 堆顶元素与末尾元素(下标5)交换
 */
public class HeapSorting {
    public static void main(String[] args) {
        //int[] arr = new int[]{4, 8, 5, 9, 2};
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =(int)(Math.random()*8000000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("开始时间"+format.format(date));
        heapSort(arr);
        Date d2 = new Date();
        System.out.println("结束时间"+format.format(d2));
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        //建立成大顶堆
        for (int i = arr.length / 2 -1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length-1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            /**
             * 栈顶元素与 末尾元素交换
             */
            adjustHeap(arr,0,j);
        }
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param i      非叶子节点下标索引
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            /**
             * arr[k + 1]   右子节点
             * arr[k]       左子节点
             * 如果左子节点 小于 右子节点
             * 指向右子节点
             */
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            /**
             * 如果 子节点 大于 根结点
             * 将较大的值 赋个 根结点
             * 继续循环比较
             */
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
            arr[i] = temp;
        }
    }
}
