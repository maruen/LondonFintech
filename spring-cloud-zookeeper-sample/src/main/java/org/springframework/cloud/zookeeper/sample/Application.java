package org.springframework.cloud.zookeeper.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@RestController
@EnableFeignClients
public class Application {

	@Value("${spring.application.name:LondonFintechApp}")
	private String appName;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired(required = false)
	private Registration registration;

	@RequestMapping("/")
	public ServiceInstance lb() {
		return this.loadBalancer.choose(this.appName);
	}

	@RequestMapping("/hi")
	public String hi() {
		return "Hello World! from " + this.registration;
	}

	@Bean
	@LoadBalanced
	RestTemplate loadBalancedRestTemplate()	{
		return new RestTemplate();
	}

	@FeignClient("LondonFintechApp")
	interface AppClient {
		@RequestMapping(path = "/hi", method = RequestMethod.GET)
		String hi();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/instances")
	public Integer getNumberOfNodes() {
		List<ServiceInstance> list = discoveryClient.getInstances("LondonFintechApp");
		return list.size();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		Integer nodes = getNumberOfNodes();
		System.out.println(String.format("Current number of nodes is -> %s", nodes));
		if (nodes == 1) {
			System.out.println("We are started!");
		}
	}



}
