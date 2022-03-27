package twc.Automation.ExecutableTestCases;

import twc.Automation.General.TwcAndroidBaseTest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Description;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import twc.Automation.Driver.Drivers;
import twc.Automation.General.DeviceStatus;
import twc.Automation.General.Functions;
import twc.Automation.General.loginModule;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.HandleWithCharles.CharlesProxy;
import twc.Automation.ReadDataFromFile.read_excel_data;
import twc.Automation.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import twc.Automation.Driver.Drivers;
import twc.Automation.General.loginModule;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Automation.General.Utils;
import twc.Automation.General.TwcAndroidBaseTest;
import twc.Automation.General.Utils;

public class AndroidApkDownload  extends  TwcAndroidBaseTest {
	
public static String CurrentWifiName=null;

public static String  ipAddress=null;
public static String  portNumber=null;

	private static final String CONFIG_FILE_PATH = "charles_common.config";

	private static final String BN_SEVERE1_CONFIG_FILE_PATH = "BNSevere1charles_common.config";
	private static final String BN_SEVERE2_CONFIG_FILE_PATH = "BNSevere2charles_common.config";
	private static final String CRITEO_CONFIG_FILE_PATH = "Criteocharles_common.config";
	private static final String CRITEO_NONUS_CONFIG_FILE_PATH = "CriteoNonUScharles_common.config";
	// public static CharlesProxy proxy;
	public File configFile;
	private CharlesProxy proxy;
	
	
//	public static String  portNumber="8222";

	  
	
	@BeforeTest
	public void Before_Test() throws Exception {
		System.out.println("================= Before Test Started =========================");
	AppiumFunctions.getIpaddress();		
		Drivers.property();
		//ipAddress=properties.getProperty("currentIpAddress");
		//portNumber=properties.getProperty("PortNumber");
		
		String CurrentWifiName=properties.getProperty("deviceWifiName");
		AppiumFunctions.LaunchSettingsAppWithFullReset();		
	AppiumFunctions.settingProxyEnable("Manual",AppiumFunctions.current_IPAddress,AppiumFunctions.Android_PortNumber);
		
	Thread.sleep(20000);
		
		//AppiumFunctions.LaunchSettingsAppWithFullReset();
		//proxy offf
	  AppiumFunctions.settingProxyOff("None");
		
	
		//proxyenable
		
		System.out.println("================= Before Test End =========================");
	}

	
	
	@Test(priority=1)
	public void downloadApkfromAppTester() throws Exception {
		AppiumFunctions.UnInstallApp();
		AppiumFunctions.LaunchAppWithFullReset();
		Thread.sleep(20000);
	}
	  
	@Test(priority=2)
	public void installApkinDevice() throws Exception {
		AppiumFunctions.installapk();
		Thread.sleep(20000);

		Ad.closeApp();
	}
	
	@AfterTest
	public void After_Test() throws Exception {
		Ad.closeApp();

	}

	
}
