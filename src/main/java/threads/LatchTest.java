package Wykopki;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static java.util.UUID.randomUUID;

/**
 * Created by mareckip on 10/13/2016.
 */
public class LatchTest {
    public static void main(String[] args) throws Exception {


        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("Main start");
        Thread t = new Thread(() -> {
            System.out.println("Thread start");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread -> countdown");
            latch.countDown();
        });
        t.start();
        System.out.println("Main awaits");
        latch.await(2000, TimeUnit.MILLISECONDS);
        System.out.println("Main lets go");




    }
}
