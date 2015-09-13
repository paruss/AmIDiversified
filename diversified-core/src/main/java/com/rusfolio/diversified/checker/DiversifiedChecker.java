package com.rusfolio.diversified.checker;

import java.util.List;

import com.rusfolio.diversified.model.DiversifiedResult;
import com.rusfolio.diversified.model.Stock;

public class DiversifiedChecker {

	public DiversifiedResult check(List<Stock> stocks) {
		DiversifiedResult result = new DiversifiedResult();
		result.setResult(DiversifiedResult.DiversifiedResultType.NOT_DIVERSIFIED);
		return result;
	}

}
