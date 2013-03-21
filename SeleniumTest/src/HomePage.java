import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {

	private WebDriver driver;

	public HomePage(FirefoxDriver driver) {
		this.driver = driver;
	}

	public MainPage login(String login, String pass) {
		
		driver.findElement(By.id("email")).sendKeys(login);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.id("u_0_4")).click();
		
		return new MainPage(driver);
	}

}
