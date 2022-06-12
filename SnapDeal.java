package week4.day2.assignments;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import com.google.common.collect.Ordering;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal 
{
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
	
	 //load driver and block notifications	
	 WebDriverManager.chromedriver().setup();
	 
	 ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
     
     ChromeDriver driver = new ChromeDriver(options);
	 
     //load url
	 driver.get("https://www.snapdeal.com/");
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 
	 Actions builder=new Actions(driver);
	 
	 
	 //Moving mouse to Men's Fashion then to Sports Shoes and clicking on it
	 WebElement Men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
	 WebElement SportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
	 
	 builder.moveToElement(Men).pause(1000).click(SportsShoes).perform();
	 
	 // Get the count of the sports shoes
	 System.out.println(driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText());
	 
	 // Click Training shoes
	 driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	 
	 //sort by low to high
	 WebElement SortBy = driver.findElement(By.xpath("//span[text()='Sort by:']"));
	 SortBy.click();
	 driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div[2]/div[3]/div[2]/ul/li[2]")).click();
	 
	 Thread.sleep(5000);
	 
	 //verify sort order
	 List<WebElement> Sorted = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	 List<String> sortedList = new ArrayList<String>();
     
	 for (WebElement e : Sorted) 
	 {
	   sortedList.add(e.getAttribute("display-price"));
	 }
	 
	 System.out.println("Items displayed: ");
	 for(String Price:sortedList)
		 System.out.println(Price);
	 
	 boolean sorted = Ordering.natural().isOrdered(sortedList);
	 System.out.println("Items displayed sorted correctly : " + sorted);
	 
	 //price set btwn 900 to 1200
	 WebElement From = driver.findElement(By.xpath("//input[@name='fromVal']"));
	 WebElement To = driver.findElement(By.xpath("//input[@name='toVal']"));
	 
     From.clear();From.sendKeys("500");//price is set to 500 as navy blue is available only in 500 range
	 To.clear();To.sendKeys("1200");
	 
	 driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
	 
	 Thread.sleep(5000);
		
	 // Filter with color Navy
	 driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();
	 
	 //verify filter
	 String filterPrice = "Price: Rs. 500 - Rs. 1200";
	 String filterColor = "Color: Navy";
	 List<WebElement> Filters = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
	 for (WebElement e : Filters) 
	 {
       String filterText = e.getText();
       if (filterPrice.equals(filterText) || filterColor.equals(filterText))
				System.out.println("Filter is applied accordingly:" + filterText);
	 }
	 
	 // Mouse Hover on first resulting Training shoes
     builder.moveToElement(driver.findElement(By.xpath("//picture/img"))).perform();
     
     // click QuickView button
     Thread.sleep(5000);
  	 driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
  	 
     // Print the cost and the discount percentage
  	 Thread.sleep(5000);
  	 
  	 System.out.println("Price : "+ driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::div[3]/span")).getText());
	
  	 System.out.println("Discount percentage : "+ driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::div[3]/span[2]")).getText());
  	
  	 //Take Snapshot
  	 File source = driver.getScreenshotAs(OutputType.FILE);
	 File destination = new File("./screenshots/firstResult.png");
	 FileUtils.copyFile(source, destination);
	
	 //close window
     driver.close();

	}

}
