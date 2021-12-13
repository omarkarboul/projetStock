package tn.esprit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Entity.Stock;
import tn.esprit.Service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	StockService stockService;

	@Test
	public void testAddStock() {
		Stock s = new Stock(10, 100, "Stock Test");
		Stock savedStock = stockService.addStock(s);
		assertNotNull(savedStock.getLibelleStock());
	}

	@Test
	public void DeleteTest() {

		Stock s = new Stock(10, 100, "Stock Test");
		Stock savedStock = stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNotNull(savedStock.getLibelleStock());

	}
}
