package SeriousAssigments;

import java.util.Locale;
import java.util.Scanner;

public class DoubleAdder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        String doubleToRead;
        double db;
        double sum = 0;

        while (scanner.hasNext()) {
            doubleToRead = scanner.next();
            try {
                db = Double.parseDouble(doubleToRead);
                sum += db;
            }

            catch (Exception e){}
        }
        System.out.format("%.6f",sum);
    }
}