package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class AboutPage extends AbstractClass {

	WebDriver driver;

	public AboutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	
	
	
}
