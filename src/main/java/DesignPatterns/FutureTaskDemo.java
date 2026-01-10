package designpatterns;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Demonstrates FutureTask for asynchronous computation.
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws Exception {
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 45;
        };
        
        FutureTask<Integer> future = new FutureTask<>(task);
        
        Thread t1 = new Thread(future);
        
        t1.start();
        
        System.out.println("Process started...");
        
        int result = future.get();
        
        System.out.println("Result " + result);
    }
}
