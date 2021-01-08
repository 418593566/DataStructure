package ArrayStack;


/**
 * 数组栈
 */
public class SimStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.show();
        System.out.println("****************");
        stack.pop();
        stack.pop();
        stack.show();
    }
}


class ArrayStack {
    private int top = -1;          //栈顶
    private int maxSize;           //最大容量
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //空
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value   数据
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满...");
            return;
        }
        top++;
        stack[top]=value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈是空的...");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 输出
     */
    public void show(){
        if (isEmpty()){
            System.out.println("栈是空的\n你个棒槌");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}