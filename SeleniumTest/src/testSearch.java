import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class testSearch {
private FirefoxDriver driver;
private static final Logger LOGGER = LoggerFactory.getLogger(testSearch.class);
	/*open fb.com
	enter login
	enter pass
	click login*/
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://fb.com");
	}
	
	@After
	public void tearDown() {
		driver.close();

	}	
	
	@Test
	public void test(){
		//String pageSource = driver.getPageSource();
	//	HomePage home = new HomePage(driver);
	//	MainPage main = home.login("","");
	//	assertEquals("Incorrect Email", 
	//		     driver.findElement(By.xpath(".//*[@id='login_form']/div[1]/div[1]")).getText());
		//driver.W(driver.findElementByXPath(".//*[@id='u_0_0']"));
		WebElement checkboxFemale = driver.findElementByXPath(".//*[@id='u_0_0']");
		WebElement checkboxMale = driver.findElementByXPath(".//*[@id='u_0_1']");
		checkboxFemale.click();
		assertTrue("checkboxFemale.isSelected", checkboxFemale.isSelected());
		LOGGER.info("checkbox checked");
		LOGGER.error("checkbox checked");
		LOGGER.warn("checkbox checked");
		assertTrue("checkboxMale.isSelected", !checkboxMale.isSelected());
        /*
         * System.out.println("checkboxMale.isSelected()"): " + checkboxMAle.isSe);
         */
	}
}
