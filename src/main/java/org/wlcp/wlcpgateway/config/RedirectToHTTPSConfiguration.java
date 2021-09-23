package org.wlcp.wlcpgateway.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;

import reactor.core.publisher.Mono;

@Configuration
public class RedirectToHTTPSConfiguration {
	
	@Profile("ecs")
	@Bean
	public void startRedirectServer() {
		NettyReactiveWebServerFactory httpNettyReactiveWebServerFactory = new NettyReactiveWebServerFactory(80);
		httpNettyReactiveWebServerFactory.getWebServer((request, response) -> {
			URI uri = request.getURI();
			URI httpsUri;
			try {
				httpsUri = new URI("https", uri.getUserInfo(), uri.getHost(), 443, uri.getPath(), uri.getQuery(),
						uri.getFragment());
			} catch (URISyntaxException e) {
				return Mono.error(e);
			}
			response.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
			response.getHeaders().setLocation(httpsUri);
			return response.setComplete();
		}).start();
	}

}
