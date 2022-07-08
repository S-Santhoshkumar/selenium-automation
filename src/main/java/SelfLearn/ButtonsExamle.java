package SelfLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsExamle {
	public static void buttons() {
		WebDriver buttons = new ChromeDriver();
		buttons.get("https://demoqa.com/buttons");

		WebElement doubleClick = buttons.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		doubleClick.click();
		String colorString = doubleClick.getCssValue("color");
		System.out.println(colorString);
		String background = doubleClick.getCssValue("background-color");
		System.out.println(background);

		WebElement rightClick = buttons.findElement(By.id("rightClickBtn"));
		rightClick.click();
		int height = rightClick.getSize().getHeight();
		int width = rightClick.getSize().getWidth();
		System.out.println("height " + height + " ....width " + width);

		WebElement click = buttons.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
		click.click();
		Point xypoint = click.getLocation();
		int x = xypoint.getX();
		int y = xypoint.getY();
		System.out.println("position of x :" + x);
		System.out.println("position of y :" + y);

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		buttons();
	}
}
