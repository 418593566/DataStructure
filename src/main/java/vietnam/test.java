package vietnam;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;

public class test {

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        File file = new File("D:/ip.txt/");
        FileInputStream fis = new FileInputStream(file);
        int leng = fis.available();
        byte[] bytes = new byte[leng];
        fis.read(bytes);
        String str = new String(bytes, Charset.forName("utf-8"));

        String[] split = str.split(" ");

        for (int i = 0; i < split.length; i++) {
            HeroNode node = new HeroNode(split[i]);
            list.add(node);
        }


        list.selectByno("171.211.45.54");
        list.list();
    }
}

/**
 * 节点
 */
class   HeroNode {
    public String ip;
    public HeroNode next;

    public HeroNode(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "ip='" + ip + '\'' +
                '}';
    }
}

/**
 * 链表
 */
class LinkedList {
    private HeroNode head = new HeroNode("");

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

    public void selectByno(String sip){
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp.next==null) {
                return;
            }
            if (temp.ip==sip){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag) {
            System.out.println(temp);
        }else {
            System.out.println("没有找到ip...");
        }
    }
}
