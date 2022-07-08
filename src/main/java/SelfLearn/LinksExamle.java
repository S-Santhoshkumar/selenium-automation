package SelfLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksExamle {
	public static void links() throws InterruptedException {
		WebDriver links = new ChromeDriver();
		links.get(
				"https://www.google.co.in/search?q=javatpoint&source=hp&ei=8T2PYun8FOuwmAWh352YDg&iflsig=AJiK0e8AAAAAYo9MAR_H7aG2FIzSkG4kQy3ge39mYYLk&oq=javaT&gs_lcp=Cgdnd3Mtd2l6EAEYADILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBMggIABCABBCxAzIICAAQgAQQsQMyCAgAEIAEELEDMgsIABCABBCxAxCDATIICAAQgAQQsQMyBQgAEIAEMgUILhCABDILCAAQgAQQsQMQgwE6DggAEOoCELQCENkCEOUCOggILhCxAxCDAToOCC4QgAQQsQMQxwEQ0QM6CwguEIAEELEDEIMBOgsILhCxAxCDARDUAjoICC4QgAQQ1AI6CwguEIAEELEDENQCUJgOWPUbYPKUK2gBcAB4AIABugGIAd8GkgEDMC41mAEAoAEBsAEI&sclient=gws-wiz");

		WebElement linksElement = links.findElement(By.linkText("Java Tutorial"));
		linksElement.click();

		WebElement partialLink = links.findElement(By.partialLinkText("Java"));
		partialLink.click();

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		links();
	}
}
