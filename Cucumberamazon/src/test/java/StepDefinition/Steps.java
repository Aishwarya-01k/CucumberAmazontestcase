package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps{
	WebDriver driver= new ChromeDriver();

@Given("Open Chrome and launch")
public void open_chrome_and_launch() {

	System.setProperty("WebDriver.Chrome.driver", "chromedriver.exe");
	driver.get("https://www.amazon.in/");
    
}

@When("Search for a product")
public void search_for_a_product() {
	WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
	search.sendKeys("Dell Laptop");
	
	driver.findElement(By.id("nav-search-submit-button")).click();

		
}

@Then("Product list should be displayed")
public void product_list_should_be_displayed() {
	WebElement prdct=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));
	prdct.click();
	WebDriverWait wait = new WebDriverWait(driver,2);
String expected="Amazon.in : Dell Laptop";
String t= driver.getTitle();
System.out.println(t);
if(t.equals(expected)) {
	Assert.assertTrue(true);
}
else {
	Assert.assertFalse("not the expecetd product",true);
}

 wait = new WebDriverWait(driver,5);
   
}

@Given("product is selected in the site")
public void product_is_selected_in_the_site() {

	System.setProperty("WebDriver.Chrome.driver", "chromedriver.exe");
	driver.get("https://www.amazon.in/HP-Micro-Edge-Keyboard-Graphics-14s-fq1089AU/dp/B09Q3JZ4YX/ref=sr_1_1_sspa?crid=3PWWK3TOSM0QP&keywords=dell+laptop&qid=1646140840&sprefix=dell+lapto%2Caps%2C322&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzTUMyU1pXQlQ0V05TJmVuY3J5cHRlZElkPUEwMDc2NTc0MVdXNFRWVFhYMUlDWiZlbmNyeXB0ZWRBZElkPUEwOTcyMDkxMkFETUY1RzJPWTk5TSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=");
	System.out.println("Im in the selected product page");
    
}

@When("clicked on add to cart button")
public void clicked_on_add_to_cart_button() {
	

	int a = driver.findElements(By.id("add-to-cart-button")).size();
	System.out.println(+a);
	if (a==1) {
		driver.findElement(By.id("add-to-cart-button")).click();
	}
	else if(a==0) {
		System.out.println("No Add to cart element found");
		
	}
	else {
		System.out.println("There are more elements on the page with the given locator");
	}
	WebDriverWait wait = new WebDriverWait(driver,2);
	
   
}

@Then("product will be added to cart")
public void product_will_be_added_to_cart() {

	
	String t =driver.getTitle();
	String pg= "Amazon.in Shopping Cart";
			
			if(t.equals(pg)) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse("product not added to cart",true);
			}
    
}

	
}