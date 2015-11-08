package com.russfolio.diversified.matcher;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.russfolio.diversified.model.matcher.Company;

public class CompanyListFileParser {

	public List<Company> getCompaniesFromFile() throws IOException {

		Reader reader = new FileReader(
				"/Users/patrickrussell100/code/AmIDiversified/diversified-core/src/main/resources/companylist.csv");
		CSVStrategy strategy = CSVStrategy.UK_DEFAULT;
		CSVReader<Company> csvCompanyReader = new CSVReaderBuilder<Company>(reader)
				.entryParser(new CompanyItemParser()).strategy(strategy ).build();
		List<Company> companies = csvCompanyReader.readAll();

		return companies;
	}
	

	
}
