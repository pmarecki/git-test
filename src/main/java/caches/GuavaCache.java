
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by pm on 11/5/16.
 */
public class GuavaCache {
    static Integer u = 0;
    public static void main(String[] args) throws Exception {

        LoadingCache<Integer, Integer> c = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .recordStats()
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public Integer load(Integer key) throws Exception {
                        //what to put for `key`
                        return key + (u++);
                    }
                });
        c.put(12, 111);
        for (int i = 0; i < 10; i++) {
            System.out.println(c.get(12));
            System.out.println(c.stats());
            Thread.sleep(1050);
        }
    }
}
