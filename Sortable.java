package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();

		WebElement Item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement Item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));

		Actions builder = new Actions(driver);
	
		builder.clickAndHold(Item3).moveToElement(Item1).release().perform();

		driver.close();
	}

}