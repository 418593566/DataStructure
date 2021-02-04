package seek;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找  前提是要数组有序
 * 找到数组的中间值
 * 比较要找的值是大是小
 * 如果fanValue < midValue
 * left:0 ; right:midValue的下标-1
 * 递归查找
 * 反之fanValue > midValue
 * left:midValue的下标+1 ; right:数组长度-1
 * 递归查找
 * fanValue == arr[mid] 找到了
 * 如果 left > right 没有找到
 * 公式：mid = (left+right)/2 = left+(right-left)*1/2
 */
public class BinarySearch {
    static int count = 0;

    public static void main(String[] args) {
        int[] arrs = new int[]{1, 5, 5, 5, 33, 44, 55, 66, 77, 78, 89, 90, 91, 92, 93, 94, 95, 8000, 9451};
        //int index = binarySim(arrs, 0, arrs.length - 1, 44);
        // System.out.printf("arrs[%d]", index);
        List list = binary(arrs, 0, arrs.length - 1, 33);
        System.out.println(count);
        System.out.println(list);
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int mid = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < mid) {
                l += 1;
            }
            while (arr[r] > mid) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[r] == mid) {
                l += 1;
            }
            if (arr[l] == mid) {
                r -= 1;
            }
        }
        if (l == r) {
            r -= 1;
            l += 1;
        }
        if (left < r) {
            sort(arr, left, r);
        }
        if (right > l) {
            sort(arr, l, right);
        }
    }

    public static int binarySim(int[] arrs, int left, int right, int finalValue) {
        //获取中间值的下标
        int mai = (left + right) / 2;
        //获取中间值
        int maiValue = arrs[mai];

        if (left > right) {
            return 0;
        }
        //如果要查找的值大于中间值
        //向右递归
        if (finalValue > maiValue) {
            return binarySim(arrs, mai + 1, right, finalValue);
        } else if (finalValue < maiValue) {
            return binarySim(arrs, left, mai - 1, finalValue);
        } else {
            return mai;
        }
    }

    public static List binary(int[] arrs, int left, int right, int resVal) {
        count++;
        //int mai = (left + right) / 2;
        int mai = left + (right - left) * 1 / 2;
        //int mai = left+(right-left)*(resVal-arrs[left])/(arrs[right]-arrs[left]);
        int malVal = arrs[mai];

        if (left > right) {
            return new ArrayList<>();
        }

        if (resVal > malVal) {
            return binary(arrs, mai + 1, right, resVal);
        } else if (resVal < malVal) {
            return binary(arrs, left, mai - 1, resVal);
        } else {
            ArrayList<Integer> resIndex = new ArrayList<Integer>();
            //向左扫描
            //right
            int temp = mai - 1;
            while (true) {
                //如果temp 小于 0 或者 没找到resVal 扫描完了
                if (temp < 0 || arrs[temp] != resVal) {
                    break;
                }
                resIndex.add(temp);
                temp -= 1;
            }
            resIndex.add(mai);

            //向右扫描
            temp = mai + 1;
            while (true) {
                if (temp > arrs.length - 1 || arrs[temp] != resVal) {
                    break;
                }
                resIndex.add(temp);
                temp += 1;
            }
            return resIndex;
        }
    }
}
