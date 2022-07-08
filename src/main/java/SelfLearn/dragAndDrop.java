package SelfLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragAndDrop {
	public static void dragAndDrop() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/dragabble");

		WebElement simple = driver.findElement(By.id("draggableExample-tabpane-simple"));
		WebElement to = driver.findElement(By.className("main-header"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(simple, to).build().perform();
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		dragAndDrop();
	}
}
