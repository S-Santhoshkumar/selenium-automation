package CodeReusability;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	Properties browserProperties = new Properties();
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String userWorkingDirectory = System.getProperty("user.dir");
		String pathSeparator = System.getProperty("file.separator");
		String filePath = userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java"
				+ pathSeparator + "CodeReusability" + pathSeparator + "amazon.properties";

		FileInputStream inputStream = new FileInputStream(filePath);

		browserProperties.load(inputStream);
		driver.get(browserProperties.getProperty("url"));

		WebElement cancel = driver.findElement(By.xpath(browserProperties.getProperty("cancel")));
		cancel.click();
	}

	@Test
	public void searchButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(20)).ignoring(IOException.class);

		WebElement searchElement = driver.findElement(By.xpath(browserProperties.getProperty("searchBox")));
		searchElement.sendKeys(browserProperties.getProperty("searchtext"));
		searchElement.sendKeys(Keys.ENTER);

		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(20)).ignoring(IOException.class);

		// Printing the brand names
		WebElement checkBox = driver.findElement(By.xpath(browserProperties.getProperty("checkBox")));
		checkBox.click();

		Wait<WebDriver> wait11 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(20)).ignoring(IOException.class);

		List<String> addBrandName = new ArrayList<String>();

		List<WebElement> getNameList = driver.findElements(By.xpath(browserProperties.getProperty("searchTextList")));
		for (WebElement nameElement : getNameList) {
			String brandName = nameElement.getText();
			System.out.println("Brand name List :" + brandName);
			addBrandName.add(brandName);
		}

		// Printing the brand pricing

		List<String> addRatingList = new ArrayList<String>();

		List<WebElement> getBrandRatingList = driver.findElements(By.xpath(browserProperties.getProperty("rateList")));
		for (WebElement ratingElement : getBrandRatingList) {
			String brandRating = ratingElement.getText();
			System.out.println("Price list : " + brandRating);
			addRatingList.add(brandRating);
		}

		// Checking the highest price
		TreeSet<Double> myRatingList = new TreeSet<Double>();
		for (String myRating : addRatingList) {
			double newPrice = Double.parseDouble(myRating);
			myRatingList.add(newPrice);
		}
		System.out.println("Highest rating  : " + myRatingList.last());
		driver.close();
	}

}
