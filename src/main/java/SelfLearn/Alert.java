package SelfLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	public static void alert() throws InterruptedException {
		WebDriver alert = new ChromeDriver();
		alert.get("https://demoqa.com/alerts");
		WebElement alertElement = alert.findElement(By.id("alertButton"));
		alertElement.click();
		Thread.sleep(2000);
		org.openqa.selenium.Alert alert2 = alert.switchTo().alert();
		alert2.accept();
		Thread.sleep(2000);

		WebElement timerElement = alert.findElement(By.id("timerAlertButton"));
		timerElement.click();
		Thread.sleep(6000);
		org.openqa.selenium.Alert timAlert = alert.switchTo().alert();
		timAlert.accept();

		WebElement confirmElement = alert.findElement(By.id("confirmButton"));
		confirmElement.click();
		Thread.sleep(2000);
		org.openqa.selenium.Alert confirmAlert = alert.switchTo().alert();
		confirmAlert.dismiss();
		Thread.sleep(2000);

		WebElement promptElement = alert.findElement(By.id("promtButton"));
		promptElement.click();
		Thread.sleep(2000);
		org.openqa.selenium.Alert prompAlert = alert.switchTo().alert();
		prompAlert.sendKeys("Hi");
		Thread.sleep(2000);
		prompAlert.accept();

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		alert();
	}
}
