package crptest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.*;
import jxl.read.biff.BiffException;

public class CrapsStrategy {
	private Workbook workbook;
	private Sheet sheet;
	private Map<String, String> strategy;
	
	public CrapsStrategy(String filename) {
		try {
			workbook = Workbook.getWorkbook(new File(filename));
		} catch (BiffException e) {
			e.printStackTrace();
			System.exit(-11);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-12);
		}
		
		strategy = new HashMap<String, String>();
		readSheet();
		writeStrategy();
	}
	
	/**
	 * Method that retrieves the Excel document for reading.
	 */
	public void readSheet() {
		try {
			sheet = workbook.getSheet(0);
		} catch (Exception e) {
			System.err.println("Error when retrieving sheet from Excel document.");
			System.exit(-13);
		}
	}
	
	/**
	 * Method that reads each cell from the provided Excel document and imports it into the Table strategy.
	 */
	public void writeStrategy() {
		try {
		strategy.put("None", sheet.getCell(0, 0).getContents());
		strategy.put("C4", sheet.getCell(0, 1).getContents());
		strategy.put("C5", sheet.getCell(0, 2).getContents());
		strategy.put("C6", sheet.getCell(0, 3).getContents());
		strategy.put("C8", sheet.getCell(0, 4).getContents());
		strategy.put("C9", sheet.getCell(0, 5).getContents());
		strategy.put("C10", sheet.getCell(0, 6).getContents());
		strategy.put("C4C5", sheet.getCell(0, 7).getContents());
		strategy.put("C4C6", sheet.getCell(0, 8).getContents());
		strategy.put("C4C8", sheet.getCell(0, 9).getContents());
		strategy.put("C4C9", sheet.getCell(0, 10).getContents());
		strategy.put("C4C10", sheet.getCell(0, 11).getContents());
		strategy.put("C5C6", sheet.getCell(0, 12).getContents());
		strategy.put("C5C8", sheet.getCell(0, 13).getContents());
		strategy.put("C5C9", sheet.getCell(0, 14).getContents());
		strategy.put("C5C10", sheet.getCell(0, 15).getContents());
		strategy.put("C6C8", sheet.getCell(0, 16).getContents());
		strategy.put("C6C9", sheet.getCell(0, 17).getContents());
		strategy.put("C6C10", sheet.getCell(0, 18).getContents());
		strategy.put("C8C9", sheet.getCell(0, 19).getContents());
		strategy.put("C8C10", sheet.getCell(0, 20).getContents());
		strategy.put("C9C10", sheet.getCell(0, 21).getContents());
		
		strategy.put("D4", sheet.getCell(1, 0).getContents());
		strategy.put("D4C4", sheet.getCell(1, 1).getContents());
		strategy.put("D4C5", sheet.getCell(1, 2).getContents());
		strategy.put("D4C6", sheet.getCell(1, 3).getContents());
		strategy.put("D4C8", sheet.getCell(1, 4).getContents());
		strategy.put("D4C9", sheet.getCell(1, 5).getContents());
		strategy.put("D4C10", sheet.getCell(1, 6).getContents());
		strategy.put("D4C4C5", sheet.getCell(1, 7).getContents());
		strategy.put("D4C4C6", sheet.getCell(1, 8).getContents());
		strategy.put("D4C4C8", sheet.getCell(1, 9).getContents());
		strategy.put("D4C4C9", sheet.getCell(1, 10).getContents());
		strategy.put("D4C4C10", sheet.getCell(1, 11).getContents());
		strategy.put("D4C5C6", sheet.getCell(1, 12).getContents());
		strategy.put("D4C5C8", sheet.getCell(1, 13).getContents());
		strategy.put("D4C5C9", sheet.getCell(1, 14).getContents());
		strategy.put("D4C5C10", sheet.getCell(1, 15).getContents());
		strategy.put("D4C6C8", sheet.getCell(1, 16).getContents());
		strategy.put("D4C6C9", sheet.getCell(1, 17).getContents());
		strategy.put("D4C6C10", sheet.getCell(1, 18).getContents());
		strategy.put("D4C8C9", sheet.getCell(1, 19).getContents());
		strategy.put("D4C8C10", sheet.getCell(1, 20).getContents());
		strategy.put("D4C9C10", sheet.getCell(1, 21).getContents());
		
		strategy.put("D5", sheet.getCell(2, 0).getContents());
		strategy.put("D5C4", sheet.getCell(2, 1).getContents());
		strategy.put("D5C5", sheet.getCell(2, 2).getContents());
		strategy.put("D5C6", sheet.getCell(2, 3).getContents());
		strategy.put("D5C8", sheet.getCell(2, 4).getContents());
		strategy.put("D5C9", sheet.getCell(2, 5).getContents());
		strategy.put("D5C10", sheet.getCell(2, 6).getContents());
		strategy.put("D5C4C5", sheet.getCell(2, 7).getContents());
		strategy.put("D5C4C6", sheet.getCell(2, 8).getContents());
		strategy.put("D5C4C8", sheet.getCell(2, 9).getContents());
		strategy.put("D5C4C9", sheet.getCell(2, 10).getContents());
		strategy.put("D5C4C10", sheet.getCell(2, 11).getContents());
		strategy.put("D5C5C6", sheet.getCell(2, 12).getContents());
		strategy.put("D5C5C8", sheet.getCell(2, 13).getContents());
		strategy.put("D5C5C9", sheet.getCell(2, 14).getContents());
		strategy.put("D5C5C10", sheet.getCell(2, 15).getContents());
		strategy.put("D5C6C8", sheet.getCell(2, 16).getContents());
		strategy.put("D5C6C9", sheet.getCell(2, 17).getContents());
		strategy.put("D5C6C10", sheet.getCell(2, 18).getContents());
		strategy.put("D5C8C9", sheet.getCell(2, 19).getContents());
		strategy.put("D5C8C10", sheet.getCell(2, 20).getContents());
		strategy.put("D5C9C10", sheet.getCell(2, 21).getContents());
		
		strategy.put("D6", sheet.getCell(3, 0).getContents());
		strategy.put("D6C4", sheet.getCell(3, 1).getContents());
		strategy.put("D6C5", sheet.getCell(3, 2).getContents());
		strategy.put("D6C6", sheet.getCell(3, 3).getContents());
		strategy.put("D6C8", sheet.getCell(3, 4).getContents());
		strategy.put("D6C9", sheet.getCell(3, 5).getContents());
		strategy.put("D6C10", sheet.getCell(3, 6).getContents());
		strategy.put("D6C4C5", sheet.getCell(3, 7).getContents());
		strategy.put("D6C4C6", sheet.getCell(3, 8).getContents());
		strategy.put("D6C4C8", sheet.getCell(3, 9).getContents());
		strategy.put("D6C4C9", sheet.getCell(3, 10).getContents());
		strategy.put("D6C4C10", sheet.getCell(3, 11).getContents());
		strategy.put("D6C5C6", sheet.getCell(3, 12).getContents());
		strategy.put("D6C5C8", sheet.getCell(3, 13).getContents());
		strategy.put("D6C5C9", sheet.getCell(3, 14).getContents());
		strategy.put("D6C5C10", sheet.getCell(3, 15).getContents());
		strategy.put("D6C6C8", sheet.getCell(3, 16).getContents());
		strategy.put("D6C6C9", sheet.getCell(3, 17).getContents());
		strategy.put("D6C6C10", sheet.getCell(3, 18).getContents());
		strategy.put("D6C8C9", sheet.getCell(3, 19).getContents());
		strategy.put("D6C8C10", sheet.getCell(3, 20).getContents());
		strategy.put("D6C9C10", sheet.getCell(3, 21).getContents());
		
		strategy.put("D8", sheet.getCell(4, 0).getContents());
		strategy.put("D8C4", sheet.getCell(4, 1).getContents());
		strategy.put("D8C5", sheet.getCell(4, 2).getContents());
		strategy.put("D8C6", sheet.getCell(4, 3).getContents());
		strategy.put("D8C8", sheet.getCell(4, 4).getContents());
		strategy.put("D8C9", sheet.getCell(4, 5).getContents());
		strategy.put("D8C10", sheet.getCell(4, 6).getContents());
		strategy.put("D8C4C5", sheet.getCell(4, 7).getContents());
		strategy.put("D8C4C6", sheet.getCell(4, 8).getContents());
		strategy.put("D8C4C8", sheet.getCell(4, 9).getContents());
		strategy.put("D8C4C9", sheet.getCell(4, 10).getContents());
		strategy.put("D8C4C10", sheet.getCell(4, 11).getContents());
		strategy.put("D8C5C6", sheet.getCell(4, 12).getContents());
		strategy.put("D8C5C8", sheet.getCell(4, 13).getContents());
		strategy.put("D8C5C9", sheet.getCell(4, 14).getContents());
		strategy.put("D8C5C10", sheet.getCell(4, 15).getContents());
		strategy.put("D8C6C8", sheet.getCell(4, 16).getContents());
		strategy.put("D8C6C9", sheet.getCell(4, 17).getContents());
		strategy.put("D8C6C10", sheet.getCell(4, 18).getContents());
		strategy.put("D8C8C9", sheet.getCell(4, 19).getContents());
		strategy.put("D8C8C10", sheet.getCell(4, 20).getContents());
		strategy.put("D8C9C10", sheet.getCell(4, 21).getContents());
		
		strategy.put("D9", sheet.getCell(5, 0).getContents());
		strategy.put("D9C4", sheet.getCell(5, 1).getContents());
		strategy.put("D9C5", sheet.getCell(5, 2).getContents());
		strategy.put("D9C6", sheet.getCell(5, 3).getContents());
		strategy.put("D9C8", sheet.getCell(5, 4).getContents());
		strategy.put("D9C9", sheet.getCell(5, 5).getContents());
		strategy.put("D9C10", sheet.getCell(5, 6).getContents());
		strategy.put("D9C4C5", sheet.getCell(5, 7).getContents());
		strategy.put("D9C4C6", sheet.getCell(5, 8).getContents());
		strategy.put("D9C4C8", sheet.getCell(5, 9).getContents());
		strategy.put("D9C4C9", sheet.getCell(5, 10).getContents());
		strategy.put("D9C4C10", sheet.getCell(5, 11).getContents());
		strategy.put("D9C5C6", sheet.getCell(5, 12).getContents());
		strategy.put("D9C5C8", sheet.getCell(5, 13).getContents());
		strategy.put("D9C5C9", sheet.getCell(5, 14).getContents());
		strategy.put("D9C5C10", sheet.getCell(5, 15).getContents());
		strategy.put("D9C6C8", sheet.getCell(5, 16).getContents());
		strategy.put("D9C6C9", sheet.getCell(5, 17).getContents());
		strategy.put("D9C6C10", sheet.getCell(5, 18).getContents());
		strategy.put("D9C8C9", sheet.getCell(5, 19).getContents());
		strategy.put("D9C8C10", sheet.getCell(5, 20).getContents());
		strategy.put("D9C9C10", sheet.getCell(5, 21).getContents());
		
		strategy.put("D10", sheet.getCell(6, 0).getContents());
		strategy.put("D10C4", sheet.getCell(6, 1).getContents());
		strategy.put("D10C5", sheet.getCell(6, 2).getContents());
		strategy.put("D10C6", sheet.getCell(6, 3).getContents());
		strategy.put("D10C8", sheet.getCell(6, 4).getContents());
		strategy.put("D10C9", sheet.getCell(6, 5).getContents());
		strategy.put("D10C10", sheet.getCell(6, 6).getContents());
		strategy.put("D10C4C5", sheet.getCell(6, 7).getContents());
		strategy.put("D10C4C6", sheet.getCell(6, 8).getContents());
		strategy.put("D10C4C8", sheet.getCell(6, 9).getContents());
		strategy.put("D10C4C9", sheet.getCell(6, 10).getContents());
		strategy.put("D10C4C10", sheet.getCell(6, 11).getContents());
		strategy.put("D10C5C6", sheet.getCell(6, 12).getContents());
		strategy.put("D10C5C8", sheet.getCell(6, 13).getContents());
		strategy.put("D10C5C9", sheet.getCell(6, 14).getContents());
		strategy.put("D10C5C10", sheet.getCell(6, 15).getContents());
		strategy.put("D10C6C8", sheet.getCell(6, 16).getContents());
		strategy.put("D10C6C9", sheet.getCell(6, 17).getContents());
		strategy.put("D10C6C10", sheet.getCell(6, 18).getContents());
		strategy.put("D10C8C9", sheet.getCell(6, 19).getContents());
		strategy.put("D10C8C10", sheet.getCell(6, 20).getContents());
		strategy.put("D10C9C10", sheet.getCell(6, 21).getContents());
		
		strategy.put("D4D5", sheet.getCell(7, 0).getContents());
		strategy.put("D4D5C4", sheet.getCell(7, 1).getContents());
		strategy.put("D4D5C5", sheet.getCell(7, 2).getContents());
		strategy.put("D4D5C6", sheet.getCell(7, 3).getContents());
		strategy.put("D4D5C8", sheet.getCell(7, 4).getContents());
		strategy.put("D4D5C9", sheet.getCell(7, 5).getContents());
		strategy.put("D4D5C10", sheet.getCell(7, 6).getContents());
		strategy.put("D4D5C4C5", sheet.getCell(7, 7).getContents());
		strategy.put("D4D5C4C6", sheet.getCell(7, 8).getContents());
		strategy.put("D4D5C4C8", sheet.getCell(7, 9).getContents());
		strategy.put("D4D5C4C9", sheet.getCell(7, 10).getContents());
		strategy.put("D4D5C4C10", sheet.getCell(7, 11).getContents());
		strategy.put("D4D5C5C6", sheet.getCell(7, 12).getContents());
		strategy.put("D4D5C5C8", sheet.getCell(7, 13).getContents());
		strategy.put("D4D5C5C9", sheet.getCell(7, 14).getContents());
		strategy.put("D4D5C5C10", sheet.getCell(7, 15).getContents());
		strategy.put("D4D5C6C8", sheet.getCell(7, 16).getContents());
		strategy.put("D4D5C6C9", sheet.getCell(7, 17).getContents());
		strategy.put("D4D5C6C10", sheet.getCell(7, 18).getContents());
		strategy.put("D4D5C8C9", sheet.getCell(7, 19).getContents());
		strategy.put("D4D5C8C10", sheet.getCell(7, 20).getContents());
		strategy.put("D4D5C9C10", sheet.getCell(7, 21).getContents());
		
		strategy.put("D4D6", sheet.getCell(8, 0).getContents());
		strategy.put("D4D6C4", sheet.getCell(8, 1).getContents());
		strategy.put("D4D6C5", sheet.getCell(8, 2).getContents());
		strategy.put("D4D6C6", sheet.getCell(8, 3).getContents());
		strategy.put("D4D6C8", sheet.getCell(8, 4).getContents());
		strategy.put("D4D6C9", sheet.getCell(8, 5).getContents());
		strategy.put("D4D6C10", sheet.getCell(8, 6).getContents());
		strategy.put("D4D6C4C5", sheet.getCell(8, 7).getContents());
		strategy.put("D4D6C4C6", sheet.getCell(8, 8).getContents());
		strategy.put("D4D6C4C8", sheet.getCell(8, 9).getContents());
		strategy.put("D4D6C4C9", sheet.getCell(8, 10).getContents());
		strategy.put("D4D6C4C10", sheet.getCell(8, 11).getContents());
		strategy.put("D4D6C5C6", sheet.getCell(8, 12).getContents());
		strategy.put("D4D6C5C8", sheet.getCell(8, 13).getContents());
		strategy.put("D4D6C5C9", sheet.getCell(8, 14).getContents());
		strategy.put("D4D6C5C10", sheet.getCell(8, 15).getContents());
		strategy.put("D4D6C6C8", sheet.getCell(8, 16).getContents());
		strategy.put("D4D6C6C9", sheet.getCell(8, 17).getContents());
		strategy.put("D4D6C6C10", sheet.getCell(8, 18).getContents());
		strategy.put("D4D6C8C9", sheet.getCell(8, 19).getContents());
		strategy.put("D4D6C8C10", sheet.getCell(8, 20).getContents());
		strategy.put("D4D6C9C10", sheet.getCell(8, 21).getContents());
		
		strategy.put("D4D8", sheet.getCell(9, 0).getContents());
		strategy.put("D4D8C4", sheet.getCell(9, 1).getContents());
		strategy.put("D4D8C5", sheet.getCell(9, 2).getContents());
		strategy.put("D4D8C6", sheet.getCell(9, 3).getContents());
		strategy.put("D4D8C8", sheet.getCell(9, 4).getContents());
		strategy.put("D4D8C9", sheet.getCell(9, 5).getContents());
		strategy.put("D4D8C10", sheet.getCell(9, 6).getContents());
		strategy.put("D4D8C4C5", sheet.getCell(9, 7).getContents());
		strategy.put("D4D8C4C6", sheet.getCell(9, 8).getContents());
		strategy.put("D4D8C4C8", sheet.getCell(9, 9).getContents());
		strategy.put("D4D8C4C9", sheet.getCell(9, 10).getContents());
		strategy.put("D4D8C4C10", sheet.getCell(9, 11).getContents());
		strategy.put("D4D8C5C6", sheet.getCell(9, 12).getContents());
		strategy.put("D4D8C5C8", sheet.getCell(9, 13).getContents());
		strategy.put("D4D8C5C9", sheet.getCell(9, 14).getContents());
		strategy.put("D4D8C5C10", sheet.getCell(9, 15).getContents());
		strategy.put("D4D8C6C8", sheet.getCell(9, 16).getContents());
		strategy.put("D4D8C6C9", sheet.getCell(9, 17).getContents());
		strategy.put("D4D8C6C10", sheet.getCell(9, 18).getContents());
		strategy.put("D4D8C8C9", sheet.getCell(9, 19).getContents());
		strategy.put("D4D8C8C10", sheet.getCell(9, 20).getContents());
		strategy.put("D4D8C9C10", sheet.getCell(9, 21).getContents());
		
		strategy.put("D4D9", sheet.getCell(10, 0).getContents());
		strategy.put("D4D9C4", sheet.getCell(10, 1).getContents());
		strategy.put("D4D9C5", sheet.getCell(10, 2).getContents());
		strategy.put("D4D9C6", sheet.getCell(10, 3).getContents());
		strategy.put("D4D9C8", sheet.getCell(10, 4).getContents());
		strategy.put("D4D9C9", sheet.getCell(10, 5).getContents());
		strategy.put("D4D9C10", sheet.getCell(10, 6).getContents());
		strategy.put("D4D9C4C5", sheet.getCell(10, 7).getContents());
		strategy.put("D4D9C4C6", sheet.getCell(10, 8).getContents());
		strategy.put("D4D9C4C8", sheet.getCell(10, 9).getContents());
		strategy.put("D4D9C4C9", sheet.getCell(10, 10).getContents());
		strategy.put("D4D9C4C10", sheet.getCell(10, 11).getContents());
		strategy.put("D4D9C5C6", sheet.getCell(10, 12).getContents());
		strategy.put("D4D9C5C8", sheet.getCell(10, 13).getContents());
		strategy.put("D4D9C5C9", sheet.getCell(10, 14).getContents());
		strategy.put("D4D9C5C10", sheet.getCell(10, 15).getContents());
		strategy.put("D4D9C6C8", sheet.getCell(10, 16).getContents());
		strategy.put("D4D9C6C9", sheet.getCell(10, 17).getContents());
		strategy.put("D4D9C6C10", sheet.getCell(10, 18).getContents());
		strategy.put("D4D9C8C9", sheet.getCell(10, 19).getContents());
		strategy.put("D4D9C8C10", sheet.getCell(10, 20).getContents());
		strategy.put("D4D9C9C10", sheet.getCell(10, 21).getContents());
		
		strategy.put("D4D10", sheet.getCell(11, 0).getContents());
		strategy.put("D4D10C4", sheet.getCell(11, 1).getContents());
		strategy.put("D4D10C5", sheet.getCell(11, 2).getContents());
		strategy.put("D4D10C6", sheet.getCell(11, 3).getContents());
		strategy.put("D4D10C8", sheet.getCell(11, 4).getContents());
		strategy.put("D4D10C9", sheet.getCell(11, 5).getContents());
		strategy.put("D4D10C10", sheet.getCell(11, 6).getContents());
		strategy.put("D4D10C4C5", sheet.getCell(11, 7).getContents());
		strategy.put("D4D10C4C6", sheet.getCell(11, 8).getContents());
		strategy.put("D4D10C4C8", sheet.getCell(11, 9).getContents());
		strategy.put("D4D10C4C9", sheet.getCell(11, 10).getContents());
		strategy.put("D4D10C4C10", sheet.getCell(11, 11).getContents());
		strategy.put("D4D10C5C6", sheet.getCell(11, 12).getContents());
		strategy.put("D4D10C5C8", sheet.getCell(11, 13).getContents());
		strategy.put("D4D10C5C9", sheet.getCell(11, 14).getContents());
		strategy.put("D4D10C5C10", sheet.getCell(11, 15).getContents());
		strategy.put("D4D10C6C8", sheet.getCell(11, 16).getContents());
		strategy.put("D4D10C6C9", sheet.getCell(11, 17).getContents());
		strategy.put("D4D10C6C10", sheet.getCell(11, 18).getContents());
		strategy.put("D4D10C8C9", sheet.getCell(11, 19).getContents());
		strategy.put("D4D10C8C10", sheet.getCell(11, 20).getContents());
		strategy.put("D4D10C9C10", sheet.getCell(11, 21).getContents());
		
		strategy.put("D5D6", sheet.getCell(12, 0).getContents());
		strategy.put("D5D6C4", sheet.getCell(12, 1).getContents());
		strategy.put("D5D6C5", sheet.getCell(12, 2).getContents());
		strategy.put("D5D6C6", sheet.getCell(12, 3).getContents());
		strategy.put("D5D6C8", sheet.getCell(12, 4).getContents());
		strategy.put("D5D6C9", sheet.getCell(12, 5).getContents());
		strategy.put("D5D6C10", sheet.getCell(12, 6).getContents());
		strategy.put("D5D6C4C5", sheet.getCell(12, 7).getContents());
		strategy.put("D5D6C4C6", sheet.getCell(12, 8).getContents());
		strategy.put("D5D6C4C8", sheet.getCell(12, 9).getContents());
		strategy.put("D5D6C4C9", sheet.getCell(12, 10).getContents());
		strategy.put("D5D6C4C10", sheet.getCell(12, 11).getContents());
		strategy.put("D5D6C5C6", sheet.getCell(12, 12).getContents());
		strategy.put("D5D6C5C8", sheet.getCell(12, 13).getContents());
		strategy.put("D5D6C5C9", sheet.getCell(12, 14).getContents());
		strategy.put("D5D6C5C10", sheet.getCell(12, 15).getContents());
		strategy.put("D5D6C6C8", sheet.getCell(12, 16).getContents());
		strategy.put("D5D6C6C9", sheet.getCell(12, 17).getContents());
		strategy.put("D5D6C6C10", sheet.getCell(12, 18).getContents());
		strategy.put("D5D6C8C9", sheet.getCell(12, 19).getContents());
		strategy.put("D5D6C8C10", sheet.getCell(12, 20).getContents());
		strategy.put("D5D6C9C10", sheet.getCell(12, 21).getContents());
		
		strategy.put("D5D8", sheet.getCell(13, 0).getContents());
		strategy.put("D5D8C4", sheet.getCell(13, 1).getContents());
		strategy.put("D5D8C5", sheet.getCell(13, 2).getContents());
		strategy.put("D5D8C6", sheet.getCell(13, 3).getContents());
		strategy.put("D5D8C8", sheet.getCell(13, 4).getContents());
		strategy.put("D5D8C9", sheet.getCell(13, 5).getContents());
		strategy.put("D5D8C10", sheet.getCell(13, 6).getContents());
		strategy.put("D5D8C4C5", sheet.getCell(13, 7).getContents());
		strategy.put("D5D8C4C6", sheet.getCell(13, 8).getContents());
		strategy.put("D5D8C4C8", sheet.getCell(13, 9).getContents());
		strategy.put("D5D8C4C9", sheet.getCell(13, 10).getContents());
		strategy.put("D5D8C4C10", sheet.getCell(13, 11).getContents());
		strategy.put("D5D8C5C6", sheet.getCell(13, 12).getContents());
		strategy.put("D5D8C5C8", sheet.getCell(13, 13).getContents());
		strategy.put("D5D8C5C9", sheet.getCell(13, 14).getContents());
		strategy.put("D5D8C5C10", sheet.getCell(13, 15).getContents());
		strategy.put("D5D8C6C8", sheet.getCell(13, 16).getContents());
		strategy.put("D5D8C6C9", sheet.getCell(13, 17).getContents());
		strategy.put("D5D8C6C10", sheet.getCell(13, 18).getContents());
		strategy.put("D5D8C8C9", sheet.getCell(13, 19).getContents());
		strategy.put("D5D8C8C10", sheet.getCell(13, 20).getContents());
		strategy.put("D5D8C9C10", sheet.getCell(13, 21).getContents());
		
		strategy.put("D5D9", sheet.getCell(14, 0).getContents());
		strategy.put("D5D9C4", sheet.getCell(14, 1).getContents());
		strategy.put("D5D9C5", sheet.getCell(14, 2).getContents());
		strategy.put("D5D9C6", sheet.getCell(14, 3).getContents());
		strategy.put("D5D9C8", sheet.getCell(14, 4).getContents());
		strategy.put("D5D9C9", sheet.getCell(14, 5).getContents());
		strategy.put("D5D9C10", sheet.getCell(14, 6).getContents());
		strategy.put("D5D9C4C5", sheet.getCell(14, 7).getContents());
		strategy.put("D5D9C4C6", sheet.getCell(14, 8).getContents());
		strategy.put("D5D9C4C8", sheet.getCell(14, 9).getContents());
		strategy.put("D5D9C4C9", sheet.getCell(14, 10).getContents());
		strategy.put("D5D9C4C10", sheet.getCell(14, 11).getContents());
		strategy.put("D5D9C5C6", sheet.getCell(14, 12).getContents());
		strategy.put("D5D9C5C8", sheet.getCell(14, 13).getContents());
		strategy.put("D5D9C5C9", sheet.getCell(14, 14).getContents());
		strategy.put("D5D9C5C10", sheet.getCell(14, 15).getContents());
		strategy.put("D5D9C6C8", sheet.getCell(14, 16).getContents());
		strategy.put("D5D9C6C9", sheet.getCell(14, 17).getContents());
		strategy.put("D5D9C6C10", sheet.getCell(14, 18).getContents());
		strategy.put("D5D9C8C9", sheet.getCell(14, 19).getContents());
		strategy.put("D5D9C8C10", sheet.getCell(14, 20).getContents());
		strategy.put("D5D9C9C10", sheet.getCell(14, 21).getContents());
		
		strategy.put("D5D10", sheet.getCell(15, 0).getContents());
		strategy.put("D5D10C4", sheet.getCell(15, 1).getContents());
		strategy.put("D5D10C5", sheet.getCell(15, 2).getContents());
		strategy.put("D5D10C6", sheet.getCell(15, 3).getContents());
		strategy.put("D5D10C8", sheet.getCell(15, 4).getContents());
		strategy.put("D5D10C9", sheet.getCell(15, 5).getContents());
		strategy.put("D5D10C10", sheet.getCell(15, 6).getContents());
		strategy.put("D5D10C4C5", sheet.getCell(15, 7).getContents());
		strategy.put("D5D10C4C6", sheet.getCell(15, 8).getContents());
		strategy.put("D5D10C4C8", sheet.getCell(15, 9).getContents());
		strategy.put("D5D10C4C9", sheet.getCell(15, 10).getContents());
		strategy.put("D5D10C4C10", sheet.getCell(15, 11).getContents());
		strategy.put("D5D10C5C6", sheet.getCell(15, 12).getContents());
		strategy.put("D5D10C5C8", sheet.getCell(15, 13).getContents());
		strategy.put("D5D10C5C9", sheet.getCell(15, 14).getContents());
		strategy.put("D5D10C5C10", sheet.getCell(15, 15).getContents());
		strategy.put("D5D10C6C8", sheet.getCell(15, 16).getContents());
		strategy.put("D5D10C6C9", sheet.getCell(15, 17).getContents());
		strategy.put("D5D10C6C10", sheet.getCell(15, 18).getContents());
		strategy.put("D5D10C8C9", sheet.getCell(15, 19).getContents());
		strategy.put("D5D10C8C10", sheet.getCell(15, 20).getContents());
		strategy.put("D5D10C9C10", sheet.getCell(15, 21).getContents());
		
		strategy.put("D6D8", sheet.getCell(16, 0).getContents());
		strategy.put("D6D8C4", sheet.getCell(16, 1).getContents());
		strategy.put("D6D8C5", sheet.getCell(16, 2).getContents());
		strategy.put("D6D8C6", sheet.getCell(16, 3).getContents());
		strategy.put("D6D8C8", sheet.getCell(16, 4).getContents());
		strategy.put("D6D8C9", sheet.getCell(16, 5).getContents());
		strategy.put("D6D8C10", sheet.getCell(16, 6).getContents());
		strategy.put("D6D8C4C5", sheet.getCell(16, 7).getContents());
		strategy.put("D6D8C4C6", sheet.getCell(16, 8).getContents());
		strategy.put("D6D8C4C8", sheet.getCell(16, 9).getContents());
		strategy.put("D6D8C4C9", sheet.getCell(16, 10).getContents());
		strategy.put("D6D8C4C10", sheet.getCell(16, 11).getContents());
		strategy.put("D6D8C5C6", sheet.getCell(16, 12).getContents());
		strategy.put("D6D8C5C8", sheet.getCell(16, 13).getContents());
		strategy.put("D6D8C5C9", sheet.getCell(16, 14).getContents());
		strategy.put("D6D8C5C10", sheet.getCell(16, 15).getContents());
		strategy.put("D6D8C6C8", sheet.getCell(16, 16).getContents());
		strategy.put("D6D8C6C9", sheet.getCell(16, 17).getContents());
		strategy.put("D6D8C6C10", sheet.getCell(16, 18).getContents());
		strategy.put("D6D8C8C9", sheet.getCell(16, 19).getContents());
		strategy.put("D6D8C8C10", sheet.getCell(16, 20).getContents());
		strategy.put("D6D8C9C10", sheet.getCell(16, 21).getContents());
		
		strategy.put("D6D9", sheet.getCell(17, 0).getContents());
		strategy.put("D6D9C4", sheet.getCell(17, 1).getContents());
		strategy.put("D6D9C5", sheet.getCell(17, 2).getContents());
		strategy.put("D6D9C6", sheet.getCell(17, 3).getContents());
		strategy.put("D6D9C8", sheet.getCell(17, 4).getContents());
		strategy.put("D6D9C9", sheet.getCell(17, 5).getContents());
		strategy.put("D6D9C10", sheet.getCell(17, 6).getContents());
		strategy.put("D6D9C4C5", sheet.getCell(17, 7).getContents());
		strategy.put("D6D9C4C6", sheet.getCell(17, 8).getContents());
		strategy.put("D6D9C4C8", sheet.getCell(17, 9).getContents());
		strategy.put("D6D9C4C9", sheet.getCell(17, 10).getContents());
		strategy.put("D6D9C4C10", sheet.getCell(17, 11).getContents());
		strategy.put("D6D9C5C6", sheet.getCell(17, 12).getContents());
		strategy.put("D6D9C5C8", sheet.getCell(17, 13).getContents());
		strategy.put("D6D9C5C9", sheet.getCell(17, 14).getContents());
		strategy.put("D6D9C5C10", sheet.getCell(17, 15).getContents());
		strategy.put("D6D9C6C8", sheet.getCell(17, 16).getContents());
		strategy.put("D6D9C6C9", sheet.getCell(17, 17).getContents());
		strategy.put("D6D9C6C10", sheet.getCell(17, 18).getContents());
		strategy.put("D6D9C8C9", sheet.getCell(17, 19).getContents());
		strategy.put("D6D9C8C10", sheet.getCell(17, 20).getContents());
		strategy.put("D6D9C9C10", sheet.getCell(17, 21).getContents());
		
		strategy.put("D6D10", sheet.getCell(18, 0).getContents());
		strategy.put("D6D10C4", sheet.getCell(18, 1).getContents());
		strategy.put("D6D10C5", sheet.getCell(18, 2).getContents());
		strategy.put("D6D10C6", sheet.getCell(18, 3).getContents());
		strategy.put("D6D10C8", sheet.getCell(18, 4).getContents());
		strategy.put("D6D10C9", sheet.getCell(18, 5).getContents());
		strategy.put("D6D10C10", sheet.getCell(18, 6).getContents());
		strategy.put("D6D10C4C5", sheet.getCell(18, 7).getContents());
		strategy.put("D6D10C4C6", sheet.getCell(18, 8).getContents());
		strategy.put("D6D10C4C8", sheet.getCell(18, 9).getContents());
		strategy.put("D6D10C4C9", sheet.getCell(18, 10).getContents());
		strategy.put("D6D10C4C10", sheet.getCell(18, 11).getContents());
		strategy.put("D6D10C5C6", sheet.getCell(18, 12).getContents());
		strategy.put("D6D10C5C8", sheet.getCell(18, 13).getContents());
		strategy.put("D6D10C5C9", sheet.getCell(18, 14).getContents());
		strategy.put("D6D10C5C10", sheet.getCell(18, 15).getContents());
		strategy.put("D6D10C6C8", sheet.getCell(18, 16).getContents());
		strategy.put("D6D10C6C9", sheet.getCell(18, 17).getContents());
		strategy.put("D6D10C6C10", sheet.getCell(18, 18).getContents());
		strategy.put("D6D10C8C9", sheet.getCell(18, 19).getContents());
		strategy.put("D6D10C8C10", sheet.getCell(18, 20).getContents());
		strategy.put("D6D10C9C10", sheet.getCell(18, 21).getContents());
		
		strategy.put("D8D9", sheet.getCell(19, 0).getContents());
		strategy.put("D8D9C4", sheet.getCell(19, 1).getContents());
		strategy.put("D8D9C5", sheet.getCell(19, 2).getContents());
		strategy.put("D8D9C6", sheet.getCell(19, 3).getContents());
		strategy.put("D8D9C8", sheet.getCell(19, 4).getContents());
		strategy.put("D8D9C9", sheet.getCell(19, 5).getContents());
		strategy.put("D8D9C10", sheet.getCell(19, 6).getContents());
		strategy.put("D8D9C4C5", sheet.getCell(19, 7).getContents());
		strategy.put("D8D9C4C6", sheet.getCell(19, 8).getContents());
		strategy.put("D8D9C4C8", sheet.getCell(19, 9).getContents());
		strategy.put("D8D9C4C9", sheet.getCell(19, 10).getContents());
		strategy.put("D8D9C4C10", sheet.getCell(19, 11).getContents());
		strategy.put("D8D9C5C6", sheet.getCell(19, 12).getContents());
		strategy.put("D8D9C5C8", sheet.getCell(19, 13).getContents());
		strategy.put("D8D9C5C9", sheet.getCell(19, 14).getContents());
		strategy.put("D8D9C5C10", sheet.getCell(19, 15).getContents());
		strategy.put("D8D9C6C8", sheet.getCell(19, 16).getContents());
		strategy.put("D8D9C6C9", sheet.getCell(19, 17).getContents());
		strategy.put("D8D9C6C10", sheet.getCell(19, 18).getContents());
		strategy.put("D8D9C8C9", sheet.getCell(19, 19).getContents());
		strategy.put("D8D9C8C10", sheet.getCell(19, 20).getContents());
		strategy.put("D8D9C9C10", sheet.getCell(19, 21).getContents());
		
		strategy.put("D8D10", sheet.getCell(20, 0).getContents());
		strategy.put("D8D10C4", sheet.getCell(20, 1).getContents());
		strategy.put("D8D10C5", sheet.getCell(20, 2).getContents());
		strategy.put("D8D10C6", sheet.getCell(20, 3).getContents());
		strategy.put("D8D10C8", sheet.getCell(20, 4).getContents());
		strategy.put("D8D10C9", sheet.getCell(20, 5).getContents());
		strategy.put("D8D10C10", sheet.getCell(20, 6).getContents());
		strategy.put("D8D10C4C5", sheet.getCell(20, 7).getContents());
		strategy.put("D8D10C4C6", sheet.getCell(20, 8).getContents());
		strategy.put("D8D10C4C8", sheet.getCell(20, 9).getContents());
		strategy.put("D8D10C4C9", sheet.getCell(20, 10).getContents());
		strategy.put("D8D10C4C10", sheet.getCell(20, 11).getContents());
		strategy.put("D8D10C5C6", sheet.getCell(20, 12).getContents());
		strategy.put("D8D10C5C8", sheet.getCell(20, 13).getContents());
		strategy.put("D8D10C5C9", sheet.getCell(20, 14).getContents());
		strategy.put("D8D10C5C10", sheet.getCell(20, 15).getContents());
		strategy.put("D8D10C6C8", sheet.getCell(20, 16).getContents());
		strategy.put("D8D10C6C9", sheet.getCell(20, 17).getContents());
		strategy.put("D8D10C6C10", sheet.getCell(20, 18).getContents());
		strategy.put("D8D10C8C9", sheet.getCell(20, 19).getContents());
		strategy.put("D8D10C8C10", sheet.getCell(20, 20).getContents());
		strategy.put("D8D10C9C10", sheet.getCell(20, 21).getContents());
		
		strategy.put("D9D10", sheet.getCell(21, 0).getContents());
		strategy.put("D9D10C4", sheet.getCell(21, 1).getContents());
		strategy.put("D9D10C5", sheet.getCell(21, 2).getContents());
		strategy.put("D9D10C6", sheet.getCell(21, 3).getContents());
		strategy.put("D9D10C8", sheet.getCell(21, 4).getContents());
		strategy.put("D9D10C9", sheet.getCell(21, 5).getContents());
		strategy.put("D9D10C10", sheet.getCell(21, 6).getContents());
		strategy.put("D9D10C4C5", sheet.getCell(21, 7).getContents());
		strategy.put("D9D10C4C6", sheet.getCell(21, 8).getContents());
		strategy.put("D9D10C4C8", sheet.getCell(21, 9).getContents());
		strategy.put("D9D10C4C9", sheet.getCell(21, 10).getContents());
		strategy.put("D9D10C4C10", sheet.getCell(21, 11).getContents());
		strategy.put("D9D10C5C6", sheet.getCell(21, 12).getContents());
		strategy.put("D9D10C5C8", sheet.getCell(21, 13).getContents());
		strategy.put("D9D10C5C9", sheet.getCell(21, 14).getContents());
		strategy.put("D9D10C5C10", sheet.getCell(21, 15).getContents());
		strategy.put("D9D10C6C8", sheet.getCell(21, 16).getContents());
		strategy.put("D9D10C6C9", sheet.getCell(21, 17).getContents());
		strategy.put("D9D10C6C10", sheet.getCell(21, 18).getContents());
		strategy.put("D9D10C8C9", sheet.getCell(21, 19).getContents());
		strategy.put("D9D10C8C10", sheet.getCell(21, 20).getContents());
		strategy.put("D9D10C9C10", sheet.getCell(21, 21).getContents());
		} catch (Exception e) {
			System.err.println("Failure reading specific cells from Excel document.");
			System.exit(-14);
		}
	}
	
	/**
	 * Method to help determine the strategy's idea for the next shot.
	 * 
	 * Bet information is passed as a comma delimited String, with all Come bets shown in numerical order before all Don't Come bets are shown.
	 * Examples:
	 *  - C6,DC8,DC10: Come 6, Don't Come 8, Don't Come 10
	 *  - C10,DC4,DC10: Come 10, Don't Come 4, Don't Come 10
	 * 
	 * @param currentbets String value containing the current bets on the table, comma seperated.
	 * @param allowrepeats Boolean to determine if repeating bets should be handled. For instance, if Come 4 and Don't Come 5 should be ignored because they offset or identified as bets.
	 * @return Wagers to make before the next shot
	 */
	public String getStrategy(String currentbets, boolean allowrepeats) {
		// currentbets has a standard of placing each Come and Don't Come bet in numerical order.
		// For example, DC9C4C6 represents Don't Come 9, Come 4, Come 6.
		// Another example, DC4DC5C5 represents Don't Come 4, Don't Come 5, Come 5.
		// All Don't Come bets are shown before any Come bets.
		// If length < 3, it can only contain one bet and is unnecessary to continue.
		
		String stratToGet = "";
		if (currentbets.equals("None") || currentbets.length() < 3)
			return strategy.get(currentbets);
		
		List<String> splitupbets = new LinkedList<String>(Arrays.asList(currentbets.split("[,]")));
		if (!allowrepeats) {
			if (splitupbets.contains("D4"))
				if (splitupbets.contains("C4"))
					splitupbets.remove(splitupbets.indexOf("C4"));
			if (splitupbets.contains("D5"))
				if (splitupbets.contains("C5"))
					splitupbets.remove(splitupbets.indexOf("C5"));
			if (splitupbets.contains("D6"))
				if (splitupbets.contains("C6"))
					splitupbets.remove(splitupbets.indexOf("C6"));
			if (splitupbets.contains("D8"))
				if (splitupbets.contains("C8"))
					splitupbets.remove(splitupbets.indexOf("C8"));
			if (splitupbets.contains("D9"))
				if (splitupbets.contains("C9"))
					splitupbets.remove(splitupbets.indexOf("C9"));
			if (splitupbets.contains("D10"))
				if (splitupbets.contains("C10"))
					splitupbets.remove(splitupbets.indexOf("C10"));
		}
		
		for(int i = 0; i < splitupbets.size(); i++) {
			stratToGet += splitupbets.get(i);
		}
		
		int numcome = stratToGet.length() - stratToGet.replace("C", "").length();
		int numdontcome = stratToGet.length() - stratToGet.replace("D", "").length();
		
		if (numcome >= 3)
			return "D";
		if (numdontcome >= 3)
			return "P";
		
		return strategy.get(stratToGet);
	}
	
	//http://www.andykhan.com/jexcelapi/tutorial.html
}
