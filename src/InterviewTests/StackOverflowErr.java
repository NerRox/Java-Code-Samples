package InterviewTests;

public class StackOverflowErr {
    StackOverflowErr b = new StackOverflowErr();
    public int show(){
        return true ? null : 0;
    }

    public static void main(String[] args) {
        StackOverflowErr b = new StackOverflowErr();
        b.show();
    }
}