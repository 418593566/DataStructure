public class test8 {
    public static void main(String[] args) {

    }
}


class Sims{
    private Sims(){}
    private Sims str = null;

    public Sims getS(){
        if (str==null){
            str = new Sims();
        }
        return str;
    }
}