package com.denovo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.denovo.util.TestUtil;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {


	public static WebDriver driver;
	public static Logger logger;

	File f;
	FileInputStream fis;
	static Properties pro;

	//constructor
	public TestBase() {
		try {
			f=new File("D:\\Eclipse_workspace\\DenovoWebPortal\\src\\main\\java\\com\\denovo\\config\\config.properties");
			fis= new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public static void initialization() {

		String browserName= pro.getProperty("browser");

		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver",pro.getProperty("chromepath"));
			driver= new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.chrome.driver", pro.getProperty("edgepath"));
			driver = new EdgeDriver();	
		}
		else {
			System.out.println("Given browsername is wrong");
		}


		logger = Logger.getLogger("Denovo");
		PropertyConfigurator.configure("log4j.properties");



		driver.get(pro.getProperty("url"));


		logger.info("Url is Opened");

		TestUtil.maximize();

		logger.info("Window is maximize");

		TestUtil.implicitWait();

		logger.info("Implicitwait is applied for 30sec");

	}
}