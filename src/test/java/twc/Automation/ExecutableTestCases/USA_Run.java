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

public class USA_Run extends  TwcAndroidBaseTest {
	private static final String CONFIG_FILE_PATH = "enableUSA.config";
	private static final String LGPD_CONFIG_FILE_PATH = "enableLGPD.config";
	private static final String GDPR_CONFIG_FILE_PATH ="enableGDPR.config";
	private static final String LATAMCO_CONFIG_FILE_PATH = "enableLATAMCO.config";
	private static final String SERBIA_CONFIG_FILE_PATH = "enableSerbia.config";
	private static final String USA_CONFIG_FILE_PATH = "enableUSA.config";
	
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** USA CCPA  Privacy Test Started");
		logStep("****** LGPD Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
		this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

		this.proxy.startCharlesProxyWithUI();
		this.proxy.disableRewriting();
		this.proxy.stopRecording();
		this.proxy.disableMapLocal();
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (this.configFile != null) {
			this.configFile.delete();
		}
		this.proxy.disableRewriting();
		this.proxy.quitCharlesProxy();
		
		System.out.println("****** USA CCPA  Privacy Test Ended");
		logStep("****** USA CCPA  Privacy Test Ended");
	}
	
	@Test(priority = 100)
	public void preConditionsTest_for_USA_CCPA() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		this.proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
	    Thread.sleep(10000);	
		 Ad.resetApp();
		  Thread.sleep(60000);	
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();		
		  System.out.println("App launched ");
	 	this.proxy.clearCharlesSession();
		AppFunctions.Kill_Launch_App();
		AppiumFunctions.ClickonIUnderstand();
	
	}
	
	
	@Test(priority =102, enabled = true)  
	  @Description("Verifying Privacy Card is present on the screen") public void
	 Verifying_PrivacyCard_PresenceonScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	  AppiumFunctions.SwipeUp_Counter_privacy(25);
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 104, enabled = true)	  
	  @Description("Selecting the  Do Not Sell My Information option  in the privacy card") 
	  public void Selecting_DoNotSellMyInformation_scenario() throws Exception {	  
	 System.out. println("=================Slecting Opt out mode scenario in privacy card testcase started =========================" );
	  Thread.sleep(20000); 
	  Functions.selecting_opt_out_mode(); 
			  System.out.println("kill launch the app for two times");
		    Thread.sleep(20000);		
		  this.proxy.clearCharlesSession(); 
	  Thread.sleep(30000); 
	   AppFunctions.Kill_Launch_App();  
		this.proxy.clearCharlesSession();
	  System.out.println("================= Slecting Optout mode scenario in privacy card  testcase End =========================");	  
	  }
	  
	  @Test(priority = 105, enabled = true)
		@Description("Verify NextGen IM ad call sod value when privacy optout")
		public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout");
			logStep("Verify NextGen IM Adcall sod value when privacy optout");				
			Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

		}
		
		@Test(priority = 106, enabled = true)
		@Description("Verify Hourly details page Call sod value when privacy optout")
		public void verify_Hourly_details_call_sod_val_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");

			System.out.println("****** Verify Hourly details Call sod value when privacy optout");
			logStep("Verify Hourly details Call sod value when privacy optout");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "no");

		}

		@Test(priority = 107, enabled = true)
		@Description("Verify Daily details page Call sod value when privacy optout")
		public void verify_Daily_details_call_sod_val_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Verify Daily details Call sod value when privacy optout");
			logStep("Verify Daily details Call sod value when privacy optout");
			Utils.validate_custom_param_val_of_gampad("Smoke", "Daily(10day)", "sod", "no");
		}
		
		/**
		 * This method verifies Amazon call
		 * @throws Exception
		 */
		@Test(priority = 111, enabled = true)
		@Description("Amazon aax call verification when privacy optout")
		public void Verify_Amazon_Call_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout");
			logStep("****** amazon-adsystem.com Call test case Started when privacy optout");
			Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
		}

		@Test(priority = 114, enabled = true)
		@Description("Verify amazon aax homescreen today preload ad call when privacy optout")
		public void Verify_amazon_aax_homescreen_today_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax homescreen today preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax homescreen today preload ad call validation Started when privacy optout");
			logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optout");
			
			Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", false);

		}

		@Test(priority = 115, enabled = true)
		@Description("Verify amazon aax Feed1 preload ad call when privacy optout")
		public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed1 preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax feed1 preload ad call validation Started when privacy optout");
			logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout");

			Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

		}

		@Test(priority = 116, enabled = true)
		@Description("Verify amazon aax Feed2 preload ad call when privacy optout")
		public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed2 preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax feed2 preload ad call validation Started when privacy optout");
			logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout");

			Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

		}

		@Test(priority = 117, enabled = true)
		@Description("Verify amazon aax Feed3 preload ad call when privacy optout")
		public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed3 preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax feed3 preload ad call validation Started when privacy optout");
			logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

		}

		@Test(priority = 118, enabled = true)
		@Description("Verify amazon aax Feed4 preload ad call when privacy optout")
		public void Verify_amazon_aax_feed4_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed4 preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax feed4 preload ad call validation Started when privacy optout");
			logStep("****** amazon aax feed4 preload ad call validation Started when privacy optout");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed4", false);

		}

		@Test(priority = 119, enabled = true)
		@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout")
		public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon PreRollVideo preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout");
			logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout");
			
			Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

		}

		@Test(priority = 120, enabled = true)
		@Description("Verify amazon aax map details preload ad call when privacy optout")
		public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax map details preload ad call when privacy optout ====================");

			System.out.println("****** amazon aax Map details preload ad call validation Started when privacy optout");
			logStep("****** amazon aax Map details preload ad call validation Started when privacy optout");
			
			Utils.verifyAAX_SlotId("Smoke", "Map", false);

		}

		@Test(priority = 121, enabled = true)
		@Description("Verify amazon aax Daily Details ad call when privacy optout")
		public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Daily Details  ad call when privacy optout ====================");

			System.out.println("****** amazon aax Daily Details ad call validation Started when privacy optout");
			logStep("****** amazon aax Daily Details ad call validation Started when privacy optout");

			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

		}

		@Test(priority = 122, enabled = true)
		@Description("Verify amazon aax Hourly Details ad call when privacy optout")
		public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Hourly Details  ad call when privacy optout====================");

			System.out.println("****** amazon aax Hourly Details ad call validation Started when privacy optout");
			logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout");

			Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

		}

		// Lotame Test case
		@Test(priority = 131, enabled = true)
		@Description("Lotame Call when privacy optout")
		public void Verify_Lotame_Call_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** bcp.crwdcntrl.net Call test case Started when privacy optout");
			logStep("****** bcp.crwdcntrl.net Call test case Started when privacy optout");

			Utils.verifyAPICal("Smoke", "Lotame", false);

		}

		// FACTUAL Test cases
		/*
		 * Factual call is blocked, hence expected to not present this call in charles
		 * session from 12.6 builds onwards...
		 */

		@Test(priority = 132, enabled = true)
		@Description("Factual Call when privacy optout")
		public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** location.wfxtriggers.com Call test case Started when privacy optout");
			logStep("location.wfxtriggers.com Call test case Started when privacy optout");
			Utils.verifyAPICal("Smoke", "LocationWFX", false);

		}
		
		/*
		 * This method validates WFXTriggers call
		 */
		@Test(priority = 133, enabled = true)
		@Description("WFXTrigger Call when privacy optout")
		public void Verify_WFXTriggers_Call_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** triggers.wfxtriggers.com Call test case Started when privacy optout");
			logStep("****** triggers.wfxtriggers.com Call test case Started when privacy optout");
			Utils.verifyAPICal("Smoke", "WFXTrigger", true);

		}

		@Test(priority = 135, enabled = true)
		@Description("Validating NextGen IM Call rdp value when privacy optout")
		public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating NextGenIM Call rdp value when privacy optout");
			logStep("Validating NextGenIM Call rdp value when privacy optout ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 140, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call when privacy optout")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout ====================");
			System.out.println("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 141, enabled = true)
		@Description("Verify Criteo SDK config app call when privacy optout")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout====================");
			System.out.println("****** Criteo SDK config/app call when privacy optout validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 175, enabled = true)
		@Description("Deriving Video Call when privacy optout")
		public void derive_VideoCall_IU_when_Privacy_optout_for_USA() throws Exception {

			System.out.println("==============================================");
			System.out.println("****** Deriving VideoCall For USA when privacy optout");
			logStep("****** Deriving VideoCall For USA when privacy optout");
			CharlesFunctions.archive_folder("Charles");
			proxy.clearCharlesSession();
			// navigate to Video tab
			AppFunctions.click_video_element();
	    Thread.sleep(10000);
			CharlesFunctions.archive_folder("Charles");
			Thread.sleep(10000);
			proxy.getXml();
			Utils.createXMLFileForCharlesSessionFile();
			Utils.get_iu_value_of_Feedcall("Smoke", "PreRollVideo");
		}

		@Test(priority = 176, enabled = true)
		@Description("Verify Preroll ad on Video Call sod value when privacy optout")
		public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");

			System.out.println("****** Prerol-video Call sod value when privacy optout");
			logStep("Verify Prerol-video Call sod value when privacy optout");
			Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

		}

		@Test(priority = 177, enabled = true)
		@Description("Validating PrerollVideo Call rdp value when privacy optout")
		public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating PrerollVideo Call rdp value when privacy optout");
			logStep("Validating PrerollVideo Call rdp value when privacy optout ");
			Utils.validate_rdp_val_in_gampad_url("Smoke", "PrerollVideo", true);			
			/*
			 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
			 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
			 */
			System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			Thread.sleep(240000);

		}
		
		@Test(priority = 200, enabled = true)
		@Description("Enabling Preconfiguration for USA To LGPD Travel Scenario")
		public void enable_PreConfiguration_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA To LGPD Travel Scenario");
			logStep("Enable Preconfiguration for USA To LGPD Travel Scenario");
			proxy.quitCharlesProxy();
			this.configFile = this.rewriteRuleToEnableLGPD(LGPD_CONFIG_FILE_PATH);
			proxy = new CharlesProxy("localhost", 8333, LGPD_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			proxy.enableRewriting();
			proxy.startRecording();
			proxy.disableMapLocal();
			AppiumFunctions.Kill_launch();	
			CharlesFunctions.archive_folder("Charles");
			proxy.getXml();
			proxy.clearCharlesSession();;
			Ad.runAppInBackground(15);
		}

		@Test(priority = 201, enabled = true)
		@Description("Navigating to Feed Cards when privacy optout for USA To LGPD Travel Scenario")
		public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out.println("****** Navigating to Feed Cards when privacy optout for USA To LGPD Travel Scenario");
			logStep("Navigating to Feed Cards when privacy optout for USA To LGPD Travel Scenario");

			try {
				AppFunctions.click_hourly_element();
			Thread.sleep(10000);
				// navigate to Daily tab
			AppFunctions.click_daily_element();
				Thread.sleep(10000);
				// navigate to Video tab
				// vTab.navigateToVideoTab();
				
			} catch (Exception e) {
				System.out.println("There is an exception while navigting to all the feed cards.");
				logStep("There is an exception while navigting to all the feed cards.");
			} finally {
				CharlesFunctions.archive_folder("Charles");
				Thread.sleep(10000);
				proxy.getXml();
				Utils.createXMLFileForCharlesSessionFile();
			}

		}
		
		@Test(priority = 210, enabled = true)
		@Description("Verify NextGen IM ad call sod value when privacy optout for USA To LGPD Travel Scenario")
		public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			
			System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To LGPD Travel Scenario");
			logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

		}

		@Test(priority = 211, enabled = true)
		@Description("Verify Hourly details page Call sod value when privacy optout for USA To LGPD Travel Scenario")
		public void verify_Hourly_details_call_sod_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out
					.println("****** Verify Hourly details Call sod value when privacy optout for USA To LGPD Travel Scenario");
			logStep("Verify Hourly details Call sod value when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "no");

		}
		
		/**
		 * This method verifies Amazon call
		 * @throws Exception
		 */
		@Test(priority = 213, enabled = true)
		@Description("Amazon aax call verification when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_Amazon_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
			Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
		}

		@Test(priority = 214, enabled = true)
		@Description("Verify amazon aax homescreen today preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_homescreen_today_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax homescreen today preload ad call when privacy optout  for USA To LGPD Travel Scenario====================");

			System.out.println(
					"****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", false);

		}

		@Test(priority = 215, enabled = true)
		@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed1 preload ad call when privacy optout for USA To LGPD Travel Scenario====================");

			System.out.println(
					"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

		}

		@Test(priority = 216, enabled = true)
		@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed2 preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

		}

		@Test(priority = 217, enabled = true)
		@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed3 preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

		}

		@Test(priority = 218, enabled = true)
		@Description("Verify amazon aax Feed4 preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_feed4_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed4 preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed4", false);

		}

		@Test(priority = 219, enabled = true)
		@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

			System.out.println(
					"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

		}

		@Test(priority = 220, enabled = true)
		@Description("Verify amazon aax map details preload ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax map details preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Map", false);

		}

		@Test(priority = 221, enabled = true)
		@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Daily Details  ad call when privacy optout for USA To LGPD Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

		}

		@Test(priority = 222, enabled = true)
		@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To LGPD Travel Scenario====================");

			System.out.println(
					"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

		}

		// Lotame Test case
		@Test(priority = 231, enabled = true)
		@Description("Lotame Call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_Lotame_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Lotame Call test case Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** Lotame Call test case Started when privacy optout for USA To LGPD Travel Scenario");

			Utils.verifyAPICal("Smoke", "Lotame", false);

		}

		// FACTUAL Test cases
		/*
		 * Factual call is blocked, hence expected to not present this call in charles
		 * session from 12.6 builds onwards...
		 */

		@Test(priority = 232, enabled = true)
		@Description("Factual Call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
			logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
			Utils.verifyAPICal("Smoke", "LocationWFX", false);

		}

		@Test(priority = 235, enabled = true)
		@Description("Validating NextGen IM Call rdp value when privacy optout for USA To LGPD Travel Scenario")
		public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out
					.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To LGPD Travel Scenario");
			logStep("Validating NextGenIM Call rdp value when privacy optout for USA To LGPD Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 241, enabled = true)
		@Description("Validating NextGen IM Call npa value for USA To LGPD Travel Scenario")
		public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating NextGen IM Call npa value for USA To LGPD Travel Scenario");
			logStep("Validating NextGen IM Call npa value for USA To LGPD Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 250, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To LGPD Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK inapp/v2 call when privacy optout for USA To LGPD Travel Scenario validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To LGPD Travel Scenario validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 251, enabled = true)
		@Description("Verify Criteo SDK config app call when privacy optout for USA To LGPD Travel Scenario")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout for USA To LGPD Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK config/app call when privacy optout for USA To LGPD Travel Scenario validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout for USA To LGPD Travel Scenario validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 275, enabled = true)
		@Description("Deriving Video Call when privacy optout for USA To LGPD Travel Scenario")
		public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {

			System.out.println("==============================================");
			System.out.println("****** Deriving VideoCall when privacy optout for USA To LGPD Travel Scenario");
			logStep("****** Deriving VideoCall when privacy optout for USA To LGPD Travel Scenario");
			AppFunctions.click_hourly_element();
			CharlesFunctions.archive_folder("Charles");
			proxy.clearCharlesSession();
			// navigate to Video tab
		AppFunctions.click_hourly_element();
		Thread.sleep(10000);
			CharlesFunctions.archive_folder("Charles");
			Thread.sleep(10000);
			proxy.getXml();
			Utils.createXMLFileForCharlesSessionFile();
			Utils.get_iu_value_of_Feedcall("Smoke", "PreRollVideo");
		}

		@Test(priority = 276, enabled = true)
		@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To LGPD Travel Scenario")
		public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			
			System.out.println("****** Prerol-video Call sod value when privacy optout for USA To LGPD Travel Scenario");
			logStep("Verify Prerol-video Call sod value when privacy optout for USA To LGPD Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

		}

		@Test(priority = 277, enabled = true)
		@Description("Validating Video Call npa value for USA To LGPD Travel Scenario")
		public void validate_Video_call_npa_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating Video Call npa value for USA To LGPD Travel Scenario");
			logStep("Validating Video Call npa value for USA To LGPD Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

		}

		@Test(priority = 278, enabled = true)
		@Description("Validating Preroll Video Call rdp value when privacy optout for USA To LGPD Travel Scenario")
		public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** Validating PreRollVideo Call rdp value when privacy optout for USA To LGPD Travel Scenario");
			logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To LGPD Travel Scenario ");

			
			Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
			/*
			 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
			 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
			 */
			System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			Thread.sleep(240000);

		}
		
		
		@Test(priority = 300, enabled = true)
		@Description("Enabling Preconfiguration for USA To GDPR Travel Scenario")
		public void enable_PreConfiguration_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA To GDPR Travel Scenario");
			logStep("Enable Preconfiguration for USA To GDPR Travel Scenario");
			proxy.quitCharlesProxy();
			this.configFile = this.rewriteRuleToEnableGDPR(GDPR_CONFIG_FILE_PATH);
			proxy = new CharlesProxy("localhost", 8333, GDPR_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			proxy.enableRewriting();
			proxy.startRecording();
			proxy.disableMapLocal();
			AppFunctions.Kill_Launch_App();
			CharlesFunctions.archive_folder("Charles");
			proxy.getXml();
			proxy.clearCharlesSession();
         Ad.runAppInBackground(15);
		}

		@Test(priority = 301, enabled = true)
		@Description("Navigating to Feed Cards when privacy optout for USA To GDPR Travel Scenario")
		public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Navigating to Feed Cards when privacy optout for USA To GDPR Travel Scenario");
			logStep("Navigating to Feed Cards when privacy optout for USA To GDPR Travel Scenario");
			try {
				AppFunctions.click_hourly_element();
	Thread.sleep(2000);
				// navigate to Daily tab
			AppFunctions.click_daily_element();
			Thread.sleep(2000);
				// navigate to Video tab
				// vTab.navigateToVideoTab();
			} catch (Exception e) {
				System.out.println("There is an exception while navigting to all the feed cards.");
				logStep("There is an exception while navigting to all the feed cards.");
			} finally {
				CharlesFunctions.archive_folder("Charles");
				Thread.sleep(2000);
				proxy.getXml();
				Utils.createXMLFileForCharlesSessionFile();
			}

		}
		
		@Test(priority = 310, enabled = true)
		@Description("Verify NextGen IM ad call sod value when privacy optout for USA To GDPR Travel Scenario")
		public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
		
			System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To GDPR Travel Scenario");
			logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To GDPR Travel Scenario");
		
			Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

		}

		@Test(priority = 311, enabled = true)
		@Description("Verify Hourly details page Call sod value when privacy optout for USA To GDPR Travel Scenario")
		public void verify_Hourly_details_call_sod_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out
					.println("****** Verify Hourly details Call sod value when privacy optout for USA To GDPR Travel Scenario");
			logStep("Verify Hourly details Call sod value when privacy optout for USA To GDPR Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "no");

		}
		
		/**
		 * This method verifies Amazon call
		 * @throws Exception
		 */
		@Test(priority = 313, enabled = true)
		@Description("Amazon aax call verification when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_Amazon_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
			Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
		}

		@Test(priority = 314, enabled = true)
		@Description("Verify amazon aax homescreen today preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_homescreen_today_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax homescreen today preload ad call when privacy optout  for USA To GDPR Travel Scenario====================");

			System.out.println(
					"****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", false);

		}

		@Test(priority = 315, enabled = true)
		@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed1 preload ad call when privacy optout for USA To GDPR Travel Scenario====================");

			System.out.println(
					"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

		}

		@Test(priority = 316, enabled = true)
		@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed2 preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

		}

		@Test(priority = 317, enabled = true)
		@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed3 preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

		}

		@Test(priority = 318, enabled = true)
		@Description("Verify amazon aax Feed4 preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_feed4_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed4 preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed4", false);

		}

		@Test(priority = 319, enabled = true)
		@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

			System.out.println(
					"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

		}

		@Test(priority = 320, enabled = true)
		@Description("Verify amazon aax map details preload ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax map details preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Map", false);

		}

		@Test(priority = 321, enabled = true)
		@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Daily Details  ad call when privacy optout for USA To GDPR Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

		}

		@Test(priority = 322, enabled = true)
		@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To GDPR Travel Scenario====================");

			System.out.println(
					"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

		}

		// Lotame Test case
		@Test(priority = 331, enabled = true)
		@Description("Lotame Call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_Lotame_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Lotame Call test case Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** Lotame Call test case Started when privacy optout for USA To GDPR Travel Scenario");

			Utils.verifyAPICal("Smoke", "Lotame", false);

		}

		// FACTUAL Test cases
		/*
		 * Factual call is blocked, hence expected to not present this call in charles
		 * session from 12.6 builds onwards...
		 */

		@Test(priority = 332, enabled = true)
		@Description("Factual Call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
			logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
			Utils.verifyAPICal("Smoke", "LocationWFX", false);

		}

		@Test(priority = 335, enabled = true)
		@Description("Validating NextGen IM Call rdp value when privacy optout for USA To GDPR Travel Scenario")
		public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out
					.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To GDPR Travel Scenario");
			logStep("Validating NextGenIM Call rdp value when privacy optout for USA To GDPR Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 341, enabled = true)
		@Description("Validating NextGen IM Call npa value for USA To GDPR Travel Scenario")
		public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating NextGen IM Call npa value for USA To GDPR Travel Scenario");
			logStep("Validating NextGen IM Call npa value for USA To GDPR Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 350, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To GDPR Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK inapp/v2 call when privacy optout for USA To GDPR Travel Scenario validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To GDPR Travel Scenario validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 351, enabled = true)
		@Description("Verify Criteo SDK config app call when privacy optout for USA To GDPR Travel Scenario")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout for USA To GDPR Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK config/app call when privacy optout for USA To GDPR Travel Scenario validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout for USA To GDPR Travel Scenario validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 375, enabled = true)
		@Description("Deriving Video Call when privacy optout for USA To GDPR Travel Scenario")
		public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {

			System.out.println("==============================================");
			System.out.println("****** Deriving VideoCall when privacy optout for USA To GDPR Travel Scenario");
			logStep("****** Deriving VideoCall when privacy optout for USA To GDPR Travel Scenario");
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

		@Test(priority = 376, enabled = true)
		@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To GDPR Travel Scenario")
		public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			
			System.out.println("****** Prerol-video Call sod value when privacy optout for USA To GDPR Travel Scenario");
			logStep("Verify Prerol-video Call sod value when privacy optout for USA To GDPR Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

		}

		@Test(priority = 377, enabled = true)
		@Description("Validating Video Call npa value for USA To GDPR Travel Scenario")
		public void validate_Video_call_npa_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating Video Call npa value for USA To GDPR Travel Scenario");
			logStep("Validating Video Call npa value for USA To GDPR Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

		}

		@Test(priority = 378, enabled = true)
		@Description("Validating Preroll Video Call rdp value when privacy optout for USA To GDPR Travel Scenario")
		public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** Validating PreRollVideo Call rdp value when privacy optout for USA To GDPR Travel Scenario");
			logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To GDPR Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
			/*
			 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
			 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
			 */
			System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			Thread.sleep(240000);
		}
		
		@Test(priority = 400, enabled = true)
		@Description("Enabling Preconfiguration for USA To SERBIA Travel Scenario")
		public void enable_PreConfiguration_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA To SERBIA Travel Scenario");
			logStep("Enable Preconfiguration for USA To SERBIA Travel Scenario");
			proxy.quitCharlesProxy();
			this.configFile = this.rewriteRuleToEnableSERBIA(SERBIA_CONFIG_FILE_PATH);
			proxy = new CharlesProxy("localhost", 8333, SERBIA_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			proxy.enableRewriting();
			proxy.startRecording();
			proxy.disableMapLocal();
			AppFunctions.Kill_Launch_App();
			CharlesFunctions.archive_folder("Charles");
			proxy.getXml();
			proxy.clearCharlesSession();
			Ad.runAppInBackground(15);
		}

		@Test(priority = 401, enabled = true)
		@Description("Navigating to Feed Cards when privacy optout for USA To SERBIA Travel Scenario")
		public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out.println("****** Navigating to Feed Cards when privacy optout for USA To SERBIA Travel Scenario");
			logStep("Navigating to Feed Cards when privacy optout for USA To SERBIA Travel Scenario");

			try {
			AppFunctions.click_hourly_element();
			Thread.sleep(2000);
				// navigate to Daily tab
      AppFunctions.click_daily_element();
				Thread.sleep(2000);
				// navigate to Video tab
				// vTab.navigateToVideoTab();
				
			} catch (Exception e) {
				System.out.println("There is an exception while navigting to all the feed cards.");
				logStep("There is an exception while navigting to all the feed cards.");
			} finally {
				CharlesFunctions.archive_folder("Charles");
				Thread.sleep(2000);
				proxy.getXml();
				Utils.createXMLFileForCharlesSessionFile();
			}

		}
		
		@Test(priority = 410, enabled = true)
		@Description("Verify NextGen IM ad call sod value when privacy optout for USA To SERBIA Travel Scenario")
		public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
		
			System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To SERBIA Travel Scenario");
			logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To SERBIA Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

		}

		@Test(priority = 411, enabled = true)
		@Description("Verify Hourly details page Call sod value when privacy optout for USA To SERBIA Travel Scenario")
		public void verify_Hourly_details_call_sod_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out
					.println("****** Verify Hourly details Call sod value when privacy optout for USA To SERBIA Travel Scenario");
			logStep("Verify Hourly details Call sod value when privacy optout for USA To SERBIA Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "no");

		}
		
		/**
		 * This method verifies Amazon call
		 * @throws Exception
		 */
		@Test(priority = 413, enabled = true)
		@Description("Amazon aax call verification when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_Amazon_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
			Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
		}

		@Test(priority = 414, enabled = true)
		@Description("Verify amazon aax homescreen today preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_homescreen_today_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax homescreen today preload ad call when privacy optout  for USA To SERBIA Travel Scenario====================");

			System.out.println(
					"****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", false);

		}

		@Test(priority = 415, enabled = true)
		@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed1 preload ad call when privacy optout for USA To SERBIA Travel Scenario====================");

			System.out.println(
					"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

		}

		@Test(priority = 416, enabled = true)
		@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed2 preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

		}

		@Test(priority = 417, enabled = true)
		@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed3 preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

		}

		@Test(priority = 418, enabled = true)
		@Description("Verify amazon aax Feed4 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_feed4_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed4 preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
		
			Utils.verifyAAX_SlotId("Smoke", "Feed4", false);

		}

		@Test(priority = 419, enabled = true)
		@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
		
			Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

		}

		@Test(priority = 420, enabled = true)
		@Description("Verify amazon aax map details preload ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax map details preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
		
			Utils.verifyAAX_SlotId("Smoke", "Map", false);

		}

		@Test(priority = 421, enabled = true)
		@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Daily Details  ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

		}

		@Test(priority = 422, enabled = true)
		@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To SERBIA Travel Scenario====================");

			System.out.println(
					"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

		}

		// Lotame Test case
		@Test(priority = 431, enabled = true)
		@Description("Lotame Call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_Lotame_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Lotame Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** Lotame Call test case Started when privacy optout for USA To SERBIA Travel Scenario");

			Utils.verifyAPICal("Smoke", "Lotame", false);

		}

		// FACTUAL Test cases
		/*
		 * Factual call is blocked, hence expected to not present this call in charles
		 * session from 12.6 builds onwards...
		 */

		@Test(priority = 432, enabled = true)
		@Description("Factual Call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
			logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
			Utils.verifyAPICal("Smoke", "LocationWFX", false);

		}

		@Test(priority = 435, enabled = true)
		@Description("Validating NextGen IM Call rdp value when privacy optout for USA To SERBIA Travel Scenario")
		public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out
					.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To SERBIA Travel Scenario");
			logStep("Validating NextGenIM Call rdp value when privacy optout for USA To SERBIA Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 441, enabled = true)
		@Description("Validating NextGen IM Call npa value for USA To SERBIA Travel Scenario")
		public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating NextGen IM Call npa value for USA To SERBIA Travel Scenario");
			logStep("Validating NextGen IM Call npa value for USA To SERBIA Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 450, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To SERBIA Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK inapp/v2 call when privacy optout for USA To SERBIA Travel Scenario validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To SERBIA Travel Scenario validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 451, enabled = true)
		@Description("Verify Criteo SDK config app call when privacy optout for USA To SERBIA Travel Scenario")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout for USA To SERBIA Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK config/app call when privacy optout for USA To SERBIA Travel Scenario validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout for USA To SERBIA Travel Scenario validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 475, enabled = true)
		@Description("Deriving Video Call when privacy optout for USA To SERBIA Travel Scenario")
		public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {

			System.out.println("==============================================");
			System.out.println("****** Deriving VideoCall when privacy optout for USA To SERBIA Travel Scenario");
			logStep("****** Deriving VideoCall when privacy optout for USA To SERBIA Travel Scenario");
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

		@Test(priority = 476, enabled = true)
		@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To SERBIA Travel Scenario")
		public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			
			System.out.println("****** Prerol-video Call sod value when privacy optout for USA To SERBIA Travel Scenario");
			logStep("Verify Prerol-video Call sod value when privacy optout for USA To SERBIA Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

		}

		@Test(priority = 477, enabled = true)
		@Description("Validating Video Call npa value for USA To SERBIA Travel Scenario")
		public void validate_Video_call_npa_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating Video Call npa value for USA To SERBIA Travel Scenario");
			logStep("Validating Video Call npa value for USA To SERBIA Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

		}

		@Test(priority = 478, enabled = true)
		@Description("Validating Preroll Video Call rdp value when privacy optout for USA To SERBIA Travel Scenario")
		public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** Validating PreRollVideo Call rdp value when privacy optout for USA To SERBIA Travel Scenario");
			logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To SERBIA Travel Scenario ");
			Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
			/*
			 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
			 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
			 */
			System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			Thread.sleep(240000);
		}
		
		
		@Test(priority = 500, enabled = true)
		@Description("Enabling Preconfiguration for USA To LATAMCO Travel Scenario")
		public void enable_PreConfiguration_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA To LATAMCO Travel Scenario");
			logStep("Enable Preconfiguration for USA To LATAMCO Travel Scenario");
			proxy.quitCharlesProxy();
			this.configFile = this.rewriteRuleToEnableLATAMCO(LATAMCO_CONFIG_FILE_PATH);
			proxy = new CharlesProxy("localhost", 8333, LATAMCO_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			proxy.enableRewriting();
			proxy.startRecording();
			proxy.disableMapLocal();
			AppFunctions.Kill_Launch_App();;
			CharlesFunctions.archive_folder("Charles");
			proxy.getXml();
			proxy.clearCharlesSession();
	  Ad.runAppInBackground(15);

		}

		@Test(priority = 501, enabled = true)
		@Description("Navigating to Feed Cards when privacy optout for USA To LATAMCO Travel Scenario")
		public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out.println("****** Navigating to Feed Cards when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("Navigating to Feed Cards when privacy optout for USA To LATAMCO Travel Scenario");

			try {
		AppFunctions.click_hourly_element();;
		Thread.sleep(2000);
				// navigate to Daily tab
			AppFunctions.click_daily_element();
				Thread.sleep(2000);
				// navigate to Video tab
				// vTab.navigateToVideoTab();
				
			} catch (Exception e) {
				System.out.println("There is an exception while navigting to all the feed cards.");
				logStep("There is an exception while navigting to all the feed cards.");
			} finally {
				CharlesFunctions.archive_folder("Charles");
				Thread.sleep(2000);
				proxy.getXml();
				Utils.createXMLFileForCharlesSessionFile();
			}

		}
		
		@Test(priority = 510, enabled = true)
		@Description("Verify NextGen IM ad call sod value when privacy optout for USA To LATAMCO Travel Scenario")
		public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
		
			System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

		}

		@Test(priority = 511, enabled = true)
		@Description("Verify Hourly details page Call sod value when privacy optout for USA To LATAMCO Travel Scenario")
		public void verify_Hourly_details_call_sod_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out
					.println("****** Verify Hourly details Call sod value when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("Verify Hourly details Call sod value when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "no");

		}
		
		/**
		 * This method verifies Amazon call
		 * @throws Exception
		 */
		@Test(priority = 513, enabled = true)
		@Description("Amazon aax call verification when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_Amazon_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LATAMCO Travel Scenario");
			Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
		}

		@Test(priority = 514, enabled = true)
		@Description("Verify amazon aax homescreen today preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_homescreen_today_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax homescreen today preload ad call when privacy optout  for USA To LATAMCO Travel Scenario====================");

			System.out.println(
					"****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", false);

		}

		@Test(priority = 515, enabled = true)
		@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed1 preload ad call when privacy optout for USA To LATAMCO Travel Scenario====================");

			System.out.println(
					"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

		}

		@Test(priority = 516, enabled = true)
		@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed2 preload ad call when privacy optout for USA To LATAMCO Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

		}

		@Test(priority = 517, enabled = true)
		@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed3 preload ad call when privacy optout for USA To LATAMCO Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

		}

		@Test(priority = 518, enabled = true)
		@Description("Verify amazon aax Feed4 preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_feed4_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed4 preload ad call when privacy optout for USA To LATAMCO Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed4", false);

		}

		@Test(priority = 519, enabled = true)
		@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To LATAMCO Travel Scenario ====================");

			System.out.println(
					"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

		}

		@Test(priority = 520, enabled = true)
		@Description("Verify amazon aax map details preload ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax map details preload ad call when privacy optout for USA To LATAMCO Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Map", false);

		}

		@Test(priority = 521, enabled = true)
		@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Daily Details  ad call when privacy optout for USA To LATAMCO Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

		}

		@Test(priority = 522, enabled = true)
		@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To LATAMCO Travel Scenario====================");

			System.out.println(
					"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LATAMCO Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

		}

		// Lotame Test case
		@Test(priority = 531, enabled = true)
		@Description("Lotame Call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_Lotame_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Lotame Call test case Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** Lotame Call test case Started when privacy optout for USA To LATAMCO Travel Scenario");

			Utils.verifyAPICal("Smoke", "Lotame", false);

		}

		// FACTUAL Test cases
		/*
		 * Factual call is blocked, hence expected to not present this call in charles
		 * session from 12.6 builds onwards...
		 */

		@Test(priority = 532, enabled = true)
		@Description("Factual Call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To LATAMCO Travel Scenario");
			Utils.verifyAPICal("Smoke", "LocationWFX", false);

		}

		@Test(priority = 535, enabled = true)
		@Description("Validating NextGen IM Call rdp value when privacy optout for USA To LATAMCO Travel Scenario")
		public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out
					.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("Validating NextGenIM Call rdp value when privacy optout for USA To LATAMCO Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 541, enabled = true)
		@Description("Validating NextGen IM Call npa value for USA To LATAMCO Travel Scenario")
		public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating NextGen IM Call npa value for USA To LATAMCO Travel Scenario");
			logStep("Validating NextGen IM Call npa value for USA To LATAMCO Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 550, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To LATAMCO Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK inapp/v2 call when privacy optout for USA To LATAMCO Travel Scenario validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To LATAMCO Travel Scenario validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 551, enabled = true)
		@Description("Verify Criteo SDK config app call when privacy optout for USA To LATAMCO Travel Scenario")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout for USA To LATAMCO Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK config/app call when privacy optout for USA To LATAMCO Travel Scenario validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout for USA To LATAMCO Travel Scenario validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 575, enabled = true)
		@Description("Deriving Video Call when privacy optout for USA To LATAMCO Travel Scenario")
		public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {

			System.out.println("==============================================");
			System.out.println("****** Deriving VideoCall when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("****** Deriving VideoCall when privacy optout for USA To LATAMCO Travel Scenario");
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

		@Test(priority = 576, enabled = true)
		@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To LATAMCO Travel Scenario")
		public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			// Functions.retryclear();

			System.out.println("****** Prerol-video Call sod value when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("Verify Prerol-video Call sod value when privacy optout for USA To LATAMCO Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

		}

		@Test(priority = 577, enabled = true)
		@Description("Validating Video Call npa value for USA To LATAMCO Travel Scenario")
		public void validate_Video_call_npa_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating Video Call npa value for USA To LATAMCO Travel Scenario");
			logStep("Validating Video Call npa value for USA To LATAMCO Travel Scenario ");

			Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

		}

		@Test(priority = 578, enabled = true)
		@Description("Validating Preroll Video Call rdp value when privacy optout for USA To LATAMCO Travel Scenario")
		public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** Validating PreRollVideo Call rdp value when privacy optout for USA To LATAMCO Travel Scenario");
			logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To LATAMCO Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
			/*
			 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
			 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
			 */
			System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
			Thread.sleep(240000);
		}
		
		@Test(priority = 800, enabled = true)
		@Description("Enabling Preconfiguration for USA To USA Travel Scenario")
		public void enable_PreConfiguration_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA To USA Travel Scenario");
			logStep("Enable Preconfiguration for USA To USA Travel Scenario");
			proxy.quitCharlesProxy();
			this.configFile = this.rewriteRuleToEnableUSA(USA_CONFIG_FILE_PATH);
			proxy = new CharlesProxy("localhost", 8333, USA_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			proxy.enableRewriting();
			proxy.startRecording();
			proxy.disableMapLocal();
			AppFunctions.Kill_Launch_App();
			CharlesFunctions.archive_folder("Charles");
			proxy.getXml();
			proxy.clearCharlesSession();
			AppFunctions.Kill_Launch_App();
			Ad.runAppInBackground(15);
		}

		@Test(priority = 801, enabled = true)
		@Description("Navigating to Feed Cards when privacy optout for USA To USA Travel Scenario")
		public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out.println("****** Navigating to Feed Cards when privacy optout for USA To USA Travel Scenario");
			logStep("Navigating to Feed Cards when privacy optout for USA To USA Travel Scenario");

			try {
	AppFunctions.click_HomeButton();
				AppFunctions.click_hourly_element();
				Thread.sleep(2000);
				// navigate to Daily tab
		AppFunctions.click_daily_element();
				Thread.sleep(2000);
				// navigate to Video tab
				// vTab.navigateToVideoTab();
				
			} catch (Exception e) {
				System.out.println("There is an exception while navigting to all the feed cards.");
				logStep("There is an exception while navigting to all the feed cards.");
			} finally {
				CharlesFunctions.archive_folder("Charles");
				Thread.sleep(2000);
				proxy.getXml();
				Utils.createXMLFileForCharlesSessionFile();
			}

		}

		@Test(priority = 810, enabled = true)
		@Description("Verify NextGen IM ad call sod value when privacy optout for USA To USA Travel Scenario")
		public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			// Functions.retryclear();

			System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To USA Travel Scenario");
			logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To USA Travel Scenario");
		
			Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

		}

		@Test(priority = 811, enabled = true)
		@Description("Verify Hourly details page Call sod value when privacy optout for USA To USA Travel Scenario")
		public void verify_Hourly_details_call_sod_val_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");

			System.out
					.println("****** Verify Hourly details Call sod value when privacy optout for USA To USA Travel Scenario");
			logStep("Verify Hourly details Call sod value when privacy optout for USA To USA Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "no");

		}
		
		/**
		 * This method verifies Amazon call
		 * @throws Exception
		 */
		@Test(priority = 813, enabled = true)
		@Description("Amazon aax call verification when privacy optout for USA To USA Travel Scenario")
		public void Verify_Amazon_Call_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To USA Travel Scenario");
			Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
		}

		@Test(priority = 814, enabled = true)
		@Description("Verify amazon aax homescreen today preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_homescreen_today_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax homescreen today preload ad call when privacy optout  for USA To USA Travel Scenario====================");

			System.out.println(
					"****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optout for USA To USA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", false);

		}

		@Test(priority = 815, enabled = true)
		@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed1 preload ad call when privacy optout for USA To USA Travel Scenario====================");

			System.out.println(
					"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

		}

		@Test(priority = 816, enabled = true)
		@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed2 preload ad call when privacy optout for USA To USA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

		}

		@Test(priority = 817, enabled = true)
		@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed3 preload ad call when privacy optout for USA To USA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

		}

		@Test(priority = 818, enabled = true)
		@Description("Verify amazon aax Feed4 preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_feed4_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax feed4 preload ad call when privacy optout for USA To USA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax feed4 preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Feed4", false);

		}

		@Test(priority = 819, enabled = true)
		@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To USA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

		}

		@Test(priority = 820, enabled = true)
		@Description("Verify amazon aax map details preload ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax map details preload ad call when privacy optout for USA To USA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To USA Travel Scenario");
			
			Utils.verifyAAX_SlotId("Smoke", "Map", false);

		}

		@Test(priority = 821, enabled = true)
		@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Daily Details  ad call when privacy optout for USA To USA Travel Scenario ====================");

			System.out.println(
					"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To USA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

		}

		@Test(priority = 822, enabled = true)
		@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To USA Travel Scenario")
		public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To USA Travel Scenario====================");

			System.out.println(
					"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To USA Travel Scenario");

			Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

		}

		// Lotame Test case
		@Test(priority = 831, enabled = true)
		@Description("Lotame Call when privacy optout for USA To USA Travel Scenario")
		public void Verify_Lotame_Call_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Lotame Call test case Started when privacy optout for USA To USA Travel Scenario");
			logStep("****** Lotame Call test case Started when privacy optout for USA To USA Travel Scenario");

			Utils.verifyAPICal("Smoke", "Lotame", false);

		}

		// FACTUAL Test cases
		/*
		 * Factual call is blocked, hence expected to not present this call in charles
		 * session from 12.6 builds onwards...
		 */

		@Test(priority = 832, enabled = true)
		@Description("Factual Call when privacy optout for USA To USA Travel Scenario")
		public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To USA Travel Scenario");
			logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To USA Travel Scenario");
			Utils.verifyAPICal("Smoke", "LocationWFX", false);

		}

		@Test(priority = 835, enabled = true)
		@Description("Validating NextGen IM Call rdp value when privacy optout for USA To USA Travel Scenario")
		public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out
					.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To USA Travel Scenario");
			logStep("Validating NextGenIM Call rdp value when privacy optout for USA To USA Travel Scenario ");

			Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

		}

		@Test(priority = 850, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To USA Travel Scenario")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To USA Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK inapp/v2 call when privacy optout for USA To USA Travel Scenario validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To USA Travel Scenario validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 851, enabled = true)
		@Description("Verify Criteo SDK config app call when privacy optout for USA To USA Travel Scenario")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout for USA To USA Travel Scenario====================");
			System.out.println(
					"****** Criteo SDK config/app call when privacy optout for USA To USA Travel Scenario validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout for USA To USA Travel Scenario validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

		@Test(priority = 875, enabled = true)
		@Description("Deriving Video Call when privacy optout for USA To USA Travel Scenario")
		public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {

			System.out.println("==============================================");
			System.out.println("****** Deriving VideoCall when privacy optout for USA To USA Travel Scenario");
			logStep("****** Deriving VideoCall when privacy optout for USA To USA Travel Scenario");
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

		@Test(priority = 876, enabled = true)
		@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To USA Travel Scenario")
		public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			
			System.out.println("****** Prerol-video Call sod value when privacy optout for USA To USA Travel Scenario");
			logStep("Verify Prerol-video Call sod value when privacy optout for USA To USA Travel Scenario");
			
			Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

		}

		
		@Test(priority = 878, enabled = true)
		@Description("Validating Preroll Video Call rdp value when privacy optout for USA To USA Travel Scenario")
		public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_USA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"****** Validating PreRollVideo Call rdp value when privacy optout for USA To USA Travel Scenario");
			logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To USA Travel Scenario ");
			Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
			
		}
		
		
		@Test(priority = 878, enabled = true)
		public void preConditionsTest_for_USA_Selecting_StandardAdvertisingSettings() throws Exception {
			proxy.quitCharlesProxy();
			this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
			this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

			this.proxy.startCharlesProxyWithUI();
			this.proxy.disableMapLocal();
			this.proxy.enableRewriting();
    	         this.proxy.startRecording();
             this.proxy.clearCharlesSession();
		//	Functions.close_launchApp();
			//Utils.navigateToAllCards(false);
		//	Utils.createXMLFileForCharlesSessionFile();
		}




