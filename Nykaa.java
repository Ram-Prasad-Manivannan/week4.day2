package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.Iterator; 
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa 
{
	public static void main(String[] args) throws Exception
	{
	 
	 WebDriverManager.chromedriver().setup();
		
	 ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
     
     ChromeDriver driver = new ChromeDriver(options);
     
     driver.get("https://www.nykaa.com/");
     
     driver.manage().window().maximize();
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     
     Actions builder=new Actions(driver);
     
     WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
     
     builder.moveToElement(brands).perform();
     
     driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
     
     driver.findElement(By.linkText("L'Oreal Paris")).click();
     
     String title=driver.getTitle();
     
     System.out.println(title);
     
     if(title.contains("L'Oreal Paris")) 
     {
       System.out.println("The title is L'Oreal Paris");
     }
     else
     {
    	 System.out.println("Wrong title Check the code");
     }
     
     driver.findElement(By.xpath("//span[@class=\"sort-name\"]")).click();
     
     driver.findElement(By.xpath("//*[@id=\"filter-sort\"]/div/div/ul/div[4]/label/div[1]/span")).click();
     
     driver.findElement(By.xpath("//span[text()='Category']")).click();
     
     Thread.sleep(2000);
     
     driver.findElement(By.xpath("//span[text()='Hair']")).click(); Thread.sleep(2000);
     
     driver.findElement(By.xpath("//span[text()='Hair Care']")).click(); Thread.sleep(2000);
     
     driver.findElement(By.xpath("//span[text()='Shampoo']")).click(); Thread.sleep(2000);
     
     driver.findElement(By.xpath("//span[text()='Concern']")).click(); Thread.sleep(2000);
     
     driver.findElement(By.xpath("//span[text()='Color Protection']")).click(); Thread.sleep(2000);
     
     //check filter
     String filter = driver.findElement(By.xpath("//*[@id=\"filters-listing\"]/div[1]/div[2]/div[1]/span")).getText();
     
     System.out.println(filter);
     
     if(filter.contains("Shampoo"))
     {
    	 System.out.println("Shampoo is selected in filter");
     }
     else 
     {
    	 System.out.println("Shampoo is not selected check the code");
     }
     
     driver.findElement(By.xpath("//*[@id=\"product-list-wrap\"]/div[1]/div/div[1]/a/div[2]/div[1]")).click();
     
     //moving to new window
     // It will return the parent window name as a String
     String parent=driver.getWindowHandle();

     Set<String>s=driver.getWindowHandles();

     // Now iterate using Iterator
     Iterator<String> I1= s.iterator();

     while(I1.hasNext())
     {

      String child_window=I1.next();


      if(!parent.equals(child_window))
      {
       driver.switchTo().window(child_window);

       System.out.println(driver.switchTo().window(child_window).getTitle());
      }
     }
     //already size same so did not code the step
     
     Thread.sleep(2000);
     
     String MRP = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/span[2]")).getText();
     
     System.out.println("MRP is"+MRP);
     
     Thread.sleep(2000);
     
     //add bag
     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div[5]/div[1]/div/button")).click();
     
     Thread.sleep(2000);
     
     //shopping bag
     driver.findElement(By.xpath("//*[@id=\"header_id\"]/div[2]/div/div[2]/div[2]/button")).click();
     
     Thread.sleep(8000);
     
     WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"portal-root\"]/div/div[1]/iframe"));
     
     driver.switchTo().frame(frame1);
     
     String gtot = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div[1]/div[4]/div[2]")).getText();
     
     System.out.println("Grand Total is:"+gtot);
     
     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div[2]/button")).click();
     
     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[4]/button")).click();
     
     Thread.sleep(2000);
     
     String Gtot = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div[2]/div[2]/div[2]/span")).getText();
     
     System.out.println("Grand Total in this page is: "+Gtot);

     //check total
     if(gtot==Gtot) 
     {
    	 System.out.println("Both grand total are same ");
     }
     else 
     {
     System.out.println("There is a problem somewhere");
     }
 driver.close();
     
     //moving to parentwindow
     driver.switchTo().window(parent);
     
     driver.close();
	}
}