package recrusion;

public class test2 {
    int max = 8;
    int[] arr = new int[max];

    public static void main(String[] args) {
        test2 t2 = new test2();
        t2.ck(0);
    }


    public void ck(int n) {
        if (n == max) {
            show();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (sim(n)){
                ck(n+1);
            }
        }
    }

    public boolean sim(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void show() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+1 + "\t");
        }
        System.out.println();
    }
}
