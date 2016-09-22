package problem5;

public class PlanckConstant {

    public static void main(String[] args) {

        System.out.println(Calculations.reducePlancConstant());
    }
}

class Calculations{

    private static final double PLANC_CONSTANT = 6.62606896e-34;
    private static final double PI = 3.14159;

    public static double reducePlancConstant(){
        return PLANC_CONSTANT / (2*PI);
    }
}
