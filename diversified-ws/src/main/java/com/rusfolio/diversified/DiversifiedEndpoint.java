package com.rusfolio.diversified;

import ie.blogspot.russfolio.DiversifiedRequest;
import ie.blogspot.russfolio.DiversifiedResponse;

import java.util.ArrayList;
import java.util.List;

import com.rusfolio.diversified.checker.DiversifiedChecker;
import com.rusfolio.diversified.model.Stock;

public class DiversifiedEndpoint {

    private DiversifiedChecker diversifiedChecker;

    public DiversifiedResponse getDiversified(DiversifiedRequest diversifiedRequest) {
	DiversifiedResponse response = new DiversifiedResponse();
	List<Stock> stocks = new ArrayList<Stock>();

	// diversifiedChecker.check(stocks);
	response.setDiversified(false);
	return response;
    }
}
