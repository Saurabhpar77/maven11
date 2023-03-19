package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest {
	
	public WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	
	public void initObjects(WebDriver driver) { 
		
		loginpage =new LoginPage(driver);
		homepage =new HomePage(driver);
	}
	
	@BeforeClass
	public void init() {
		
		//step-1
		WebDriverManager.chromedriver().setup();
		
		//step-2
		driver =new ChromeDriver();
		
		//step-3
		driver.manage().window().maximize();
		
		//step-4
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//step-5 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step-6
		initObjects(driver);
		
	}
	
	@BeforeMethod
	public void precondition() {
		
		loginpage.enterUsernameIntextBox("Admin");
		loginpage.enterPasswordIntextBox("admin123");
		loginpage.clickOnLoginButton();
	}
	
	@Test
	public void logout() {
		
		Assert.assertTrue(homepage.verifyDashBoardMenu());
		
		homepage.clickOnProfile();
		
		homepage.clickOnLogout();
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}
}
