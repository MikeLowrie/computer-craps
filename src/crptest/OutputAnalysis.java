package crptest;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class OutputAnalysis {

	//http://www.javaworld.com/article/2074940/learn-java/java-app-dev-reading-and-writing-excel-spreadsheets.html
	
	private WritableWorkbook workbook;
	private WritableSheet sheet;
	private Label label;
	private Number number;
	
	public OutputAnalysis(String filename)
	{
		try {
		    workbook = Workbook.createWorkbook( new File( filename ) );
		    sheet = workbook.createSheet("Raw Data", 0);
			} catch(IOException e) {
				System.err.println("Is this file open elsewhere?");
				e.printStackTrace();
				System.exit(-21);
			}
	}

	
	public void writeNextLine(int x, int y, String output)
	{
		try {
			label = new Label(x, y, output);
			sheet.addCell(label);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(-22);
		}
	}
	
	public void writeNextLine(int x, int y, int output)
	{
		try {
			number = new Number(x, y, output);
			sheet.addCell(number);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(-23);
		}
	}
	
	public void analytics()
	{
		this.writeNextLine(5, 0, "Ceiling when losing");
		this.writeNextLine(5, 1, "=AVERAGE(C2:C10002)");
		this.writeNextLine(6, 0, "Floor when winning");
		this.writeNextLine(6, 1, "=AVERAGE(D2:D10002)");
	}
	
	public void writeToBook()
	{
		try {
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			System.err.println("Error thrown during write to workbook.");
			e.printStackTrace();
			System.exit(-24);
		} catch (WriteException e) {
			System.err.println("Error thrown during close of workbook.");
			e.printStackTrace();
			System.exit(-25);
		}
	}
}
