import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishDemo {
    public static void main(String[] args) {
        String str = "5 6 + 3 * 3 /";
        List list = getList(str);
        System.out.println(list);
        int count = counter(list);
        System.out.println(count);
    }

    public static List getList(String str) {
        List<String> list = new ArrayList<>();
        String[] s = str.split(" ");
        for (String sc : s) {
            list.add(sc);
        }
        return list;
    }

    public static int counter(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int sum = 0;
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (item.equals("+")) {
                    sum = num1 + num2;
                } else if (item.equals("-")) {
                    sum = num2 - num1;
                } else if (item.equals("*")) {
                    sum = num2 * num1;
                } else if (item.equals("/")) {
                    sum = num2 / num1;
                }
                stack.push(String.valueOf(sum));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