@Test(priority =878, enabled = true)	  
@Description("Selecting the  Standard Advertising Settings  in the privacy card") public void
Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
logStep("Selecting the Standard Advertising Settings  in the privacy card");
System.out. println("=================Slecting Standard Advertising Settings  in privacy card testcase started =========================");
Ad.resetApp();
AppFunctions.Kill_Launch_App();
//CharlesFunctions.archive_folder("charles");
Thread.sleep(100000);	  
AppiumFunctions.SwipeUp_Counter_privacy(25);
Thread.sleep(40000); 
// Functions.selecting_opt_in_mode();
 Thread.sleep(40000); 		  	
AppFunctions.Kill_Launch_App();
this.proxy.clearCharlesSession();
AppFunctions.Kill_Launch_App();
this.proxy.clearCharlesSession();
System.out.println("================= Slecting Standard Advertising Settings  in privacy card  testcase End ========================="); 
}




@Test(priority = 878, enabled = true)	  
@Description("Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_presence_USA_CCPA_Privacy_StandardAdvertisingSettings() throws  Exception { 
logStep("Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
System.out.println("=================Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================");	  
this.proxy.clearCharlesSession();
 AppFunctions.click_hourly_element();
 AppFunctions.click_daily_element();	
CharlesFunctions.archive_folder("charles");
	this.proxy.getXml();		
	Utils.createXMLFileForCharlesSessionFile();
	Utils.verifyAPICal("Smoke", "Lotame", true);
System.out.println("================= Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );

}

@Test(priority = 19, enabled = true)
@Description("Verify NextGen IM ad call sod value when privacy optin")
public void validate_NextGen_IM_Adcall_sod_val_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	// Functions.retryclear();

	System.out.println("****** Verify NextGen IM Adcall sod value when privacy optin");
	logStep("Verify NextGen IM Adcall sod value when privacy optin");
	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "yes");

}

