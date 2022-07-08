package SelfLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Editboxes {

	public static void editBoxes() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("javaTpoint" + Keys.ENTER);
		WebDriver boxes = new ChromeDriver();
		boxes.get("https://demoqa.com/automation-practice-form");

		WebElement date = boxes.findElement(By.xpath("(//*[@class='form-control'])[1]"));
		String displayDate = date.getAttribute("value");
		System.out.println(displayDate);

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		editBoxes();
	}
}
