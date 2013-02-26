import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testSearch {
private FirefoxDriver driver;
	/*open fb.com
	enter login
	enter pass
	click login*/
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://fb.com");
	}
	
	@After
	public void tearDown() {
		driver.close();

	}	
	
	@Test
	public void test(){
		HomePage home = new HomePage(driver);
		MainPage main = home.login("","");
		Assert.assertTrue(main.welcome("Добро пожаловать на Facebook");
	}
}
