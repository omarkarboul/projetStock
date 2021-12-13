package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.Stock;
import tn.esprit.Repository.StockRepository;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {

		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {

		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock stock = stockRepository.findById(id).orElse(null);
		return stock;
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);

	}

	//@Scheduled(cron = "*/60 * * * * *")
	public void statusStock() {
		List<Stock> stocks = stockRepository.statusStockRup();
		for (Stock stock : stocks) {
			log.info("le stock" + stock.getLibelleStock() + "a une quantité " + stock.getQte()
					+ " qui est inférieur à la quantité minimale " + stock.getQteMin());
		}

	}

}
