import java.util.Stack;

public class test4 {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.add("sdf");
        stack.add("sss");
        stack.add("aaa");
        stack.push("sdfdddd");
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
