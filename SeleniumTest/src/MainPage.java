import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
private WebDriver driver;
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
public void logout(){
	driver.findElement(By.id("userNavigationLabel")).click();
	driver.findElement(By.xpath(".//*[@id='logout_form']/label/input")).click();
}
public String welcome(String string) {
	driver.findElement(By.xpath(".//*[@id='navItem_app_156203961126022']/a/div[2]/div")).click();
	driver.findElement(By.xpath(".//*[@id='pagelet_welcome']/div/div/div[2]/h2")).getText();
	return string;
}
}