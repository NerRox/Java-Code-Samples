package SimpleTasks;

import java.util.*;


public class GenericsSamples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int value;
        int i = 0;
        while (scanner.hasNext()) {
            value = scanner.nextInt();
            if (i % 2 == 1) {
                queue.add(value);
            }
            i++;
        }

        for(Iterator descItr = queue.descendingIterator();descItr.hasNext();) {
            System.out.print(descItr.next() + " ");
        }
    }

    public static int countDividableN(int a, int b, int n) {
        int count = 0;

        while (a <= b) {
            a+=n;
            count++;
        }
        return count;
    }

    public static long productOfNumbers(int a, int b) {
        long res = 1;

        for (int i = a; i < b; i++) {
            res = res * i;
        }

        return res;
    }

    public static String numberLucky(int n) {
        String prom = Integer.toString(n);
        int halfLen = prom.length() / 2;

        String[] firstPart = prom.substring(0,halfLen).split("");
        String[] secondPart = prom.substring(halfLen).split("");

        int m = 0 , j = 0;

        for(int i = 0; i < firstPart.length; i++){
            m += Integer.parseInt(firstPart[i]);
        }

        for(int i = 0; i < secondPart.length; i++){
            j += Integer.parseInt(secondPart[i]);
        }

        if (m == j) {
            return "YES";
        }

        return "NO";
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set11 = new HashSet<T>(set1);
        Set<T> set22 = new HashSet<T>(set2);

        Set<T> set111 = new HashSet<T>(set1);
        Set<T> set222 = new HashSet<T>(set2);

        set11.removeAll(set22);
        set222.removeAll(set111);

        set11.addAll(set222);

        return set11;

//        Set<Integer> result = symmetricDifference(num1,num2); пример вызовы
    }
}

class Example<X> {
    public void someMethod(Object obj) {
//        obj instanceof Optional<X>;  не компилируется
//        X y = (X) obj;
//        Example<X> z = Optional.empty();
//        var u = new Optional<>(); не компилируется
    }
}

class Pair<S, N> {
    private S Svalue;
    private N Nvalue;

    private Pair(S Svalue, N Nvalue){
        this.Svalue = Svalue;
        this.Nvalue = Nvalue;
    }

    static <S, N> Pair<S, N> of(S value, N value1) {
        return new Pair<S, N>(value, value1);
    }

    S getFirst(){
        return Svalue;
    }

    N getSecond(){
        return Nvalue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(Svalue, pair.Svalue) &&
                Objects.equals(Nvalue, pair.Nvalue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Svalue, Nvalue);
    }
}
