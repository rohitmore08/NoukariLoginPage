package Login_Noukari;

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


public class LoginPage1_Naukari2 
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
			String	TCID = sheet.getRow(2).getCell(4).getStringCellValue();
			
			
			System.setProperty("webdriver.chrome.driver", "D:\\path\\chromedriver.exe");
			WebDriver driver = new ChromeDriver(option);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.naukri.com/");
			
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//a [text()='Login']")).click();
			
			driver.findElement(By.xpath("//input [contains(@placeholder,' Email')]")).sendKeys(userid);
			
			driver.findElement(By.xpath("//input [contains(@placeholder,' pass')]")).sendKeys(pass);
			
			driver.findElement(By.xpath("//button [@type='submit']")).click();
			
			driver.findElement(By.xpath("//div [@class='view-profile-wrapper']")).click();
			
			String ActualUN = driver.findElement(By.xpath("//span [@class='fullname']")).getText();
			
			
			if(ActualUN.equals(ExpUN))
			{
				System.out.println("Actual and Expected results Match");
				System.out.println(TCID+" is Pass");
			}
			else
			{
				System.out.println("Actual and Expected results Not Match");
				System.out.println(TCID+" is Fail");
			}
				
			
			driver.findElement(By.xpath("//div [@class='nI-gNb-bar3']")).click();
			
			driver.findElement(By.xpath("//a [@title='Logout']")).click();
			
			driver.close();
					
			
		}
}
