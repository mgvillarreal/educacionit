package Eduit.Educacionit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebElement;

public class Laboratorio1 {
	
	@Test @Ignore
	public void lab1_test() {
		System.out.println("Hola Mundo de Automatizacion!");
	}
	
	
	@Test @Ignore
	public void lab1_E1() {
		System.setProperty("Webdriver.chrome.driver", "..\\Educacionit\\Drivers\\chromedriver.exe"); //se hace referecia a la ruta del driver. Primero se setea el driver y luego la ruta
		WebDriver driver = new ChromeDriver(); //instancia del chrome
		
		driver.get("http://automationpractice.com/index.php"); //le digo la url a donde quiero ingresar. Se pueden usar navigate to, navigate tambien. Permite abrir la web que quiero automatizar
		
		//driver.close(); //el close cierra la pantalla actual. El quit cierra todo
		
		driver.manage().window().maximize(); //maximiza la pantalla
	}
	
	
	@Test @Ignore
	public void lab1_E2() {
		System.setProperty("Webdriver.chrome.driver", "..\\Educacionit\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.close();
	}
	
	
	@Test
	public void lab1_E3() {
		System.setProperty("Webdriver.chrome.driver", "..\\Educacionit\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		WebElement txtTopSearch = driver.findElement(By.id("search_query_top"));
		txtTopSearch.clear(); //para borrar
		txtTopSearch.sendKeys("Blouse"); //le mando un dato al txt
		txtTopSearch.sendKeys(Keys.ENTER); //le mando referencia a la tecla enter
		
		driver.close();
	}

}
