package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();

		WebElement Item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement Item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement Item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));

		// select elements using keysDown & Up
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(Item1).click(Item2).click(Item4).keyUp(Keys.CONTROL).perform();

		WebElement Item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement Item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));

		// select elements using ClickAndHold

		builder.clickAndHold(Item6).clickAndHold(Item7).release().perform();

		driver.close();

	}

}