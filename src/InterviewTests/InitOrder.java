package InterviewTests;

public class InitOrder {
    public static void main(String[] args) {
        new Test();
    }


}
class SuperTest {
    static {System.out.println(1);}
    {
        System.out.println(2);
    }

    public SuperTest(){
        System.out.println(3);
    }
}

class Test extends SuperTest{
    static {System.out.println(4);}
    {System.out.println(5);}

    public Test(){
        System.out.println(6);
    }
}
