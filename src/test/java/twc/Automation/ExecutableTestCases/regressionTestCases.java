
package twc.Automation.ExecutableTestCases;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import twc.Automation.Driver.Drivers;
import twc.Automation.General.DeviceStatus;
import twc.Automation.General.loginModule;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
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
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Automation.General.Functions;
import twc.Automation.General.TwcAndroidBaseTest;
import twc.Automation.General.Utils;

public class regressionTestCases extends  TwcAndroidBaseTest {
//	protected String email;
	public static String CurrentWifiName=null;
	
	private static final String CONFIG_FILE_PATH = "charles_common.config";
	private static final String BN_SEVERE1_CONFIG_FILE_PATH = "BNSevere1charles_common.config";
	private static final String BN_SEVERE2_CONFIG_FILE_PATH = "BNSevere2charles_common.config";
	// public static CharlesProxy proxy;
	public File configFile;
	private CharlesProxy proxy;
	

		
	/**
	 * @throws Exception This Script Validate NextGen IM Ad and its parameters
	 */
	@Test(priority = 3010, enabled = true)
	@Description("Validating NextGen IM Static Ad when app in test mode")
	public void Validate_NextGenIM_StaticAd() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Static Ad in test mode");
		logStep("Validating NextGen IM Static Ad in test mode ");
		AppiumFunctions.LaunchAppWithFullReset();
		AppiumFunctions.enterRequiredUserGroup("AdsTestAdUnitOnly");
		Ad.runAppInBackground(30);
		//Ad.launchApp();
		AppFunctions.Kill_Launch_App();
		AppiumFunctions.ClickonIUnderstand();
		AppiumFunctions.enablingResponsiveMode();
		Ad.runAppInBackground(30);
		AppFunctions.Kill_Launch_App();
		AppiumFunctions.enter_requiredLocation("30124");
		Thread.sleep(20000);
		this.proxy.getXml();
		CharlesFunctions.createXMLFileForCharlesSessionFile();
		Utils.verifyPubadCal("Smoke", "Marqueetestmode");
	}


	/**
	 * This Script Validate NextGen IM Ad response
	 * @throws Exception
	 */
	@Test(priority = 602, enabled = true)
	@Description("Validating NextGen IM Static Ad response when app in test mode")
	public void Validate_NextGenIM_StaticAd_response() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Static Ad response in test mode");
		logStep("Validating NextGen IM Static Ad response in test mode ");
		Utils.verifyMarqueeAd_byCallResponse("Smoke", "NextGenIM");

	}
		
		
	/**
	 * This Script Validate NextGen IM Ad and its parameters
	 * @throws Exception
	 */
	@Test(priority = 603, enabled = true)
	@Description("Validating NextGen IM Static Ad BackGround Asset Call")
	public void Validate_NextGenIM_StaticAd_bgAssetCall() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Static Ad BG Asset Call");
		logStep("Validating NextGen IM Static Ad BG Asset Call ");
     	Utils.verifyBGAd_byCallResponse("Smoke", "NextGenIM", "Static");

	}
	
	
	/**
	 * This Script Validate NextGen IM Ad and its parameters
	 * @throws Exception
	 */
	@Test(priority = 604, enabled = true)
	@Description("Validating NextGen IM Static Ad ForeGround Asset Call")
	public void Validate_NextGenIM_StaticAd_fgAssetCall() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Static Ad FG Asset Call");
		logStep("Validating NextGen IM Static Ad FG Asset Call ");
    	Utils.verifyFGAd_byCallResponse("Smoke", "NextGenIM", "Static");

	}
	
	@Test(priority = 605, enabled = true)
	@Description("Validating NextGen IM Static Ad sz parameter")
	public void Validate_NextGenIM_StaticAd_Size() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Static Ad sz parameter in charles");
		logStep("Validating NextGen IM Static Ad sz parameter in charles ");
		Utils.verify_Ad_Size("Smoke", "NextGenIM");
		

	}

	@Test(priority = 1006, enabled = true)
	@Description("Validating Tapability Of Hourly Nav Tab Test Ad when app in test mode")
	public void Validate_TapabilityOfHourlyavTabTestAd() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating Tapability Of Hourly Nav Tab Test Ad in test mode");
		logStep("Validating Tapability Of Hourly Nav Tab Test Ad in test mode ");
Assert.fail("");
	
		
	}
	
	
	
		
		
		
		}




		
	
	
	


