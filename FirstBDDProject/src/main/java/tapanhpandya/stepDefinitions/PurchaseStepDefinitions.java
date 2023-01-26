package tapanhpandya.stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PurchaseStepDefinitions {
WebDriver driver;
	
	@Given("^User is already on Login Page$")
	public void user_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//java//tapanhpandya//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@When("^Title of login page is Lets Shop$")
	public void title_of_login_page_is_lets_shop() {
		String title = driver.getTitle();
		Assert.assertEquals("Let's Shop", title);
	}
	
	@Then("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
	}
	
	@Then("^User clicks on login button$")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("login")).click();
	}
	
	@And("^user is on home page.$")
	public void user_is_on_home_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean isPresent = driver.findElement(By.xpath("//h3[text()='Automation']")).isDisplayed();
		Assert.assertTrue(isPresent);
	}
	
	@Then("^user adds \"(.*)\" to cart.$")
	public void user_adds_product_to_cart(String product) {
		driver.findElement(By.cssSelector(product)).click();
	}
	
	@Then("^user clicks on \"(.*)\"$")
	public void user_clicks_on_cart(String cart) {
		// ngx-spinner-overlay
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-spinner-overlay")));
		driver.findElement(By.xpath(cart)).click();
	}
		
	@Then("^user clicks to \"(.*)\" button.$")
	public void user_clicks_on_checkout_button(String checkoutBtn) {
		driver.findElement(By.xpath(checkoutBtn)).click();
	}
	
	@Then("^user enters \"(.*)\" and selects country from dropdown.$")
	public void user_enters_country_and_selects_country_from_dropdown(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath(country)), "india").build().perform();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='form-group']/section"))));
		
		List<WebElement> dropdowns = driver.findElements(By.xpath("//section/button"));
		List<WebElement> c = dropdowns.stream().filter(item -> item.findElement(By.tagName("span")).getText().equalsIgnoreCase("india")).toList();
		// Need some more work
		a.click(c.get(0)).build().perform();
	}
	
	@Then("^user finally \"(.*)\".$")
	public void user_finally_placeorder(String placeorder) {
		driver.findElement(By.xpath(placeorder)).click();
	}
	
	@And("^user receives order confirmation number on the next page.$")
	public void user_receives_order_confirmation_number_on_the_next_page() {
		String orderMessage = driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(orderMessage.equalsIgnoreCase("thankyou for the order."));
	}

}
