import java.util.Arrays;

public class demo3 {
    public static void main(String[] args) {
        int[] arr = new int[]{123, 333, 2341, 5, 231, 53,-1};
        //bubbleSreach(arr);
        selectSreach(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void bubbleSreach(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * 选择
     * @param arr
     */
    public static void selectSreach(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = 0 + i; k < arr.length; k++) {
                if (arr[i] > arr[k]) {
                    temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }
    }

    /**
     * 插入
     * @param arr
     */
    public static void insertSreach(int[] arr){

    }
}