@Test(priority = 20, enabled = true)
@Description("Verify Hourly details page Call sod value when privacy optin")
public void verify_Hourly_details_call_sod_val_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");

	System.out.println("****** Verify Hourly details Call sod value when privacy optin");
	logStep("Verify Hourly details Call sod value when privacy optin");
	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "sod", "yes");

}

@Test(priority = 21, enabled = true)
@Description("Verify Daily details page Call sod value when privacy optin")
public void verify_Daily_details_call_sod_val_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");

	System.out.println("****** Verify Daily details Call sod value when privacy optin");
	logStep("Verify Daily details Call sod value when privacy optin");
	Utils.validate_custom_param_val_of_gampad("Smoke", "Daily(10day)", "sod", "yes");

}

@Test(priority = 27, enabled = true)
@Description("Verify amazon aax homescreen today preload ad call when privacy optin")
public void Verify_amazon_aax_homescreen_today_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax homescreen today preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax homescreen today preload ad call validation Started when privacy optin");
	logStep("****** amazon aax homescreen today preload ad call validation Started when privacy optin");

	Utils.verifyAAX_SlotId("Smoke", "Pulltorefresh", true);
}

@Test(priority = 28, enabled = true)
@Description("Verify amazon aax Feed1 preload ad call when privacy optin")
public void Verify_amazon_aax_feed1_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax feed1 preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax feed1 preload ad call validation Started when privacy optin");
	logStep("****** amazon aax feed1 preload ad call validation Started when privacy optin");

	Utils.verifyAAX_SlotId("Smoke", "Feed1", true);

}

