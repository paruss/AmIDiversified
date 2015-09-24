package com.russfolio.diversified;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import ie.blogspot.russfolio.DiversifiedRequest;
import ie.blogspot.russfolio.DiversifiedResponse;
import ie.blogspot.russfolio.Stock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.russfolio.diversified.matcher.SectorMatcher;
import com.russfolio.diversified.model.Sector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:build-test.xml")
public class DiversifiedEndpointTest {

    @Autowired
    private DiversifiedEndpoint endpoint;

    @Test
    public void testOneStockNotDiversified() {
	DiversifiedRequest diversifiedRequest = new DiversifiedRequest();
	Stock stock = new Stock();
	stock.setName("Apple");
	stock.setTickerSymbol("AAPL");
	stock.setValue(100);
	diversifiedRequest.getStocks().add(stock);
	SectorMatcher sectorMatcher = Mockito.mock(SectorMatcher.class);
	List<com.russfolio.diversified.model.Stock> stocksWithSectors = new ArrayList<com.russfolio.diversified.model.Stock>();
	com.russfolio.diversified.model.Stock stockWithSector = new com.russfolio.diversified.model.Stock();
	stockWithSector.setSector(Sector.CONSUMER_DISCRETIONARY);
	stockWithSector.setTickerSymbol("AAPL");
	stockWithSector.setValue(100);
	stocksWithSectors.add(stockWithSector);
	when(sectorMatcher.getStocksWithSector(any())).thenReturn(stocksWithSectors);
	endpoint.setSectorMatcher(sectorMatcher);
	DiversifiedResponse isDiversifiedResponse = endpoint.getDiversified(diversifiedRequest);
	assertThat(isDiversifiedResponse.isDiversified()).isFalse();
    }

    @Test
    public void testFiveStocksDiversified() {
	DiversifiedRequest diversifiedRequest = new DiversifiedRequest();
	Stock stock = new Stock();
	stock.setName("Apple");
	stock.setTickerSymbol("AAPL");
	stock.setValue(100);
	Stock stock1 = new Stock();
	stock.setName("Boeing");
	stock.setTickerSymbol("BA");
	stock.setValue(100);
	Stock stock2 = new Stock();
	stock.setName("Skechers");
	stock.setTickerSymbol("SKX");
	stock.setValue(100);
	Stock stock3 = new Stock();
	stock.setName("Isis Pharamcuticals");
	stock.setTickerSymbol("ISIS");
	stock.setValue(100);
	Stock stock4 = new Stock();
	stock.setName("Dominos Pizza");
	stock.setTickerSymbol("DPZ");
	stock.setValue(100);
	diversifiedRequest.getStocks().add(stock);
	diversifiedRequest.getStocks().add(stock1);
	diversifiedRequest.getStocks().add(stock2);
	diversifiedRequest.getStocks().add(stock3);
	diversifiedRequest.getStocks().add(stock4);
	SectorMatcher sectorMatcher = Mockito.mock(SectorMatcher.class);
	List<com.russfolio.diversified.model.Stock> stocksWithSectors = new ArrayList<com.russfolio.diversified.model.Stock>();
	com.russfolio.diversified.model.Stock stockWithSector = new com.russfolio.diversified.model.Stock();
	stockWithSector.setSector(Sector.TECHNOLOGY);
	stockWithSector.setTickerSymbol("AAPL");
	stockWithSector.setValue(100);
	stocksWithSectors.add(stockWithSector);
	com.russfolio.diversified.model.Stock stockWithSector1 = new com.russfolio.diversified.model.Stock();
	stockWithSector1.setSector(Sector.CONSUMER_DISCRETIONARY);
	stockWithSector1.setTickerSymbol("SKX");
	stockWithSector1.setValue(100);
	stocksWithSectors.add(stockWithSector1);
	com.russfolio.diversified.model.Stock stockWithSector2 = new com.russfolio.diversified.model.Stock();
	stockWithSector2.setSector(Sector.HEALTH);
	stockWithSector2.setTickerSymbol("ISIS");
	stockWithSector2.setValue(100);
	stocksWithSectors.add(stockWithSector2);
	com.russfolio.diversified.model.Stock stockWithSector3 = new com.russfolio.diversified.model.Stock();
	stockWithSector3.setSector(Sector.UTILITIES);
	stockWithSector3.setTickerSymbol("DPZ");
	stockWithSector3.setValue(100);
	com.russfolio.diversified.model.Stock stockWithSector4 = new com.russfolio.diversified.model.Stock();
	stockWithSector4.setSector(Sector.INDUSTRIAL);
	stockWithSector4.setTickerSymbol("BA");
	stockWithSector4.setValue(100);
	stocksWithSectors.add(stockWithSector4);
	stocksWithSectors.add(stockWithSector3);
	when(sectorMatcher.getStocksWithSector(any())).thenReturn(stocksWithSectors);
	endpoint.setSectorMatcher(sectorMatcher);
	DiversifiedResponse isDiversifiedResponse = endpoint.getDiversified(diversifiedRequest);
	assertThat(isDiversifiedResponse.isDiversified()).isTrue();
    }

