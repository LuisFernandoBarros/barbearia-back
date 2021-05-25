package com.webflux.reativo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.reativo.model.Dashboard;
import com.webflux.reativo.reposotitory.DashboardRepository;

import io.netty.util.internal.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "dashboard")
@Slf4j
public class DashboardController {

	@Autowired
	private DashboardRepository repo;
	
	@GetMapping
	public Flux<Dashboard> get() {
		return this.repo.findAll();
	}

	@GetMapping(value = "insert")
	public void save() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
		this.repo.save(Dashboard.builder().totalClientes(randomNum).build())
		.subscribe(null ,null, () -> log.info("done"));
	}

}
