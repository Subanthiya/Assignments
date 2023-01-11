package week2.day1.assignments;

	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class DuplicateLead {

		public static void main(String[] args) {
			ChromeDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/control/login");
			
			String title = driver.getTitle();
			System.out.println("Starting Page : "+ title);
			
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.partialLinkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("subanthiya Sharath");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Subanthiya");
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Selenium WebDriver");
			driver.findElement(By.id("createLeadForm_description")).sendKeys("Learn Selenium Java");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("subanthiyasp@gmail.com");
			
			driver.findElement(By.className("smallSubmit")).click();
			
			String title1 = driver.getTitle();
			System.out.println("Resulting Page Before Duplicate : "+ title1);
			
			driver.findElement(By.linkText("Duplicate Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).clear();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
			driver.findElement(By.id("createLeadForm_firstName")).clear();
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Subanthiya Sharath");
			
			driver.findElement(By.className("smallSubmit")).click();
			
			String title2 = driver.getTitle();
			System.out.println("Resulting Page After Duplicate : "+ title2);
		}

	

}
