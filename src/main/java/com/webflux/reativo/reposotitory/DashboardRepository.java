package com.webflux.reativo.reposotitory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webflux.reativo.model.Dashboard;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface DashboardRepository extends ReactiveMongoRepository<Dashboard, String> {

    @Tailable
    Flux<Dashboard> findAllByIdContaining(String id);
}
