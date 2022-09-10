package Eduit.Educacionit;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class laboratorio3_ejercicio1 {
	
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("Webdriver.chrome.driver", "..\\Educacionit\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}

	@BeforeTest
	public void irUrl() {
		driver.get(url);
	}
	
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(priority=2) //le da prioridad a los test, con enable se puede activar/desactivar los test a ejecutar
	public void registroUsuario() {
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo" + Math.random() + "@correo.com");
		
		WebElement btnCreate = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		btnCreate.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));
		
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.name("customer_firstname")).sendKeys("Gabriela");
		
		driver.findElement(By.name("passwd")).sendKeys("123456");
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue("4");
		
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		
		//VALIDAMOS
		Assert.assertEquals(url, driver.getCurrentUrl()); //se validan las URL: la que seteamos y en la que estamos parados
	}
	
	@AfterMethod
	public void capturarPantalla() throws IOException {
		//cuando trabajamos con archivos necesitamos una dependencia (commons-io)
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\Educacionit\\Evidencias\\pantalla.png"));
	}
	
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de prueba");	
	}
	
	@AfterTest
	public void cierreNavegador() {
		driver.close();
	}
	
	@AfterSuite
	public void finSuite() {
		System.out.println("Fin de suite");
	}
}