@Test(priority = 29, enabled = true)
@Description("Verify amazon aax Feed2 preload ad call when privacy optin")
public void Verify_amazon_aax_feed2_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax feed2 preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax feed2 preload ad call validation Started when privacy optin");
	logStep("****** amazon aax feed2 preload ad call validation Started when privacy optin");

	Utils.verifyAAX_SlotId("Smoke", "Feed2", true);

}

@Test(priority = 30, enabled = true)
@Description("Verify amazon aax Feed3 preload ad call when privacy optin")
public void Verify_amazon_aax_feed3_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax feed3 preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax feed3 preload ad call validation Started when privacy optin");
	logStep("****** amazon aax feed3 preload ad call validation Started when privacy optin");
	
	Utils.verifyAAX_SlotId("Smoke", "Feed3", true);

}

@Test(priority = 31, enabled = true)
@Description("Verify amazon aax Feed4 preload ad call when privacy optin")
public void Verify_amazon_aax_feed4_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax feed4 preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax feed4 preload ad call validation Started when privacy optin");
	logStep("****** amazon aax feed4 preload ad call validation Started when privacy optin");
	
	Utils.verifyAAX_SlotId("Smoke", "Feed4", true);

}

@Test(priority = 32, enabled = true)
@Description("Verify amazon aax PreRollVideo preload ad call when privacy optin")
public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon PreRollVideo preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax PreRollVideo preload ad call validation Started when privacy optin");
	logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optin");
	
	Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", true);

}

