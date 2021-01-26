package tree;

/**
 * Tree 前中后序遍历
 */
public class BinaryTree {
    public static void main(String[] args) {
        SimBinary binary = new SimBinary();
        HeroNode root = new HeroNode(1, "路飞");
        HeroNode node = new HeroNode(2, "索隆");
        HeroNode node2 = new HeroNode(3, "山治");
        HeroNode node3 = new HeroNode(4, "艾斯");
        HeroNode node4 = new HeroNode(5, "乔巴");
        HeroNode node5 = new HeroNode(6, "乌索普");
        HeroNode node6 = new HeroNode(7, "萨博");
        binary.setRoot(root);

        root.setLeft(node);
        node.setLeft(node3);
        node.setRight(node4);

        root.setRight(node2);
        node2.setLeft(node5);
        node2.setRight(node6);

        System.out.println("前序遍历");
        binary.preOrder();
        System.out.println("中序遍历");
        binary.midOrder();
        System.out.println("后序遍历");
        binary.postOrder();
        System.out.println("*********************************");
        HeroNode node1 = binary.preSreach(2);
        System.out.println("前序查找:" + "\n" + node1);

        HeroNode node7 = binary.midSreach(5);
        System.out.println("中序查找:" + "\n" + node7);

        HeroNode node8 = binary.postSreach(4);
        System.out.println("后序查找:" + "\n" + node8);

        HeroNode node9 = new HeroNode(4, "娜美");
        binary.preUpdate(node9);

        System.out.println();
        HeroNode n = binary.postSreach(4);
        System.out.println("修改后" + "\n" + n);

        System.out.println();
        binary.preDel(5);
        binary.postOrder();

    }
}


class SimBinary {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("没有数据...");
        }
    }

    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("没有数据...");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            throw new RuntimeException("没有数据...");
        }
    }

    public HeroNode preSreach(int no) {
        if (this.root != null) {
            return this.root.preSreach(no);
        }
        return null;
    }

    public HeroNode midSreach(int no) {
        if (this.root != null) {
            return this.root.midSreach(no);
        }
        return null;
    }

    public HeroNode postSreach(int no) {
        if (this.root != null) {
            return this.root.postSreach(no);
        }
        return null;
    }

    public void preUpdate(HeroNode node) {
        if (this.root != null) {
            this.root.preUpdata(node);
        } else {
            System.out.println("没有数据...");
        }
    }

    /**
     * 删除
     * @param no
     */
    public void preDel(int no) {
        //先判断要删除的是否是根结点
        if (this.root!=null){
            if (this.root.getNo()==no) {
                this.root = null;
            }else {
                this.root.preDel(no);
            }
        }else {
            System.out.println("没有找到...");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //前序   中左右
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序 左中右
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序  左右中
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找  中左右
    public HeroNode preSreach(int no) {
        //如果当前根节点的no==no
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        //先要判断左节点不为空
        //递归结束条件 为空
        if (this.left != null) {
            //以左节点为根 递归
            res = this.left.preSreach(no);
        }
        //结束后 res 的值不为空 说明 找到了
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preSreach(no);
        }
        return res;
    }

    /**
     * 中序查找  左中右
     *
     * @param no
     * @return
     */
    public HeroNode midSreach(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.midSreach(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.midSreach(no);
        }
        return res;
    }

    /**
     * 后序查找   左右中
     *
     * @param no
     * @return 找到的值
     */
    public HeroNode postSreach(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.postSreach(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postSreach(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }

    //前
    public void preUpdata(HeroNode node) {
        if (this.no == node.no) {
            this.setNo(node.no);
            this.setName(node.name);
        }
        if (this.left != null) {
            this.left.preUpdata(node);
            if (this.left.no == node.no) {
                this.left.setNo(node.no);
                this.left.setName(node.name);
            }
        }
        if (this.right != null) {
            this.right.preUpdata(node);
            if (this.right.no == node.no) {
                this.right.setNo(node.no);
                this.right.setName(node.name);
            }
        }
    }

    /**
     * 删除
     *      先判断左节点是否是要删除的结点
     *          找到了 就将结点置空  this.left = null;
     *          如果不是 以左结点为根 进行递归 查询要删除的结点
     *          未果
     *      再判断右结点是否是要删除的结点
     *          找到了 就将结点置空 this.right = null;
     *          如果不是 以右节点为根 进行递归 查询要删除的结点
     *      都没有找到那就说明 BinaryTree中没有该结点
     * @param no
     */
    public void preDel(int no) {
        //如果当前结点的左节点，不为空，并且就是要找的
        boolean flag = false;
        boolean flax = false;
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }else {   //如果不是左结点 就直接递归左子结点
            flag = true;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }else {
            flax = true;
        }
        //如果前面没有删除就要进行递归删除
        if (flag) {
            if (this.left != null) {
                this.left.preDel(no);
            }
        }
        if (flax) {
            if (this.right != null) {
                this.right.preDel(no);
            }
        }
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}