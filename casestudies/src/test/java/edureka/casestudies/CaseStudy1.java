package edureka.casestudies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class CaseStudy1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://newtours.demoaut.com/";
		// Load web page
		driver.get(baseUrl);

		// wait 3 seconds
		Thread.sleep(3000);

		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		Thread.sleep(2000);

		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Test");

		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("User");

		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("212-123-4567");

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("user@gmail.com");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("abc123");

		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("abc123");

		WebElement registered = driver.findElement(By.name("register"));
		registered.submit();

		WebElement flights = driver.findElement(By.linkText("Flights"));
		flights.click();
		Thread.sleep(2000);

		// select fourth option on departing flight
		WebElement departureDropDown = driver.findElement(By.name("fromPort"));
		Select departure = new Select(departureDropDown);
		departure.selectByIndex(3);

		// select fourth option on returning flight
		WebElement arrivalDropDown = driver.findElement(By.name("toPort"));
		Select arrival = new Select(arrivalDropDown);
		arrival.selectByIndex(4);

		// click continue button
		WebElement findFlight = driver.findElement(By.name("findFlights"));
		findFlight.click();
		Thread.sleep(2000);

		// click continue
		WebElement reserveFlight = driver.findElement(By.name("reserveFlights"));
		reserveFlight.click();
		Thread.sleep(2000);

		// enter passenger first name
		WebElement firstName1 = driver.findElement(By.name("passFirst0"));
		firstName1.sendKeys("Test");

		// enter passenger last name
		WebElement lastName1 = driver.findElement(By.name("passLast0"));
		lastName1.sendKeys("User");

		// enter credit card info
		WebElement creditNumber = driver.findElement(By.name("creditnumber"));
		creditNumber.sendKeys("123456789");

		// buy flights
		WebElement buyFlight = driver.findElement(By.name("buyFlights"));
		buyFlight.click();
		Thread.sleep(2000);

		Thread.sleep(3000);
		driver.close();
		System.out.println("<-------------Test Successfully Executed------------->");

	}

}
