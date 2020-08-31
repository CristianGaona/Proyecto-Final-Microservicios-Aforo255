package afor255.ms.test.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Aforo255MsTestGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aforo255MsTestGatewayApplication.class, args);
	}

}
