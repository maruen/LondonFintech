# LondonFintechExam
London Fintech Exam Solution

Running the Sample

1) Open a terminal and go the folder apache-zookeeper-3.6.1-bin/bin and run the command below:
    - cd apache-zookeeper-3.6.1-bin/bin
    -  ./zkServer.sh start
    
2) Open a new terminal and go to the folder spring-cloud-zookeeper-sample and run the first server in port 8181
    - cd spring-cloud-zookeeper-sample
    - java -jar target/london-fintech-exam-3.0.0-SNAPSHOT.jar --server.port=8181

2) Open a new terminal and go to the folder spring-cloud-zookeeper-sample and run the first server in port 8282
    - cd spring-cloud-zookeeper-sample
    - java -jar target/london-fintech-exam-3.0.0-SNAPSHOT.jar --server.port=8181

3) Repeat the previous step if you want another server running and change the port to another one not used.
   (For the sake of this exam only two servers are enough to demonstrate)
         

You should se the the message below for the server running on the port 8181
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-06-26 15:55:54.294  INFO 7834 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-config/LondonFintechApp'}, BootstrapPropertySource {name='bootstrapProperties-config/application'}]
2020-06-26 15:55:54.350  INFO 7834 --- [           main] o.s.cloud.zookeeper.sample.Application   : No active profile set, falling back to default profiles: default
2020-06-26 15:55:56.775  INFO 7834 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=aa4abe82-74e1-3c1f-b0b6-9080e45640f8
2020-06-26 15:55:57.454  INFO 7834 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.zookeeper.sample.Application$AppClient' of
type [org.springframework.cloud.openfeign.FeignClientFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-06-26 15:55:58.517  INFO 7834 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8181 (http)
2020-06-26 15:55:58.538  INFO 7834 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-06-26 15:55:58.538  INFO 7834 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
2020-06-26 15:55:58.726  INFO 7834 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-06-26 15:55:58.727  INFO 7834 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 4329 ms
2020-06-26 15:56:00.385  INFO 7834 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-26 15:56:01.810  WARN 7834 --- [           main] iguration$LoadBalancerCaffeineWarnLogger : Spring Cloud LoadBalancer is currently working with the default cache. You
can switch to using Caffeine cache, by adding it to the classpath.
2020-06-26 15:56:01.881  INFO 7834 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2020-06-26 15:56:02.163  INFO 7834 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8181 (http) with context path ''
2020-06-26 15:56:02.346  INFO 7834 --- [           main] o.s.cloud.zookeeper.sample.Application   : Started Application in 10.626 seconds (JVM running for 65.425)
Current number of nodes is -> 1
We are started!



And you should see the message below for the server running in the port 8282


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

2020-06-26 15:56:59.662  INFO 9464 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapPropertie
s-config/LondonFintechApp'}, BootstrapPropertySource {name='bootstrapProperties-config/application'}]
2020-06-26 15:56:59.718  INFO 9464 --- [           main] o.s.cloud.zookeeper.sample.Application   : No active profile set, falling back to default profiles: default
2020-06-26 15:57:01.608  INFO 9464 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=aa4abe82-74e1-3c1f-b0b6-9080e45640f8
2020-06-26 15:57:02.069  INFO 9464 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.zookeeper.sample.Application$AppClient' of
type [org.springframework.cloud.openfeign.FeignClientFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-06-26 15:57:02.603  INFO 9464 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8282 (http)
2020-06-26 15:57:02.625  INFO 9464 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-06-26 15:57:02.625  INFO 9464 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
2020-06-26 15:57:02.748  INFO 9464 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-06-26 15:57:02.748  INFO 9464 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2987 ms
2020-06-26 15:57:04.548  INFO 9464 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-26 15:57:05.459  WARN 9464 --- [           main] iguration$LoadBalancerCaffeineWarnLogger : Spring Cloud LoadBalancer is currently working with the default cache. You
can switch to using Caffeine cache, by adding it to the classpath.
2020-06-26 15:57:05.519  INFO 9464 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2020-06-26 15:57:05.605  INFO 9464 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8282 (http) with context path ''
2020-06-26 15:57:05.754  INFO 9464 --- [           main] o.s.cloud.zookeeper.sample.Application   : Started Application in 7.842 seconds (JVM running for 8.477)
Current number of nodes is -> 2


Note that we don't see the message We are started! in the server runing in the port 8282


Obs: For debuging
java -agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=y -jar target/london-fintech-exam-3.0.0-SNAPSHOT.jar --server.port=8181

If you want to change the code and rebuild, just change all that you need and xecute the command below:

 - cd spring-cloud-zookeeper-sample
 - mvn -U clean package -DskipTests
