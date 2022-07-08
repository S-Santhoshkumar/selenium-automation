import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task_02_06_22 {
	@Test
	public void tables() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@class=\"tsc_table_s13\"]/tbody/tr/th"));

		List<WebElement> redAlList = driver.findElements(By.xpath("//table[@class=\"tsc_table_s13\"]/tbody/tr"));
		int structureCount = redAlList.size();
		System.out.println("Total Structure present in the column :" + structureCount);

		for (WebElement textElement : rowCount) {
			System.out.println("Text present in the structure column :" + textElement.getText());
		}
		for (WebElement readAll : redAlList) {
			System.out.println("Read all values from the table row-wise :" + readAll.getText());
		}

	}

}
