package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.AbstractClass;

public class HomePage extends AbstractClass{

	public WebDriver driver;
	
	public HomePage( WebDriver driver )
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.XPATH, xpath = "//div[@class='header__nav-top'] //span[text()='Sign In / Sign Up']")
	private WebElement sign_in_signUp;
	
	
	
//  Actions
	
	public void clickOnSignInSignUp() 
	{
		waitWebElementToAppear(sign_in_signUp);
		Assert.assertEquals(driver.getTitle(), "Quick Loans | Money Mart");
		sign_in_signUp.click();
	}
	
}
