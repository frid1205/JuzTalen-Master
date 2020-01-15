/**
 * @author fendyridwan
 * 
 * This page used for configuration setting
 *
 */
package bases;

import java.io.File;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import pages.AuthenticationSignInPage;

@Listeners(bases.Listener.class)
public class BaseWeb 
{
	public static WebDriver driver;
	public static String validCompanyUser;
	public static String validUsername;
	public static String validPassword;
	public static String url;
	
	@BeforeSuite
	public void settupTestingData() {
		validCompanyUser = "company2";
		validUsername = "company2admin";
		validPassword = "123456789";
	}
	
	@BeforeSuite
	public void deleteScreenShot() throws IOException
	{
		File dir = new File("ScreenShot");
		File[] listFiles = dir.listFiles();
	
		if(dir.length() >0) {
			for(File file : listFiles){
				file.getName();
				file.delete();
			}
			dir.delete();
		}
	}
	
	@BeforeClass
	@Parameters ({"browser"})
	public void setBaseConfig(String browser) 
	{
		url = "http://juztalent-cms-staging.s3-website-ap-southeast-1.amazonaws.com";
		
		WebDriver driver = BrowserFactory.startBrowser(browser, url);
		BaseWeb.driver = driver;
		
	}
	
	
	//sign in with valid credential
	public void signIn()
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		//Type invalid company username
		login.typeCompanyUserName(validCompanyUser);
		
		//Type valid username
		login.typeUserName(validUsername);
		
		//type valid password
		login.typePassword(validPassword);
		
		//click login button
		login.clickLoginButton();
	}
	
	//get driver of this class for screenshot
	public File getscreenshot()throws IOException
	{
		File des = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return des;
	}
	
	
	@AfterClass
	public void quitDriver()
	{
		driver.quit();
	}
}
