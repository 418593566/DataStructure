package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class Search {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 5, 5, 5, 33, 44, 8000, 9451};
        int index = binarySim(arrs, 0, arrs.length - 1, 8111);
        System.out.printf("arrs[%d]", index);
//        List list = binary(arrs, 0, arrs.length - 1, 6);
//        System.out.println(list);
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
        int mai = (left + right) / 2;
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
