public class MyThread extends Thread {
    public void run(){
        System.out.println("This is a new thread.");
    }

    public class ThreadExample {
        public static void main(String[] args) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
    }
}
