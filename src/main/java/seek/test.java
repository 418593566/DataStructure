package seek;

import org.junit.Test;

public class test {
    @Test
    public void t1() {
        int left = 0;
        int right = 5;
        if (left + (right - left) * 1 / 2 == (left + right) / 2) {
            System.out.println(true);
        }

        System.out.println(594 / 18);
    }

    @Test
    public void t2() {
        int[] arrs = new int[]{1, 5, 5, 5, 33, 44, 55, 66, 77, 78, 89, 90, 91, 92, 93, 94, 95};
        int left = 0;
        int right = arrs.length - 1;
        int fanValue = 77;
        int mid = left + (right - left) * (fanValue - arrs[left]) / (arrs[right] - arrs[left]);
        System.out.println(mid);
    }
}
