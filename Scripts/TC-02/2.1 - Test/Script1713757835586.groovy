import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import mii.JsonParser
import mii.VariableCollections

def variable = [:];

//RequestObject request = findTestObject('Postman/TC-02/2-1-checkSubscriberStatus',variable);
//
//def response = WS.sendRequest(request);
//
//def bodyResponse = response.getResponseBodyContent();
//
//def jsonData = JsonParser.parseJson(bodyResponse);
//
//WS.comment(bodyResponse);

VariableCollections.map.put("subscriberStatus", "A");
VariableCollections.map.put("pricePlan", "active prepaid priceplan");

String subscriberStatus = VariableCollections.map.get("subscriberStatus");
String pricePlan = VariableCollections.map.get("pricePlan");

println(subscriberStatus+" and "+pricePlan)

//JsonParser.validateSubscriberStatusAndPricePlan(bodyResponse, subscriberStatus, pricePlan);