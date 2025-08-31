package FindingPrimes;
import java.util.Arrays;

public class FindingPrimes {

    public static void main(String[] args) {

        int limit = 1000000000;
        long startTime = System.nanoTime();

        // Chiamiamo il metodo del Crivello per ottenere il conteggio
        int primesFound = sieveOfEratosthenes(limit);

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Primes Found: " + primesFound);
        System.out.println("Time taken: " + String.format("%.3f", duration) + " seconds");
    }

    public static int sieveOfEratosthenes(int n) {
        // Passo 1: Crea un array booleano e inizializza tutti gli elementi a 'true'
        // Questo array rappresenta i numeri da 0 a n.
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        // I numeri 0 e 1 non sono primi.
        isPrime[0] = false;
        isPrime[1] = false;

        // Passo 2: Inizia a 'crivellare' da 2
        for (int p = 2; p * p<= n; p++) {
            // Se isPrime[p] è ancora true, significa che 'p' è un numero primo.
            if (isPrime[p]) {
                // Passo 3: Marca tutti i multipli di 'p' come non primi
                // Inizia da p*p perché i multipli più piccoli sono già stati segnati.
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Passo 4: Conta i numeri primi rimasti
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}