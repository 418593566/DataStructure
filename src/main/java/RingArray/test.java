package RingArray;

import java.util.LinkedList;
import java.util.List;

/**
 * 环形队列
 */
public class test {
    public static void main(String[] args) {
        Ring r = new Ring(5);
        r.addArr(0);
        r.addArr(1);
        r.addArr(2);
        r.addArr(3);
        r.getArr();
        r.getArr();
        r.addArr(0);
        r.addArr(1);
        r.showArr();
    }
}


class Ring{
    private     int     front;
    private     int     rear;
    private     int     maxSize;
    private     int[]   arr;
    public Ring(int arrMax){
        maxSize =   arrMax;
        front   =   0;
        rear    =   0;
        arr     =   new int[maxSize];
    }

    /**
     * 满
     * @return
     */
    public boolean isFull(){ return (rear+1)%maxSize == front;}

    /**
     * 空
     * @return
     */
    public boolean isEmpty(){return rear == front;}

    /**
     * 添加
     * @param n
     */
    public void addArr(int n){
        if (isFull()){
            throw new RuntimeException("队列已满...");
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    /*
     *取出
     * @return
     */
    public int getArr(){
        if (isEmpty()){
            throw new RuntimeException("队列为空...");
        }
        int count = front;
        front = (front+1)%maxSize;
        return arr[count];
    }

    public void showArr(){
        if (isEmpty()){
            throw new RuntimeException("队列为空...");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int size(){ return (rear+maxSize-front)%maxSize;}

}
