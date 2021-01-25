package hashtable;

import java.util.Scanner;

public class SimEmp {
    public static void main(String[] args) {
        empHashTable table = new empHashTable(7);
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1.添加" + "\t" + "2.删除" + "\t" + "3.修改" + "\t" + "4.查询" + "\t" + "5.退出");
            int s = sc.nextInt();
            switch (s) {
                case 1:
                    System.out.println("请输入编号:");
                    int s2 = sc.nextInt();
                    System.out.println("请输入名字:");
                    String s1 = sc.next();
                    Emp emp = new Emp(s2, s1);
                    table.add(emp);
                    //table.show();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    table.show();
                    break;
                case 5:
                    sc.close();
                    flag = false;
                    System.err.println("成功退出!!!");
                    break;
            }
        }
    }
}

class Emp {
    public int no;
    public String name;
    public Emp next;
    public int size;

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }
}

class DisposeEmp {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
        }
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    public void update(Emp emp) {
        if (head.next == null) {
            throw new RuntimeException("链表为空...");
        }
        boolean flag = false;
        Emp temp = head.next;
        while (true) {
            if (temp == null) {
                return;
            }
            if (temp.no == emp.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.no = emp.no;
            temp.name = emp.name;
        } else {
            System.out.println("没有找到...");
        }
    }

    public void del(int no) {
        if (head.next == null) {
            throw new RuntimeException("没有数据...");
        }
        Emp temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                return;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到...");
        }
    }

    public void show(int n) {
        if (head == null) {
            throw new RuntimeException("没有数据...");
        }
        System.out.println("第" + (n + 1) + "条链表" + "\t");
        Emp temp = head;
        while (true) {
            System.out.println("编号:" + temp.no + "\t" + "姓名:" + temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
}


class empHashTable {
    private DisposeEmp[] poseEmp;
    public int size;

    public empHashTable(int size) {
        this.size = size;
        poseEmp = new DisposeEmp[size];
        for (int i = 0; i < size; i++) {
            poseEmp[i] = new DisposeEmp();
        }
    }

    public void add(Emp emp) {
        int addEmp = hash(emp.no);
        poseEmp[addEmp].add(emp);
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            poseEmp[i].show(i);
        }
    }

    public void del(int no) {
        poseEmp[no].del(no);
    }

    public int hash(int id) {
        return id % size;
    }
}