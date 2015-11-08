package com.russfolio.diversified.matcher;

import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;

import com.russfolio.diversified.matcher.CompanyListFileParser;
import com.russfolio.diversified.model.matcher.Company;

public class CompanyListParserTest {
	@Test
	public void fileParsedCorrectly() throws IOException{
		List<Company> companyList = new ArrayList<Company>();
		CompanyListFileParser listParser = new CompanyListFileParser();
		companyList = listParser.getCompaniesFromFile();
		assertThat(companyList.size()).isGreaterThan(0);
	}
}
