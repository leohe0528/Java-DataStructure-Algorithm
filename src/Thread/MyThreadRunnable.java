package Thread;

public class MyThreadRunnable implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("I am runnable");
        }
    }

    public static void main(String[] args){
        MyThreadRunnable mr = new MyThreadRunnable();
        Thread t = new Thread(mr);
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("I am main");
        }
    }
}
