public class demo2 {
    public static void main(String[] args) {
        demo2 demo2 = new demo2();
        int i = demo2.get(100);
        System.out.println(i);
    }
    public int get(int n){
        if (n==1){
            return 1;
        }else {
            return get(n-1)+n;
        }
    }
}
