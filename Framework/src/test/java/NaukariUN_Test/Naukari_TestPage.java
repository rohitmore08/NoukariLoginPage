package NaukariUN_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import NaukariUN_POM.HomePage_Naukari;
import NaukariUN_POM.Login_Naukari;
import NaukariUN_POM.Profile_Naukari;

public class Naukari_TestPage 
{
	@Test
	public void naukariUNVerification () throws EncryptedDocumentException, IOException 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		FileInputStream file = new FileInputStream("D:\\path\\excel.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet2");
		String userid = sheet.getRow(2).getCell(1).getStringCellValue();
		String pass = sheet.getRow(2).getCell(2).getStringCellValue();
		String ExpUN = sheet.getRow(2).getCell(3).getStringCellValue();
			
		
		System.setProperty("webdriver.chrome.driver", "D:\\path\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		
		driver.manage().window().maximize();
		
		Login_Naukari login = new Login_Naukari (driver);
		login.LoginPage(userid, pass);
	
		
		HomePage_Naukari hmPage = new HomePage_Naukari(driver);
		hmPage.ClickHomePage();
		
		Profile_Naukari profile = new Profile_Naukari(driver);
		profile.VerifyUN(ExpUN);
		profile.ClickLogoutButton();
		
				
		driver.close();
	}

}
