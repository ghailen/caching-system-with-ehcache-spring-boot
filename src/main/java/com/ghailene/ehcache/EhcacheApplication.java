package com.ghailene.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcacheApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<>();
		caches.add(new ConcurrentMapCache("customerList"));
		cacheManager.setCaches(caches);
		return cacheManager;
	}
}
