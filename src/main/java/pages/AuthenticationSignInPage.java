/**
 * @author fendyridwan
 *
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthenticationSignInPage {
	
	WebDriver driver;
	
	public AuthenticationSignInPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(name="company")
	@CacheLookup
	WebElement companyUserName;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[2]/div/div/div/form/button")
	@CacheLookup
	WebElement submitButton;
	
	
	public void typeCompanyUserName(String companyUserName){
		this.companyUserName.sendKeys(companyUserName);
	}
	
	public void typeUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void typePassword(String password){
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton(){
		submitButton.click();
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}

	public String expectedURL(){
		return "http://juztalent-cms-staging.s3-website-ap-southeast-1.amazonaws.com/";
	}
	
	public boolean getErrorMessage(){
		boolean em = !driver.findElements(By.xpath("//*[contains(text(), 'UserNotFound')]")).isEmpty();
		return em;
	}
	
	public boolean getMandatoryMessage(){
		boolean em = !driver.findElements(By.xpath("//*[contains(text(), 'This field is mandatory.')]")).isEmpty();
		return em;
	}
	
	public void clearField() {
		companyUserName.clear();
		userName.clear();
		password.clear();
	}
	
	
}
