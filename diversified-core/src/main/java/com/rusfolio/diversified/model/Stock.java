package com.rusfolio.diversified.model;

import java.math.BigDecimal;

import com.rusfolio.model.Sector;

public class Stock {

	private String tickerSymbol;
	private BigDecimal value;
	private Sector sector;

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Sector getSector() {
		return sector;
	}

	public void setTickerSymbol(String symbol) {
		this.tickerSymbol = symbol;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
		
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	

}
