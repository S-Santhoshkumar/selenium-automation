package SelfLearn;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebtables {

	@Test
	public void tables() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.geeksforgeeks.org/difference-between-python-and-java/");
		WebElement rowElement = driver.findElement(By.xpath("//div[@class='text']/table/tbody/tr"));
		String rowString = rowElement.getText();
		System.out.println(rowString);

		List<WebElement> rowSize = driver.findElements(By.xpath("//div[@class='text']/table/tbody/tr"));
		int rowCount = rowSize.size();
		System.out.println(rowCount);

		Scanner scanner = new Scanner(System.in);
		int row;
		System.out.println("Enter the row to be printed :");
		row = scanner.nextInt();

		int columnCount;
		System.out.println("Enter the column to be printed :");
		columnCount = scanner.nextInt();
//		int row = 0;
//		int columnCount = 0;
//		for (row = 2; row <= rowlength; row++) {
		String columnElement = "//div[@class='text']/table/tbody/tr[" + row + "]/td";
//			List<WebElement> columnSize = driver.findElements(By.xpath(columnElement));
//			for (columnCount = 1; columnCount <= columnlength; columnCount++) {
		String columnXpath = "//div[@class='text']/table/tbody/tr[" + row + "]/td[" + columnCount + "]";
		String sizeOfColumn = driver.findElement(By.xpath(columnXpath)).getText();
		System.out.println(sizeOfColumn);
//			}
//		}
		System.out.println(columnCount);
		driver.close();
	}

}
