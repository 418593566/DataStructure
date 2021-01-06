package ArrayStack;

import java.util.Stack;

/**
 * 链表栈
 */
public class LinkedListStack {
    public static void main(String[] args) {
        LinkedList lis = new LinkedList();
        StackNode h1 = new StackNode(1,"张飞");
        StackNode h2 = new StackNode(2,"关羽");
        StackNode h3 = new StackNode(3,"刘备");
        lis.push(h1);
        lis.push(h2);
        lis.push(h3);
        lis.show();
        System.out.println(lis.size());
    }
}

class StackNode{
    private StackNode next;
    private int no;
    private String name;

    public StackNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
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

class LinkedList{
    private StackNode head = new StackNode(0,"");

    /**
     * 入栈
     * @param node
     */
    public void push(StackNode node){
        StackNode temp = head;
        while (true){
            if(temp.getNext()==null){
                break;
            }
            temp=temp.getNext();
        }
        temp.setNext(node);
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){

        return 0;
    }

//    public void show(){
//        StackNode temp = head;
//        int size = size();
//        if (head.getNext()==null){
//            System.out.println("栈是空的\n你个棒槌...");
//            return;
//        }
//        for (int i = size; i >= 0; i--) {
//            temp=temp.getNext();
//        }
//        System.out.println(temp);
//    }

    public void show(){
        Stack<Object> stack = new Stack<>();
        StackNode temp = head.getNext();
        while (temp != null) {
            if (head == null) {
                break;
            }
            stack.push(temp);
            temp=temp.getNext();
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public int size(){
        StackNode temp = head.getNext();
        int count=0;
        if (head==null) {
            throw new RuntimeException("栈为空...");
        }
        while (temp!=null){
            if (temp==null) {
                return 0;
            }
            count++;
            temp=temp.getNext();
        }
        return count;
    }
}