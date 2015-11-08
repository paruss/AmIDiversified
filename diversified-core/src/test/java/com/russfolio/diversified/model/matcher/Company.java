package com.russfolio.diversified.model.matcher;

import com.russfolio.diversified.model.Sector;

import lombok.Getter;
import lombok.Setter;

public class Company {
	
	@Getter @Setter
	private String symbol;
	@Getter @Setter
	private Sector sector;

	public Company(String symbol, String sector) {
		this.symbol = symbol;
		this.sector = Sector.valueOf(sector);
	}

}
