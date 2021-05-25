package com.webflux.reativo.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "dashboard")
@Builder
public class Dashboard {
	
    @Id
    private String id;
    
    @NotNull
    private int totalClientes;	

}
