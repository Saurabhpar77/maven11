package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest {
public WebDriver driver;
	
	LoginPage lp;
	
	@BeforeClass
	public void initalization() {
		
		//step-0
		WebDriverManager.chromedriver().setup();
		
		//step-1
		driver =new ChromeDriver();
		
		//step-2
		driver.manage().window().maximize();
		
		//step-3
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//step-4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step-5 init object
		lp =new LoginPage(driver);
		
	}
	
	
	
	@Test (priority=2)
	public void login() {
		
		//step-1
		lp.enterUsernameIntextBox("Admin");
		
		//step-2
		lp.enterPasswordIntextBox("admin123");
		
		//step-3
		lp.clickOnLoginButton();
		
		
	}
	
	@Test (priority=1)
	public void verifyPageTitle() {
		
		Assert.assertTrue(driver.getTitle().contains("Orange"),"Page title does not matched");
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}


}
