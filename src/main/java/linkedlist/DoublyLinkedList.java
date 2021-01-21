package linkedlist;

/**
 * 双向链表
 */
public class DoublyLinkedList {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        HeroNode hero = new HeroNode(1,"王五ss","喜喜");
        HeroNode h = new HeroNode(3,"王五ss","喜喜");
        HeroNode h3 = new HeroNode(2,"王五ss","喜喜");
        HeroNode h4 = new HeroNode(7,"王五ss","喜喜");
        l.insert(hero);
        l.insert(h);
        l.insert(h3);
        l.insert(h4);

        l.show();
        System.out.println(l.size());
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nikeName;
    public HeroNode next;
    public HeroNode prev;

    public HeroNode(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}

class LinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加
     * @param hero
     */
    public void add(HeroNode hero){
        HeroNode temp = head;
        while (true) {
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=hero;
        hero.prev=temp;
    }

    public void insert(HeroNode hero){
        HeroNode temp = head;
        boolean falg = false;
        while(true){
            if (temp.next==null) {
                break;
            }
            if (temp.next.no==hero.no) {
                falg=true;
                break;
            } else if (temp.next.no>hero.no) {
                break;
            }
            temp=temp.next;
        }
        if (falg){
            System.out.println("已有重复的节点...");
        }else {
            //找到了比它的节点
            hero.next=temp.next;
            //上一个节点指向新加入的节点
            temp.next=hero;
            hero.prev=temp.prev;
            temp.prev=hero;
        }
    }

    /**
     * 修改
     * @param hero
     */
    public void update(HeroNode hero){
        HeroNode temp = head.next;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空...");
        }
        while (true) {
            if (temp==null) {
                break;
            }
            if (temp.no==hero.no) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag) {
            temp.name=hero.name;
            temp.nikeName=hero.nikeName;
        }else {
            System.out.println("没有找到节点...");
        }
    }

    /**
     * 删除
     * @param sno
     */
    public void delete(int sno){
        //直接下一个
        HeroNode temp = head.next;
        boolean flag = false;
        if (head.next==null){
            System.out.println("链表为空...");
        }
        while (true) {
            if (temp==null){
                break;
            }
            //找到了对应的no
            if (temp.no==sno){
                flag=true;
                break;
            }
            //往下找
            temp=temp.next;
        }
        if (flag) {
            temp.prev.next=temp.next;
            //如果删除的是链表的最后一个
            if (temp.next==null){
                temp=temp.prev;
            }else {
                temp.next.prev = temp.prev;
            }
        }else {
            System.out.println("没有找到...");
        }
    }

    /**
     * 查询
     */
    public void show(){
        HeroNode temp = head.next;
        if (head.next==null) {
            System.out.println("链表为空...");
        }
        while (true) {
            if (temp==null){
                return;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public int size(){
        HeroNode temp = head.next;
        int count = 0;
        while (temp!=null){
            if (temp == null) {
                return 0;
            }
            temp=temp.next;
            count++;
        }
        return count;
    }
}