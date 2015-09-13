package com.rusfolio.diversified_core;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.rusfolio.diversified.checker.DiversifiedChecker;
import com.rusfolio.diversified.model.DiversifiedResult;
import com.rusfolio.diversified.model.Stock;
import com.rusfolio.model.Sector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:build-test.xml")

public class AmIDiversifiedTest {
	
	@Autowired
	private DiversifiedChecker diversifiedChecker;

	@Test
	public void testHasOneStockNotDiversified() {
		List<Stock> stocks = new ArrayList<Stock>();
		Stock stock = new Stock();
		String appleSymbol = "AAPL";
		BigDecimal thousandDollars = new BigDecimal(1000);
		Sector techSector = Sector.TECHNOLOGY;
		stock.setTickerSymbol(appleSymbol);
		stock.setValue(thousandDollars);
		stock.setSector(techSector);
		stocks.add(stock);
		DiversifiedResult result = diversifiedChecker.check(stocks);
		assertEquals(result.getResult(), DiversifiedResult.DiversifiedResultType.NOT_DIVERSIFIED);
	}
}
