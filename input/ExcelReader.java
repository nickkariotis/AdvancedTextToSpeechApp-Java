package input;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;
import java.io.FileNotFoundException;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelReader implements DocumentReader{
	
	private ArrayList<String> contents = new ArrayList<String>();
	private String path;
	
	public ExcelReader(String path)
	{
		this.path = path;
	}
	
	public ArrayList<String> read(){
		try(XSSFWorkbook doc = new XSSFWorkbook(Files.newInputStream(Paths.get(path)))){
			Sheet datatypeSheet = doc.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while(iterator.hasNext()) {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                ArrayList<String> temp = new ArrayList<String>();
                while (cellIterator.hasNext()) {
                	
                	Cell currentCell = cellIterator.next();
                	if(currentCell.getCellType() == CellType.STRING) 
                	{
                		temp.add(currentCell.getStringCellValue());
                	}
                	else if(currentCell.getCellType() == CellType.NUMERIC) 
                	{
                		String str = NumberToTextConverter.toText(currentCell.getNumericCellValue());
                		temp.add(str);
                	}
                }
                String line = String.join(" ",temp);
                contents.add(line);

                
            }
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return contents;
	}
			
}
