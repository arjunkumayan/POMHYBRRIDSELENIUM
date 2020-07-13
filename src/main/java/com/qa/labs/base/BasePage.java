package com.qa.labs.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.labs.util.ElementUtil;
import com.qa.labs.util.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	public Properties prop;
	
	public ElementUtil elementUtil;
	public OptionsManager optionsManager;
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * this method is used to initilize the webdriver on the basis of browser
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {	
		
		String browserName = null;
		if (System.getProperty("browser") == null) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = System.getProperty("browser");
		}

		System.out.println("Running on --->" + browserName + " browser");
		
		
		
		
		optionsManager = new OptionsManager(prop);
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();	
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}		
		
		//driver.manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	//	driver.manage().window().maximize();
	 //	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		//driver.get("https://app.hubspot.com/");
		getDriver().get(prop.getProperty("url"));
		//return driver;		
		return getDriver();
	}
	
	/**
	 * this method is used to initilize the properties from com.config file on the basis of given env variable
	 * @return prop
	 */
	
	public Properties init_prop() {
		
		String path = null;
		String env = null;
		
		prop = new Properties();
		
		try {
			env= System.getProperty("env");
			System.out.println("env value is---->"+env);
			if(env ==null) {
				path ="./src/main/java/com/qa/labs/config/config.properties";
				
			}
			else {
				switch(env) {
				
				case "qa":
					path="./src/main/java/com/qa/labs/config/qa.config.properties";
					break;
				case "dev":
					path="./src/main/java/com/qa/labs/config/dev.config.properties";
					break;
				case "stage":
					path="./src/main/java/com/qa/labs/config/stage.config.properties";
					break;
					
				default:
					System.out.println("Please pass the correct env value---->"+env);
					break;
				}
				
			}
			
			
			FileInputStream ip = new FileInputStream(path);
		     prop.load(ip);
		     
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return prop;
		
	}
	
	
	/**
	 * this method will take the screenshot 
	 * @return 
	 */
	
	public String getScreenshot() {
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
		
	}
	
	
	
	
	
	
	

}
