package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Stock;
import tn.esprit.Service.StockService;

@RestController
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	StockService stockService;

	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		return stocks;
	}

	@GetMapping("/retrieve-stock/{stockId}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stockId") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock c) {
		Stock stock = stockService.addStock(c);
		return stock;
	}

	@DeleteMapping("/remove-stock/{stockId}")
	@ResponseBody
	public void removeStock(@PathVariable("stockId") Long stockId) {
		stockService.deleteStock(stockId);
	}

	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}

	@GetMapping("/status-stock")
	@ResponseBody
	public void statusStock() {
		stockService.statusStock();
	}
}
