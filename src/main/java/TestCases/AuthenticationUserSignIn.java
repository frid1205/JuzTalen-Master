/**
 * @author fendyridwan
 * Verify Authentication User Sign In
 */
package TestCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import bases.BaseWeb;
import pages.AuthenticationSignInPage;


public class AuthenticationUserSignIn extends BaseWeb {
	
	/*
	 * Feature	: Sign In with Unregistered Company Username
	 * Given	: the user type unregistered company username
	 * And		: user type valid username
	 * And		: user type valid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_001_AuthenticationWithUnregisteredCompanyUser() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//clear field
		login.clearField();
		
		//Type invalid company username
		login.typeCompanyUserName("invalidCompanyUsername");
		
		//Type valid username
		login.typeUserName(validUsername);
		
		//type valid password
		login.typePassword(validPassword);
		
		//click login button
		login.clickLoginButton();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//assertion if display error and page still in login page mean pass otherwise fail
		Assert.assertEquals(login.getURL(), login.expectedURL());
		Assert.assertTrue(login.getErrorMessage());
		
	}
	
	
	/*
	 * Feature	: Sign In with unregistered Username
	 * Given	: the user type registered Company username
	 * And		: user type unregistered username
	 * And		: user type valid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_002_AuthenticationWithUnregisteredUserName() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//clear field
		login.clearField();
		
		//Type valid company username
		login.typeCompanyUserName(validCompanyUser);
		
		//Type invalid username
		login.typeUserName("test");
		
		//type valid password
		login.typePassword(validPassword);
		
		//click login button
		login.clickLoginButton();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//assertion if display error and page still in login page mean pass otherwise fail
		Assert.assertEquals(login.getURL(), login.expectedURL());
		Assert.assertTrue(login.getErrorMessage());
	}
	
	/*
	 * Feature	: Sign In with invalid password
	 * Given	: the user type registered Company username
	 * And		: user type registered username
	 * And		: user type invalid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_003_AuthenticationWithInvalidPassword() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//clear field
		login.clearField();
		
		//Type invalid company username
		login.typeCompanyUserName(validCompanyUser);
		
		//Type valid username
		login.typeUserName(validUsername);
		
		//type invalid password
		login.typePassword("lskdjflkdsjf");
		
		//click login button
		login.clickLoginButton();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//assertion if display error and page still in login page mean pass otherwise fail
		Assert.assertEquals(login.getURL(), login.expectedURL());
		Assert.assertTrue(login.getErrorMessage());
	}
	
	/*
	 * Feature	: Sign In with Empty Company Username
	 * Given	: Company username is skipped
	 * And		: username field is skipped
	 * And		: user type valid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_004_AuthenticationWithEmptyCompanyUserName() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//clear field
		login.clearField();
		
		Thread.sleep(5000);
		
		//Type valid company username
		login.typeUserName(validUsername);
		
		//type valid password
		login.typePassword(validPassword);
		
		//click login button
		login.clickLoginButton();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//assertion if display error and page still in login page mean pass otherwise fail
		Assert.assertEquals(login.getURL(), login.expectedURL());
		Assert.assertTrue(login.getMandatoryMessage());
	}
	
	/*
	 * Feature	: Sign In with Empty Username
	 * Given	: the user type registered Company username
	 * And		: username field is skipped
	 * And		: user type valid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_005_AuthenticationWithEmptyUserName() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//clear field
		login.clearField();
		
		//Type valid company username
		login.typeCompanyUserName(validCompanyUser);
		
		//type valid password
		login.typePassword(validPassword);
		
		//click login button
		login.clickLoginButton();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//assertion if display error and page still in login page mean pass otherwise fail
		Assert.assertEquals(login.getURL(), login.expectedURL());
		Assert.assertTrue(login.getMandatoryMessage());
	}
	
	/*
	 * Feature	: Sign In with Empty Password
	 * Given	: the user type registered Company username
	 * And		: The user type registered username
	 * And		: password field is skipped
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_006_AuthenticationWithEmptyPassword() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//clear field
		login.clearField();
		
		//Type valid company username
		login.typeCompanyUserName(validCompanyUser);
		
		//Type valid username
		login.typeUserName(validUsername);
		
		//click login button
		login.clickLoginButton();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//assertion if display error and page still in login page mean pass otherwise fail
		Assert.assertEquals(login.getURL(), login.expectedURL());
		Assert.assertTrue(login.getMandatoryMessage());
		Assert.assertTrue(false);
	}

}
