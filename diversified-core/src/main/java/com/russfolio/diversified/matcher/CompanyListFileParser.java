package com.russfolio.diversified.matcher;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;
 
import au.com.bytecode.opencsv.CSVReader;

import com.russfolio.diversified.model.matcher.Company;

public class CompanyListFileParser {

	public List<Company> getCompaniesFromFile() {
		
		CSVReader reader = null;
        try
        {
            //Get the CSVReader instance with specifying the delimiter to be used
            reader = new CSVReader(new FileReader("/Users/patrickrussell100/code/AmIDiversified/diversified-core/src/main/resources/companylist.csv"),',');
            String [] nextLine;
            //Read one line at a time
            while ((nextLine = reader.readNext()) != null)
            {
                for(String token : nextLine)
                {
                    //Print all tokens
                    System.out.println(token);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
	}
	

	
}
