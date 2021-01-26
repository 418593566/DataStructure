package tree;

/**
 * 顺序存储二叉树
 * n 表示二叉树的第几个元素 (从零开始)
 * 特点: 第 n 个元素的左子节点为 2*n+1
 * 第 n 个元素的右子节点为 2*n+2
 * 第 n 个元素的父节点为 (n-1)/2
 */
public class ArrBinarySreach {
    public static void main(String[] args) {
        int[] arrs = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrBinary arr = new ArrBinary(arrs);
        //arr.preSreach();
        //arr.midSreach(0);
        arr.postSreach(0);
    }
}

class ArrBinary {
    private int[] arr;

    public ArrBinary(int[] arr) {
        this.arr = arr;
    }

    public void preSreach() {
        this.preSreach(0);
    }

    /**
     * 前序
     *
     * @param index 下标
     */
    public void preSreach(int index) {

        if (arr == null && arr.length < 0) {
            System.out.println("没有数据...");
            return;
        }
        System.out.print(arr[index] + "\t");
        //向左递归遍历
        //左节点的下标 小于 数组的大小
        if ((2 * index + 1) < arr.length) {
            preSreach((2 * index + 1));
        }
        //向右递归遍历
        if ((2 * index + 2) < arr.length) {
            preSreach((2 * index + 2));
        }
    }

    /**
     * 中序
     *
     * @param index
     */
    public void midSreach(int index) {
        if (arr == null && arr.length < 0) {
            System.out.println("没有数据...");
            return;
        }
        if ((2 * index + 1) < arr.length) {
            midSreach((2 * index + 1));
        }
        System.out.print(arr[index] + "\t");
        if ((2 * index + 2) < arr.length) {
            midSreach((2 * index + 2));
        }
    }

    /**
     * 后
     */
    public void postSreach(int index) {
        if (arr == null && arr.length < 0) {
            throw new RuntimeException("没有数据...");
        }
        if ((2 * index + 1 < arr.length)) {
            postSreach((2 * index + 1));
        }
        if ((2 * index + 2) < arr.length) {
            postSreach((2 * index + 2));
        }
        System.out.print(arr[index] + "\t");
    }
}

