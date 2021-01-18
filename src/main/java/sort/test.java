package sort;

import org.junit.Test;

import java.util.Arrays;

public class test {
    @Test
    public void test1() {
        int[] arr = new int[]{1, 5, 44, -8, 33, 51};

        int minValue = 0;
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            minIndex = i - 1;
            minValue = arr[i];

            while (minIndex >= 0 && minValue < arr[minIndex]) {
                arr[minIndex + 1] = arr[minIndex];
                minIndex--;
            }
            arr[minIndex + 1] = minValue;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 5, 44, -8, 33, 51};

        int minValue = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = minValue;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        int[] arr = new int[]{1, 5, 44, -8, 33, 51};
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
