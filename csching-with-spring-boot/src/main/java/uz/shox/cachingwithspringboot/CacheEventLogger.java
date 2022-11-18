package uz.shox.cachingwithspringboot;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 18/11/22 18:49 (Friday)
 * caching-in-Spring-Boot/IntelliJ IDEA
 */
@Slf4j
public class CacheEventLogger implements CacheEventListener<Object, Object> {
    @Override
    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        System.out.println("Cache event listener => " + cacheEvent.getKey() + cacheEvent.getOldValue() + cacheEvent.getNewValue());
    }
}
