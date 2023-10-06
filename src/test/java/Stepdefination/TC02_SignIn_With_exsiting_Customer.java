package Stepdefination;

import org.testng.annotations.Test;

import PageObject.DashBoardPage;
import PageObject.HomePage;
import PageObject.SignInPage;
import Utilities.BaseClass;

public class TC02_SignIn_With_exsiting_Customer extends BaseClass {
	
	@Test
	public void signInWithExsitingCustomer() throws Exception {
		
		HomePageObject = new HomePage(driver);
		HomePageObject.clickOnSignInSignUp();
		
		SignInPageObject = new SignInPage(driver);
		SignInPageObject.sendEmailID("SaidawdlOyO@yopmail.com");
		SignInPageObject.sendPassword("Chary@733");
		SignInPageObject.clickOnSignInBtn();
		
		
		DashBoardObject = new DashBoardPage(driver);
		DashBoardObject.clickOnSignOut();
		
		
				
		
		
	}
	

	
	
	
	

}
