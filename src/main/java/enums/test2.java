package enums;

public class test2 {
    public static void main(String[] args) {
        seasion spring = seasion.SPRING;
        seasion sum = seasion.SUM;
        System.out.println("季节:"+spring.getSname()+"\n"+"运动:"+spring.getScore());
        System.out.println("季节:"+sum.getSname()+"\n"+"运动:"+sum.getScore());

        seasion sum1 = seasion.valueOf("SUM");
        System.out.println(sum1);

        seasion[] values = seasion.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        sum.show();

    }
}

interface into{
    void show();
}


enum seasion implements into{
    SUM("夏天","游泳"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    SPRING("春天","爬山"){
        @Override
        public void show() {
            System.out.println("春天在哪");
        }
    };

    private final String sname;
    private final String score;

    seasion(String sname,String score){
        this.sname=sname;
        this.score=score;
    }

    public String getSname() {
        return sname;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "seasion{" +
                "sname='" + sname + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}