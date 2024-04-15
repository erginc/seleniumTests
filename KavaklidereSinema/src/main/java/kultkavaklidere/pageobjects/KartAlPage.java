package kultkavaklidere.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kultkavaklidere.AbstractClasses.AbstractClass;

public class KartAlPage extends AbstractClass{

	
	WebDriver driver;
	public KartAlPage(WebDriver driver)
	{
		super(driver); 
		this.driver = driver;
	}

	By byName = By.id("Name"); 
	By bySurname = By.id("Surname");
	By byGSM = By.id("GsmNumber");
	By byEmail = By.id("email");
	By byOdemeYap = By.id("paymentButton");
	By kabulEt = By.id("LicenceAccepted");
	By paymentButton = By.id("iyz-payment-button");
	
	public void BilgileriGirveOdemeTusunaBas(String name, String surname, String mail, String mobile)
	{
		waitElementAppear(byName);
		driver.findElement(byName).sendKeys(name);
		driver.findElement(bySurname).sendKeys(surname);
		driver.findElement(byEmail).sendKeys(mail);
		driver.findElement(byGSM).sendKeys(mobile);
		driver.findElement(kabulEt).click();
		
		WebElement element = driver.findElement(byOdemeYap);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
		
	}
	
	public Boolean TestResult()
	{
		waitElementAppear(paymentButton);
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		Boolean result = false;
		if(currentURL.contains("https://www.kultkavaklidere.org/Odeme/PaymentStartKartAl?")) 
		{
			result = true;
		}
		return result;
	}
	
	
	
}
