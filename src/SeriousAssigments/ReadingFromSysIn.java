package SeriousAssigments;

import java.io.*;

public class ReadingFromSysIn {
    public static void main(String[] args) throws IOException {
        System.setIn(new ByteArrayInputStream(new byte[] {0x65, 0x13, 0x10, 0x10, 0x13}));

        int prev = System.in.read();
        int next;

        while (prev != -1) {
            next = System.in.read();
            if (prev != 13 || next != 10) {
                System.out.write(prev);
            }
            prev = next;
        }

        System.out.flush();
        System.out.close();
    }
}

//1) читаем новый байт из потока и запоминаем его в переменную prev
//2) если prev не -1, входим в цикл и читаем следующий байт из потока в переменную next, иначе переходим к пункту (6)
//3) если prev != 13 или next != 10, выводим prev
//4) "передвигаем" очередь путём присвоения prev = next
//5) переходим к пункту (2)
//6) делаем flush.