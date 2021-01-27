package tree;

/**
 * 线索化二叉树
 * 1. 利用二叉链表中的空指针域，存放指向该结点在某
 * 种遍历次序下的前驱和后继结点的指针(线索)
 * 2. n 个节点中含有 2*n - (n-1) = n+1 个空指针域
 * 不同的遍历方式会得到不同的 线索化二叉树   (前序/中序/后序 线索化BinaryTree)
 * 一个结点的前一个结点 "前驱结点"
 * 一个结点的后一个结点 "后继结点"
 * 中序遍历的结果：{8,3,10,1,14,6}
 * 8 的后继结点 3  8 没有前驱结点
 * 3 的前驱结点 8
 * 将空指针域的指针指向该结点的 前驱 或 后继
 */
public class CluesToTheTree {
    public static void main(String[] args) {
        TreadedTree root = new TreadedTree(1, "张飞");
        TreadedTree t2 = new TreadedTree(3, "王五");
        TreadedTree t3 = new TreadedTree(6, "流水");
        TreadedTree t4 = new TreadedTree(8, "古龙");
        TreadedTree t5 = new TreadedTree(10, "青云");
        TreadedTree t6 = new TreadedTree(14, "水墨");
        SimTreadedTree tree = new SimTreadedTree();
        tree.setRoot(root);
        root.setLeft(t2);
        t2.setLeft(t4);
        t2.setRight(t5);

        root.setRight(t3);
        t3.setLeft(t6);
        tree.midOrder();
        System.out.println();

        tree.midTree();
        TreadedTree left = t5.getLeft();
        System.out.println(left);
        TreadedTree right = t5.getRight();
        System.out.println(right);

    }
}


class TreadedTree {
    private int no;
    private String name;
    private TreadedTree left;
    private TreadedTree right;
    /**
     * leftType = 0 表示指针指向左子结点
     * leftType = 1 表示指针指向前驱结点
     */
    private int leftType;
    /**
     * rightType = 0 表示指针指向右子节点
     * rightType = 1 表示指针指向后继结点
     */
    private int rightType;

    public TreadedTree(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreadedTree getLeft() {
        return left;
    }

    public void setLeft(TreadedTree left) {
        this.left = left;
    }

    public TreadedTree getRight() {
        return right;
    }

    public void setRight(TreadedTree right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "TreadedTree{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder() {
        if (this == null) {
            throw new RuntimeException("没有数据...");
        }
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {
        if (this == null) {
            return;
        }
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }
}


class SimTreadedTree {
    private TreadedTree root;
    public TreadedTree pre = null;

    public void setRoot(TreadedTree root) {
        this.root = root;
    }

    public void midTree(){
        this.midTree(root);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            throw new RuntimeException("没有数据...");
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            throw new RuntimeException("没有数据...");
        }
    }

    /**
     * 对二叉树进行中序线索化二叉树
     *      先 处理 左结点
     *      处理当前结点
     *           前驱结点   后继结点
     *      处理右结点
     * @param node 需要线索化的结点
     */
    public void midTree(TreadedTree node) {

        if (node == null) {
            return;
        }
        //左节点 线索化
        midTree(node.getLeft());

        //当前节点 线索化
        //当前的左节点为空
        //处理前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
        }
        //因为是中序  所以第一次左叶子节点的前驱结点为空
        //右递归 顶替了node的位置
        //pre 为空就可以指针指向后继结点
        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //第二次递归  node回退 就是后继结点
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个结点 就 让当前结点是下一个结点的前驱结点
        pre = node;
        //右节点 线索化
        midTree(node.getRight());
    }
}