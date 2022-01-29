package output;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter implements DocumentWriter{

	private String path;
	
	public 	ExcelWriter(String path)
	{
		this.path = path;
	}
	
	public void write(ArrayList<String> contents)
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("new");
		int rowCount = 0;
		for(String line:contents)
		{
			Row row = sheet.createRow(rowCount);
			String[] single = line.split(" ");
			int columnCount = 0;
			for(String elem:single)
			{
				Cell cell = row.createCell(columnCount);
				cell.setCellValue(elem);
				columnCount++;
			}
			rowCount++;
		}
		try 
		{
			 FileOutputStream out = new FileOutputStream(new File(path));
			 workbook.write(out);
			 workbook.close();
			 out.close();
	    }
		catch(IOException e)
		{
				e.printStackTrace();
		}
	}
	
}
