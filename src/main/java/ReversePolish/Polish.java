package ReversePolish;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算   后缀表达式
 */
public class Polish {
    public static void main(String[] args) {
        String res = "(10+((2+2)*4)-5)/4";
        List suffix = suffix(res);
        System.out.println(suffix);
    }


    public static List<String> getList(String res) {
        List<String> list = new ArrayList<>();
        String[] s = res.split(" ");
        for (String str : s) {
            list.add(str);
        }
        return list;
    }

    /**
     * 运算
     *
     * @param lis 传入表达式的集合
     * @return 返回栈中结果
     */
    public static int counter(List<String> lis) {
        Stack<String> stack = new Stack<String>();
        for (String item : lis) {
            //检测字符串是否匹配给定的正则表达式
            if (item.matches("\\d+")) {
                //是数字 放入栈中
                stack.push(item);
            } else {
                //pop出两个数字来进行运算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int sum = 0;
                if (item.equals("+")) {
                    sum = num1 + num2;
                } else if (item.equals("-")) {
                    sum = num2 - num1;
                } else if (item.equals("*")) {
                    sum = num1 * num2;
                } else if (item.equals("/")) {
                    sum = num2 / num1;
                } else {
                    throw new RuntimeException("表达式有误...");
                }
                //计算结果放入栈中
                stack.push(String.valueOf(sum));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List suffix(String res) {
        List<String> list = new ArrayList<>();
        //扫描res指针
        int temp = 0;
        //多位数拼接
        String str ;
        //字符存储
        char ch = ' ';
        do {
            //如果不是数字
            if ((ch = res.charAt(temp)) < 48 || (ch = res.charAt(temp)) > 57) {
                list.add(""+ch);
                temp++;
            }else {
                str = "";
                while (temp<res.length() && (ch=res.charAt(temp))>=48 && (ch=res.charAt(temp))<=57) {
                    str+=ch;
                    temp++;
                }
                list.add(str);
            }
        } while (temp < res.length());
        return list;
    }
}
