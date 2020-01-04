package com.cucumber.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.baseclass.BaseClass;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin="com.cucumber.listener.ExtentCucumberFormatter:\\src\\test\\resource\\com\\cucumber\\report\\extent.html",
	features ="src\\test\\java\\com\\cucumber\\feature",
	glue="com.cucumber.StepDefinition",dryRun=false)

public class TestRunner 
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void driverInitilization() throws Throwable 
	{
		
	}
	@AfterClass
	public static void driverQuit() 
	{
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\cucumber\\properties\\extent-config.xml"));
		driver.quit();
	}

}
