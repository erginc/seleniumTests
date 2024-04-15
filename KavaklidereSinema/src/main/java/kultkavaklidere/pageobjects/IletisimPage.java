package kultkavaklidere.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import kultkavaklidere.AbstractClasses.AbstractClass;

public class IletisimPage extends AbstractClass{

	WebDriver driver;
	public IletisimPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	By byKartAl = By.xpath("//a[contains(.,'Kart Al')]");
	
	public void ClickKartAl()
	{
		waitElementAppear(byKartAl);
		
		WebElement element = driver.findElement(byKartAl);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);//normal click atınca not clickable exception atıyodu
		

	}
}
