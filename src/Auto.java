import java.util.concurrent.Semaphore;

public class Auto implements Runnable {
    @Override
    public void run() {
        synchronized (Main.class) {
            if(Main.nextFreeSlot >= Main.autos.length) {
                try {
                    System.out.println("Auto " + Thread.currentThread().getName() + " dorme");
                    wait(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Auto " + Thread.currentThread().getName() + " parcheggiata");
            Main.autos[Main.nextFreeSlot++] = this;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Main.nextFreeSlot--;
            if(Main.autos.length == Main.nextFreeSlot){
                notify();
            }
            System.out.println("Auto " + Thread.currentThread().getName() + " lascia il parcheggio");
        }
    }

}
