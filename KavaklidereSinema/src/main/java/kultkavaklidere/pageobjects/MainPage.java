package kultkavaklidere.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import kultkavaklidere.AbstractClasses.AbstractClass;

public class MainPage{

	WebDriver driver;
	public MainPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By byIletisim = By.xpath("/html/body/div[1]/nav/ul/li[6]/a");
	
	
	public void goToMainPage()
	{
		driver.get("https://www.kultkavaklidere.org");
	}
	
	public void goToIletisimPage()
	{
		driver.findElement(byIletisim).click();
	}
	
	public void goToKartAlPage() 
	{
		driver.get("https://www.kultkavaklidere.org/Odeme/KartAl?ProductSubCategory=KultKart_Student");
	}
}
