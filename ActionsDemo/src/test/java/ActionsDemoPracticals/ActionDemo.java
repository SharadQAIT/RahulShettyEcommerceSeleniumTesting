package ActionsDemoPracticals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// New ChromeDriver is the launch the browser.
		// We are creating an instance variable for webdriver and that variable populates the webdriver methods and it's communicate with chromedriver
		//driver is an instance variable of type WebDriver.
		//This variable holds the reference to an object of the ChromeDriver class.
		//This allows us to call the methods defined in the WebDriver interface (e.g., get(), findElement(), quit()) on the ChromeDriver instance.
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions a= new Actions(driver);
		
		WebElement move= driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(move).build().perform();
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		a.moveToElement(move).contextClick().build().perform(); // Right click code > Contextclick() method use
	}

}
