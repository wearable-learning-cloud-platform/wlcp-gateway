package org.wlcp.wlcpgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WlcpGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlcpGatewayApplication.class, args);
	}

}
