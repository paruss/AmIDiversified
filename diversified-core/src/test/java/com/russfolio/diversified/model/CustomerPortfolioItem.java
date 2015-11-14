package com.russfolio.diversified.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class CustomerPortfolioItem {
	
	@Setter @Getter
	String symbol;
	@Setter @Getter
	BigDecimal value;

}
