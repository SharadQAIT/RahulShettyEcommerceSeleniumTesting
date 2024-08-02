package Eccommerce;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot" , "Carrot" ,"Tomato" };

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(5000);
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("H4.product-name"));

		for (int i = 0; i < products.size(); i++) 
		{
			// Brocolli - 1 Kg
			// Brocolli, 1 Kg

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// format it to get actual vegetable name

			// Convert array into array list for easy search
			// Check weather name you extracted is present in arraylist or not

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) 
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) 
				{
					break;
				}

			}

		}

	}

}
