import java.util.Scanner;

public class test9 {
    public static void main(String[] args) {
        int i = 10;
        String s = Integer.toString(i);
        System.out.println(s);

        String str= "20";
        int i1 = Integer.parseInt(str);
        System.out.println(i1);

        int i2 = Integer.valueOf(str).intValue();
        System.out.println(i2);


        System.out.println("****************************");

        Scanner sc = new Scanner(System.in);
        sc.nextInt();

        int n1 = 10;
        int n2 = -20;
        int n3 = 30;
        int max = (n1>n2)?n1:n2;
        int max2 = (max>n3)?max:n3;
        System.out.println(max2);
    }
}
class  demo{
    static class demo2{}
}