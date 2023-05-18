package NaukariUN_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Profile_Naukari 

{
	
@FindBy (xpath="//span [@class='fullname']")private WebElement getUN;
@FindBy (xpath="//div [@class='nI-gNb-bar3']")private WebElement ClickOnPage;
@FindBy (xpath="//a [@title='Logout']") private WebElement ClickOnLogout;



	public Profile_Naukari  (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyUN(String expUN)
	{
		
		String ActualUN = getUN.getText();
		
		Assert.assertEquals(ActualUN, expUN);
		
		Reporter.log("Test case ID 100 Pass");
	}

	public void ClickLogoutButton()
	{
		ClickOnPage.click();
		ClickOnLogout.click();
		
	}
}
