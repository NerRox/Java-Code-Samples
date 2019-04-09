package SimpleTasks;

public class AsciiCharSequenceTest {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString()); //Hello!
        System.out.println("Размер её - " + answer.length()); //6
        System.out.println("Символ под № 1 - " + answer.charAt(1)); //e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5)); //ello
    }
}

class AsciiCharSequence implements CharSequence{
    private final byte[] seq;

    AsciiCharSequence(byte[] seq){
        this.seq = seq;
    }

    @Override
    public int length() {
        return seq.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > seq.length) {
            throw new IndexOutOfBoundsException("Index is less than 0 or more than length!");
        }
        return (char) (seq[index] & 0xff);
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        if (start < 0 || end < 0 || end > seq.length || start > end) {
            throw new IndexOutOfBoundsException("Incorrect start or end, check the input!");
        }
        return new AsciiCharSequence(new String(seq).substring(start, end).getBytes());
    }

    @Override
    public String toString() {
        return new String(seq);
    }
}
