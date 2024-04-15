package kultkavaklidere.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kultkavaklidere.AbstractClasses.AbstractClass;
import kultkavaklidere.TestComponents.BaseTest;
import kultkavaklidere.pageobjects.*;

public class SadeceKrediKarti extends BaseTest {
	
		@Test(dataProvider = "KisiDataSadeceKK")
		public void sadece_kredi_karti(String name, String surname, String mail, String mobile,String namesurname, String kartno,
				String tarih, String cvv) throws InterruptedException
		{
			BaseTest baseTest = new BaseTest();
			driver = baseTest.InitializeWebDriver();
			
			MainPage mainPage = new MainPage(driver);
			KartAlPage kartAlPage = new KartAlPage(driver);
			OdemePage odemePage = new OdemePage(driver);
			
			mainPage.goToKartAlPage();
			Thread.sleep(500);
			kartAlPage.BilgileriGirveOdemeTusunaBas(name,surname,mail,mobile);
			odemePage.OdemeBilgileriniGirVeOde(namesurname,kartno,tarih,cvv);
			
			if(odemePage.TestResult())
			{
				assert true;
			}
			else assert false;
			
		}
		@DataProvider(name = "KisiDataSadeceKK", parallel = false)
		public Object[][] getData(){
			return new Object[][] {
				{"Mehmet","Yıldız","trial@hotmail.com","5392346091" , "Ergin", "4910050000000006", "1230", "123"},
				{"Ali","Aykut","trial@gmail.com","5392139542" , "Ergin", "4122111111111118", "1230", "123"}
				};
		}
}
