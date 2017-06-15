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

public class CrapsExcelReader {

	private Workbook workbook;
	private Sheet sheet;
	private Map<String, String> strategy;
	
	public CrapsExcelReader(String filename) {
		try {
			workbook = Workbook.getWorkbook(new File(filename));
		} catch (BiffException e) {
			e.printStackTrace();
			System.exit(-11);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-12);
		}
		
		//strategy = new HashMap<String, String>();
		readSheet();
		writeCrapsBet();
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
	public void writeCrapsBet() {
		try {
		//strategy.put("None", sheet.getCell(0, 0).getContents());
		
		} catch (Exception e) {
			System.err.println("Failure reading specific cells from Excel document.");
			System.exit(-14);
		}
	}
	
	//http://www.andykhan.com/jexcelapi/tutorial.html
}
