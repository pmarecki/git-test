package Wykopki;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static java.util.UUID.randomUUID;

/**
 * Created by mareckip on 10/13/2016.
 */
public class NanoTimeTest {
    public static void main(String[] args) throws Exception {
        for (int j = 0; j < 30; j++) {
            long st = System.nanoTime();
            double b = 0;
            for (int i = 0; i < 100000; i++) {
                b += Math.sin(i * i);
            }
            long en = System.nanoTime();
            System.out.println((en-st)/1000 + "[us]");
        }



    }
}
