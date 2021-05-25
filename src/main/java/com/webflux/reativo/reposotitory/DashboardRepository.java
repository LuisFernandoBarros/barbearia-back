package com.webflux.reativo.reposotitory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webflux.reativo.model.Dashboard;

public interface DashboardRepository extends ReactiveMongoRepository<Dashboard, String> {
}
