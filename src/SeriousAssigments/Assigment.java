package SeriousAssigments;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.util.*;

public class Assigment {
    static private DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    public static void main(String[] args) throws Exception {
        String filePath = "." + File.separator + "src" + File.separator + "log.log";
        File fileToRead = new File(filePath);
        String targetDate = "27/Dec/2015:14:18:20 +0100";
        Date staticDate =  dateFormat.parse(targetDate);

        try(RandomAccessFile file = new RandomAccessFile(fileToRead, "r")) {
            long fileSize = file.length();
            long left = 0L;
            long right = file.length();
            while (left < right) {
                long middle = left + (right - left) / 2;
                long lineStart = getLineStart(file, middle, left);
                long lineEnd = getLineEnd(file, middle, right);
                file.seek(lineStart);
                byte[] buffer = new byte[(int) (lineEnd - lineStart)];
                file.read(buffer);
                String line = new String(buffer, StandardCharsets.US_ASCII);
                Date date = strDateParser(line);
                if (date.compareTo(staticDate) < 0) {
                    left = lineEnd + 1;
                } else {
                    right = lineStart - 1;
                }
            }
            if (left < fileSize) {
                byte[] buffer = new byte[4096];
                file.seek(left);
                for (int i = 0; i >= 0; i = file.read(buffer)) {
                    System.out.print(new String(buffer, 0, i, StandardCharsets.US_ASCII));
                }
            }
        }
    }

    private static long getLineEnd(RandomAccessFile file, long middle, long right) throws IOException {
        long pos = middle;
        file.seek(pos);
        while (pos < right) {
            if (file.readByte() == '\n') {
                return pos;
            };
            pos++;
        }
        return right;
    }

    private static long getLineStart(RandomAccessFile file, long middle, long left) throws IOException {
        long pos = middle;
        while (pos >= left) {
            file.seek(pos);
            if (file.readByte() == '\n') {
                return pos;
            };
            pos--;
        }
        return left;
    }

    private static Date strDateParser(String str) throws Exception {
        String dateFromStr = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
        Date parsedDate =  dateFormat.parse(dateFromStr);
        return parsedDate;
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