package counter;

/**
 * 中缀表达式
 */
public class CounterTest {
    public static void main(String[] args) {
        //存储数字
        StackPeek numStack = new StackPeek(10);
        //存储运算符
        StackPeek operStack = new StackPeek(10);
        String expression = "7*8-1+5";
        int num1 = 0;
        int num2 = 0;
        //运算符
        int oper = 0;
        //运算结果
        int sum = 0;
        //扫描表达式
        int index = 0;
        char ch = ' ';

        while (true) {
            //从index到index+1 取出
            ch = expression.substring(index, index + 1).charAt(0);

            //如果是运算符
            if (operStack.isOper(ch)) {
                //如果oper栈不是空
                if (!operStack.isEmpty()) {
                    //如果当前的运算符的优先级小于或等于 栈中的运算符
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        sum = numStack.operation(num1, num2, oper);

                        numStack.push(sum);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //是char 根据ascll码
                numStack.push(ch - 48);
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            sum = numStack.operation(num1, num2, oper);
            numStack.push(sum);
        }
        System.out.printf("%s=%d",expression,numStack.pop());
    }
}


class StackPeek {
    private int top = -1;
    private int maxSize;
    private int[] arr;

    public StackPeek(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        return arr[top];
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满...");
            return;
        }
        top++;
        arr[top] = value;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈是空的...");
        }
        int value = arr[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈是空的...");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 运算优先级
     *
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 是否是运算符
     *
     * @param vr
     * @return
     */
    public boolean isOper(char vr) {
        return vr == '*' || vr == '/' || vr == '+' || vr == '-';
    }

    /**
     * 运算
     *
     * @param num1 先pop出的数
     * @param num2 后pop出的数
     * @param oper
     * @return
     */
    public int operation(int num1, int num2, int oper) {
        int sum = 0;
        switch (oper) {
            case '*':
                sum = num1 * num2;
                break;
            case '/':
                sum = num2 / num1;
                break;
            case '+':
                sum = num1 + num2;
                break;
            case '-':
                sum = num2 - num1;
                break;
        }
        return sum;
    }
}