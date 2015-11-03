package com.russfolio.diversified;

import ie.blogspot.russfolio.DiversifiedRequest;
import ie.blogspot.russfolio.DiversifiedResponse;

import java.io.StringReader;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import com.russfolio.diversified.checker.DiversifiedChecker;
import com.russfolio.diversified.mapper.StockMapper;
import com.russfolio.diversified.matcher.SectorMatcher;
import com.russfolio.diversified.model.DiversifiedResult;
import com.russfolio.diversified.model.DiversifiedResultType;
import com.russfolio.diversified.model.Stock;

@Endpoint
public class DiversifiedEndpoint {

    private DiversifiedChecker diversifiedChecker;
    StockMapper stockMapper;
    SectorMatcher sectorMatcher;

    private static final String MESSAGE = "<message xmlns=\"http://tempuri.org\">Hello World</message>";

    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    public void setDefaultUri(String defaultUri) {
	webServiceTemplate.setDefaultUri(defaultUri);
    }

    // send to the configured default URI
    public void simpleSendAndReceive() {
	StreamSource source = new StreamSource(new StringReader(MESSAGE));
	StreamResult result = new StreamResult(System.out);
	webServiceTemplate.sendSourceAndReceiveToResult(source, result);
    }

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
