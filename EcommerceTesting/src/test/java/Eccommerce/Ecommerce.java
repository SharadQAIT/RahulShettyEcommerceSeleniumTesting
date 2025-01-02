package Eccommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot", "Carrot", "Tomato" };

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// WebDriverWait w = new WebDriverWait (driver,5);

		/*
		 * ImplicitlyWait checks every web element for up to 5 seconds. If the element
		 * is found within that time, the script continues execution immediately.
		 */

		/*
		 * Example - The error message appears in 2 seconds, and we have set a 5-second
		 * wait to capture it. However, the execution time of the elements captured it
		 * before the wait period completed.
		 */

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(5000);
		additems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		// Explicit Wait

		/*
		 * Target on specific web element
		 * 
		 */

		// w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		FluentWait<WebDriver> w = null;
		// Explicit Wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void additems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("H4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// Brocolli - 1 Kg
			// Brocolli, 1 Kg

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// format it to get actual vegetable name

			// Convert array into array list for easy search
			// Check weather name you extracted is present in arraylist or not

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}

			}

		}

	}

}
