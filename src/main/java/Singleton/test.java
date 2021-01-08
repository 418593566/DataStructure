package Singleton;

public class test {
    public static void main(String[] args) {

    }
}

class GeeUnile{
    private static GeeUnile gu = null;

    private GeeUnile(){}

    public static GeeUnile getGu(){
        if (gu == null) {
            gu = new GeeUnile();
        }
        return gu;
    }
}