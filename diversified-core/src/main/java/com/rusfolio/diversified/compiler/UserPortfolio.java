package com.rusfolio.diversified.compiler;

import java.util.ArrayList;
import java.util.List;

import com.russfolio.diversified.model.CustomerPortfolioItem;

public class UserPortfolio {

	private ArrayList<CustomerPortfolioItem> customerPortfolioItems;

	public UserPortfolio() {
		this.customerPortfolioItems = new ArrayList<CustomerPortfolioItem>();
	}

	public List<CustomerPortfolioItem> getListOfPortfolioItems() {
		return this.customerPortfolioItems;
	}

}
