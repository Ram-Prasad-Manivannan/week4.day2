package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		WebElement Drag_element = driver.findElement(By.xpath("(//h3[text()='Resizable']/following-sibling::div)[3]"));

		Actions builder = new Actions(driver);
		
		Thread.sleep(3000);
		
		builder.clickAndHold(Drag_element).moveByOffset(30,40).release(Drag_element).perform();
		
		//driver.close();

	}

}