package com.webflux.reativo.controller;

import com.webflux.reativo.model.Dashboard;
import com.webflux.reativo.reposotitory.DashboardRepository;
import io.netty.util.internal.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping(value = "dashboard")
@Slf4j
public class DashboardController {

	@Autowired
	private DashboardRepository repo;
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dashboard> get() {
		//return this.repo.findAll().delayElements(Duration.ofMillis(1000));
		return this.repo.findAllByIdContaining("a").delayElements(Duration.ofMillis(1000));
	}

	@GetMapping(value = "insert")
	public void save() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
		this.repo.save(Dashboard.builder().totalClientes(randomNum).build())
		.subscribe(null ,null, () -> log.info("done"));
	}

}
