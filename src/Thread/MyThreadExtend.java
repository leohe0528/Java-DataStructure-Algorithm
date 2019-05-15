package Thread;

public class MyThreadExtend extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("I am thread");
        }
    }

    public static void main(String[] args){
        MyThreadExtend t = new MyThreadExtend();
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("I am main");
        }
    }

}
