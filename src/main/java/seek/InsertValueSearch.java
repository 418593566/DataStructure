package seek;

/**
 * 插值查找
 * 自适应 (中间值)mid
 * mid : left + (right - left) * (fanValue - arr[left]) / (arr[right] - arr[left])
 */
public class InsertValueSearch {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int values = getValues(arr, 0, arr.length - 1, 16);
        System.err.println("寻找次数:" + count);
        System.out.println("index:" + values);
    }

    public static int getValues(int[] arr, int left, int right, int fanValue) {
        count++;
        if (left > right || fanValue < arr[left] || fanValue > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * (fanValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (fanValue > midValue) {
            return getValues(arr, mid + 1, right, fanValue);
        } else if (fanValue < midValue) {
            return getValues(arr, left, mid - 1, fanValue);
        } else {
            return mid;
        }
    }
}
