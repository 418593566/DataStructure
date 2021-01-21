package queue;

import java.util.Scanner;

/**
 * 单向队列
 */
public class SingleArray {
    public static void main(String[] args) {
        ArrayQueue aay = new ArrayQueue(5);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.err.println("1.添加数据"+"\t"+"2.取出数据"+"\t"+"3.显示"+"\t"+"4.退出");
            int s = sc.nextInt();
            switch (s){
                case 1:
                    System.out.println("输入添加数据");
                    Scanner scanner = new Scanner(System.in);
                    int i = scanner.nextInt();
                    aay.addQueue(i);
                    aay.showQueue();
                    break;
                case 2:
                    try {
                        int i1 = aay.OutQueue();
                        System.out.printf("%d\n",i1);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    aay.prek();
                    break;
                case 3:
                    aay.showQueue();
                    break;
                case 4:
                    sc.close();
                    loop=false;
                    System.out.println("程序退出...");
                    break;
                default:
            }
        }
    }
}



class ArrayQueue{
    private int   maxSize;
    private int[] arr;
    private int   front;
    private int   rear;

    /**
     *
     * @param Array  数量
     */
    public ArrayQueue(int Array){
        maxSize = Array ;
        arr   =  new int[maxSize];
        front =  -1;          //头
        rear  =  -1;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){ return front == rear; }

    /**
     * 判断是否存满
     * @return
     */
    public boolean isFull(){ return rear == maxSize-1; }

    /**
     * 添加
     * @param x
     */
    public void addQueue(int x){
        if (isFull()){
            throw new RuntimeException("队列已满...");
        }
        rear++;
        arr[rear] = x;
    }

    /**
     * 取出
     * @return
     */
    public int OutQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空...");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示队列数据
     */
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空...");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public void prek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空...");
        }
        for (int i = front+1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
