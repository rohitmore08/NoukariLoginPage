package NaukariUN_POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Naukari_Base 
{
	String userid;
	String pass;
	String ExpUN;
	WebDriver driver;
	
	public void initilizeBrowser () throws EncryptedDocumentException, IOException
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		FileInputStream file = new FileInputStream("D:\\path\\excel.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet2");
		userid = sheet.getRow(2).getCell(1).getStringCellValue();
		pass = sheet.getRow(2).getCell(2).getStringCellValue();
		ExpUN = sheet.getRow(2).getCell(3).getStringCellValue();
					
		System.setProperty("webdriver.chrome.driver", "D:\\path\\chromedriver.exe");
		driver = new ChromeDriver(option);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		
		driver.manage().window().maximize();
	}
	

}
