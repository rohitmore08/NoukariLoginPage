package NaukariUN_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Naukari 
{
	@FindBy (xpath="//div [@class='view-profile-wrapper']")private WebElement clickOnUN;

	
	public HomePage_Naukari (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickHomePage()
	{
		clickOnUN.click();
	}


}
