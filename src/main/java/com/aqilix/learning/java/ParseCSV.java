package com.aqilix.learning.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParseCSV {

	public static void main(String[] args) {
		String dataDir = System.getProperty("user.dir") + "/data";
		String csvFile = dataDir + "/sample.csv";
		CSVParser csvParser = null;
		Reader in = null;
		
		try {
			in = new FileReader(csvFile);
			// set csv format
			CSVFormat csvFormat = CSVFormat.EXCEL.withHeader();
			// initialize csv parser
			csvParser = new CSVParser(in, csvFormat);
			// get csv records
			List<CSVRecord> csvRecords = csvParser.getRecords();
			
			System.out.println("Total Records: " + csvRecords.size());
			
			// iterate records
			for (CSVRecord record : csvRecords) {
				String uuid = record.get("uuid");
				String name = record.get("name");
				
				System.out.print(uuid + ": ");
				System.out.println(name);
			}
		} catch (Exception e) {
			System.err.println("Error read CSV");
			e.printStackTrace();
		}
		
		finally {
			try {
				in.close();
				csvParser.close();
			} catch (IOException e) {
				System.err.println("Error closing CSV resource");
				e.printStackTrace();
			}
		}
	}

}
