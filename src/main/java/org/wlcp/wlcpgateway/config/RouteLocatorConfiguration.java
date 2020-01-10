package org.wlcp.wlcpgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfiguration {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("wlcp-api-service",
						predicateSpec -> predicateSpec.path("/wlcp-api/**").filters(fn -> fn.stripPrefix(1))
								.uri("lb://wlcp-api"))
				.route("wlcp-transpiler-service",
						predicateSpec -> predicateSpec.path("/wlcp-transpiler/**").filters(fn -> fn.stripPrefix(1))
								.uri("lb://wlcp-transpiler"))
				.route("wlcp-gameserver-service",
						predicateSpec -> predicateSpec.path("/wlcp-gameserver/**").filters(fn -> fn.stripPrefix(1))
								.uri("lb://wlcp-gameserver"))
				.route("wlcp-ui-service", predicateSpec -> predicateSpec.path("/wlcp-ui/**")
						.filters(fn -> fn.stripPrefix(1)).uri("lb://wlcp-ui"))
				.build();
	}
}
