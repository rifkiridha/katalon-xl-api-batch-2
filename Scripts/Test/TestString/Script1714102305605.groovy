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

def variable = [:];

RequestObject request = findTestObject('Postman/HitXML',variable);
def response = WS.sendRequest(request);

def bodyResponse = response.getResponseBodyContent();

WS.comment(bodyResponse);

print(bodyResponse);

def root = new XmlSlurper().parseText(bodyResponse)

def allQuotas = []

// Loop through each offer
root.offers.offer.each { offer ->
	// Loop through each channel attribute
	offer.channel_attributes.channel_attribute.each { attribute ->
		// Check if the name is "BASE_MAIN_QUOTA"
		if (attribute.name.text() == "BASE_MAIN_QUOTA") {
			// Get the value
			def value = attribute.value.text()
			
			// Process the value here
			println("BASE_MAIN_QUOTA value: $value")
			
			def splitValue = value.substring(0, Math.min(value.size(), 5))
			
			println(splitValue)
			
			if(splitValue == "QUOTA") {
				allQuotas.add("$value")
			}
		}
	}
}



println("All quotas: $allQuotas")