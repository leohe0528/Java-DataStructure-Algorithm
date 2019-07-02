package Calculator;

public class MyPow {
//    public double myPow(double x, int n) {
//        if (n < 0) return myPow(1/x, -n);
//        if (n == 0) return 1;
//        // if (n == 1) return x;
//        if (n % 2 == 0){
//            return myPow(x * x, n/2);
//        }else{
//            return myPow(x * x, n/2) * x;
//        }
//    }

    public double myPow(double x, int n) {
        if (n < 0){
            return helper(1 / x, -n);
        }
        return helper(x, n);
    }
    private double helper(double x, int n){
        if (n == 0) return 1;
        if (n % 2 == 0){
            return helper(x * x, n / 2);
        }else{
            return helper(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args){
        double x = 1.0;
        int n = -2147483648;
        double res = new MyPow().myPow(x, n);
    }
}
