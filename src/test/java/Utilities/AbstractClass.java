package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {
	
	public WebDriver driver;
	
	By loader = By.xpath("//div[@class='mm-page-loader__wrapper']");
	
	public AbstractClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// Waits
	public void waitWebElementToAppear(WebElement WebElement) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(WebElement));
		
	}
	
	public void waitListOFWebElementsToAppear(List<WebElement> WebElements) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(WebElements));	
	}

	public void waitWebElementToDissappear(By loader2) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.invisibilityOf(WebElement));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}
	
// Random Strings
	
	@SuppressWarnings("static-access")
	public String randomString() 
	{
		String randaom = new RandomStringUtils().randomAlphabetic(6);
		return randaom;
		
	}

	@SuppressWarnings("static-access")
	public String randomPhoneNumber() 
	{
		
		String randaomPhoneNumber = new RandomStringUtils().randomNumeric(10);
		return randaomPhoneNumber;
		
	}

	@SuppressWarnings("static-access")
	public String randomNumeric() 
	{
		
		String randomNumericValue = new RandomStringUtils().randomNumeric(3);
		return randomNumericValue;
		
	}
	
	public String properties(String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		String getProperty = prop.getProperty(value);

		return getProperty;
	}
	
}
