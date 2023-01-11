package week3.day1.assignments;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Raghu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//a[text()='Raghu'])[1]")).click();
		
		String title = driver.getTitle();
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("Title have the word : " +title);
		}
		else {
			System.out.println("The Title does not have the word View Lead");
		}
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Infosys");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("TestLeaf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		System.out.println(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText());
		Thread.sleep(2000);
		driver.close();
		}

}
