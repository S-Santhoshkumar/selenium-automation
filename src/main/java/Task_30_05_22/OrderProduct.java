package Task_30_05_22;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderProduct {
	public void register() {
//	WebElement registerElement = driver.findElement(By.xpath("//div[@id='gh-top']/ul/li/span/span/a"));
//	registerElement.click();
//
//	WebElement firstName = driver.findElement(By.id("firstname"));
//	firstName.sendKeys("Kumar");
//
//	WebElement lastName = driver.findElement(By.id("lastname"));
//	lastName.sendKeys("sabari");
//
//	WebElement email = driver.findElement(By.id("Email"));
//	email.sendKeys("sabarisamy04@gmail.com");
//
//	WebElement password = driver.findElement(By.id("password"));
//	password.sendKeys("kumar99rockz");
//	Thread.sleep(2000);
//	WebElement register = driver.findElement(By.xpath("//button[@name='EMAIL_REG_FORM_SUBMIT']"));
//	register.click();
	}

	@Test
	public static void search() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String oldWindow = driver.getWindowHandle();

		WebElement signin = driver.findElement(By.xpath("//div[@id='gh-top']/ul/li/span/a"));
		signin.click();

		WebElement userName = driver.findElement(By.id("userid"));
		userName.sendKeys("sabarisamy04@gmail.com");

		WebElement continueLogin = driver.findElement(By.id("signin-continue-btn"));
		continueLogin.click();
		Thread.sleep(6000);
		WebElement passwrord = driver.findElement(By.xpath("//input[@id='pass']"));
		passwrord.sendKeys("kumar99rockz");

		WebElement signinbutton = driver.findElement(By.id("sgnBt"));
		signinbutton.click();
		Thread.sleep(20000);

		WebElement searchElement = driver.findElement(By.xpath("//td[@class='gh-td-s']/div/div/input"));

		searchElement.sendKeys("shoe");

		String textString = searchElement.getAttribute("aria-label");
		System.out.println("name:" + textString);
		searchElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//img[@class='s-item__image-img'])[3]")).click();

		Set<String> handle = driver.getWindowHandles();

		for (String newWindows : handle) {
			driver.switchTo().window(newWindows);
		}
		WebElement dropdownByIndex = driver.findElement(By.xpath("//select[@id='msku-sel-1']"));
		Select select = new Select(dropdownByIndex);
		select.selectByIndex(2);

		WebElement imagElement = driver.findElement(By.xpath("//a[@id='vi-viewInCartBtn']"));
		imagElement.click();

		WebElement checkoutElement = driver.findElement(By.xpath("//div[@class='cartsummary-cta']/button"));
		checkoutElement.click();
		Thread.sleep(2000);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File pathFile = screenshot.getScreenshotAs(OutputType.FILE);

		Scanner input = new Scanner(System.in);
		String fileOne;
		String userDirectoryString = System.getProperty("user.dir");
		System.out.println("Enter the first file name");
		fileOne = input.nextLine();
		String PathString = userDirectoryString + File.separator + fileOne;
		File sourceFile = new File(PathString);
		org.openqa.selenium.io.FileHandler.copy(pathFile, sourceFile);
	}

	public void addAddress() {
//	WebElement changeAddress = driver.findElement(By.xpath("(//span[@class='loadable-icon-and-text'])[19]/span/a"));
//	changeAddress.click();
//	Thread.sleep(2000);
//
//	WebElement addNewAdress = driver.findElement(By.xpath("(//span[@class='loadable-icon-and-text'])[20]/span/a"));
//	addNewAdress.click();
//	Thread.sleep(2000);
//
//	WebElement countryId = driver.findElement(By.xpath("//select[@id='country']"));
//	Select selectCountry = new Select(countryId);
//	selectCountry.selectByVisibleText("United States");
//	Thread.sleep(2000);
//
//	WebElement fistName = driver
//			.findElement(By.xpath("(//input[@class='textbox__control textbox__control--large'])[1]"));
//	fistName.sendKeys("Kumar");
//
//	WebElement lastName = driver
//			.findElement(By.xpath("(//input[@class='textbox__control textbox__control--large'])[2]"));
//	lastName.sendKeys("sabari");
//
//	WebElement address = driver
//			.findElement(By.xpath("(//input[@class='textbox__control textbox__control--large'])[3]"));
//	address.sendKeys("15205 North Kierland Blvd. Suite 100");
//
//	WebElement city = driver
//			.findElement(By.xpath("(//input[@class='textbox__control textbox__control--large'])[5]"));
//	city.sendKeys("Scottsdale");
//
//	WebElement statElement = driver.findElement(By.xpath("//select[@id='stateOrProvince']"));
//	Select selectState = new Select(statElement);
//	selectState.selectByVisibleText("Arizona");
//
//	WebElement pincode = driver
//			.findElement(By.xpath("(//input[@class='textbox__control textbox__control--large'])[6]"));
//	pincode.sendKeys("85254");
//
//	WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
//	phoneNumber.sendKeys("48060733884");
//
//	WebElement add = driver.findElement(By.xpath("//div[@class='form-action ADD_ADDRESS_SUBMIT']/button"));
//	add.click();
//	Thread.sleep(2000);
//
//	WebElement useThisAddress = driver.findElement(By.xpath("(//div[@class='address-action'])[1]/button"));
//	useThisAddress.click();
	}

//	public static void main(String[] args) throws InterruptedException, IOException {
//		search();
//
//	}
}
