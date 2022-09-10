package Eduit.Educacionit;

import org.junit.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

public class Laboratorio2 {
	
	@Test 
	public void lab2_E1() {
		System.setProperty("Webdriver.chrome.driver", "..\\Educacionit\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		driver.manage().window().maximize();
		
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
		
		driver.close();
	}

}
