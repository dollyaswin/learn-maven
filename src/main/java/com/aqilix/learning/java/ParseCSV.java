package main.java.com.aqilix.learning.java;

import java.io.FileReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParseCSV {

	public static void main(String[] args) {
		String dataDir = System.getProperty("user.dir") + "/data";
		String csvFile = dataDir + "/sample.csv";
		
		try {
			Reader in = new FileReader(csvFile);
			CSVParser parse   = CSVFormat.EXCEL.withHeader().parse(in);
			Iterable<CSVRecord> records = parse.getRecords();
			
			for (CSVRecord record : records) {
				String uuid = record.get("uuid");
				String name = record.get("name");
				
				System.out.print(uuid + ": ");
				System.out.println(name);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error read CSV");
			e.printStackTrace();
	    }
	}

}
