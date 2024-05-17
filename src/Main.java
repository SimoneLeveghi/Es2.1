/*ES1
    Realizza un programma che simuli l'attività di 10 automobili che utilizzano un parcheggio di 5 posti; se il parcheggio
    è totalmente occupato le eventuali auto che vogliono entrare devono essere messe in attesa (wait) circolando
    per un tempo massimo di 20 secondi.
    Le auto in attesa devono ritentare l'ingresso appena si libera un posto (notify). Ogni auto può restare
    parcheggiata solo per un tempo massimo di 10 secondi.
*/
import java.util.concurrent.Semaphore;

public class Main {

    public static final int nPosti = 5;

    public static void main(String[] args) {
        Semaphore s = new Semaphore(nPosti);

        for(int i = 0; i < 20; ++i) {
            new Thread(new Auto(s)).start();
        }

    }




}