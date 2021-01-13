package ArrayStack;


import java.util.Stack;

/**
 * 链表栈
 */
public class LinkedListStack {
    public static void main(String[] args) {
        LinkedList lis = new LinkedList();
        StackNode h1 = new StackNode(1, "张飞");
        StackNode h2 = new StackNode(2, "关羽");
        StackNode h3 = new StackNode(3, "刘备");
        lis.push(h1);
        lis.push(h2);
        lis.push(h3);
        lis.show();
        System.out.println("******************");
        int p = lis.pop();
        System.out.println(p);
        lis.pop();
        lis.show();
        System.out.println(lis.size());
    }
}

class StackNode {
    public StackNode next;
    public StackNode prev;
    private int no;
    private String name;

    public StackNode(int no, String name) {
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

    @Override
    public String toString() {
        return "StackNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

class LinkedList {
    private StackNode head = new StackNode(0, "");

    /**
     * 入栈
     *
     * @param node
     */
    public void push(StackNode node) {
        StackNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next=node;
        node.prev=temp;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        StackNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp.next==null){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next.prev=temp.prev;
            if (temp.prev==head){
                System.out.println("哈哈哈");
                return 0;
            }
        }

        return temp.getNo();
    }

    public void show() {
        Stack<Object> stack = new Stack<>();
        StackNode temp = head.next;
        while (temp != null) {
            if (head == null) {
                break;
            }
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public int size() {
        StackNode temp = head.next;
        int count = 0;
        if (head == null) {
            throw new RuntimeException("栈为空...");
        }
        while (temp != null) {
            if (temp == null) {
                return 0;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }
}