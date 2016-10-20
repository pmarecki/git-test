package Wykopki;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by mareckip on 10/20/2016.
 */
public class BBB {
    public static void main(String[] args) {
        //launch task; run no longer than
        RunnableFuture<Integer> w = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(200);
                return 12;
            }
        });
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(w);
        Integer g = null;
        try {
            g = w.get(100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("Timeout");
        }
        System.out.println(g);
        service.shutdownNow();
    }
}
