package Thread;

//1.MyThread extend to Thread
//2.Thread implements Runnable
//3.MyThread implements Runnable
//注意1和3的override run不能写在class Mythread下面，因为重复了，所以需要写在相对应的object
class MyThread extends Thread implements Runnable{

    public static void main(String[] args) {
        MyThread t1 = new MyThread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("I am MyThread");
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("I am Thread-Runnable");
                }
            }
        });
        t2.start();

        MyThread t3 = new MyThread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("I am MyThread-Runnable");
                }
            }
        };
        t3.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("I am main");
        }
    }

}


