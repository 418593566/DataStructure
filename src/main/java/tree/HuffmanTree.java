package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 * 权值越大的结点离根节点越近的二叉树才是最优二叉树
 * 从根节点到该结点之间的路径长度与该结点的权的乘积
 * WPL最小的就是赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,10,11,15};
        Node node = callHunffman(arr);
        preOrder(node);
    }

    public static void preOrder(Node root){
        if (root!=null){
            root.preTree();
        }else {
            throw new  RuntimeException("没有数据...");
        }
    }

    public static Node callHunffman(int[] arr) {
        //将数列构建成node对象 一个一个的放入集合中
        List<Node> list = new ArrayList();
        for (int ar : arr) {
            list.add(new Node(ar));
        }
        //重复操作 至只有一个元素
        while (list.size() > 1) {
            //从小到大排序
            Collections.sort(list);
            //取出前两个最小的
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            //创建新树
            Node paren = new Node(leftNode.value + rightNode.value);
            paren.left = leftNode;
            paren.right = rightNode;
            //删除原集合中的数据
            list.remove(leftNode);
            list.remove(rightNode);
            //将创建的新树 添加至集合
            list.add(paren);
        }
        //最后返回头节点  因为最后合成为一颗树
        return list.get(0);
    }
}


class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * @param o
     * @return 当此对象返回负数、零、整数
     * 就表示对象 小于、等于或大于指定对象时
     */
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preTree() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preTree();
        }
        if (this.right != null) {
            this.right.preTree();
        }
    }
}