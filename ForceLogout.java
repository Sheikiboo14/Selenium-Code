package Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForceLogout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Info 
		String AgentnURL="https://web-v2.doocti.com/v2.1.104/";
		
		String AgentEmail="devsandbox_agent03@doocti.com";
		
		String UserPassword="Doocti@123";
		
		String AdminURL="https://console-v2.doocti.com/v2.1.104";
		
		String AdminEmail="devsandbox_admin@doocti.com";
		
		String AdminPassword="Doocti@123";
		
		String DeleteAgent="devsandbox_agent03@doocti.com";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		// Agent Portal
		driver.get(AgentnURL);
		
		driver.findElement(By.id("formBasicEmail")).sendKeys(AgentEmail);

		
		driver.findElement(By.id("formBasicPassword")).sendKeys(UserPassword);

		
		driver.findElement(By.xpath("//button[@class='mb-3 btn btn-primary']")).click();
		
		Thread.sleep(3000);
		

		//Selecting the campaign
		
		WebElement dropdown= driver.findElement(By.xpath("//div[@class=' css-hlgwow']"));
		
		dropdown.click();
		
		WebElement Options = driver.findElement(By.xpath("//div[text()='Dialer']"));
		
		Options.click();
		
		Thread.sleep(1000);
		
	
		
		driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(1000);
		
		
		//Selecting Queue
		
		WebElement Queue = driver.findElement(By.xpath("//div[@class='Customform-field-cnt']//div[contains(@class,'css-hlgwow')]"));
		
		Queue.click();
		
		WebElement QueueOption = driver.findElement(By.xpath("//div[contains(text(),'devsandbox_8037491382')]"));
		
		QueueOption.click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

		//Switching tabs
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		//Admin Portal
		
		driver.get(AdminURL);
		
		driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(AdminEmail);
		
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(AdminPassword);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//div[contains(text(),'Real Time')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[normalize-space()='Live Agents/Calls']")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("(//div[@class='v-btn__content'])[17]")).click();
		
		Thread.sleep(1000);
		
		//Delete Agent Check
		
		if(driver.findElement(By.xpath("//div[@class='bold']")).getText().equalsIgnoreCase(DeleteAgent)) {
			
			driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-btn__content'][normalize-space()='Continue']")).click();
			
			System.out.println("Logout the Agent "+DeleteAgent+" Successfully");
			
			
			Thread.sleep(1000);
			
			driver.close();
		}
		
		else {
			driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-btn__content'][normalize-space()='Cancel']")).click();

			System.out.println("Wrong Agents Choosen");

		}
		
			
		}
		
}


	


