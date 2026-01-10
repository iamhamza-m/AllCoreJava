package MultiThreading;

/**
 * Runs multiple Runnable threads with priorities and join.
 */
public class RunnableInAction {
    public static void main(String[] args) throws InterruptedException {
        ImplementingRunnable t1 = new ImplementingRunnable('#');
        ImplementingRunnable t2 = new ImplementingRunnable('$');
        ImplementingRunnable t3 = new ImplementingRunnable('^');
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        
        Thread p1 = new Thread(t1);
        p1.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Thread1 started");
        
        Thread p2 = new Thread(t2);
        p2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread2 started");
        p1.join();
        
        Thread p3 = new Thread(t3);
        p3.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread3 started");
    }
}
