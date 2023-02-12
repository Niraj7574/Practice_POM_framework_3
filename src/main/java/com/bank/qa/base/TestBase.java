package com.bank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.bank.qa.utils.TestUtil;
import com.bank.qa.utils.WebEventListener;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	static WebEventListener eventListener;
	static EventFiringWebDriver e_driver;
	
	public TestBase() {
		try {
			FileInputStream input = new FileInputStream("C:\\QA\\Selenium_WorkSpace\\Practice_POM_framework_3\\src\\main\\java\\com\\bank\\qa\\config\\config.properties");
			prop = new Properties();
			prop.load(input);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void initilization() {
		String browser = prop.getProperty("Browser");
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Need to create object of EventListenerHandler to register in with EventFiring WebDriver
		eventListener = new WebEventListener();
		e_driver = new EventFiringWebDriver(driver);
		e_driver.register(eventListener);
		driver = e_driver;
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
