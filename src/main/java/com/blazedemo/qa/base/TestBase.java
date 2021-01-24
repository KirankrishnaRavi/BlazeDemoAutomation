package com.blazedemo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.blazedemo.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	//config property file is loaded.
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\blazedemo\\qa\\config\\config.properties"));
			prop.load(fs);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Chrome Driver is initialized.
	public void initialize()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{			
			System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAG_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}
}
