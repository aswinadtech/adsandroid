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

public class BURDAPrivacyTest  extends  TwcAndroidBaseTest {
	
	private static final String CONFIG_FILE_PATH ="enableGDPR.config";
	private CharlesProxy proxy;
	private File configFile;
	public static String  ipAddress=null;
	public static String  portNumber=null;
	
	public static String  defaultPortNumber=properties.getProperty("PortNumber");
	public static String CurrentWifiName=null;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** BURDA Privacy Test Started");
		logStep("****** BURDA Privacy Test Started");
		//this.configFile = this.rewriteRuleToEnableLGPD(CONFIG_FILE_PATH);
		this.configFile = this.charlesGeneralConfigFile(CONFIG_FILE_PATH);
		proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

		proxy.startCharlesProxyWithUI();
		proxy.disableRewriting();
		proxy.stopRecording();
		proxy.disableMapLocal();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (this.configFile != null) {
			this.configFile.delete();
		}
		this.proxy.disableRewriting();
		this.proxy.quitCharlesProxy();
		
		System.out.println("****** Burda  Privacy Test Ended");
		logStep("****** Burda Privacy Test Ended");
	}

	
	
	@Test(priority = 0)
	@Description("Enable Preconditions to change locale BURDA ")
	public void enable_preConditions_toChange_Region_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** enable Preconditions to change region to Germany for BURDA test case Started");
		logStep("****** enable Preconditions to change region to Germany for BURDA test case Started");
	//	Functions.Appium_Autostart();
		// Preconditions
		//Utils.getCurrentMacIPAddressAndSetiPhoneProxy(true, true);
	//	Functions.listFilesForFolder(CharlesFunctions.folder);
		CharlesFunctions.archive_folder("Charles");
		proxy.startRecording();
		proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
		//Functions.launchtheApp_forLocalizatio();
		System.out.println("App launched ");
		logStep("App launched ");
		proxy.getXml();
		CharlesFunctions.archive_folder("Charles");
		proxy.clearCharlesSession();
		AppFunctions.Kill_Launch_App();
		Thread.sleep(6000);
		proxy.getXml();
	//CharlesFunctions.createXMLFileForCharlesSessionFile();
	}
	
	
	
	@Test(priority = 130, enabled = true)
	@Description("Validating NextGen IM Call npa value")
	public void validate_NextGen_IM_call_npa_val_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Call npa value");
		logStep("Validating NextGen IM Call npa value ");

		Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee_BURDA", true);

	}
	
	
	
	
	
	
	@Test(priority = 140, enabled = true)
	@Description("Enable Preconditions to change region to Germany and language to German for BURDA ")
	public void enable_preConditions_toChange_Region_and_Language_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Enable Preconditions to change region to Germany and language to German for BURDA test case Started");
		logStep("****** Enable Preconditions to change region to Germany and language to German for BURDA test case Started");
		Ad.closeApp();
	//	Functions.Appium_Autostart();
		// Preconditions
		//Utils.getCurrentMacIPAddressAndSetiPhoneProxy(true, true);
		//Functions.listFilesForFolder(Functions.folder);
		CharlesFunctions.archive_folder("Charles");
		proxy.startRecording();
		proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
	//Functions.launchtheApp_forLocalizationn("true","DE",true,"de",true);
		System.out.println("App launched ");
		logStep("App launched ");
		CharlesFunctions.archive_folder("Charles");
		proxy.clearCharlesSession();
		AppFunctions.Kill_Launch_App();
		proxy.getXml();
	//CharlesFunctions.createXMLFileForCharlesSessionFile();
	}

	
	
	@Test(priority = 150, enabled = true)
	@Description("Deriving Video Call")
	public void derive_VideoCall_IU_for_BURDA() throws Exception {
		
		System.out.println("==============================================");
		System.out.println("****** Deriving VideoCall For BURDA test case Started");
		logStep("****** Deriving VideoCall For BURDA test case Started");
		proxy.clearCharlesSession();
		AppFunctions.click_HomeButton();
		CharlesFunctions.archive_folder("Charles");
		proxy.clearCharlesSession();
		// navigate to Video tab
AppFunctions.click_video_element();
Thread.sleep(2000);
		CharlesFunctions.archive_folder("Charles");
		Thread.sleep(2000);
		proxy.getXml();
		Utils.createXMLFileForCharlesSessionFile();
		Utils.get_iu_value_of_Feedcall("Smoke", "PreRollVideo");
	}
			
	@Test(priority = 151, enabled = true)
	@Description("Validating Video Call npa value")
	public void validate_Video_call_npa_val_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating Video Call npa value");
		logStep("Validating Video Call npa value ");

		Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

	}
	
	
	
	

}
