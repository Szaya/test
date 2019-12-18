package com.epam.university.tests;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
	protected WebDriver driver;
	protected Wait<WebDriver> fluentWait;
	protected WebDriverWait wait;

	@Before
	public void setUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = getChromeDriver("hu");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500))
				.ignoring(ElementNotInteractableException.class)
				.ignoring(NoSuchElementException.class);

		wait = new WebDriverWait(driver, 5);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getChromeDriver(String lang) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--lang=" + lang);
		return new ChromeDriver(options);
	}

	public void takeScreenshot(String fileName) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = "target/screenshots/" + fileName + ".jpg";
		FileUtils.copyFile(screenshot, new File(screenshotPath));
	}
}
