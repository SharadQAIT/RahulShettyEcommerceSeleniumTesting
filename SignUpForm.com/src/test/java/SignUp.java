import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(1000);
		driver.findElement(By.name("name")).sendKeys("Sharad");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid"))
				.sendKeys("sharad@mailinator.com");
		Thread.sleep(1000);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test@123");
		Thread.sleep(1000);
		driver.findElement(By.id("exampleCheck1")).click();
		Thread.sleep(1000);
		WebElement staticDropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select DropDown = new Select(staticDropDown);
		DropDown.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("bday")).sendKeys("22/10/1993");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		/*
		 * driver.findElement(By.cssSelector(
		 * ".form-control.ng-untouched.ng-pristine.ng-invalid")).clear(); WebElement
		 * nameTextBox = driver.findElement(By.cssSelector(
		 * ".form-control.ng-untouched.ng-pristine.ng-invalid"));
		 * nameTextBox.sendKeys(""); nameTextBox.sendKeys(Keys.BACK_SPACE);
		 * System.out.println(driver.findElement(By.
		 * xpath("//div[@class='form-group'][2]//div[@class='alert alert-danger']")).
		 * getText());
		 */
	}

}
