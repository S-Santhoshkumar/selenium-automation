package SelfLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void dropDown() throws InterruptedException {
		WebDriver dropDown = new ChromeDriver();
		dropDown.get("https://demoqa.com/select-menu");
		WebElement dropdownByIndex = dropDown.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		Select select = new Select(dropdownByIndex);
		select.selectByIndex(2);
		Thread.sleep(4000);
		select.selectByValue("4");
		Thread.sleep(4000);
		select.selectByVisibleText("Voilet");

		List<WebElement> a = select.getOptions();
		int size = a.size();
		System.out.println("Size :" + size);

		dropdownByIndex.sendKeys("White");
		Thread.sleep(2000);
		WebElement sElement = dropDown.findElement(By.xpath("//select[@id='cars']"));

		Select mulSelect = new Select(sElement);
		mulSelect.selectByIndex(0);
		mulSelect.selectByIndex(1);
		mulSelect.selectByIndex(3);

		WebElement dropElement = dropDown.findElement(By.xpath("(//*[@class='css-19bqh2r'])[1]"));
		dropElement.click();

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		dropDown();
	}

}
