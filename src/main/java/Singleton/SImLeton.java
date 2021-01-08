package Singleton;

public class SImLeton {
    public static void main(String[] args) {

    }
}

class Sim{

    private Sim(){}

    private static Sim str = new Sim();

    public static Sim getSim(){
        return str;
    }
}