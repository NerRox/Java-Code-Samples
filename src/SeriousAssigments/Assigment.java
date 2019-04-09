package SeriousAssigments;

import java.io.*;
import java.text.*;
import java.util.*;

public class Assigment {
    public static void main(String[] args) throws Exception {
        File fileToRead = new File("C:\\Users\\Alex\\IdeaProjects\\JavaStudy\\src\\log.log");

        try(RandomAccessFile file = new RandomAccessFile(fileToRead, "r")) {
            int fileLength = (int) file.length();

            while (strDateParser(file.readLine())){
                file.seek(fileLength/2 - 1);
                int count = 0;

                while (file.read() != '\n') {
                    file.seek(fileLength/2 - 1 + count);
                    count--;
                }
            }


            for(String line; (line = file.readLine()) != null; ) {
                    System.out.println(line);
            }
        }
    }

    private static boolean strDateParser(String str) throws Exception {
        String dateFromStr = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
        DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        Date parsedDate =  dateFormat.parse(dateFromStr);

        String targetDate = "27/Dec/2015:14:18:20 +0100";
        Date staticDate =  dateFormat.parse(targetDate);


        return parsedDate.compareTo(staticDate) > 0;
    }

    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == x) {
                return middle;
            }

            if (arr[middle] < x) {
                left = middle + 1;
            }

            else {
                right = middle - 1;
            }
        }

        return -1;
    }
}