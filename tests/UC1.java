package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;
import java.util.*;
class UC1 {


	private String testPath;
	private Document test = new Document();
	
	@Test
	void test() {
		
		//Non Encrypted Word
		String path = System.getProperty("user.dir").toString();
		System.out.println(path);
		String word_test_string = "This is a test file.";
		String excel_test_string = "This is a test file.";
		
		testPath = path + "\\tests\\test1.docx";
		test.setPath(testPath);
		test.setEncoding("Default");
		test.open();
		ArrayList<String> content1 = test.getContents();
		String contentString1 = String.join("",content1);
		assertEquals(word_test_string,contentString1);
		
		//Non Encrypted Excel
		testPath = path + "\\tests\\test2.xlsx";
		test.setPath(testPath);
		test.setEncoding("Default");
		test.open();
		ArrayList<String> content2 = test.getContents();
		String contentString2 = String.join("",content2);
		System.out.println(content2);
		assertEquals(excel_test_string,contentString2);
		
		//AtBash Word
		testPath = path + "\\tests\\test3.docx";
		test.setPath(testPath);
		test.setEncoding("Atbash");
		test.open();
		ArrayList<String> content3 = test.getContents();
		String contentString3 = String.join(" ",content3);
		assertEquals(word_test_string,contentString3);

		//AtBash Excel
		
		testPath = path + "\\tests\\test4.xlsx";
		test.setPath(testPath);
		test.setEncoding("Atbash");
		test.open();
		ArrayList<String> content4 = test.getContents();
		String contentString4 = String.join(" ",content4);
		assertEquals(excel_test_string,contentString4);
		
		//Rot13 Word
		testPath = path + "\\tests\\test5.docx";
		test.setPath(testPath);
		test.setEncoding("Rot13");
		test.open();
		ArrayList<String> content5 = test.getContents();
		String contentString5 = String.join("",content5);
		assertEquals(word_test_string,contentString5);
		
		//Rot13 Excel
		testPath = path + "\\tests\\test6.xlsx";
		test.setPath(testPath);
		test.setEncoding("Rot13");
		test.open();
		ArrayList<String> content6 = test.getContents();
		String contentString6 = String.join("",content6);
		assertEquals(excel_test_string,contentString6);
	}

}
