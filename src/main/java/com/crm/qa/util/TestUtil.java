package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase{
	public static long Page_Load_Timeout=20;
	public static long Implicit_Wait_Timeout=10;
	public static String TestData_Path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\testdata\\testdata.xlsx";
	
	public static Object[][] data;
	
	public static void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream fi;
		XSSFWorkbook wb;
		
		try {
			fi = new FileInputStream(TestData_Path);
			wb=new XSSFWorkbook(fi);
			XSSFSheet sheet=wb.getSheet(sheetname);
			int lastRowNum=sheet.getLastRowNum();
			int lastColNum=sheet.getRow(0).getLastCellNum();
			data=new Object[lastRowNum][lastColNum];
			for(int i=1;i<=lastRowNum;i++)
			{
				for(int j=0;j<lastColNum;j++)
				{
					data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return data;
		
	}


	public static void takeScreenshot() throws IOException{
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File f=new File(System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(srcFile, f);
		
	}

}
