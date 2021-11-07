package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.util.TestUtil;

public class Base{
	public static WebDriver driver;
	public static Properties prop;
    public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public Base() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(".//Resources//com//qa//config//config.properties");
		    prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		
		}
		catch(IOException e) {
			e.printStackTrace();
	
		}
	}
	
	
	//Initialization of driver and launching of browser
	public static void initialize() throws IOException{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",".//Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("nhsuk-cookie-banner__link_accept")).click();
	}
	
	
	@BeforeTest
	public void setReport() {
		
		String dateName=new SimpleDateFormat("MM-dd-yyy_HH-mm-ss").format(new Date());		
		htmlreporter=new ExtentHtmlReporter(".//Reports//NHS Wales Cost Checker_"+dateName +".html");
			htmlreporter.config().setDocumentTitle("NHS Wales Cost Checker");	
			htmlreporter.config().setReportName("NHS Wales Cost Checker");
		htmlreporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		
	}
	
	
   @AfterTest
   public void endReport() {
	extent.flush();
                            }
   
   
   
   @AfterMethod
   public void tearDown() {
 	try {
 		driver.quit();
	}
 	catch(Exception e) {
		
	}
	}
}

