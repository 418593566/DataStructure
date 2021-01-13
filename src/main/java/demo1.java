public class demo1 {
    public static void main(String[] args) {
        SimStr s = new SimStr();
        SimStr.student sr = s.new student();
        sr.eat();
        sr.show();

        SimStr.teacher st = new SimStr.teacher();
        st.eat();
    }
}

interface Complable{
    public void show();
}

class SimStr{

    static class teacher{
        public void eat(){
            System.out.println("吃饭");
        }
    }

    class student implements Complable{
        public void eat(){
            System.out.println("吃饭");
        }

        @Override
        public void show() {
            System.out.println("走干饭去");
        }
    }
}