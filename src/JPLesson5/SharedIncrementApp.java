package JPLesson5;

import java.util.ArrayList;
import java.util.List;

public class SharedIncrementApp {

    private static int counter = 0;

    private static synchronized void increment(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementor = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                for (int i=0; i<10; i++){
                    increment();
                }
            }
        };

        List<Thread> threadList = new ArrayList<>();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(incrementor);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thr : threadList){
            thr.join();
        }

        System.out.println(counter);
    }
}