    @Test
    public void testFiveStocksNotDiversified() {
	DiversifiedRequest diversifiedRequest = new DiversifiedRequest();
	Stock stock = new Stock();
	stock.setName("Apple");
	stock.setTickerSymbol("AAPL");
	stock.setValue(100);
	Stock stock1 = new Stock();
	stock.setName("Boeing");
	stock.setTickerSymbol("BA");
	stock.setValue(100);
	Stock stock2 = new Stock();
	stock.setName("Skechers");
	stock.setTickerSymbol("SKX");
	stock.setValue(100);
	Stock stock3 = new Stock();
	stock.setName("Isis Pharamcuticals");
	stock.setTickerSymbol("ISIS");
	stock.setValue(100);
	Stock stock4 = new Stock();
	stock.setName("Dominos Pizza");
	stock.setTickerSymbol("DPZ");
	stock.setValue(100);
	diversifiedRequest.getStocks().add(stock);
	diversifiedRequest.getStocks().add(stock1);
	diversifiedRequest.getStocks().add(stock2);
	diversifiedRequest.getStocks().add(stock3);
	diversifiedRequest.getStocks().add(stock4);
	SectorMatcher sectorMatcher = Mockito.mock(SectorMatcher.class);
	List<com.russfolio.diversified.model.Stock> stocksWithSectors = new ArrayList<com.russfolio.diversified.model.Stock>();
	com.russfolio.diversified.model.Stock stockWithSector = new com.russfolio.diversified.model.Stock();
	stockWithSector.setSector(Sector.TECHNOLOGY);
	stockWithSector.setTickerSymbol("AAPL");
	stockWithSector.setValue(100);
	stocksWithSectors.add(stockWithSector);
	com.russfolio.diversified.model.Stock stockWithSector1 = new com.russfolio.diversified.model.Stock();
	stockWithSector1.setSector(Sector.CONSUMER_DISCRETIONARY);
	stockWithSector1.setTickerSymbol("SKX");
	stockWithSector1.setValue(100);
	stocksWithSectors.add(stockWithSector1);
	com.russfolio.diversified.model.Stock stockWithSector2 = new com.russfolio.diversified.model.Stock();
	stockWithSector2.setSector(Sector.HEALTH);
	stockWithSector2.setTickerSymbol("ISIS");
	stockWithSector2.setValue(100);
	stocksWithSectors.add(stockWithSector2);
	com.russfolio.diversified.model.Stock stockWithSector3 = new com.russfolio.diversified.model.Stock();
	stockWithSector3.setSector(Sector.INDUSTRIAL);
	stockWithSector3.setTickerSymbol("DPZ");
	stockWithSector3.setValue(100);
	com.russfolio.diversified.model.Stock stockWithSector4 = new com.russfolio.diversified.model.Stock();
	stockWithSector4.setSector(Sector.INDUSTRIAL);
	stockWithSector4.setTickerSymbol("BA");
	stockWithSector4.setValue(100);
	stocksWithSectors.add(stockWithSector4);
	stocksWithSectors.add(stockWithSector3);
	when(sectorMatcher.getStocksWithSector(any())).thenReturn(stocksWithSectors);
	endpoint.setSectorMatcher(sectorMatcher);
	DiversifiedResponse isDiversifiedResponse = endpoint.getDiversified(diversifiedRequest);
	assertThat(isDiversifiedResponse.isDiversified()).isFalse();
    }
}
