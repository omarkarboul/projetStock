package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.IStockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImpTest {

	@Autowired
	StockRepository stockrepo;
	@Autowired
	IStockService stockService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAddStock() {
//	List<Stock> stocks = stockService.retrieveAllStocks();
//	int expected=stocks.size();
	Stock s = new Stock(10, 100, "stock test");
	Stock savedStock= stockService.addStock(s);
	assertNotNull(savedStock.getIdStock());
	assertNotNull(savedStock.getLibelleStock());
	assertNotNull(savedStock.getQte());
	assertNotNull(savedStock.getQteMin());
	stockService.deleteStock(savedStock.getIdStock());
}
	
	@Test
	public void testReadAll() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		assertThat(stocks).size().isGreaterThan(0);
	}
	
	@Test
	public void testdeleteStock() {
		Stock s = new Stock(1, 2, "test stock");
		Stock savedStock= stockService.addStock(s);
		stockrepo.delete(savedStock);
		assertNotNull(stockrepo.findById(savedStock.getIdStock()));
	}
}
