package com.russfolio.diversified.matcher;

import java.util.List;

import com.russfolio.diversified.model.Sector;
import com.russfolio.diversified.model.Stock;

public class SectorMatcher {

	public List<Stock> getStocksWithSector(List<Stock> stocks) {
		stocks.stream().forEach(stock -> stock.setSector(Sector.CONSUMER_DISCRETIONARY));
		return stocks;
		//todo implement functionality to match the stock to sector.
	}

}
