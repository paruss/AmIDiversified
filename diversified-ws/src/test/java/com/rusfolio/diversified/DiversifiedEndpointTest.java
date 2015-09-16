package com.rusfolio.diversified;

import static org.assertj.core.api.StrictAssertions.assertThat;
import ie.blogspot.russfolio.DiversifiedRequest;
import ie.blogspot.russfolio.DiversifiedResponse;
import ie.blogspot.russfolio.Stock;

import org.junit.Test;

public class DiversifiedEndpointTest {

    @Test
    public void testOneStockNotDiversified() {
	DiversifiedEndpoint endpoint = new DiversifiedEndpoint();
	DiversifiedRequest diversifiedRequest = new DiversifiedRequest();
	Stock stock = new Stock();
	stock.setName("Apple");
	stock.setTickerSymbol("AAPL");
	diversifiedRequest.getStocks().add(stock);
	DiversifiedResponse isDiversifiedResponse = endpoint.getDiversified(diversifiedRequest);
	assertThat(isDiversifiedResponse.isDiversified()).isFalse();
    }
}
