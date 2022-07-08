package CodeReusability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aspire {
	WebDriver driver;

	@Test(priority = 0)
	public void chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://aspire.atmecs.online/login");
	}

	@Test(priority = 1)
	public void loginDetails() {
		WebElement userName = driver.findElement(By.xpath("(//input[@class='text '])[1]"));
		LoginPage.isElemenetPresent(userName, "Sasn");
		WebElement password = driver.findElement(By.xpath("(//input[@class='text '])[2]"));
		LoginPage.isElemenetPresent(password, "323");
	}
}
