package SeriousAssigments;

import java.util.function.DoubleUnaryOperator;

public class CalcIntegral {

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h = 10E-6;
        double result = 0;

        double n = ((b - a) / h);

        for(int i = 0; i < n; i++) {
            result += f.applyAsDouble(a + h * (i + 0.5));
        }

        return result *= h;
    }

    public static double integrate_v2(DoubleUnaryOperator f, double a, double b) {
        final double h = 1e-6;
        double sum = 0;
        long i = 0;
        for (double x = a; x < b; x = a + h * i++) {
            sum += h * f.applyAsDouble(x);
        }
        return sum;
    }

    public static double integrate_v3(DoubleUnaryOperator f, double a, double b) {
        double I = 0;
        while (a < b) {
            I += f.applyAsDouble(a += 1e-6);
        }
        return I*1e-6;
    }
}
