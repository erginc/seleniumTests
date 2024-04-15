package kultkavaklidere.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kultkavaklidere.AbstractClasses.AbstractClass;
import kultkavaklidere.TestComponents.BaseTest;
import kultkavaklidere.pageobjects.*;

public class KrediKarti extends BaseTest {
	
	@Test(dataProvider = "KisiData")
	public void kredi_karti(String name, String surname, String mail, String mobile,String namesurname, String kartno, String tarih, String cvv) throws InterruptedException
	{
	BaseTest baseTest = new BaseTest();
	driver = baseTest.InitializeWebDriver();
	Thread.sleep(500);
	MainPage mainPage = new MainPage(driver);
	IletisimPage iletisimPage = new IletisimPage(driver);
	DestekPage destekPage = new DestekPage(driver);
	KultKartPage kultKartPage = new KultKartPage(driver);
	KartAlPage kartAlPage = new KartAlPage(driver);
	OdemePage odemePage = new OdemePage(driver);
	
	
	mainPage.goToMainPage();
	mainPage.goToIletisimPage();
	
	iletisimPage.ClickKartAl();
	
	destekPage.ClickIncele();
	
	kultKartPage.TL400KartAl();
	
	kartAlPage.BilgileriGirveOdemeTusunaBas(name,surname,mail,mobile);
	odemePage.OdemeBilgileriniGirVeOde(namesurname,kartno,tarih,cvv);
	
	if(odemePage.TestResult())
	{
		assert true;
	}
	else assert false; 
	
	
	}
	@DataProvider(name = "KisiData")
	public Object[][] getData(){
		
		return new Object[][] {
			
			{"Ergin","Cumalı","aay@gmail.com","5394561234" , "Ergin", "4910050000000006", "1230", "123"}
			};
	}

	
	
//	
//	
//	
//	
//	
//	fail kısmı
	
	@Test(dataProvider = "KisiData_fail")
	public void kredi_karti_fail(String name, String surname, String mail, String mobile,String namesurname, String kartno, String tarih, String cvv) throws InterruptedException
	{
	BaseTest baseTest = new BaseTest();
	driver = baseTest.InitializeWebDriver();
	
	MainPage mainPage = new MainPage(driver);
	IletisimPage iletisimPage = new IletisimPage(driver);
	DestekPage destekPage = new DestekPage(driver);
	KultKartPage kultKartPage = new KultKartPage(driver);
	KartAlPage kartAlPage = new KartAlPage(driver);
	OdemePage odemePage = new OdemePage(driver);
	
	
	mainPage.goToMainPage();
	mainPage.goToIletisimPage();
	
	iletisimPage.ClickKartAl();
	
	destekPage.ClickIncele();
	
	kultKartPage.TL400KartAl();
	
	kartAlPage.BilgileriGirveOdemeTusunaBas(name,surname,mail,mobile);
	
	odemePage.OdemeBilgileriniGirVeOde(namesurname,kartno,tarih,cvv);
	
	if(odemePage.TestResult_fail())
	{
		assert true;
	}
	else assert false; 
	
	
	}
	@DataProvider(name = "KisiData_fail", parallel = false)
	public Object[][] getData_fail(){
		
		return new Object[][] {
			{"Ergin","Cumalı","ergin@hotmail.com","5413216789" , "Ergin", "5168880000000002", "1230", "123"}
			
			};
	}
}