import java.util.Stack;

public class test4 {
    public static void main(String[] args) {
        Stack<Object> sta = new Stack<>();
        sta.add("张飞");
        sta.add("sda");
        sta.add("we");
        sta.add("xv");

        while (sta.size()>0) {
            System.out.println(sta.pop());
        }
    }
}
