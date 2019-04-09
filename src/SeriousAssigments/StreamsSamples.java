package SeriousAssigments;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.*;

public class StreamsSamples {
    public static void main(String[] args) throws Exception {
//        InputStream stream = new ByteArrayInputStream ( new byte[] { 0x33, 0x45, 0x01});
//        InputStream stream1 = new ByteArrayInputStream(new byte[]{});
//        System.out.println(checkSumOfStream(stream));
//        System.out.println(checkSumOfStream(stream1));

//        byte[] data = {0x33, 0x45, 0x01}; // {0011 0011, 0100 0101, 0000 0001}
//        int C1 = Integer.rotateLeft(0,1) ^ data[0]; // 51dec
//        int C2 = Integer.rotateLeft(C1,1) ^ data[1]; // 35dec
//        int C3 = Integer.rotateLeft(C2,1) ^ data[2]; // 71dec
//        System.out.println(C1);
//        System.out.println(C2);
//        System.out.println(C3);
//        C1 = rotateLeft(C0) xor b1 = 0000 0000 xor 0011 0011 = 0011 0011 = 51dec;
//        C2 = rotateLeft(C1) xor b2 = 0110 0110 xor 0100 0101 = 0010 0011 = 35dec;
//        C3 = rotateLeft(C2) xor b3 = 0100 0110 xor 0000 0001 = 0100 0111 = 71dec;
        InputStream stream = new ByteArrayInputStream ( new byte[] { 0x33, 0x45, 0x01});
        InputStream streamOfNums = new ByteArrayInputStream ( new byte[] { 48, 49, 50, 51});

//        System.out.println(checkSumOfStream(stream));
        System.out.println(readAsString(streamOfNums, US_ASCII ));
    }

    private static int checkSumOfStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        byte[] x = buffer.toByteArray();

        if (x.length == 0) {
            return 0;
        }
        int s = 0;
        for (byte datum : x) {
            s = Integer.rotateLeft(s, 1) ^ (datum & 0xFF);
        }
        return s;
    }

    private static int checkSumOfStream_v1(InputStream inputStream) throws IOException {
        int res = 0;
        int read;
        while((read = inputStream.read()) != -1) {
            res = Integer.rotateLeft(res, 1) ^ read;
        }
        return res;
    }

    private static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader intstr = new InputStreamReader(inputStream, charset);
        int read;
        StringBuilder res = new StringBuilder();

        while ((read = intstr.read()) != -1) {
            res.append((char) read);
        }

        return String.valueOf(res);
    }

    public static String readAsString_v2(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int block;
        while ((block = inputStream.read()) != -1) {
            outputStream.write(block);
        }

        return new String(outputStream.toByteArray(), charset);
    }

//    Java9+
//    public static String readAsString_v3(InputStream inputStream, Charset charset) throws IOException {
//        return new String(inputStream.readAllBytes(), charset);
//    }
}

class tier2 {
    public static void main(String[] args) throws IOException {
        String s = "Ы";
        byte [] b = s.getBytes();
        for (byte b1 : b) {
            System.out.print(((int) b1 ^ -1 << 8) + " ");
        } //Значение Ы - 208 171
    }
}

class tier5 {
    public static void main(String[] args) {
//        System.out.println(testForStream(200));
//        System.out.println(testForStream(55));
//        System.out.println(pseudoRandomStream(13));
//        System.out.println(pseudoRandomStream(26));

        Stream<Integer> stringStream = Stream.of(10, 22, 33);
        Integer[] stringArray = stringStream.toArray(size -> new Integer[size]);
        Arrays.stream(stringArray).forEach(System.out::println);

    }

    private static IntStream pseudoRandomStream(int n) {
        return IntStream.iterate(n, x->Integer.parseInt(
                String.valueOf(x*x%10000/1000)
                        + String.valueOf(x*x%1000/100)
                        + String.valueOf(x*x%100/10)));
    }

    private static int testForStream(int x) {
        return Integer.parseInt(String.valueOf(x*x%10000/1000)
                + String.valueOf(x*x%1000/100)
                + String.valueOf(x*x%100/10));
    }

//    TODO Доделать задание https://stepik.org/lesson/12781/step/12?unit=3128
    @SuppressWarnings("unchecked")
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T[] arr = (T[]) stream.toArray();
        System.out.println(Arrays.toString(arr));
    }
}

