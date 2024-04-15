package kultkavaklidere.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import kultkavaklidere.AbstractClasses.AbstractClass;

public class OdemePage extends AbstractClass{

	WebDriver driver;
	public OdemePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By adsoyad = By.id("ccname");
	By cardno = By.id("ccnumber");
	By cardtarih = By.id("ccexp");
	By cvc = By.id("cccvc");
	By paybutton = By.id("iyz-payment-button");
	By image = By.cssSelector(".status-image");
	By statu = By.cssSelector(".status-text");
	
	public void OdemeBilgileriniGirVeOde(String namesurname, String kartno, String tarih, String cvv) throws InterruptedException
	{
        waitElementAppear(adsoyad);
        Thread.sleep(100);
        driver.findElement(adsoyad).sendKeys(namesurname);
        Thread.sleep(100);
        driver.findElement(cardno).sendKeys(kartno);
        Thread.sleep(100);
        driver.findElement(cardtarih).sendKeys(tarih);
        Thread.sleep(100);
        driver.findElement(cvc).sendKeys(cvv);
        Thread.sleep(100);
        
		WebElement element = driver.findElement(paybutton);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
	}
	public Boolean TestResult() throws InterruptedException
	{
		Boolean result;
//		waitElementAppear(image);
		waitElementAppear(statu);
		Thread.sleep(3000);
		String resulttext = driver.findElement(statu).getText();
		System.out.println("result: " + resulttext);
		
		if(resulttext.contains("Başarılı")) 
		{
			result = true;
		}
		else if (resulttext.contains("Başarısız")) {
			result = false;
		}
		else result = false;
		return result;
	}
	public Boolean TestResult_fail() throws InterruptedException
	{
		Boolean result;
//		waitElementAppear(image);
		waitElementAppear(statu);
		Thread.sleep(3000);
		String resulttext = driver.findElement(statu).getText();
		System.out.println("result: " + resulttext);
		
		if(resulttext.contains("Başarısız")) 
		{
			result = true;
		}
		else result = false;
		return result;
	}
}
