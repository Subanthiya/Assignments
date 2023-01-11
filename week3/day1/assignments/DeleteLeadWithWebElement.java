package week3.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadWithWebElement {

public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9025315181");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//a)[1]"));
		
		String leadId = element.getText();
		System.out.println("LeadId is : " + leadId);
		element.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		String Message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		
		if (Message.contains("No records to display")) {
			System.out.println("The Lead Deleted Successfully");	
		}
		else {
			System.out.println("Failed To Delete the Lead ");
		}
		Thread.sleep(1000);
		driver.close();
	}

}
