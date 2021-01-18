package recrusion;

public class Queue {
    int maxSize = 8;
    int[] arr = new int[maxSize];
    static int count = 0;

    public static void main(String[] args) {
        Queue sk = new Queue();
        sk.sim(0);
        System.err.println("有'" + count + "'种解法...");
    }

    /**
     * 放入皇后
     *
     * @param n 从第n个皇后开始放入
     */
    public void sim(int n) {
        //当n(皇后) == 8 表示皇后放完了
        if (n == maxSize) {
            show();
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            //先把这个皇后 放入 这个列
            //n : x
            //i : y
            //将下标 负值 i
            arr[n] = i;
            //判断是否冲突
            if (logic(n)) {
                sim(n + 1);
            }
            //冲突的话  继续for循环 i++ 就是往后移一个位置(y+1)
        }
    }

    /**
     * x = n, y = n+1
     *
     * @param n 第几个皇后    从0开始  n+1
     * @return
     */
    public boolean logic(int n) {
        for (int i = 0; i < n; i++) {
            //arr[n] == arr[i]   arr[i]是 上一个
            // 列是否相等
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i])
            //  -->Math.abs(n - i) : x 坐标 的差
            //     Math.abs(arr[n] - arr[i]) : y 坐标 的差
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i])
            //'.'：n = 2 ; i = 0
            //.'.：arr[n] = 3；arr[i] = 1
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void show() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + 1 + "\t");
        }
        System.out.println();
    }
}
