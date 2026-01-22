package MultiThreading;

/**
 * Demonstrates running multiple threads and measuring time.
 */
public class ImplementingThreading {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        
       ThreadSecond t1 = new ThreadSecond();
       ThreadFirst t2 = new ThreadFirst();
        System.out.println("Starting first thread");
        t1.start();
        System.out.println("Starting second thread");
        t2.start();
        
        long endTime = System.currentTimeMillis();
        
        long totalTime = endTime - startTime;
        
        System.out.printf(" %s Total time taken is : %d", Thread.currentThread().getName(), totalTime);
    }
}
