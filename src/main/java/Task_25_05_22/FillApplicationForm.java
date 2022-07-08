package Task_25_05_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FillApplicationForm {

	public void demoQa() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");

		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Santhosh");

		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Kumar");

		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("kumarsabari0141@gmail.com");

		WebElement mobNumber = driver.findElement(By.id("userNumber"));
		mobNumber.sendKeys("9940615632");

		WebElement address = driver.findElement(By.id("currentAddress"));
		address.sendKeys("Tirnuninravur");

		WebElement gender = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]"));
		gender.click();

		WebElement sportsHobbies = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]"));
		sportsHobbies.click();

		WebElement readHobbbies = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[5]"));
		readHobbbies.click();

		WebElement musicHobbbies = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[6]"));
		musicHobbbies.click();
		WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		subject.sendKeys("Student");

		/// html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		FillApplicationForm oForm = new FillApplicationForm();
		oForm.demoQa();

	}
}
