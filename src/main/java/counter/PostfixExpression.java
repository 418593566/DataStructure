package counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算   后缀表达式
 */
public class PostfixExpression {
    public static void main(String[] args) {
//        String res = "3*(4+1)";
//        List suffix = suffix(res);
//        System.out.println(suffix);
//        System.out.println();
//        List lis = getArrLis(suffix);
//        int counter = counter(lis);
//        System.out.println(counter);

//        String res = "3 10 * 5 + 6 - 3 2 - +";
//        List<String> list = getList(res);
        String res = "3*10+5-6+(3-2)";
        List suffix = suffix(res);
        List lis = getArrLis(suffix);
        int counter = counter(lis);
        System.out.println(counter);
    }


    public static List<String> getList(String res) {
        List<String> list = new ArrayList<>();
        String[] s = res.split(" ");
        for (String str : s) {
            list.add(str);
        }
        return list;
    }

    public static List getArrLis(List<String> list) {
        List<String> s2 = new ArrayList<>();
        Stack<String> s1 = new Stack<>();
        //遍历传入的list(存储的是中缀表达式)
        for (String item : list) {
            //如果是数字
            if (item.matches("\\d+")) {
                //添加到集合
                s2.add(item);
                //如果是(
            } else if (item.equals("(")) {
                //放入符号栈
                s1.push(item);
                //如果是)
            } else if (item.equals(")")) {
                //循环找 只要栈顶不是( 就把运算符添加到集合
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //把( pop出  抵消()
                s1.pop();
            } else {
                //循环 运算符栈 只要栈中还有数据 并且 遍历到的运算符的优先级小于或等栈顶的运算符
                //就把栈中数据pop出 放入集合中
                while (s1.size() != 0 && Opertion.getValue(item) <= Opertion.getValue(s1.peek())) {
                    s2.add(s1.pop());
                }
                //则把运算符放入栈中
                s1.push(item);
            }
        }
        //最后比较完后 栈中还有运算符 将运算符放入集合中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
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
        //最后在栈中的就是结果
        return Integer.parseInt(stack.pop());
    }

    public static List suffix(String res) {
        List<String> list = new ArrayList<>();
        //扫描res指针
        int temp = 0;
        //多位数拼接
        String str;
        //字符存储
        char ch = ' ';
        do {
            //如果不是数字
            if ((ch = res.charAt(temp)) < 48 || (ch = res.charAt(temp)) > 57) {
                list.add("" + ch);
                temp++;
            } else {
                str = "";
                while (temp < res.length() && (ch = res.charAt(temp)) >= 48 && (ch = res.charAt(temp)) <= 57) {
                    str += ch;
                    temp++;
                }
                list.add(str);
            }
        } while (temp < res.length());
        return list;
    }


    static class Opertion {
        private static int ADD = 1;
        private static int SCT = 1;
        private static int SUM = 2;
        private static int PVG = 2;

        /**
         * 优先级
         *
         * @param oper
         * @return
         */
        public static int getValue(String oper) {
            int count = 0;
            switch (oper) {
                case "+":
                    count = ADD;
                    break;
                case "-":
                    count = SCT;
                    break;
                case "*":
                    count = SUM;
                    break;
                case "/":
                    count = SUM;
                    break;
            }
            return count;
        }
    }

}

