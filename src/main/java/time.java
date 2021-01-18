import org.junit.Test;

/**
 * 算法时间复杂度
 */
public class time {
    /**
     * 常数介O(1)
     * 无论代码执行多少行 ，只要没有循环等复杂结构
     * 那么这个代码的时间复杂度就是 O(1)
     */
    @Test
    public void test() {
        int i = 1;
        int j = 2;
        ++i;
        j++;
        System.out.println(i + j);
    }

    /**
     * 对数介 O(log_2n)
     * n = i x
     * x:循环次数
     * x = log i n
     * x 译 以 i 为底的n的对数
     * x 速度
     * n 数量
     */
    @Test
    public void test2() {
        int i = 1;
        int n = 1024;
        int count = 0;
        while (i < n) {
            count++;
            i = i * 2;
        }
        //log2n   2的10次幂
        System.out.println(i);
        System.out.println(count);
    }

    /**
     * 线性介O(n)
     * 消耗的时间是随着 n 的变化而变化
     */
    @Test
    public void test3() {
        int j = 0;
        int n = 10;
        for (int i = 0; i <= n; ++i) {
            j = i;
            j++;
        }
        System.out.println(j);
    }

    /**
     * 线性对数介
     * n*O(logN)   O(nlogN)
     */
    @Test
    public void test4() {
        int n = 10;
        int i = 0;
        for (int m = 1; m < n; m++) {
            i = 1;
            while (i < n) {
                i = i * 2;
            }
        }
        System.out.println(i);
    }

    /**
     * 平方介O(n^2)
     */
    @Test
    public void test5() {
        int n = 100;
        int x = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
               // x = n;
                x++;
            }
        }
        System.out.println(x);
    }
}
