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

public class Amazon {

	@SuppressWarnings("unlikely-arg-type")
	public static void checkBoxList() {
		Scanner inputScanner = new Scanner(System.in);

		String webElement;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		WebElement searchElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchElement.sendKeys("mobiles");
		searchElement.sendKeys(Keys.ENTER);

		WebElement firstCheckBox = driver.findElement(By.xpath("//li[@id='p_89/Samsung']"));
		String firstTextString = firstCheckBox.getAttribute("aria-label");
		System.out.println(firstTextString);

		WebElement secondCheckBox = driver.findElement(By.xpath("//li[@id='p_89/Redmi']"));
		String secondTextString = secondCheckBox.getAttribute("aria-label");
		System.out.println(secondTextString);

		WebElement thirdCheckBox = driver.findElement(By.xpath("//li[@id='p_89/realme']"));
		String thirdTextString = thirdCheckBox.getAttribute("aria-label");
		System.out.println(thirdTextString);

		WebElement fourthCheckBox = driver.findElement(By.xpath("//li[@id='p_89/OnePlus']"));
		String fourthTextString = fourthCheckBox.getAttribute("aria-label");
		System.out.println(fourthTextString);

		List<String> checkList = new LinkedList<String>();
		checkList.add(firstTextString);
		checkList.add(secondTextString);
		checkList.add(thirdTextString);
		checkList.add(fourthTextString);
		System.out.println("Elements present : " + checkList);

//		List<String> checkBox = new LinkedList<String>();
//		checkBox.addAll(checkList);

		System.out.println("Enter the text want to be search :");
		webElement = inputScanner.nextLine();
		if (!checkList.contains(webElement)) {
			System.out.println("It is not present in the check box list");
		} else {
			System.out.println("It is present in the check box list");
		}
		for (int i = 0; i < webElement.length(); i++) {

		}
	}

	public static void main(String[] args) {
		checkBoxList();
	}
}
