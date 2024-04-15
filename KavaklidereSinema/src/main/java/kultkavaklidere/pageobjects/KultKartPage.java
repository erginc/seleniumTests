package kultkavaklidere.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import kultkavaklidere.AbstractClasses.AbstractClass;

public class KultKartPage extends AbstractClass{

	WebDriver driver;
	public KultKartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By by400TL = By.xpath("//a[contains(@href,'/Odeme/KartAl?ProductSubCategory=KultKart_Student')]");
	
	public void TL400KartAl()
	{
        waitElementAppear(by400TL);
		
		WebElement element = driver.findElement(by400TL);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
	}
}
