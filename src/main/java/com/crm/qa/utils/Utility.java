package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class Utility extends TestBase{
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =20;
	public static final String TESTDATA_SHEET_PATH="C:\\sivareddyproject\\framework\\src"
			+ "\\main\\java\\com\\crm\\qa\\testdata\\FreecrmcontactsTestdata.xlsx";
	public static Workbook workbook;
    public static Sheet sheet;


	public void switchtoframe(){
		driver.switchTo().frame("mainpanel");
	}
	public static Object[][] getContactsTestData(String sheetName){

		File file = new File(TESTDATA_SHEET_PATH);

		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}try{
			workbook =WorkbookFactory.create(fis);
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		Object[][] sheetdata = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    System.out.println(sheet.getLastRowNum() + "--------" +sheet.getRow(0).getLastCellNum());
	    for(int i=0;i<sheet.getLastRowNum();i++){
	    	for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
	    		sheetdata[i][j]=sheet.getRow(i+1).getCell(j).toString();
	    		 System.out.println(sheetdata[i][j]);
	    	}
	    	
	    }return sheetdata;
	}
	
	public static void takeScreenshotAttheEndOfTest() throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:\\sivareddyproject\\framework\\Screenshots"+System.currentTimeMillis()+".png"));
		
		}
		
	}