@Test(priority = 33, enabled = true)
@Description("Verify amazon aax map details preload ad call when privacy optin")
public void Verify_amazon_aax_map_details_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax map details preload ad call when privacy optin ====================");

	System.out.println("****** amazon aax Map details preload ad call validation Started when privacy optin");
	logStep("****** amazon aax Map details preload ad call validation Started when privacy optin");
	
	Utils.verifyAAX_SlotId("Smoke", "Map", true);

}

@Test(priority = 34, enabled = true)
@Description("Verify amazon aax Daily Details ad call when privacy optin")
public void Verify_amazon_aax_Daily_details_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax Daily Details  ad call when privacy optin ====================");

	System.out.println("****** amazon aax Daily Details ad call validation Started when privacy optin");
	logStep("****** amazon aax Daily Details ad call validation Started when privacy optin");

	Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", true);

}

@Test(priority = 35, enabled = true)
@Description("Verify amazon aax Hourly Details ad call when privacy optin")
public void Verify_amazon_aax_Hourly_details_adcall_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== amazon aax Hourly Details  ad call when privacy optin====================");

	System.out.println("****** amazon aax Hourly Details ad call validation Started when privacy optin");
	logStep("****** amazon aax Hourly Details ad call validation Started when privacy optin");

	Utils.verifyAAX_SlotId("Smoke", "Hourly", true);

}

