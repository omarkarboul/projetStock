package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Stock;
import com.example.demo.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImp implements IStockService {

	@Autowired
	StockRepository stockrepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		return stockrepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		stockrepository.save(s);
		return s;
	}

	@Override
	public Stock updateStock(Stock u) {
		return stockrepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockrepository.findById(id).get();
	}

	@Override
	public void deleteStock(Long id) {
		stockrepository.deleteById(id);

	}

	@Override
	public List<Stock> statusofstocks() {
		return stockrepository.statusofstocks();
	}

	//@Scheduled(fixedRate = 60000)
	public void verifstatusstock() {
		List<Stock> lst = stockrepository.statusofstocks();
		for (Stock s : lst) {
			log.info("le produit dont l id " + s.getIdStock() + " à depasser la qte min :" + s.getQteMin());
		}
	}

}
