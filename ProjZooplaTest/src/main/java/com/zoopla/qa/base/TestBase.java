package com.zoopla.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.zoopla.qa.util.TestUtil;
 
public class TestBase {

	static FileInputStream file; 
	public static Properties pr;
	public static WebDriver driver = null;
	private final static String FilePath = System.getProperty("user.dir") + "/src/main/java/com/zoopla/qa/config/config.properties";
	
	private final static String ChormePath = System.getProperty("user.dir")	+ "/driver/chromedriver.exe";
	private final static String FirePath = System.getProperty("user.dir")	+ "/driver/geckodriver.exe";
	private final static String IEPath = System.getProperty("user.dir")	+ "/driver/IEDriverServer.exe";
	

	
	public TestBase(){
		
	 try {
	 	file = new FileInputStream(FilePath);
	} 
	 catch (FileNotFoundException e) {
			e.printStackTrace();
	}
				
	 try {
		 pr = new Properties();
		 pr.load(file);
	 }
	 catch(IOException e) {
		 e.printStackTrace();	 
	 } 
						
	}
	
	
	public static void initialization() {
		
		String browser = pr.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ChormePath);
			driver = new ChromeDriver();			
		}
		else if (browser.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", FirePath);
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver",IEPath);
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(pr.getProperty("url"));
		
	}
	
	
	
	
	
}
