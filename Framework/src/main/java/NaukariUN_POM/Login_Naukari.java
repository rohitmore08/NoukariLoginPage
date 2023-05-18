package NaukariUN_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Naukari 
{
	
	@FindBy (xpath="//a [text()='Login']")private WebElement loginbutton;
	@FindBy (xpath="//input [contains(@placeholder,' Email')]")private WebElement userID;
	@FindBy (xpath="//input [contains(@placeholder,' pass')]")private WebElement password;
	@FindBy (xpath="//button [@type='submit']")private WebElement submit;
	
	public Login_Naukari (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginPage(String userid, String pass)
	{
		loginbutton.click();
		userID.sendKeys(userid);
		password.sendKeys(pass);
		submit.click();
	}

}
