package com.russfolio.diversified.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.russfolio.diversified.model.Stock;

public class StockMapper {

    public List<Stock> mapStocks(List<ie.blogspot.russfolio.Stock> stocks) {
	ModelMapper modelMapper = new ModelMapper();
	List<Stock> stocksMapped = new ArrayList<Stock>();
	stocks.stream().forEach(stock -> stocksMapped.add(modelMapper.map(stock, Stock.class)));
	return stocksMapped;
    }

}
