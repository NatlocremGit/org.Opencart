package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath="(//span[normalize-space()='My Account'])[1]") WebElement ActregClk;
	@FindBy(xpath="(//a[@class='dropdown-item'][normalize-space()='Register'])[1]") WebElement register;
	
	@FindBy(xpath="(//a[@class='dropdown-item'][normalize-space()='Login'])[1]") WebElement LoginClk;  // Login link added in step6

	
	
	
	public void ActRegClick()
	{
		ActregClk.click();
		
	}
	
	
	public void clickRegister()
	{
		register.click();
		
	}
	
	public void LogInClk()   // added in step6
	{
		LoginClk.click();
	}
}
