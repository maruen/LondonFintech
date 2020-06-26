# LondonFintechExam
London Fintech Exam Solution

Running the Sample

1) Open a terminal and go the folder apache-zookeeper-3.6.1-bin/bin and run the command below:
    - cd apache-zookeeper-3.6.1-bin/bin
    -  ./zkServer.sh start
    
2) Open a new terminal and go to the folder spring-cloud-zookeeper-sample and run the first server in port 8181
    - cd spring-cloud-zookeeper-sample
    - java -jar target/london-fintech-exam-3.0.0-SNAPSHOT.jar --server.port=8181

2) Open a new terminal and go to the folder spring-cloud-zookeeper-sample and run the second server in port 8282
    - cd spring-cloud-zookeeper-sample
    - java -jar target/london-fintech-exam-3.0.0-SNAPSHOT.jar --server.port=8181

3) Repeat the previous step if you want another server running and change the port to another one not used.
   (For the sake of this exam only two servers are enough to demonstrate)
         

<pre>

You should se the the message below for the server running on the port 8181

 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

 main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-config/LondonFintechApp'}, BootstrapPropertySource {name='bootstrapProperties-config/application'}]
 main] o.s.cloud.zookeeper.sample.Application   : No active profile set, falling back to default profiles: default
 main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=aa4abe82-74e1-3c1f-b0b6-9080e45640f8
 main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.zookeeper.sample.Application$AppClient' of type [org.springframework.cloud.openfeign.FeignClientFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
 main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8181 (http)
 main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
 main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
 main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
 main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2574 ms
 main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
 main] iguration$LoadBalancerCaffeineWarnLogger : Spring Cloud LoadBalancer is currently working with the default cache. You can switch to using Caffeine cache, by adding it to the classpath.
 main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
 main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8181 (http) with context path ''
 main] o.s.cloud.zookeeper.sample.Application   : Started Application in 11.596 seconds (JVM running for 12.264)
 main] o.s.cloud.zookeeper.sample.Application   : Current number of nodes is -> 1
 main] o.s.cloud.zookeeper.sample.Application   : We are started!

And you should see the message below for the server running in the port 8282

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.4.0-SNAPSHOT)

main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-config/LondonFintechApp'}, BootstrapPropertySource {name='bootstrapProperties-config/application'}]
main] o.s.cloud.zookeeper.sample.Application   : No active profile set, falling back to default profiles: default
main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=aa4abe82-74e1-3c1f-b0b6-9080e45640f8
main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.zookeeper.sample.Application$AppClient' of type [org.springframework.cloud.openfeign.FeignClientFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8282 (http)
main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 5621 ms
main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
main] iguration$LoadBalancerCaffeineWarnLogger : Spring Cloud LoadBalancer is currently working with the default cache. You can switch to using Caffeine cache, by adding it to the classpath.
main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8282 (http) with context path ''
main] o.s.cloud.zookeeper.sample.Application   : Started Application in 15.386 seconds (JVM running for 16.568)
main] o.s.cloud.zookeeper.sample.Application   : Current number of nodes is -> 2
</pre>

Note that we don't see the message We are started! in the server runing in the port 8282


Obs: For debuging use the command below:
<pre>
java -agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=y -jar target/london-fintech-exam-3.0.0-SNAPSHOT.jar --server.port=8181
</pre>

If you want to change the code and rebuild, just change all that you need and xecute the command below:

 - cd spring-cloud-zookeeper-sample
 - mvn -U clean package -DskipTests
