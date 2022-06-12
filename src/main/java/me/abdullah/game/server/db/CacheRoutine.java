package me.abdullah.game.server.db;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheRoutine {

    private final DBCache<?, ? extends DBStorable> cache;

    private final ExecutorService threadPool;

    public CacheRoutine(DBCache<?, ? extends DBStorable> cache){
        this.cache = cache;

        this.threadPool = Executors.newCachedThreadPool();
    }

    public void cacheAll(){
        cache.getCache().forEach((k, v) ->
                threadPool.submit( () -> cache.getCollection().save(v.getAsDBObject()) )
        );
    }
}
