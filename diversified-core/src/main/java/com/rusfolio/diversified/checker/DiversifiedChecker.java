package com.rusfolio.diversified.checker;

import java.util.List;

import com.rusfolio.diversified.model.DiversifiedResult;
import com.rusfolio.diversified.model.DiversifiedResultType;
import com.rusfolio.diversified.model.Stock;

public class DiversifiedChecker {

	public DiversifiedResult check(List<Stock> stocks) {
		DiversifiedResult result = new DiversifiedResult();
		int totalPortfolioValue = stocks
			    .stream()
			    .mapToInt(Stock::getValue)
			    .sum();
		int totalStocks = stocks.size();
		int average = totalPortfolioValue / totalStocks;
		boolean notDiversified =
				stocks.stream()
			                .allMatch(t -> t.getValue() > average);
		if(!notDiversified && totalStocks >= 5){
			result.setResult(DiversifiedResultType.DIVERSIFIED);
		}else{
			result.setResult(DiversifiedResultType.NOT_DIVERSIFIED);
		}
		
		return result;
	}

}
