package SelfLearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames {
	public static void frames() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame("frame1");
		WebElement sample = driver.findElement(By.id("sampleHeading"));
		String textString = sample.getText();
		System.out.println("first frame :" + textString);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement sample2 = driver.findElement(By.id("sampleHeading"));
		String textString2 = sample2.getText();
		System.out.println("second frame :" + textString2);

		driver.switchTo().defaultContent();
		List<WebElement> sizeElement = driver.findElements(By.tagName("iframe"));
		int size = sizeElement.size();
		System.out.println(size);
	}

	public static void nestedFrames() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");

//		driver.switchTo().frame(1);
//		WebElement samplElement = driver.findElement(By.xpath("//html//body//p"));
//		String textString = samplElement.getText();
//		System.out.println(textString);

		driver.switchTo().defaultContent();
		List<WebElement> totaList = driver.findElements(By.tagName("iframe"));
		int size = totaList.size();
		System.out.println(size);

	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// frames();
		nestedFrames();

	}
}
