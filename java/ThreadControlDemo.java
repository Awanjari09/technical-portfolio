class MyThread implements Runnable {
    private Thread t;
    private boolean suspended = false;
    private boolean stopped = false;

    MyThread(String name) {
        t = new Thread(this, name);
        System.out.println("Thread created: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                synchronized (this) {
                    while (suspended) {
                        wait(); // wait until resumed
                    }
                    if (stopped) break;
                }
                System.out.println(t.getName() + " : " + i);
                Thread.sleep(500); // simulate work
            }
        } catch (InterruptedException e) {
            System.out.println(t.getName() + " interrupted.");
        }
        System.out.println(t.getName() + " exiting.");
    }
    synchronized void mySuspend() {
        suspended = true;
    }

    synchronized void myResume() {
        suspended = false;
        notify(); // wake up the waiting thread
    }
    synchronized void myStop() {
        stopped = true;
        suspended = false;
        notify(); // in case it's waiting
    }
}

public class ThreadControlDemo {
    public static void main(String args[]) {
        MyThread t1 = new MyThread("Thread-1");
        try {
            Thread.sleep(2000);
            System.out.println("Suspending Thread-1");
            t1.mySuspend();

            Thread.sleep(2000);
            System.out.println("Resuming Thread-1");
            t1.myResume();

            Thread.sleep(2000);
            System.out.println("Stopping Thread-1");
            t1.myStop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