// Lotame Test case
@Test(priority = 38, enabled = true)
@Description("Lotame Call when privacy optin")
public void Verify_Lotame_call_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println("****** bcp.crwdcntrl.net Call test case Started when privacy optin");
	logStep("****** bcp.crwdcntrl.net Call test case Started when privacy optin");

	Utils.verifyAPICal("Smoke", "Lotame", true);

}

// FACTUAL Test cases
/*
* Factual call is blocked, hence expected to not present this call in charles
* session from 12.6 builds onwards...
*/

@Test(priority = 39, enabled = true)
@Description("Factual Call when privacy optin")
public void Verify_LocationWFXTriggers_Call_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println("****** location.wfxtriggers.com Call test case Started when privacy optin");
	logStep("location.wfxtriggers.com Call test case Started when privacy optin");
	Utils.verifyAPICal("Smoke", "LocationWFX", false);

}

/*
* This method validates WFXTriggers call
*/
@Test(priority = 40, enabled = true)
@Description("WFXTrigger Call when privacy optin")
public void Verify_WFXTriggers_Call_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println("****** triggers.wfxtriggers.com Call test case Started when privacy optin");
	logStep("****** triggers.wfxtriggers.com Call test case Started when privacy optin");
	Utils.verifyAPICal("Smoke", "WFXTrigger", true);

}

