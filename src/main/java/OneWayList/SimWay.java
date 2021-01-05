package OneWayList;

/**
 * 约瑟夫环
 */
public class SimWay {
    public static void main(String[] args) {
        int n = 41;
        int m = 3;
        int k = 1;

        for (int i = 1; i < n; i++) {
            for (int j = (k + m - 1) % n; j < n-1; j++) {
                System.out.println(j);
            }
        }
    }
}
