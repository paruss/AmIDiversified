package com.russfolio.diversified.matcher;

import com.googlecode.jcsv.reader.CSVEntryParser;
import com.russfolio.diversified.model.matcher.Company;

public class CompanyItemParser implements CSVEntryParser<Company> {
        public Company parseEntry(String... data) {
                String symbol = data[0];
                String sector = data[5];
                return new Company(symbol, sector);
        }
}