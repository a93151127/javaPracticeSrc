import java.math.BigDecimal;

public class DecimalMain {
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.1;
        double c = 0.1;

        if((a + b + c) == 0.3){
            System.out.println("inside true");
        }else{
            System.out.println("inside false");
        }

        System.out.println("========以上的程式會進入false(因為精準度的問題)============");

        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.1");
        BigDecimal b3 = new BigDecimal("0.1");

        BigDecimal result = new BigDecimal("0.3");

        if(b1.add(b2).add(b3).equals(result)){
            System.out.println("inside decimal true");
        }else{
            System.out.println("inside decimal false");
        }
    }
}
