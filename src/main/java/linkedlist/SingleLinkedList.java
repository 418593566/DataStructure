package linkedlist;

import java.util.Stack;

/**
 * 单链表
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList2 l = new LinkedList2();
        Node node = new Node(01,"张飞","是的地方");
        Node node2 = new Node(03,"里斯","是的地方");
        Node node3 = new Node(06,"张飞","是的地方");
        Node node4 = new Node(02,"张飞","是的地方");
        Node n5 = new Node(04,"张飞","是的地方");
        Node n6 = new Node(05,"张飞","是的地方");
        Node n7 = new Node(07,"张飞","是的地方");
        Node n8 = new Node(8,"张飞","是的地方");
//        l.addOderby(node);
//        l.addOderby(node2);
//        l.addOderby(node3);
//        l.addOderby(node4);
        l.add(node);
        l.add(node2);
        l.add(node3);
        l.add(node4);
        l.list();
        System.out.println("***************");
        l.delete(2);
        l.delete(1);
        l.list();
//        HeroNode newH = new HeroNode(02,"里斯","士大夫");
//        l.update(newH);
//        System.out.println("修改之后...");
//        l.list();
//        l.delete(03);
//        l.delete(06);
//        l.list();
//
//        System.out.println();
//        System.out.println(l.getLength());
//
//        l.getUnkown(3);
//        System.out.println("********************");
//        rollBack(l.getHead());
//        l.list();
    }

    /**
     * 反转
     */
    public static void rollBack(Node head){
        Node temp = head.next;
        //保存下一个节点
        Node next = null;
        Node repales = new Node(0,"","");
        if (temp.next==null||temp.next.next==null){
            return;
        }
        while (temp!=null){
            next=temp.next;
            //将取出的节点放入repales链表最前端
            temp.next=repales.next;
            //将temp连接到新链表
            repales.next=temp;
            //temp后移
            temp=next;
        }
        head.next=repales.next;
    }
}

/**
 * 节点
 */
class   Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName
                ;
    }
}

/**
 * 链表
 */
class LinkedList2 {
    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    //添加
    public void add(Node hero){
        Node temp = head;
        while(true){
            //找到最后一个
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=hero;
    }

    /**
     * 升序添加
     * @param hero
     */
    public void addOderby(Node hero){
        Node temp = head;
        boolean loop = false;
        while (true){
            if (temp.next==null){
                break;
            }
            //如果节点已存在
            if (temp.next.no==hero.no){
                loop=true;
                break;
            }else if (temp.next.no>hero.no){
                break;
            }
            temp = temp.next;
        }
        if (loop){
            System.out.println("元素已存在...");
        }else {
            hero.next=temp.next;
            temp.next=hero;
        }
    }

    /**
     * 修改
     * @param newHero
     */
    public void update(Node newHero){
        Node temp = head.next;
        boolean loop = false;
        while (true){
            if (temp.next==null){
                return;
            }
            if (temp.no==newHero.no){
                loop=true;
                break;
            }
            temp=temp.next;
        }
        if (loop){
            temp.name=newHero.name;
            temp.nickName=newHero.nickName;
        }else {
            System.out.println("没有找到...");
        }
    }

    /**
     * 删除
     */
    public void delete(int sno){
        Node temp = head;
        boolean loop = false;
        while (true){
            if (temp.next==null){
                return;
            }
            if (temp.next.no==sno){
                loop=true;
                break;
            }
            temp=temp.next;
        }
        if (loop){
            temp.next=temp.next.next;
        }else {
            System.out.println("没有找到节点...");
        }
    }

    //遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空...");
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 反打
     */
    public void show(){
        Stack<Node> stack = new Stack<>();
        Node temp = head.next;
        if (head.next==null){
            return;
        }
        while (temp!=null) {
            stack.add(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 获取节点数
     * @return
     */
    public int getLength(){
        Node temp = head.next;
        int leng = 0;
        while (temp!=null){
            if (temp==null){
                return 0;
            }
            leng++;
            temp=temp.next;
        }
        return leng;
    }

    /**
     * 查找倒算sno节点
     * @param sno
     */
    public void getUnkown(int sno){
        Node temp = head.next;
        int size = getLength();
        if (head.next==null){
            return;
        }
        if (sno<=0||sno>size){
            return;
        }
        for (int i = 0; i < size-sno; i++) {
            temp=temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 根据no查找
     * @param sno
     */
    public void selectByno(int sno){
        Node temp = head.next;
        boolean flag = false;
        while (true){
            if (temp.next==null) {
                return;
            }
            if (temp.no==sno){
               flag=true;
               break;
            }
            temp=temp.next;
        }
        if (flag) {
            System.out.println(temp);
        }else {
            System.out.println("没有找到no...");
        }
    }
}
