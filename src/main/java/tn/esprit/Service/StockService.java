package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Stock;

public interface StockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	void deleteStock(Long id);

	public void statusStock();
}