@Test(priority = 42, enabled = true)
@Description("Validating NextGen IM Call rdp value when privacy optin")
public void validate_NextGen_IM_call_rdp_val_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println("****** Validating NextGenIM Call rdp value when privacy optin");
	logStep("Validating NextGenIM Call rdp value when privacy optin ");

	Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", false);

}

@Test(priority = 51, enabled = true)
@Description("Verify Criteo SDK inapp v2 call when privacy optin")
public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out
			.println("=========================== Criteo SDK inapp/v2 call when privacy optin====================");
	System.out.println("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
	logStep("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
	Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", true);

}

@Test(priority = 52, enabled = true)
@Description("Verify Criteo SDK config app call when privacy optin")
public void Verify_Criteo_SDK_config_app_Call_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println(
			"=========================== Criteo SDK config/app call when privacy optin====================");
	System.out.println("****** Criteo SDK config/app call when privacy optin validation Started");
	logStep("****** Criteo SDK config/app call when privacy optin validation Started");
	Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", true);

}

@Test(priority = 75, enabled = true)
@Description("Deriving Video Call when privacy optin")
public void derive_VideoCall_IU_when_Privacy_optin_for_USA() throws Exception {

	System.out.println("==============================================");
	System.out.println("****** Deriving VideoCall For USA when privacy optin");
	logStep("****** Deriving VideoCall For USA when privacy optin");
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

@Test(priority = 76, enabled = true)
@Description("Verify Preroll ad on Video Call sod value when privacy optin")
public void verify_PrerollAd_call_sod_val_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");

	System.out.println("****** Prerol-video Call sod value when privacy optin");
	logStep("Verify Prerol-video Call sod value when privacy optin");
	Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "yes");

}

@Test(priority = 77, enabled = true)
@Description("Validating PrerollVideo Call rdp value when privacy optin")
public void validate_PrerollVideo_call_rdp_val_privacy_optin_for_USA() throws Exception {
	System.out.println("==============================================");
	System.out.println("****** Validating PrerollVideo Call rdp value when privacy optin");
	logStep("Validating PrerollVideo Call rdp value when privacy optin ");

	Utils.validate_rdp_val_in_gampad_url("Smoke", "PrerollVideo", false);

}


		

}
