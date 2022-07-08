package Task_15_06_22;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebay {
	Properties browserProperties = new Properties();
	WebDriver driver;

	@BeforeMethod
	public void launchBrower() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String userWorkingDirectory = System.getProperty("user.dir");
		String pathSeparator = System.getProperty("file.separator");

		String filePath = userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java"
				+ pathSeparator + "Task_15_06_22" + pathSeparator + "ebay.properties";
		FileInputStream inputStream = new FileInputStream(filePath);
		browserProperties.load(inputStream);
		driver.get(browserProperties.getProperty("url"));
	}

	@Test
	public void login() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		try {
			WebElement signIn = driver.findElement(By.xpath(browserProperties.getProperty("signIn")));
			signIn.click();

			WebElement userName = driver.findElement(By.id(browserProperties.getProperty("userName")));
			UsernameAndPassword.isElemenetPresent(userName, browserProperties.getProperty("userNameText"));
			userName.sendKeys(Keys.ENTER);

			WebElement continueButton = driver.findElement(By.id(browserProperties.getProperty("continueButton")));
			continueButton.click();

			WebElement password = driver.findElement(By.xpath(browserProperties.getProperty("password")));
			UsernameAndPassword.isElemenetPresent(password, browserProperties.getProperty("passwordText"));

			WebElement signInButton = driver.findElement(By.xpath(browserProperties.getProperty("signInButton")));
			signInButton.click();

		} catch (Exception e) {
			UsernameAndPassword.screenShot(driver);
		}
		driver.close();
	}
}