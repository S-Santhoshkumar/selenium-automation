package Task_31_06_22;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxList {
	public static void checkBoxList() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String oldWindow = driver.getWindowHandle();

		WebElement signIn = driver.findElement(By.xpath("//div[@id='gh-top']/ul/li/span/a"));
		signIn.click();
		Thread.sleep(2000);

		WebElement userName = driver.findElement(By.id("userid"));
		userName.sendKeys("sabarisamy04@gmail.com");

		WebElement continueLogin = driver.findElement(By.id("signin-continue-btn"));
		continueLogin.click();
		Thread.sleep(20000);

		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("kumar99rockz");

		WebElement signInButton = driver.findElement(By.id("sgnBt"));
		signInButton.click();
		Thread.sleep(20000);

		WebElement searchElement = driver.findElement(By.xpath("//td[@class='gh-td-s']/div/div/input"));
		searchElement.sendKeys("mobiles");
		searchElement.sendKeys(Keys.ENTER);

		WebElement firstCheckBox = driver.findElement(By.xpath("(//input[@class='checkbox__control'])[26]"));
		String firstTextString = firstCheckBox.getAttribute("aria-label");
		System.out.println(firstTextString);

		WebElement secondCheckBox = driver.findElement(By.xpath("(//input[@class='checkbox__control'])[27]"));
		String secondTextString = secondCheckBox.getAttribute("aria-label");
		System.out.println(firstTextString);

		WebElement thirdCheckBox = driver.findElement(By.xpath("(//input[@class='checkbox__control'])[28]"));
		String thirdTextString = thirdCheckBox.getAttribute("aria-label");
		System.out.println(firstTextString);

		WebElement fourthCheckBox = driver.findElement(By.xpath("(//input[@class='checkbox__control'])[29]"));
		String fourthTextString = fourthCheckBox.getAttribute("aria-label");
		System.out.println(firstTextString);

		List<String> checkList = new LinkedList<String>();
		checkList.add(firstTextString);
		checkList.add(secondTextString);
		checkList.add(thirdTextString);
		checkList.add(fourthTextString);
		System.out.println("Elements present : " + checkList);

		List<String> checkBox = new LinkedList<String>();
		checkBox.addAll(checkList);

		Scanner inputScanner = new Scanner(System.in);

		for (String webElement : checkBox) {
			System.out.println("Enter the text want to be search :");
			webElement = inputScanner.nextLine();
			if (!checkBox.equals(webElement)) {
				System.out.println("It is present in the check box list");
			} else {
				System.out.println("It is not present in the check box list");
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		checkBoxList();
	}
}
