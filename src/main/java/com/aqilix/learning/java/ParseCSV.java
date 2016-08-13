package com.aqilix.learning.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParseCSV {

	public static void main(String[] args) {
		String dataDir = System.getProperty("user.dir") + "/data";
		String csvFile = dataDir + "/sample.csv";
		CSVParser parser = null;
		Reader in = null;
		
		try {
			in = new FileReader(csvFile);
			parser = CSVFormat.EXCEL.withHeader().parse(in);
			Iterable<CSVRecord> records = parser.getRecords();
			
			for (CSVRecord record : records) {
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
				parser.close();
			} catch (IOException e) {
				System.err.println("Error closing CSV resource");
				e.printStackTrace();
			}
		}
	}

}
