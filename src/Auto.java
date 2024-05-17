import java.util.concurrent.Semaphore;

public class Auto implements Runnable {
    private Semaphore s;

    public Auto(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        s.acquireUninterruptibly();
        long endTime = System.nanoTime();

        if((endTime - startTime) * Math.pow(10, -9) < 20) {
            System.out.println("Auto " + Thread.currentThread().getName() + " parcheggiata");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Auto " + Thread.currentThread().getName() + " lascia il parcheggio");
        }
        s.release();
    }

}
