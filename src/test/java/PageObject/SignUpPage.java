package PageObject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class SignUpPage extends AbstractClass {

	public WebDriver driver;

	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='mm-login-page__title']")
	private WebElement signUpText;
	
	// Type 1
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement firstName_txt;

	// Type 2
	// By userName2 = By.xpath("//input[@id='userEmail']");

	// Type 3
	@FindBy(css = "input[name='lastName']")
	private WebElement lastName_txt;

	@FindBy(css = "button[class='arrowbtn']")
	private WebElement DOB_btn;

	@FindBy(xpath = "//div[@class='mm-calendar__wrapper'] //select[@name='year']")
	private WebElement yearDropDown;

	@FindBy(xpath = "//select[@name='year'] //option")
	private List<WebElement> yearsList;

	@FindBy(xpath = "//div[@class='mm-calendar__wrapper'] //select[@name='month']")
	private WebElement monthDropDown;

	@FindBy(how = How.XPATH, using = "//select[@name='month'] //option")
	private List<WebElement> monthList;

	@FindBy(xpath = "//div[@class='mm-calendar__wrapper'] //div[@class='mm-calendar__day ']")
	private List<WebElement> daysList;

	@FindBy(css = "input[name='phoneNumber']")
	private WebElement phoneNumber_txt;

	@FindBy(css = "input[name='email']")
	private WebElement email_txt;

	@FindBy(xpath = "//span[@class='mm-select']")
	private WebElement securityDropDown;

	@FindBy(xpath = "//div[@class='mm-dropdown__menu'] //button")
	private List<WebElement> securityOptions;

	@FindBy(css = "input[aria-label='securityQuesAns']")
	private WebElement securityQuesAns;

	@FindBy(xpath = "//input[@name='newPassword']")
	private WebElement newPassword_txt;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement confirmPassword_txt;

	@FindBy(xpath = "//button[@value='Create Account']")
	private WebElement CreateAccountBtn;

	@FindBy(xpath = "//div[@class='mm-alert mm-alert--success']")
	private WebElement successMessage;
	
	
	
// Actions
	public void sendFirstName() {

//		String signUpText = driver.findElement(By.xpath("//h1[@class='mm-login-page__title']")).getText();
//		Assert.assertEquals(signUpText, "Sign up to Money Mart");
		waitWebElementToAppear(signUpText);
		firstName_txt.sendKeys("Saidachary" + randomString());

	}

	public void sendLastName() {
		lastName_txt.sendKeys("Mothkuri" + randomString());

	}

	public void selectDateOfBirth() throws IOException {
		DOB_btn.click();
		waitWebElementToAppear(yearDropDown);
		yearDropDown.click();

//		Properties prop = new Properties();
//		FileInputStream file = new FileInputStream("config.properties");
//		prop.load(file);
//		String configYear = prop.getProperty("Year");

		String configYear = properties("Year");

// Select year

		for (int i = 0; i < yearsList.size(); i++) {
			String webYear = yearsList.get(i).getText();
			if (webYear.contains(configYear)) {
				yearsList.get(i).click();

			}
		}

// Select Month
		waitWebElementToAppear(monthDropDown);

//		String configMonth = prop.getProperty("Month");
		String configMonth = properties("Month");

		for (int i = 0; i < monthList.size(); i++) {
			String webYear = monthList.get(i).getText();
			if (webYear.contains(configMonth)) {
				monthList.get(i).click();
			}
		}
// Select day
		waitListOFWebElementsToAppear(daysList);
//		String configDay = prop.getProperty("Date");

		String configDay = properties("Date");

		for (int i = 0; i < daysList.size(); i++) {
			String webYear = daysList.get(i).getText();
			if (webYear.contains(configDay)) {
				daysList.get(i).click();
			}
		}
	}

	public void sendPhoneNumber() {
		waitWebElementToAppear(phoneNumber_txt);
		phoneNumber_txt.sendKeys(randomPhoneNumber());

//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.DOWN);
	}

	public String sendEmailID() {
		String emailID = "Saida" + randomString() + "@yopmail.com";
		System.out.println(emailID);
		email_txt.sendKeys(emailID);
		return emailID;
	}

	public void selectSecurityOption() throws IOException {
		securityDropDown.click();

		String configSecurityOption = properties("SecurityOptions");

		for (int i = 0; i < securityOptions.size(); i++) {
			String option = securityOptions.get(i).getText();
//			System.out.println(option);
			if (option.contains(configSecurityOption)) {
				securityOptions.get(i).click();
				break;
			}
		}
	}

	public void selectSecurityAns() throws IOException {

		String configSelectSecurityAns = properties("SelectSecurityAns");
		securityQuesAns.sendKeys(configSelectSecurityAns);
	}

	public String setPassword() {
		String password = "Chary@" + randomNumeric();
		System.out.println(password);
		newPassword_txt.sendKeys(password);
		confirmPassword_txt.sendKeys(password);
		return password;

	}

	public void clickOnCreateBtn() {
		CreateAccountBtn.click();
		//WebElement loader = driver.findElement(By.xpath("//div[@class='mm-page-loader__wrapper']"));
		//waitWebElementToDissappear();

//		System.out.println(successMessage.getText());
		
	}
}