package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.paginaLogin;

public class laboratorio4_E1 {
	WebDriver driver;
	paginaLogin login;
	
	String driverPath = "..\\Educacionit\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com/index.php?controller=authentication";

	@BeforeSuite
	public void setUp() {
		System.setProperty("Webdriver.chrome.driver", "..\\Educacionit\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get(url);
	}
	
	@AfterSuite
	public void cierreNavegador() {
		driver.close();
	}
	
	@Test
	public void irRegistroLogin() {
		
		login = new paginaLogin(driver); //paso el driver al constructor
		
		login.enterEmail("test1@gmail.com", "1234");
		
		Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
		
	}
	
}
