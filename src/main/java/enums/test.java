package enums;

public class test {
    public static void main(String[] args) {
        season str = season.s;
        System.out.println(str.getSname()+"\n"+str.getScore());
    }
}
class season{
    @SuppressWarnings("unused")
    int num = 10;
    private final String sname;
    private final String score;

    public season(String sname,String score){
        this.sname=sname;
        this.score=score;
    }

    public static season s = new season("足球","曼联");
    public static season s2 = new season("篮球","NBA");

    public String getSname() {
        return sname;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "season{" +
                "sname='" + sname + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
