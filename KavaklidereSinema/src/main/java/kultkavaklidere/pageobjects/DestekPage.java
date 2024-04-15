package kultkavaklidere.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import kultkavaklidere.AbstractClasses.AbstractClass;

public class DestekPage extends AbstractClass{

	WebDriver driver;
	public DestekPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	By byIncele = By.cssSelector(".card-container:last-of-type button:last-of-type");
	
	public void ClickIncele()
	{
		waitElementAppear(byIncele);

		WebElement element = driver.findElement(byIncele);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", element);
	}
}
