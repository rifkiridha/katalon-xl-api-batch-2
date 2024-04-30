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

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser as JParser
import com.google.gson.JsonElement

def variable = [:];

VariableCollections.status = status;
VariableCollections.code = code;
VariableCollections.message = message;


RequestObject request = findTestObject('Postman/TC-02/2-1',variable);

def response = WS.sendRequest(request);

def bodyResponse = response.getResponseBodyContent();

//Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//String prettyJsonString = gson.toJson(new JParser().parse(bodyResponse));
//
//println(prettyJsonString);
//
//WS.comment(prettyJsonString);

JsonParser.prettier(bodyResponse);

VariableCollections.subscriberStatus = "A";



VariableCollections.pricePlan = "513268";


println(VariableCollections.subscriberStatus);
JsonParser.validateSubscriberStatusAndPricePlan(bodyResponse, VariableCollections.status, VariableCollections.code, VariableCollections.message, VariableCollections.subscriberStatus, VariableCollections.pricePlan);