package com.rusfolio.diversified.checker;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.rusfolio.diversified.model.DiversifiedResult;
import com.rusfolio.diversified.model.DiversifiedResultType;
import com.rusfolio.diversified.model.Stock;
import com.rusfolio.model.Sector;

public class DiversifiedChecker {

	public DiversifiedResult check(List<Stock> stocks) {
		DiversifiedResult result = new DiversifiedResult();
		int totalPortfolioValue = stocks
			    .stream()
			    .mapToInt(Stock::getValue)
			    .sum();
		int totalStocks = stocks.size();
		int average = totalPortfolioValue / totalStocks;
		
		Map<Sector, Integer> totalValueBySector =
			    stocks
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			                Stock::getSector,                      
			                Collectors.reducing(
			                    0,
			                    Stock::getValue,
			                    Integer::sum)));
		
		Integer maxSector = Collections.max(totalValueBySector.values());
		boolean diversified = maxSector <= average;
		if(diversified && stocks.size() >= 5){
			result.setResult(DiversifiedResultType.DIVERSIFIED);
		}else{
			result.setResult(DiversifiedResultType.NOT_DIVERSIFIED);
		}
		
		return result;
	}

}
