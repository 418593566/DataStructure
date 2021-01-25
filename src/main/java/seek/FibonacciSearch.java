package seek;

import java.util.Arrays;

/**
 * 斐波那契查找法   使mid在黄金分割点附近查找
 * 斐波那契数列：就是相邻的两个数相加是下一个
 * 1,1,2,3,5,8,13,21,34,55
 * 相邻的前数/后数 会越来越接近0.618
 * 公式：mid = low+F(K-1)-1
 */
public class FibonacciSearch {
    static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 12, 34, 555, 3454, 4526, 9090};
        int i = fibSearch(arr, 555);
        System.out.println(i);
    }

    /**
     * 创建斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 编写斐波那契查找算法
     *
     * @param arr     原始数据
     * @param fanVale 要找的值
     * @return 下标
     */
    public static int fibSearch(int[] arr, int fanVale) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        //斐波那契分割点的下标
        int k = 0;
        //斐波那契数列
        int f[] = fib();
        //获取k的值
        while (right > f[k] - 1) {
            k++;
        }
        //f[k] : 斐波那契数列的下标
        //因为f[k]值可能大于arr的长度,因此我们需要使用一个新的数组指向arr[]
        int[] temp = Arrays.copyOf(arr, f[k]);
        //位数填充
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        //满足这个条件就可以继续找
        //找到我们的数value
        while (left <= right) {
            mid = left + f[k - 1] - 1;
            //向数组左查找
            if (fanVale < temp[mid]) {
                right = mid - 1;
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 因为前面有f[k-1]个元素，所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                // 即在f[k - 1]的前面继续查找
                // 即下次循环mid = low + f[k-1-1]-1
                k--;
                //向数组右边查找
            } else if (fanVale > temp[mid]) {
                left = mid + 1;
                //
                k -= 2;
            } else {
                if (mid <= right){
                    return mid;
                }else {
                    return right;
                }
            }
        }
        return -1;
    }
}
