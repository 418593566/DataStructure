public class test6 {
    public static void main(String[] args) {
        SimThod s = new SimThod();
        HeroNode h1 = new HeroNode(1,"张飞");
        HeroNode h2 = new HeroNode(2,"关羽");
        s.add(h1);
        s.add(h2);
        s.show();
        System.out.println(s.size());
    }
}


class HeroNode{
    private HeroNode next;
    private int no;
    private String name;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

class SimThod{
    private HeroNode head = new HeroNode(0,"");

    public void add(HeroNode hero){
        HeroNode temp = head;
        while (true){
            if (temp.getNext()==null){
                break;
            }
            temp=temp.getNext();
        }
        temp.setNext(hero);
    }

    public void show(){
        HeroNode temp = head.getNext();
        if (head==null) {
            System.out.println("链表为空...");
            return;
        }
        while (true) {
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.getNext();
        }
    }

    public int size(){
        HeroNode temp = head.getNext();
        if (head.getNext() == null) {
            throw new RuntimeException("链表为空...");
        }
        int count=0;
        while (temp!=null){
            if (temp==null){
                break;
            }
            count++;
            temp=temp.getNext();
        }
        return count;
    }
}