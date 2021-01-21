package linkedlist;

/**
 * 约瑟夫环
 */
public class JosephRing {
    public static void main(String[] args) {
        OneWayLinkedList one = new OneWayLinkedList();
        one.add(7);
        one.count(1, 3, 7);

    }
}

class Node2 {
    private int no;
    private Node2 next;

    public Node2(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}

class OneWayLinkedList {
    private Node2 first = null;

    /**
     * 添加
     *
     * @param nums 节点数
     */
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("输入有误...");
            return;
        }
        Node2 temp = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Node2 node = new Node2(i);
            //如果是第一个节点
            if (i == 1) {
                first = node;
                //第一个的next指向自己 成一个环形
                first.setNext(first);
                //因为first不能动 需要一个指针
                temp = first;
            } else {
                //指针指向下一个节点
                temp.setNext(node);
                //进来的node指向第一个node 成环形
                node.setNext(first);
                //指针位置调至进来的node 好指向下一个node
                temp = node;
            }
        }
    }

    /**
     * 打印
     */
    public void show() {
        if (first == null) {
            System.out.println("链表为空...");
            return;
        }
        Node2 temp = first;
        while (true) {
            System.out.printf("节点\t%d\n", temp.getNo());
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * @param start     从第几个开始
     * @param countNums 每次几下
     * @param nums      总共多少
     */
    public void count(int start, int countNums, int nums) {
        if (start > nums || first == null || start < 1) {
            System.out.println("输入有误...");
            return;
        }
        Node2 temp = first;
        //让temp指针指向最后节点
        while (true) {
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }

        //开始前先让指针指向k-1
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            temp = temp.getNext();
        }

        while (true) {
            //只有剩下一个
            if (temp == first) {
                break;
            }
            //每次移动m-1
            for (int i = 0; i < countNums - 1; i++) {
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.printf("杀死%d号\n", first.getNo());
            first = first.getNext();
            temp.setNext(first);
        }
        System.out.println(first.getNo() + "号" + "\t活着");
    }
}