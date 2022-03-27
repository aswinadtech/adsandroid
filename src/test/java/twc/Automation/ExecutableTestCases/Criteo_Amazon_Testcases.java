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

public class Criteo_Amazon_Testcases  extends  TwcAndroidBaseTest {
	
public static String CurrentWifiName=null;
	
	private static final String CONFIG_FILE_PATH = "charles_common.config";

	private static final String BN_SEVERE1_CONFIG_FILE_PATH = "BNSevere1charles_common.config";
	private static final String BN_SEVERE2_CONFIG_FILE_PATH = "BNSevere2charles_common.config";
	private static final String CRITEO_CONFIG_FILE_PATH = "Criteocharles_common.config";
	private static final String CRITEO_NONUS_CONFIG_FILE_PATH = "CriteoNonUScharles_common.config";
	// public static CharlesProxy proxy;
	public File configFile;
	private CharlesProxy proxy;


	@BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {	
	this.configFile = this.charlesGeneralConfigFile(CONFIG_FILE_PATH);
	proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);
	proxy.startCharlesProxyWithUI();
	proxy.disableRewriting();
    proxy.stopRecording();
	proxy.disableMapLocal();
	proxy.startRecording();
	proxy.clearCharlesSession();
	AppiumFunctions.LaunchAppWithFullReset();
	Thread.sleep(90000);
	AppFunctions.gettingApkVersion() ;
	AppiumFunctions.SwipeUp_Counter_feedcards(35);
	this.proxy.getXml();
	CharlesFunctions.createXMLFileForCharlesSessionFile();
	
}
	
	
	/*
	 * This method validates Amazon SDK version
	 */
	@Test(priority = 0, enabled = true)
	@Description("Validating 'adsdk' parameter of Amazon aax call ")
	public void Validate_Amazon_SDK_adsdk_parameter() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating Amazon SDK version i.e. 'adsdk' parameter of Amazon aax call");
		logStep("****** Validating Amazon SDK version i.e. 'adsdk' parameter of Amazon aax call");
		Utils.validate_Amazon_aax_call_parameter("Amazon", "adsdk","aps-android-9.1.0");

	}
	
	 @Test(priority = 2, enabled = true)
		@Description("Verifying amazon slot Id for alerts center Page")
		public void Verifying_amazon_slotId_for_AlertsCenter() throws Exception {
			System.out.println("==============================================");
			System.out.println("===========================Aleret Center page Adcal iu====================");
			System.out.println("****** Alert Center ad test case Started");
			logStep("****** Alert Center ad test case Started");
			Utils.verifyAAX_SlotId("Smoke", "MyAlerts");
		}
	
	 @Test(priority = 4, enabled = true)
		@Description("Verifying amazon Slot Id for feed1 prerol ad call")
		public void Verify_amazon_aaxSlot_feed1_adCall() throws Exception {
			System.out.println(
					"================= Verify amazon aax slot  Id for feed1 adcall  testcase Started =========================");
			System.out.println("****** amazon aax feed1 preload ad call validation Started");
			logStep("****** amazon aax feed1 preload ad call validation Started");
			Utils.verifyAAX_SlotId("Smoke", "Feed1");
			System.out.println(
					"================= Verify amazon aax slot Id for feed1  adcall testcase End =========================");
		}
	 
	 @Test(priority = 5, enabled = true)
		@Description("Verifying amazon Slot Id for homescreen sticky  ad call")
		public void Verify_amazon_aaxSlot_homescreen_sticky_adCall() throws Exception {
			System.out.println(
					"================= Verify amazon aax slot  Id for sticky adcall  testcase Started =========================");
			System.out.println("****** amazon aax feed1 preload ad call validation Started");
			logStep("****** amazon aax feed1 preload ad call validation Started");
			Utils.verifyAAX_SlotId("Smoke", "adhv");
			System.out.println(
					"================= Verify amazon aax slot Id for sticky  adcall testcase End =========================");

		}
	 
	 @Test(priority = 6, enabled = true)
		@Description("Verifying amazon  Slot Id for feed2 ad call")
		public void Verify_amazon_aaxSlot_feed2_adcall() throws Exception {
			System.out.println(
					"================= Verify amazon aax slot  Id for feed2 adcall testcase Started =========================");
			logStep(" Verifying amazon aax slot Id for feed2");
			Utils.verifyAAX_SlotId("Smoke", "Feed2");
			System.out.println(
					"================= Verify amazon aax slot Id for feed2l adcall testcase End =========================");
		}


		@Test(priority = 8, enabled = true)
		@Description("Verifying amazon  Slot Id for feed3 ad call")
		public void Smoke_Test_amazon_aaxSlot_feed3_adcall() throws Exception {
			System.out.println(
					"================= Verify amazon aax slot  Id for feed3 adcall testcase Started =========================");
			logStep(" Verifying amazon aax slot Id for feed3");
			Utils.verifyAAX_SlotId("Smoke", "Feed3");
			System.out.println(
					"================= Verify amazon aax slot Id for feed3  adcall testcase End =========================");
		}

		
		 @Test(priority = 10, enabled = true)
			@Description("Verifying amazon  Slot Id for feed4 ad call")
			public void Verify_amazon_aaxSlot_feed4_adcall() throws Exception {
				System.out.println(
						"================= Verify amazon aax slot  Id for feed4 adcall testcase Started =========================");
				logStep(" Verifying amazon aax slot Id for feed4");
				Utils.verifyAAX_SlotId("Smoke", "Feed4");
				System.out.println(
						"================= Verify amazon aax slot Id for feed4 adcall testcase End =========================");
			}
		 
		 @Test(priority = 12, enabled = true)
			@Description("Verifying amazon  Slot Id for feed4 ad call")
			public void Verify_amazon_aaxSlot_feed5_adcall() throws Exception {
				System.out.println(
						"================= Verify amazon aax slot  Id for feed5 adcall testcase Started =========================");
				logStep(" Verifying amazon aax slot Id for feed4");
				Utils.verifyAAX_SlotId("Smoke", "Feed5");
				System.out.println(
						"================= Verify amazon aax slot Id for feed5 adcall testcase End =========================");
			}
	 
		 
			
			
			
			 @Test(priority = 14, enabled = true)
				@Description("Verifying amazon Slot Id for maps details preroll ad cal")
				public void Verify_amazon_aax_mapsdetails_adcall() throws Exception {
					System.out.println("================= Verify amazon aax maps detais adcall Started =========================");
					logStep(" Verifying preload amazon aax for  map details");
					Utils.verifyAAX_SlotId("Smoke", "Map");
					System.out.println("================= Verify amazon aax maps card preroll adcall End =========================");
				}
	 
			 
			 @Test(priority =16, enabled = true)
				@Description("Verifying amazon aax for today details card")
				public void Smoke_Test_amazon_aax_today_deatailcard() throws Exception {
					System.out.println(
							"================= Verify amazon aax for today detail adcard Started =========================");
					Utils.verifyAAX_SlotId("Smoke", "Today");
					System.out.println("================= Verify amazon aax for today detail adcard End=========================");
				}
			 
			 
			 @Test(priority = 18, enabled = true)
				@Description("Verifying amazon aax for AQ details page")
				public void Smoke_Test_amazon_aax_Airquality_deatailcard() throws Exception {
					System.out.println(
							"================= Verify amazon aax for Air Quality details page Started =========================");
					Utils.verifyAAX_SlotId("Smoke", "Air Quality(Content)");
					System.out.println("================= Verify amazon aax for Air Quality detail Page  End=========================");
				}
			 
			 @Test(priority = 20, enabled = true)
				@Description("Verifying amazon slot Id for Running Bigbanner ad")
				public void Smoke_Test_Verify_amazon_SlotId_Running_Bigbanner_ad() throws Exception {
					System.out.println(
							"================= verifying amazon SlotId for Running BigBanner adcall started =========================");
				Utils.verifyAAX_SlotId("Smoke", "Health(goRun)");
					System.out.println(
							"================= verifying amazon SlotId for Running BigBanner adcall  End =========================");
				}
			 
			 @Test(priority = 22, enabled = true)
				@Description("Verifying amazon slot Id  for Boat&Beach Bigbanner ad")
				public void Verify_amazon_SlotId_Boat_Beach_Bigbanner_ad() throws Exception {
					System.out.println(
							"================= verifying amazon aax SlotId for Boat&Beach BigBanner adcall started =========================");
					Utils.verifyAAX_SlotId("Smoke", "Health(boatAndBeach)");
					System.out.println(
							"================= verifying amazon SlotId for Boat&Beach BigBanner adcall End =========================");
				}
			 
			 @Test(priority = 24, enabled = true)
				@Description("Verifying amazon slot Id for Outdoor details page")
				public void Verify_amazon_SlotId_outdoor_details() throws Exception {
					System.out.println(
							"================= verifying amazon SlotId for oudoor details adcall started =========================");
					Utils.verifyAAX_SlotId("Smoke", "SeasonalHub(Details)");
					System.out.println(
							"================= verifying amazon SlotId for outdoor details adcall  End =========================");
				}
	 
			
			 

			 
			 
		
			 
			 
	
	
	@Test(priority = 26, enabled = true)
	@Description("Verify amazon aax Hourly Details preload ad call")
	public void Verify_amazon_aax_preload_Hourly_details_adcall() throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly Details preload ad call validation Started");
		logStep("****** amazon aax Hourly Details preload ad call validation Started");
	Utils.verifyAAX_SlotId("Smoke", "Hourly");
	}
	
	@Test(priority = 28, enabled = true)
	@Description("Verify amazon aax Hourly1 Details preload ad call")
	public void Verify_amazon_aax_preload_Hourly1_details_adcall() throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly1 Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly1 Details preload ad call validation Started");
		logStep("****** amazon aax Hourly1 Details preload ad call validation Started");
	Utils.verifyAAX_SlotId("Smoke", "Hourly1");
	}
	
	@Test(priority = 30, enabled = true)
	@Description("Verify amazon aax Hourly2 Details preload ad call")
	public void Verify_amazon_aax_preload_Hourly2_details_adcall() throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly2 Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly2 Details preload ad call validation Started");
		logStep("****** amazon aax Hourly2 Details preload ad call validation Started");
	Utils.verifyAAX_SlotId("Smoke", "Hourly2");
	}
	
	@Test(priority = 32, enabled = true)
	@Description("Verify amazon aax Hourly3 Details preload ad call")
	public void Verify_amazon_aax_preload_Hourly3_details_adcall() throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly3 Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly3 Details preload ad call validation Started");
		logStep("****** amazon aax Hourly3 Details preload ad call validation Started");
	Utils.verifyAAX_SlotId("Smoke", "Hourly3");
	}
		

	 @Test(priority = 50, enabled = true)
	@Description("Verify AlertCenter ad call amazon bid id")
	public void Verify_AlertCenter_ad_call_amazon_bid_id() throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== AlertCenter ad call amazon bid id ====================");

		System.out.println("****** AlertCenter ad call amazon bid id validation Started");
		logStep("****** AlertCenter ad call amazon bid id validation Started");
		Utils.validate_aax_bid_value_with_gampad_bid_value("MyAlerts", true);

	}
	
	
	 @Test(priority = 52, enabled = true)
		@Description("Verifying amazon Slot Id for daily details day1 ad calll")
		public void Smoke_Test_amazon_aax_Daily_details_Day1_adcall() throws Exception {
			System.out
					.println("================= Verifying amazon slot id for  daily details day1 adcall test case Started =========================");
			Utils.verifyAAX_SlotId("Smoke", "Daily(10day)");
			System.out.println("================= Verifying amazon slot id for  daily details day 1 adcall test case End =========================");
		}
	 
	     @Test(priority = 54, enabled = true)
		@Description("Verify Feed1 ad call amazon bid id")
		public void Verify_Feed1_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Feed1 ad call amazon bid id ====================");
			System.out.println("****** Feed1 ad call amazon bid id validation Started");
			logStep("****** Feed1 ad call amazon bid id validation Started");
		  Utils.validate_aax_bid_value_with_gampad_bid_value("Feed1", true);		
		}
	     @Test(priority = 53, enabled = true)
			@Description("Verify home screen sticky ad call amazon bid id")
			public void Verify_homescreen_sticky_ad_call_amazon_bid_id() throws Exception {
				System.out.println("==============================================");
				System.out.println("=========================== Feed1 ad call amazon bid id ====================");
				System.out.println("****** Feed1 ad call amazon bid id validation Started");
				logStep("****** Feed1 ad call amazon bid id validation Started");
			  Utils.validate_aax_bid_value_with_gampad_bid_value("adhv", true);
				
			}
	     @Test(priority = 56, enabled = true)
	 	@Description("Verify Feed2 ad call amazon bid id")
	 	public void Verify_Feed2_ad_call_amazon_bid_id() throws Exception {
	 		System.out.println("==============================================");
	 		System.out.println("=========================== Feed2 ad call amazon bid id ====================");
	 		System.out.println("****** Feed2 ad call amazon bid id validation Started");
	 		logStep("****** Feed2 ad call amazon bid id validation Started");
	 		Utils.validate_aax_bid_value_with_gampad_bid_value("Feed2", true);
	 	}
		
	     @Test(priority = 58, enabled = true)
	 	@Description("Verify Feed3 ad call amazon bid id")
	 	public void Verify_Feed3_ad_call_amazon_bid_id() throws Exception {
	 		System.out.println("==============================================");
	 		System.out.println("=========================== Feed3 ad call amazon bid id ====================");

	 		System.out.println("****** Feed3 ad call amazon bid id validation Started");
	 		logStep("****** Feed3 ad call amazon bid id validation Started");
	 		Utils.validate_aax_bid_value_with_gampad_bid_value( "Feed3", true);
	 	}
	 
	     
	 	@Test(priority = 60, enabled = true)
		@Description("Verify Feed4 ad call amazon bid id")
		public void Verify_Feed4_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Feed4 ad call amazon bid id ====================");
			System.out.println("****** Feed4 ad call amazon bid id validation Started");
			logStep("****** Feed4 ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("Feed4", true);
		}
		
	 	@Test(priority = 62, enabled = true)
		@Description("Verify Feed5 ad call amazon bid id")
		public void Verify_Feed5_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Feed5 ad call amazon bid id ====================");

			System.out.println("****** Feed5 ad call amazon bid id validation Started");
			logStep("****** Feed5 ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("Feed5", true);
		}
	 	
	 	@Test(priority = 64, enabled = true)
		@Description("Verify Map Details ad call amazon bid id")
		public void Verify_Map_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Map Details ad call amazon bid id ====================");

			System.out.println("****** Map Details ad call amazon bid id validation Started");
			logStep("****** Map Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("Map", true);
		}
		
		@Test(priority = 66, enabled = true)
		@Description("Verify Today Details ad call amazon bid id")
		public void Verify_Today_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Today Details ad call amazon bid id ====================");

			System.out.println("****** Today Details ad call amazon bid id validation Started");
			logStep("****** Today Details ad call amazon bid id validation Started");
		Utils.validate_aax_bid_value_with_gampad_bid_value("Today", true);
		}
		@Test(priority = 68, enabled = true)
		@Description("Verify AQ Details ad call amazon bid id")
		public void Verify_AQ_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== AQ Details ad call amazon bid id ====================");

			System.out.println("****** AQ Details ad call amazon bid id validation Started");
			logStep("****** AQ Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("Air Quality(Content)", true);
		}
		
		@Test(priority = 70, enabled = true)
		@Description("Verify Health Boat & Beach Details ad call amazon bid id")
		public void Verify_Health_BoatAndBeach_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Health Boat & Beach Details ad call amazon bid id ====================");

			System.out.println("****** Health Boat & Beach Details ad call amazon bid id validation Started");
			logStep("****** Health Boat & Beach Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("Health(boatAndBeach)", true);
		}
	 
		@Test(priority = 72, enabled = true)
		@Description("Verify Health Running Details ad call amazon bid id")
		public void Verify_Health_Running_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Health Running Details ad call amazon bid id ====================");

			System.out.println("****** Health Running Details ad call amazon bid id validation Started");
			logStep("****** Health Running Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("Health(goRun)", true);
	
		}
		@Test(priority = 74, enabled = true)
		@Description("Verify amazon aax Seasonal Hub Details ad call")
		public void Verify_amazon_aax_SeasonalHub_details_adcall() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== amazon aax Seasonal Hub Details ad call ====================");

			System.out.println("****** amazon aax Seasonal Hub Details ad call validation Started");
			logStep("****** amazon aax Seasonal Hub Details ad call validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value("SeasonalHub(Details)", true);

		}
		@Test(priority = 76, enabled = true)
		@Description("Verify Hourly1 Details ad call amazon bid id")
		public void Verify_Hourly1_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Hourly1 Details ad call amazon bid id ====================");

			System.out.println("****** Hourly1 Details ad call amazon bid id validation Started");
			logStep("****** Hourly1 Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value( "Hourly1", true);
		}
		
		
		@Test(priority =78, enabled = true)
		@Description("Verify Hourly2 Details ad call amazon bid id")
		public void Verify_Hourly2_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Hourly2 Details ad call amazon bid id ====================");

			System.out.println("****** Hourly2 Details ad call amazon bid id validation Started");
			logStep("****** Hourly2 Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value( "Hourly2", true);
		}
		
		@Test(priority = 80, enabled = true)
		@Description("Verify Hourly3 Details ad call amazon bid id")
		public void Verify_Hourly3_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Hourly3 Details ad call amazon bid id ====================");

			System.out.println("****** Hourly1 Details ad call amazon bid id validation Started");
			logStep("****** Hourly3 Details ad call amazon bid id validation Started");
			Utils.validate_aax_bid_value_with_gampad_bid_value( "Hourly3", true);
		}
		
		
		@Test(priority = 82, enabled = true)
		@Description("Verify Daily Details ad call amazon bid id")
		public void Verify_Daily_Details_ad_call_amazon_bid_id() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Daily Details ad call amazon bid id ====================");

			System.out.println("****** Daily Details ad call amazon bid id validation Started");
			logStep("****** Daily Details ad call amazon bid id validation Started");
	     Utils.validate_aax_bid_value_with_gampad_bid_value("Daily(10day)", true);
		}
		
		
		
		
		
		
		@Test(priority = 162, enabled = true)
		@Description("Verify Criteo SDK config app call")
		public void Verify_Criteo_SDK_config_app_Call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK config/app call ====================");

			System.out.println("****** Criteo SDK config/app call validation Started");
			logStep("****** Criteo SDK config/app call validation Started");

		Utils.verifyCriteo_config_app_Call("Criteo");

		}
				
			
		@Test(priority = 164, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
			System.out.println("****** Criteo SDK inapp/v2 call validation Started");
			logStep("****** Criteo SDK inapp/v2 call validation Started");
		Utils.verifyCriteo_inapp_v2_Call("Criteo");
		}
		
		@Test(priority = 166, enabled = true)
		@Description("Validating 'cpId' parameter of Criteo SDK config app call")
		public void Validate_Criteo_SDK_config_app_Call_cpId_parameter() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating 'cpId' parameter of Criteo SDK config app call");
			logStep("****** Validating 'cpId' parameter of Criteo SDK config app call");
			Utils.validate_Criteo_SDK_config_app_call_parameter("Criteo", "cpId", "B-051673");

		}
		@Test(priority = 168, enabled = true)
		@Description("Validating 'bundleId' parameter of Criteo SDK config app call ")
		public void Validate_Criteo_SDK_config_app_Call_bundleId_parameter() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating 'bundleId' parameter of Criteo SDK config app call");
			logStep("****** Validating 'bundleId' parameter of Criteo SDK config app call");
			Utils.validate_Criteo_SDK_config_app_call_parameter("Criteo", "bundleId", "com.weather.Weather");

		}
		
		@Test(priority = 170, enabled = true)
		@Description("Validating 'sdkVersion' parameter of Criteo SDK config app call ")
		public void Validate_Criteo_SDK_config_app_Call_sdkVersion_parameter() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Validating 'sdkVersion' parameter of Criteo SDK config app call");
			logStep("****** Validating 'sdkVersion' parameter of Criteo SDK config app call");
			Utils.validate_Criteo_SDK_config_app_call_parameter("Criteo", "sdkVersion", "4.6.0");

		}
	
		@Test(priority = 172, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Feed1 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_Feed1_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with  Feed1 call====================");
			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with  Feed1 validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Feed1 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed1", "cpm", true);
		}

		@Test(priority = 174, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Feed1 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_Feed1_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Feed1 call====================");
			System.out.println("****** Criteo SDK invapp v2 call size parameter with Feed1 call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Feed1 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed1", "size", true);
		}

		@Test(priority = 176, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with home screen sticky call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_homescreen_sticky_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Feed1 call====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter with Feed1 call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Feed1 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed1", "displayUrl",true);
		}
		
		
		@Test(priority = 172, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with home screen sticky call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_homescreen_sticky_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with  adhv call====================");
			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with  adhv validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with adhv call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("adhv", "cpm", true);
		}

		@Test(priority = 174, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with home screen sticky call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_homescreen_sticky_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with adhv call====================");
			System.out.println("****** Criteo SDK invapp v2 call size parameter with adhv call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with adhv call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("adhv", "size", true);
		}

		@Test(priority = 176, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Feed1 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_Feed1_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Feed1 call====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter with Feed1 call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Feed1 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed1", "displayUrl",true);
		}
		
		@Test(priority = 178, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Feed2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_Feed2_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with  Feed2 call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with  Feed2 validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Feed2 call validation Started");

			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed2", "cpm", true);
		}

		@Test(priority = 180, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Feed2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_Feed2_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Feed2 call====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter with Feed2 call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Feed2 call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed2", "size", true);
		}

		@Test(priority = 182, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Feed2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_Feed2_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Feed2 call====================");

			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter with Feed2 call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Feed2 call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed2", "displayUrl",true);
		}
	
		@Test(priority = 184, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Feed3 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_Feed3_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with  Feed3 call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with  Feed3 validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Feed3 call validation Started");

			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed3", "cpm", true);
		}

		@Test(priority = 186, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Feed3 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_Feed3_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Feed3 call====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter with Feed3 call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Feed3 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed3", "size", true);
		}

		@Test(priority = 188, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Feed3 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_Feed3_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Feed3 call====================");

			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter with Feed3 call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Feed3 call validation Started");
			
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed3", "displayUrl",true);
		}

		@Test(priority = 190, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Feed4 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_Feed4_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with  Feed4 call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with  Feed4 validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Feed4 call validation Started");

			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Feed4", "cpm", true);
		}

		@Test(priority = 192, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Feed4 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_Feed4_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Feed4 call====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter with Feed4 call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Feed4 call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed4", "size", true);
		}

		@Test(priority = 194, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Feed4 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_Feed4_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Feed4 call====================");

			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter with Feed4 call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Feed4 call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed4", "displayUrl",true);
		}
		

		@Test(priority = 196, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Feed5 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_Feed5_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with  Feed5 call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with  Feed5 validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Feed5 call validation Started");

			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Feed5", "cpm", true);
		}

		@Test(priority = 198, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Feed5 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_Feed5_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Feed5 call====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter with Feed5 call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Feed5 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Feed5", "size", true);
		}

		@Test(priority = 200, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Feed5 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_Feed5_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Feed5 call====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter with Feed5 call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Feed5 call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Feed5", "displayUrl",true);
		}
		
		@Test(priority = 202, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Map Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_map_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call cpm parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of Map Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of Map Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Map", "cpm", true);
		}


		@Test(priority = 204, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Map Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_map_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call size parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call size parameter of Map Details validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter of Map Details validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Map", "size", true);
		}


		@Test(priority = 206, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Map Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_map_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter of Map Details validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter of Map Details validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Map", "displayUrl", true);
		}

		@Test(priority = 208, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Today Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_today_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with Today details call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with Today Details call validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Today Details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Today", "cpm", true);
		}

		@Test(priority = 210, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Today Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_today_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Today details call====================");
			System.out
					.println("****** Criteo SDK invapp v2 call size parameter with Today details call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Today details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Today", "size", true);
		}

		@Test(priority = 212, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Today Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_today_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Today details call====================");
			System.out.println(
					"****** Criteo SDK invapp v2 call displayUrl parameter with Today details call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Today details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Today", "displayUrl",true);
		}
		
		@Test(priority = 214, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with AQ Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_aq_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with aq details call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with aq details call validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with aq details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Air Quality(Content)","cpm", true);
		}

		@Test(priority = 216, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with AQ Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_aq_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with aq details call====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter with aq details call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with aq details call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Air Quality(Content)", "size", true);
		}

		@Test(priority = 218, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with AQ Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_aq_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with aq details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call displayUrl parameter with aq details call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with aq details call validation Started");
				
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Air Quality(Content)","displayUrl", true);
		}

		@Test(priority = 220, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with boatAndBeach Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_boatAndBeach_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with boatAndBeach Details call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of boatAndBeach Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of boatAndBeach Details validation Started");

			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Health(boatAndBeach)","cpm", true);
		}

		@Test(priority = 222, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with boatAndBeach Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_boatAndBeach_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with boatAndBeach Details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call size parameter with boatAndBeach Details call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with boatAndBeach Details call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Health(boatAndBeach)","size", true);
		}

		@Test(priority = 224, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with boatAndBeach Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_boatAndBeach_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with boatAndBeach Details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call displayUrl parameter with boatAndBeach Details call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with boatAndBeach Details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Health(boatAndBeach)","displayUrl", true);
		}



		@Test(priority = 226, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Running Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_Running_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with Running Details call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of Running Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of Running Details validation Started");

			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Health(goRun)", "cpm",true);
		}

		@Test(priority = 228, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Running Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_Running_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Running Details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call size parameter with Running Details call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Running Details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Health(goRun)", "size",true);
		}

		@Test(priority = 230, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Running Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_Running_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Running Details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call displayUrl parameter with Running Details call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Running Details call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Health(goRun)","displayUrl", true);

		}
		
		@Test(priority = 232, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Seasonal Hub Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_SeasonalHub_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with Seasonal Hub details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call cpm parameter with Seasonal Hub details call validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Seasonal Hub details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("SeasonalHub(Details)", "cpm", true);
		}

		@Test(priority = 234, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Seasonal Hub Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_SeasonalHub_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Seasonal Hub details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call size parameter with Seasonal Hub details call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Seasonal Hub details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("SeasonalHub(Details)","size", true);
		}

		@Test(priority = 236, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Seasonal Hub Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_SeasonalHub_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Seasonal Hub details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call displayUrl parameter with Seasonal Hub details call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Seasonal Hub details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("SeasonalHub(Details)","displayUrl", true);
		}

		@Test(priority = 238, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Daily Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_daily_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call cpm parameter with Daily details call====================");

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter with Daily Details call validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter with Today Details call validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value( "Daily(10day)", "cpm",true);
		}

		@Test(priority = 240, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with daily Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_daily_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call size parameter with Daily details call====================");

			System.out
					.println("****** Criteo SDK invapp v2 call size parameter with Daily details call validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter with Daily details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Daily(10day)", "size",true);
		}

		@Test(priority = 242, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Daily Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_daily_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK invapp v2 call displayUrl parameter with Daily details call====================");

			System.out.println(
					"****** Criteo SDK invapp v2 call displayUrl parameter with Daily details call validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter with Daily details call validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Daily(10day)","displayUrl", true);
		}
		
		@Test(priority = 246, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Hourly Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_hourly_details_gampad_call() throws Exception {

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of Hourly Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of Hourly Details validation Started");
		    Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly", "cpm", true);
		}

		@Test(priority = 248, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Hourly Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_hourly_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call size parameter ====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter of Hourly Details validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter of Hourly Details validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly", "size", true);
		}
		@Test(priority = 250, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Hourly Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_hourly_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call displayUrl parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly Details validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly", "displayUrl",true);
		}


				@Test(priority = 252, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Hourly1 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_hourly1_details_gampad_call() throws Exception {

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of Hourly1 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of Hourly1 Details validation Started");
		    Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly1", "cpm", true);
		}

		@Test(priority = 254, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Hourly1 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_hourly1_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call size parameter ====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter of Hourly1 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter of Hourly1 Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly1", "size", true);
		}
		@Test(priority = 256, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Hourly1 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_hourly1_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call displayUrl parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly1 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly1 Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly1", "displayUrl",true);
		}

												
												
				@Test(priority = 258, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Hourly2 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_hourly2_details_gampad_call() throws Exception {

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of Hourly2 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of Hourly2 Details validation Started");
		    Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly2", "cpm", true);
		}

		@Test(priority = 260, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Hourly2 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_hourly2_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call size parameter ====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter of Hourly2 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter of Hourly2 Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly2", "size", true);
		}
		@Test(priority = 262, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Hourly2 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_hourly2_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call displayUrl parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly2 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly2 Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly2", "displayUrl",true);
		}
												
												
																						
				@Test(priority = 264, enabled = true)
		@Description("Verify cpm parameter of Criteo SDK inapp v2 call with Hourly3 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_cpm_parameter_with_hourly3_details_gampad_call() throws Exception {

			System.out.println("****** Criteo SDK invapp v2 call cpm parameter of Hourly3 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call cpm parameter of Hourly3 Details validation Started");
		    Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly3", "cpm", true);
		}

		@Test(priority = 266, enabled = true)
		@Description("Verify size parameter of Criteo SDK inapp v2 call with Hourly3 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_size_parameter_with_hourly3_details_gampad_call() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call size parameter ====================");

			System.out.println("****** Criteo SDK invapp v2 call size parameter of Hourly3 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call size parameter of Hourly3 Details validation Started");
		Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly3", "size", true);
		}
		@Test(priority = 268, enabled = true)
		@Description("Verify displayUrl parameter of Criteo SDK inapp v2 call with Hourly3 Details call")
		public void Verify_Criteo_SDK_inapp_v2_Call_displayUrl_parameter_with_hourly3_details_gampad_call()
				throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK invapp v2 call displayUrl parameter ====================");
			System.out.println("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly3 Details validation Started");
			logStep("****** Criteo SDK invapp v2 call displayUrl parameter of Hourly3 Details validation Started");
			Utils.validate_Criteo_SDK_inapp_v2_call_param_value_with_gampad_param_value("Hourly3", "displayUrl",true);
		}
		
		
		 /* This method validates Criteo Bidder API call for not present
		 */
		@Test(priority = 270, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call after close the app")
		public void Verify_Criteo_SDK_inapp_v2_Call_for_GDPR() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
			Ad.closeApp();
			this.proxy.clearCharlesSession();
			Functions.waitForMilliSeconds(20000);
			this.proxy.getXml();
			CharlesFunctions.createXMLFileForCharlesSessionFile();
			System.out.println("****** Criteo SDK inapp/v2 call validation Started");
			logStep("****** Criteo SDK inapp/v2 call validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		/*
		 * This method validates Criteo Initialization API call for not present
		 */
		@Test(priority = 271, enabled = true)
		@Description("Verify Criteo SDK config app call after close the app")
		public void Verify_Criteo_SDK_config_app_Call_for_GDPR() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK config/app call ====================");
			System.out.println("****** Criteo SDK config/app call validation Started");
			logStep("****** Criteo SDK config/app call validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

		}

	/**
	 * This method verifies Amazon call
	 * @throws Exception
	 */
	@Test(priority = 272, enabled = true)
	@Description("Amazon aax call verification after close the app")
	public void Verify_Amazon_Call() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** amazon-adsystem.com Call test case Started");
		logStep("****** amazon-adsystem.com Call test case Started");
		Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
	}

		

}
