package sparse;

public class test {
    public static void main(String[] args) {
        int[] ints = new int[]{11,22,33,54,78,6,5,4,};
        int temp = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j< ints.length-i;j++){
                if (ints[j]>ints[j+1]){
                    temp=ints[j];
                    ints[j]=ints[j+1];
                    ints[j+1]=temp;
                }
            }
            System.out.println(temp);
        }
    }
}
