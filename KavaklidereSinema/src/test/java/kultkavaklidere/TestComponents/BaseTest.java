package kultkavaklidere.TestComponents;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	private static final ThreadLocal<WebDriver> WEBDRIVER_THREADLOCAL = new ThreadLocal<WebDriver>();
	
	public WebDriver InitializeWebDriver() 
	{ 
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
//		WEBDRIVER_THREADLOCAL.set(driver);
//		driver = WEBDRIVER_THREADLOCAL.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
//	@BeforeClass(alwaysRun = true)
//	public void setupClassName(ITestContext context) {
//	    context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(3);
//	    context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
//	}
	@AfterTest(alwaysRun = true) 
	public void closeDriver() throws IOException
	{
//		WebDriver d = WEBDRIVER_THREADLOCAL.get();
//		if(d != null) {
//		d.close();
//		}
////		driver.close();
	}
	
}
