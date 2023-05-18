package NaukariUN_POM;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Naukari_Test extends Naukari_Base
{
	Login_Naukari login;
	HomePage_Naukari hmPage;
	Profile_Naukari profile;
	
		
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		initilizeBrowser();
	}
	
	@BeforeMethod 
	public void LogintoPage()
	{
		login = new Login_Naukari (driver);
		login.LoginPage(userid, pass);
	
		hmPage = new HomePage_Naukari(driver);
		hmPage.ClickHomePage();
	}
	
	
	@Test
	public void Varify_UN () throws EncryptedDocumentException, IOException 
		{
			profile = new Profile_Naukari(driver);
			profile.VerifyUN(ExpUN);
		}
	
	
	@AfterMethod
	public void LogoutBrowser()
	{
		profile.ClickLogoutButton();
	}
	
	
	@AfterClass 
	public void closeBrowser()
	{
		driver.close();
	}
}
