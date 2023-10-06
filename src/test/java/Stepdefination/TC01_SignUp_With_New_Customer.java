package Stepdefination;

import org.testng.annotations.Test;

import PageObject.DashBoardPage;
import PageObject.HomePage;
import PageObject.SignInPage;
import PageObject.SignUpPage;
import Utilities.BaseClass;

public class TC01_SignUp_With_New_Customer extends BaseClass {

	@Test
	public void signUp() throws Exception {
//		browser and url takecare by base class

		HomePageObject = new HomePage(driver);
		HomePageObject.clickOnSignInSignUp();

		SignInPageObject = new SignInPage(driver);
		SignInPageObject.clickOnSignUp();

		SignUpPageObject = new SignUpPage(driver);

		SignUpPageObject.sendFirstName();
		SignUpPageObject.sendLastName();
		SignUpPageObject.selectDateOfBirth();
		SignUpPageObject.sendPhoneNumber();
		SignUpPageObject.sendEmailID();
		SignUpPageObject.selectSecurityOption();
		SignUpPageObject.selectSecurityAns();
		SignUpPageObject.setPassword();
		SignUpPageObject.clickOnCreateBtn();
		
		DashBoardObject = new DashBoardPage(driver);
		DashBoardObject .clickOnSignOut();
		
	}

}
