package com.ghailene.ehcache.config;

import org.springframework.context.event.ContextRefreshedEvent;

public interface CacheConf {
     void init(ContextRefreshedEvent event) throws InterruptedException;

     void loadDatatoCach() throws InterruptedException;

     void clearAllCaches();
}
