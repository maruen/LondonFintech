/*
 * Copyright 2015-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.zookeeper.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.boot.SpringApplication.run;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@RestController
@EnableFeignClients
public class Application {


	org.slf4j.Logger logger = getLogger(Application.class);

	@Value("${spring.application.name:LondonFintechApp}")
	private String appName;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired(required = false)
	private Registration registration;

	@Autowired
	private AppClient appClient;

	@RequestMapping("/")
	public ServiceInstance loadBalander() {
		return this.loadBalancer.choose(this.appName);
	}

	@RequestMapping("/hi")
	public String hi() {
		return format("Hello World! from %s", this.registration);
	}

	@RequestMapping("/self")
	public String self() {
		return this.appClient.hi();
	}

	@Bean
	@LoadBalanced
	RestTemplate loadBalancedRestTemplate()	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		run(Application.class, args);
	}

	@RequestMapping("/instances")
	public Integer getNumberOfNodes() {
		List<ServiceInstance> list = discoveryClient.getInstances("LondonFintechApp");
		return list.size();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		Integer nodes = getNumberOfNodes();
		logger.info(format("Current number of nodes is -> %s", nodes));
		if (nodes == 1) {
			logger.info("We are started!");
		}
	}

	@FeignClient("LondonFintechApp")
	interface AppClient {
		@RequestMapping(path = "/hi", method = GET)
		String hi();
	}



}
