package com.russfolio.diversified;

import ie.blogspot.russfolio.DiversifiedRequest;
import ie.blogspot.russfolio.DiversifiedResponse;

import java.util.List;

import com.russfolio.diversified.checker.DiversifiedChecker;
import com.russfolio.diversified.mapper.StockMapper;
import com.russfolio.diversified.matcher.SectorMatcher;
import com.russfolio.diversified.model.DiversifiedResult;
import com.russfolio.diversified.model.DiversifiedResultType;
import com.russfolio.diversified.model.Stock;

public class DiversifiedEndpoint {

    private DiversifiedChecker diversifiedChecker;
    StockMapper stockMapper;
    SectorMatcher sectorMatcher;

    public DiversifiedResponse getDiversified(DiversifiedRequest diversifiedRequest) {
	DiversifiedResponse response = new DiversifiedResponse();
	List<Stock> stocks = stockMapper.mapStocks(diversifiedRequest.getStocks());
	List<Stock> stocksWithSector = sectorMatcher.getStocksWithSector(stocks);
	DiversifiedResult result = diversifiedChecker.check(stocksWithSector);
	response.setDiversified(result.getResult() == DiversifiedResultType.DIVERSIFIED);
	return response;
    }

    public void setDiversifiedChecker(DiversifiedChecker diversifiedChecker) {
	this.diversifiedChecker = diversifiedChecker;
    }

    public void setStockMapper(StockMapper stockMapper) {
	this.stockMapper = stockMapper;
    }

    public void setSectorMatcher(SectorMatcher sectorMatcher) {
	this.sectorMatcher = sectorMatcher;
    }
}
