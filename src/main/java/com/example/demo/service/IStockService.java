package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Stock;

public interface IStockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
	
	void deleteStock(Long id);
	
	List<Stock> statusofstocks();
	
	
}
