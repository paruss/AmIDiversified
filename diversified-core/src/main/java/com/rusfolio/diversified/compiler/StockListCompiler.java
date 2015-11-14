package com.rusfolio.diversified.compiler;

import java.util.List;

import com.russfolio.diversified.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;

public class StockListCompiler {
	
	@Autowired
	CompanyList companyList;

	public List<Stock> compile(UserPortfolio userPortfolio) {
	}

}
