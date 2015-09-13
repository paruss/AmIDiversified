package com.rusfolio.diversified_core;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rusfolio.diversified.checker.DiversifiedChecker;
import com.rusfolio.diversified.model.DiversifiedResult;
import com.rusfolio.diversified.model.DiversifiedResultType;
import com.rusfolio.diversified.model.Stock;
import com.rusfolio.model.Sector;


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
		Integer thousandDollars = new Integer(1000);
		Sector techSector = Sector.TECHNOLOGY;
		stock.setTickerSymbol(appleSymbol);
		stock.setValue(thousandDollars);
		stock.setSector(techSector);
		stocks.add(stock);
		DiversifiedResult result = diversifiedChecker.check(stocks);
		assertEquals(result.getResult(), DiversifiedResultType.NOT_DIVERSIFIED);
	}
	
	@Test
	public void test6StocksThousandDollarsDiversified(){
		List<Stock> stocks = new ArrayList<Stock>();
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		Stock stock4 = new Stock();
		Stock stock5 = new Stock();
		Stock stock6 = new Stock();
		String appleSymbol = "AAPL";
		Integer thousandDollars = new Integer(1000);
		stock1.setTickerSymbol(appleSymbol);
		stock1.setValue(thousandDollars);
		stock1.setSector(Sector.TECHNOLOGY);
		
		String boeingSymbol = "BA";
		String skechersSymbol = "SKX";
		String isisSymbol = "ISIS";
		String dominosSymbol = "DPZ";
		String schlumbergerSymbol = "SLB";
				
		stock2.setTickerSymbol(boeingSymbol );
		stock2.setValue(thousandDollars);
		stock2.setSector(Sector.INDUSTRIAL);

		stock3.setTickerSymbol(skechersSymbol);
		stock3.setValue(thousandDollars);
		stock3.setSector(Sector.CONSUMER_DISCRETIONARY);
		
		stock4.setTickerSymbol(isisSymbol);
		stock4.setValue(thousandDollars);
		stock4.setSector(Sector.HEALTH);
		
		stock5.setTickerSymbol(dominosSymbol);
		stock5.setValue(thousandDollars);
		stock5.setSector(Sector.CONSUMER_DISCRETIONARY);
		
		stock6.setTickerSymbol(schlumbergerSymbol);
		stock6.setValue(thousandDollars);
		stock6.setSector(Sector.ENERGY);
		
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		stocks.add(stock4);
		stocks.add(stock5);
		stocks.add(stock6);
		
		DiversifiedResult result = diversifiedChecker.check(stocks);
		assertEquals(result.getResult(), DiversifiedResultType.DIVERSIFIED);
		
	}
}
