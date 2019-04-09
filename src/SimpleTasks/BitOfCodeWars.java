package SimpleTasks;

import java.util.*;
import java.util.stream.IntStream;

public class BitOfCodeWars {
    public static void main(String[] args) {
//        System.out.println(Tickets(new int[] {25, 25, 50, 50, 100}));
//        System.out.println(cubeOdd(new int[] {1,2,3,4}));
//        System.out.println(Arrays.toString(racing(720, 850, 70)));
//        System.out.println(deffer(new String[] {"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis",
//                "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"},
//                new String[] {"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"}));
//        System.out.println(nbDig(10, 1));
//        System.out.println(Arrays.toString(wave("hello"))); //=> ["Hello", "hEllo", "heLlo", "helLo", "hellO"]
//        System.out.println(Arrays.toString(wave("Two words")));
//        System.out.println(Arrays.toString(wave(" gap ")));
        SubClass x = new SubClass();
        x.printSubValue();
    }

//    TODO Дописать функцию, описание https://www.codewars.com/kata/mexican-wave
    public static String[] wave(String str) {
        str = str.toLowerCase();
        String[] res = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = str.substring(0,i) + Character.toUpperCase(str.charAt(i)) + str.substring(i+1);
        }

        return res;
    }

    private static String Tickets(int[] peopleInLine) {
        int sum = 0;
        int cost = 25;

        for (int i = 0; i < peopleInLine.length; i++) {
            if (peopleInLine[i] == cost) {
                sum+=peopleInLine[i];
            }

            if (peopleInLine[i] > cost) {
                if (sum - (peopleInLine[i] - 25) < 0) {
                    return "NO";
                }

                else {
                    sum-=cost;
                    sum+=peopleInLine[i];
                }
            }
        }
        return "YES";
    }

    public static int cubeOdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * arr[i] * arr[i];
        }

        int sum = 0;

        for (int value : arr) {
            if (value%2 != 0) {
                sum += value;
            }
        }

        return sum;
    }

    public static int deffer (String[] a1, String[] a2) {
        int aMin = a1[0].length();
        int bMax = a2[0].length();


        for (int i = 1 ; i < a1.length ; i++) {
            if (a1[i].length() < aMin) {
                aMin = a1[i].length();
            }
        }


        for (int i = 1 ; i < a2.length ; i++) {
            if (a2[i].length() > bMax) {
                bMax = a2[i].length();
            }
        }

        return Math.abs(bMax - aMin);
    }

    public static int nbDig(int n, int d) {
        int count = 0;
        int[] x = IntStream.iterate(0,q->q+1).limit(n+1).map(z->z*z).toArray();
        String[] strOfInts = Arrays.toString(x).replaceAll("\\[|\\]|,|\\s", "").split("");

        String d1 = String.valueOf(d);
        for (int i = 0; i < strOfInts.length ; i++) {
            if (strOfInts[i].equals(d1)) {
                count++;
            }
        }

        return count;
    }
}


//Образец наслеования классов
class SuperClass {

    protected int field;

    protected int getField() {
        return field;
    }

    protected void printBaseValue() {
        System.out.println(field);
    }
}

class SubClass extends SuperClass {

    protected int field;

    public SubClass() {
        this.field = 30;  // It initializes the field of SubClass
        field = 30;       // It also initializes the field of SubClass
        super.field = 20; // It initializes the field of SuperClass
    }

    /**
     * It prints the value of SuperClass and then the value of SubClass
     */
    public void printSubValue() {
        super.printBaseValue(); // It invokes the method of SuperClass, super is optional here
        System.out.println(field);
    }
}

