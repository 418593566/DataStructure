package seek;

/**
 * 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2,545,56,4,5};
        int s = search(arr, 56);
        if (s == -1) {
            System.out.println("没有找到...");
        }else {
            System.err.println("arrIndex:"+s);
        }
    }

    public static int search(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
