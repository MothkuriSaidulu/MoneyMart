package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import PageObject.DashBoardPage;
import PageObject.HomePage;
import PageObject.SignInPage;
import PageObject.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {



	public WebDriver driver;
		
	
	public HomePage HomePageObject;
	public SignInPage SignInPageObject;
	public SignUpPage SignUpPageObject; 
	public DashBoardPage DashBoardObject;
	
	
	
	public WebDriver initiateBrowser() throws IOException
	{
		
		Properties prop = new Properties();
		
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		
		String browserName = prop.getProperty("Browser");
		
		if (browserName.contains("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		return driver;
	}
	
// Every test execution below method will execute first
	@BeforeClass
	public void launchWebUrl() throws IOException 
	{
		driver = initiateBrowser();
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		String url = prop.getProperty("Url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
		
}