package Task_15_06_22;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsernameAndPassword {

	public static void isElemenetPresent(WebElement userNameCheck, String text) {
		if (userNameCheck.isDisplayed()) {
			userNameCheck.sendKeys(text);
		} else {
			System.out.println("enter correct details");

		}
	}

	public static void screenShot(WebDriver driver) throws IOException {
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
}
