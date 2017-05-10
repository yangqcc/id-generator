package com.yqc.id;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by yangqc on 2017/4/26.
 */
@SpringBootApplication
//用于注册eureka客户端
@RestController
@EnableEurekaClient
public class ServiceClientApplication {

    private static final Logger LOG = Logger.getLogger(ServiceClientApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);
    }

    /*@RequestMapping("/hi")
    public String home(@RequestParam String name) {
        LOG.log(Level.INFO, "service-client /hi");
        System.out.println(name + "*****************");
        System.out.println("this is one!");
        return "hi,my name is " + name;
    }

    @RequestMapping("/service-client")
    public String info() {
        LOG.log(Level.INFO, "service-client /service-client");
        String result = restTemplate.getForObject("http://localhost:8766/showName", String.class);
        System.out.println(result);
        return result;
    }
*/
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
