# caching-system-with-ehcache-spring-boot

before cache system : i m using thread.sleep to get data after 5000 ms 
![Capture2](https://user-images.githubusercontent.com/36199753/114894620-b21a6a00-9e06-11eb-873f-805819c00380.PNG)
after cache system : only 98 ms (the cache reload every day at 5 h am  using  @Scheduled(cron = "0 0 * * * *") annotation)
![Capture3](https://user-images.githubusercontent.com/36199753/114894639-b6468780-9e06-11eb-9895-f9e4e32d9de6.PNG)

we can reload cache immediately via this api:
![Capture3](https://user-images.githubusercontent.com/36199753/114894790-d9713700-9e06-11eb-8d8d-23a6e9fc62e1.PNG)




