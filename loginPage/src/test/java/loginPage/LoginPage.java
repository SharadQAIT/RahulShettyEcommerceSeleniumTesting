package loginPage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginPage {

	@Test(invocationCount = 10)
	public void loginTest() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 */
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

//		driver.findElement(By.id("okayBtn")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		// Locate the dropdown element by its ID
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));

		// Create a Select object with the located dropdown
		Select select = new Select(dropdown);

		// Select an option by visible text

		select.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		driver.quit();
	}

}
