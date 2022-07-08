package Assesement_06_06_22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssementDemo {
	String firstNameString, lastNameString, postCodeString;
	WebDriver driver = new ChromeDriver();

	public void demoWebsites() throws InterruptedException {

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

		Thread.sleep(2000);

		WebElement bankManagerLogin = driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-lg'])[2]"));
		bankManagerLogin.click();

		Thread.sleep(2000);

		WebElement customerList = driver.findElement(By.xpath("(//div[@class='center']/button)[1]"));
		customerList.click();
		Thread.sleep(2000);

		WebElement firstName = driver.findElement(By.xpath("(//div[@class='form-group'])[1]/input"));
		firstName.sendKeys("kumar");
		WebElement lastName = driver.findElement(By.xpath("(//div[@class='form-group'])[2]/input"));
		lastName.sendKeys("sabari");
		WebElement postCode = driver.findElement(By.xpath("(//div[@class='form-group'])[3]/input"));
		postCode.sendKeys("602024");

//		Random random = new Random();
//		firstNameString = RandomStringUtils.randomAlphabetic(7);
//		lastNameString = RandomStringUtils.randomAlphabetic(5);
//		postCodeString = "PostCode : " + random.nextInt();
//
//		firstName.sendKeys(firstNameString);
//		Thread.sleep(2000);
//		String textString = firstName.getText();
//		System.out.println(textString);
//		lastName.sendKeys(lastNameString);
//		Thread.sleep(2000);
//		postCode.sendKeys(postCodeString);
//		Thread.sleep(2000);

		WebElement addCustomer = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		addCustomer.click();
		Thread.sleep(2000);

		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		WebElement customer = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
		customer.click();
		Thread.sleep(3000);
		WebElement compare = driver.findElement(By.xpath("//div[@class='input-group']/input"));
		compare.sendKeys("602024");

		List<WebElement> list = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table"));
		for (WebElement webElement : list) {
			String text = webElement.getText();

			if (text.contains("kumar") && text.contains("sabari") && text.contains("602024")) {
				System.out.println("Customer Added sucessfully");
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		AssementDemo assementDemo = new AssementDemo();
		assementDemo.demoWebsites();
//		assementDemo.compare();
	}
}
