package com.webflux.reativo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**");
	}
}