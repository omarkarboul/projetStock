package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Client;
import com.example.demo.entities.Stock;
import com.example.demo.service.IStockService;

@Controller
@RequestMapping("/stock")
@CrossOrigin
public class StockController {
	
	@Autowired
	IStockService stockservice ;
	
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks(){
		return stockservice.retrieveAllStocks();
	}
	

	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long StockId) {
	return stockservice.retrieveStock(StockId);
	}

	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s)
	{
	Stock stock = stockservice.addStock(s);
	return stock;
	}

	@PutMapping("/update-stock")
	@ResponseBody
	public Stock updateStock(@RequestBody Stock s) {
		return stockservice.updateStock(s);
	}
	
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void deleteStock(@PathVariable("stock-id") Long stockId) {
		stockservice.deleteStock(stockId);
	}
	
	@GetMapping("/retrieve-status-stocks")
	@ResponseBody
	public List<Stock> getStocksstatus(){
		return stockservice.statusofstocks();
	}
}
