package CodeReusability;

import org.openqa.selenium.WebElement;

public class LoginPage {

	public static void isElemenetPresent(WebElement userNameCheck, String text) {
		if (userNameCheck.isDisplayed()) {
			userNameCheck.sendKeys(text);
		} else {
			System.out.println("enter the correct xpath");
		}
	}
}
