public class test2 {
    public static void main(String[] args) {
        String str = "java,java,hello";
        String s = str.replaceAll("java", "php");

        int[] arrMax = new int[]{12,12,34,54,3425,2};

        for (int i = 0; i < arrMax.length-1; i++) {
            for (int j = 0; j < arrMax.length - 1 - i; j++) {
                if (arrMax[j] > arrMax[j + 1]) {
                    int temp = arrMax[j];
                    arrMax[j] = arrMax[j + 1];
                    arrMax[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arrMax.length; i++) {
            System.out.printf("%d\t",arrMax[i]);
        }
    }
}
