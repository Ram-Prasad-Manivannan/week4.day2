package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();

		WebElement Drag_element = driver.findElement(By.id("draggable"));
		WebElement Drop_element = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(Drag_element, Drop_element).perform();

		driver.close();

	}

}