package recrusion;

/**
 * 递归
 * 每用一次 开辟一个栈(每个数据都是独立的)
 * 用空间换时间
 * 先入后出
 * -->当代码运行完毕 或者 return 就会返回 谁调用，就将结果返回给谁
 *     同时当方法执行完毕或者 return时，该方法也就执行完毕了
 */
public class Rescrusion {
    public static void main(String[] args) {
        //tx(4);
        int fal = fal(4);
        System.out.println(fal);
    }

    public static void tx(int n) {
        if (n > 2) {
            tx(n - 1);
        }
        System.out.println(n);
        //栈的先进后出
        //n ==4 放入栈中
        //n ==3 放入栈中
        //n ==2 放入栈中      这个2是没有进入if中的   如果加了else 只会打印 2
        //打印出 2 3 4
    }

    public static int fal(int n) {
        if (n == 1) {
            return 1;
        } else {
            return fal(n - 1) * n;     //(1) * 2 * 3 * 4
        }
        //'.' fal()调用自己 当等于1 的时候 返回给下面
    }
}
