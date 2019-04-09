package SimpleTasks;

import java.util.*;
import java.math.*;
import java.lang.*;

public class HelloWorld {
    public static void main(String[] args) throws java.io.IOException {
//        System.out.println("Hello world!");
//        System.out.println("Hello world! length is" + "Hello world!".length());
//        numsAndGens();
//        scanners();
//        daytime(22);
//        daytime(10);
//        fibonachi(12);
//        fibonachi(5);

//        booleanExpression(true, true, false,false); // true
//        booleanExpression(false, true, false,false); // false
//
//        doubleExpression(0.1,0.1,0.3);
//        leapYearCount(4); // 1
//        leapYearCount(100); // 24
//        System.out.println(factorial(5));
//        System.out.println(factorial(10));

//        char myChar = '\u005C\u005C';
//        System.out.println(myChar);
//        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 1, 2, 3, 4, 5}, new int[] { 5, 10, 20, 30, 40, 50, 60, 70 })));
//        File file1 = new File (".\\a\\b\\..\\b\\c\\.\\file.txt");
//        String file11 = file1.getCanonicalPath();
//        System.out.println(file11);
//
//        File file2 = new File("a\\b\\..\\file.txt");
//        String file22 = file2.getCanonicalPath();
//        System.out.println(file22);
        new Thread(() -> System.out.println(
                "inside Thread constructor using lambda")).start();
    }

    private static void numsAndGens(){
        int x = 5;
        int y = 6;
        double n = 1.9;

        Random generator = new Random();
        System.out.println(generator.nextInt());
        System.out.println(Math.pow(x, y));
        System.out.println(n);
        System.out.printf("x=%d; y=%d \n", x, y);
    }

    private static BigInteger factorial(int value) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    private static void scanners(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();System.out.printf("Your number: %d \n", num);
    }

    private static void daytime(int hour){
        if (hour >24 || hour < 0) {
            return;
        }
        if(hour > 21 || hour < 6) {
            System.out.println("Good night");
        }
        else if(hour >= 15) {
            System.out.println("Good evening");
        }
        else if(hour >= 11) {
            System.out.println("Good after noon");
        }
        else {
            System.out.println("Good morning");
        }
    }

    private static int fibonachi(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else{
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }

    private static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a != b) && (c != d)) || ((a != c) && (b != d));
    }

    private static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }

    private static void leapYearCount(int year) {
        System.out.println(year/4 + year/400 - year/100);
    }

    public static char charExpression(int a) {
        char myChar2 = '\\';
        int resint = myChar2 + a;
        return (char) resint;
    }

    public static boolean isPalindrome(String text) {
        String result = text.replaceAll("[^a-zA-Z0-9]", "");
        return result.equalsIgnoreCase(new StringBuilder(result).reverse().toString());
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        int i=0, j=0, k=0;
        while(i < a1.length && j < a2.length) {
            a3[k++] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }

        if (i < a1.length) {
            System.arraycopy(a1, i, a3, k, a1.length - i);
        }
        else if (j < a2.length) {
            System.arraycopy(a2, j, a3, k, a2.length - j);
        }

        return a3;
    }

    public static int[] mergeArrays_v2(int[] a1, int[] a2) {
        int n = a1.length, m = a2.length;
        int i = 0, j = 0;
        int[] array = new int[n + m];

        while (i < n || j < m)
            array[i + j] = (i < n && (j == m || a1[i] < a2[j])) ? a1[i++] : a2[j++];

        return array;
    }

}

class V {
    private int maxSpeed;
    private int wheels;
    private String color;
    private double fuelCap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V v = (V) o;
        return maxSpeed == v.maxSpeed &&
                wheels == v.wheels &&
                Double.compare(v.fuelCap, fuelCap) == 0 &&
                Objects.equals(color, v.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxSpeed, wheels, color, fuelCap);
    }

    V(int maxSpeed, int wheels, String color, double fuelCap){
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
        this.color = color;
        this.fuelCap = fuelCap;
    }

    void horn(){
        System.out.println("Beep");
        System.out.println(maxSpeed);
    }
}