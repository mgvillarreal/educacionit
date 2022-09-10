package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.paginaLogin;

public class laboratorio5_E1 {
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
	
	@Test(dataProvider="Datos para Login")
	public void irRegistroLogin(String email, String password) {
		
		login = new paginaLogin(driver); //paso el driver al constructor
		
		//login.enterEmail("test1@gmail.com", "1234");
		login.enterEmail(email, password);
		
		Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
		
	}
	
	
	@DataProvider(name="Datos para Login")
	public Object[][] getData(){
		
		Object[][]data = new Object[2][2];
		
		data[0][0] = "test1@gmail.com"; data[0][1] = "1234";
		data[1][0] = "test2@gmail.com"; data[1][1] = "5678";
		
		return data;
				
	}
	
}
