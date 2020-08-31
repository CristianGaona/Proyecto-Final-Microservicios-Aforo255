package afor255.ms.test.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Aforo255MsTestConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aforo255MsTestConfigServerApplication.class, args);
	}

}
