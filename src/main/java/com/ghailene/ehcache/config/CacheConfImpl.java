package com.ghailene.ehcache.config;

import com.ghailene.ehcache.services.CustomerService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;

@Configuration
@EnableCaching
@EnableScheduling
@Profile("!local")
public class CacheConfImpl implements CacheConf {
    private final CacheManager cacheManager;
    /**
     * load service
     */
    private final CustomerService customerService;

    public CacheConfImpl(CacheManager cacheManager, CustomerService customerService) {
        this.cacheManager = cacheManager;
        this.customerService = customerService;

    }

    @EventListener
    public void init(ContextRefreshedEvent event) throws InterruptedException {
        this.loadDatatoCach();
    }

    //  @Scheduled(cron = "${cron.cache}")// every 5 min
    @Scheduled(cron = "0 0 * * * *")// every day at 5h
    public void loadDatatoCach() throws InterruptedException {
        System.out.println("load cache");
        // clear all caches
        clearAllCaches();

       // customerService.getCustomers();
        System.out.println("End load cache");
    }

    public void clearAllCaches() {
        cacheManager.getCacheNames().forEach(ele -> {
            Objects.requireNonNull(cacheManager.getCache(ele)).clear();

        });
    }
}
