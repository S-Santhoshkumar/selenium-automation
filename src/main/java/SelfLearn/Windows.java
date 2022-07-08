package SelfLearn;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static void windows() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");

		// this will store and get current window identity.
		String oldWindow = driver.getWindowHandle();

		WebElement homePage = driver.findElement(By.id("home"));
		homePage.click();

		// to access the contol for new window from old window.
		Set<String> handles = driver.getWindowHandles();

		for (String newWindow : handles) {
			driver.switchTo().window(newWindow);
		}

		WebElement editboxElement = driver
				.findElement(By.xpath("//div[@class='wp-landing-categories']/div/ul/li/a/img"));
		editboxElement.click();

		driver.close();

		driver.switchTo().window(oldWindow);

		WebElement mulWindowsElement = driver
				.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/button"));
		mulWindowsElement.click();

		int size = driver.getWindowHandles().size();
		System.out.println("No of windows : " + size);

		WebElement dontClosElement = driver.findElement(By.id("color"));
		dontClosElement.click();

		Set<String> newWindowSet = driver.getWindowHandles();

		for (String allwindows : newWindowSet) {
			if (!allwindows.equals(oldWindow)) {
				driver.switchTo().window(allwindows);
				driver.close();
			}
		}
		driver.quit();
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		windows();
	}
}
