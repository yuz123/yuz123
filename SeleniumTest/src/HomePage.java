import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {

	private WebDriver driver;

	public HomePage(FirefoxDriver driver) {
		this.driver = driver;
	}

	public MainPage login(String login, String pass) {
		
		driver.findElement(By.xpath("")).sendKeys(login);
		driver.findElement(By.xpath("")).sendKeys(pass);
		driver.findElement(By.xpath("")).click();
		
		return new MainPage();
	}

}
