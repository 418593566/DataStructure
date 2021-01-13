package LinkedList;

import java.util.Stack;

/**
 * 单链表
 */
public class SimLinked {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        HeroNode node = new HeroNode(01,"张飞","是的地方");
        HeroNode node2 = new HeroNode(03,"里斯","是的地方");
        HeroNode node3 = new HeroNode(06,"张飞","是的地方");
        HeroNode node4 = new HeroNode(02,"张飞","是的地方");
        HeroNode n5 = new HeroNode(04,"张飞","是的地方");
        HeroNode n6 = new HeroNode(05,"张飞","是的地方");
        HeroNode n7 = new HeroNode(07,"张飞","是的地方");
        HeroNode n8 = new HeroNode(8,"张飞","是的地方");
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
    public static void rollBack(HeroNode head){
        HeroNode temp = head.next;
        //保存下一个节点
        HeroNode next = null;
        HeroNode repales = new HeroNode(0,"","");
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
class   HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName
                ;
    }
}

/**
 * 链表
 */
class LinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加
    public void add(HeroNode hero){
        HeroNode temp = head;
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
    public void addOderby(HeroNode hero){
        HeroNode temp = head;
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
    public void update(HeroNode newHero){
        HeroNode temp = head.next;
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
        HeroNode temp = head;
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
        HeroNode temp = head.next;
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
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
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
        HeroNode temp = head.next;
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
        HeroNode temp = head.next;
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
        HeroNode temp = head.next;
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
