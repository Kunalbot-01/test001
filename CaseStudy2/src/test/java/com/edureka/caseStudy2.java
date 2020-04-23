package com.edureka;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.assertTrue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

public class caseStudy2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Load web page
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();

		// close the dialog window
		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

		// hover over Electronics menu
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/ul/li[1]/span"));
		action.moveToElement(element).perform();
		Thread.sleep(1000);

		// hover over Mi option and click
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a"))
				.click();
		Thread.sleep(5000);

		WebElement element2 = driver.findElement(
				By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/p"));

		if (element2.isDisplayed()) {
			System.out.println("Element found");
		} else {
			System.out.println("Element not found");
		}

		// move price slider
		WebElement priceSlider = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/section[2]/div[3]/div[1]"));
		assertTrue(priceSlider.isDisplayed());
		Dimension sliderSize = priceSlider.getSize();
		int sliderWidth = sliderSize.getWidth();
		int XCoord = priceSlider.getLocation().getX();

		Actions builder = new Actions(driver);
		builder.moveToElement(priceSlider);
		builder.click();
		builder.dragAndDropBy(priceSlider, XCoord + sliderWidth, 0);
		builder.build();
		builder.perform();

		// make slider through drop down
		WebElement maxDropDown = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
		Select max = new Select(maxDropDown);
		max.selectByIndex(2);
		Thread.sleep(3000);

		// Search for "redmi go (black, 8 gb) in search bar
		WebElement search = driver.findElement(By.className("LM6RPg"));
		search.sendKeys("redmi go (black, 8 gb)");
		search.submit();
		Thread.sleep(6000);

		// click on first product & switch to new window
		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div[1]/div"))
				.click();
		Thread.sleep(3000);

//		switch to new window

		Set<String> handles = driver.getWindowHandles();
		System.out.println("Number of windows open = " + handles.size());
		String firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);

		String winHandle = handles.iterator().next();

		if (winHandle != firstWinHandle) {

			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle

			String secondWinHandle = winHandle; // Storing handle of second window handle

			// Switch control to new window

			driver.switchTo().window(secondWinHandle);
		}

		// enter delivery pincode using keyboard
		WebElement pinCode = driver.findElement(By.xpath("//*[@id='pincodeInputId']"));
		Actions code = new Actions(driver);

		for (int i = 0; i < 6; i++) {
			Actions pin = code.moveToElement(pinCode).click().sendKeys(Keys.BACK_SPACE);
			pin.perform();
		}
		Action pinc = code.moveToElement(pinCode).click().sendKeys("560048").build();
		pinc.perform();

		// click add to cart
		WebElement pinche = driver.findElement(By.xpath(
				"//div[@id='container']/div/div[3]/div[2]/div/div[2]/div[6]/div/div/div/div[2]/div/div[2]/div/span"));
		Action pincheck = code.moveToElement(pinche).click().build();
		pincheck.perform();
		Thread.sleep(3000);
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;	
		 js.executeScript("window.scrollBy(0,200)");
		
		//The Above item is not available my pincode so cannot add to cart//**** 

		System.out.println("Waiting for 30 seconds before terminating program.");
		Thread.sleep(30000);
		System.out.println("End of program.");

		driver.quit();

	}

}
