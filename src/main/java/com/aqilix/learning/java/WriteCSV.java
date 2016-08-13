package com.aqilix.learning.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

class Item {
	private String uuid;
	
	private String name;
	
	public Item(String uuid, String name) {
		this.setUuid(uuid);
		this.setName(name);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getUuid() + ": " + this.getName();
	}
	
}

public class WriteCSV {

	public static void main(String[] args) {
		Map<String, String> itemsData = new HashMap<String, String>();
		List<Item> items = new ArrayList<Item>(); 
		
		// define data
		itemsData.put("be3cffc6fd234341afadcd087fc63a98", "iMac 29\"");
		itemsData.put("cda9efc6fd234341afadcd0d223c3a4b", "IBM Thinkpad X15");
		itemsData.put("b49fefc6fd283749afadcd0d223cbf45", "Mac Book Pro MD 103");
		itemsData.put("c78fefc6fd283749afadcd0d223c9b4f", "Dell Latitude XPS");
		itemsData.put("a8fcefc6fd234338fcadcd0d223b5fca", "Dell Inspiron 1584");
		itemsData.put("b3cd2fc6fd234341af1b8fcd298bf4ca", "HP Pavilion X74");
		itemsData.put("eb34cfc6fd234341af1b8fcd2083dcab", "Raspberry Model A");
		itemsData.put("f3ac4fc6fd234341af1b8fcd22909ac8", "Raspberry Model B");
		itemsData.put("f84fcfc6fd234341af1b8fc98c3fe3bb", "Raspberry Model B+");
		itemsData.put("aa6484c6fd234341af1b8ff2cb384cf8", "Acer Inspire X190");
		
		// initialize object
		for (Map.Entry<String, String> entry: itemsData.entrySet()) {
			Item item = new Item(entry.getKey(), entry.getValue());
			items.add(item);
		}
		
		// define file system
		String dataDir = System.getProperty("user.dir") + "/data";
		String csvFile = dataDir + "/result.csv";
		// define csv writer
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat   = CSVFormat.EXCEL.withRecordSeparator(System.getProperty("line.separator"));
		
		try {
			fileWriter = new FileWriter(csvFile);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			
			// iterate contents
			for (Item item : items) {
				List<String> record = new ArrayList<String>();
				record.add(item.getUuid());
				record.add(item.getName());
				csvFilePrinter.printRecord(record);
			}
			
			System.out.println("Write to csv success!");
		} catch (Exception e) {
			System.err.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		}
		
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				System.err.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
			}
		}
		
	}

}
