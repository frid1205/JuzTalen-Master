/**
 * 
 */
package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author fendyridwan
 *
 */
public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url) 
	{
		//System.setProperty("webdriver.chrome.logfile", "TestLog.txt");
		
		if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
	}

}
