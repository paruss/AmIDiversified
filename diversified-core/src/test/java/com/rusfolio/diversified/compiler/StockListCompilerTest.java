package com.rusfolio.diversified.compiler;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.russfolio.diversified.model.CustomerPortfolioItem;

public class StockListCompilerTest {
	
	@Autowired
	StockListCompiler stockListCompiler;
	
	@Test
	public void testStockListCompiledApple(){
		UserPortfolio userPortfolio = new UserPortfolio();
		CustomerPortfolioItem customerPortfolioItem = new CustomerPortfolioItem();
		customerPortfolioItem.setSymbol("aapl");
		customerPortfolioItem.setValue(new BigDecimal(1000));
		userPortfolio.getListOfPortfolioItems().add(customerPortfolioItem);
		stockListCompiler.compile(userPortfolio);
	}

}
