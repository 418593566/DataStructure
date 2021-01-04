package gatherMethod;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test2 {
    @Test
    public void t1(){
        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bb");
        list.add("cc");
        list.add("ss");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void t2(){
        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bb");
        list.add("cc");
        list.add("ss");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void t3(){
        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bb");
        list.add("cc");
        list.add("ss");

        for (Object ob:list) {
            System.out.println(ob);
        }
    }

}
