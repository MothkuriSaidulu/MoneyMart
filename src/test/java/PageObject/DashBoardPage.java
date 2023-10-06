package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class DashBoardPage extends AbstractClass {

	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	@FindBy(xpath = "//div[@class='header-items'] //a[text()='Sign Out']")
//	@FindBy(xpath = "//a[text()='Sign Out']")	
//  @FindBy(linkText = "Sign Out")
	
	@FindBy(xpath = "//a[normalize-space()='Sign Out']")	
	private WebElement signOut;

	@FindBy(xpath = "//div[@class='mm-user-dash__cta mm-loan-status'] //button[1]")
	private WebElement Installment;

	@FindBy(xpath = "//div[@class='mm-user-dash__cta mm-loan-status'] //button[2]")
	private WebElement cashAdvance;

// Actions
	public void clickOnSignOut() throws Exception {
//		 waitWebElementToAppear(signOut);

//		WebElement l = driver.findElement(By.className("gsc-input"));
//		Thread.sleep(10000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", signOut);

		
		
//		signOut.click();
	}

	public void selectInstallmentLoan() {

		waitWebElementToAppear(Installment);
		Installment.click();
	}

}