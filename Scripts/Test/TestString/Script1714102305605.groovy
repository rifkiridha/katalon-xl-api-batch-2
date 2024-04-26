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

def value = root.offers.offer[0].channel_attributes.channel_attribute[6].value.text()
//
println "Value: $value"

String[] pairs = value.split(";");

String quotaValue = null;
for (String pair : pairs) {
	if (pair.startsWith("QUOTA")) {
		quotaValue = pair.split("\\|")[1];
		break;
	}
}

if (quotaValue != null) {
	if (quotaValue.endsWith("-MB")) {
                double mbValue = Double.parseDouble(quotaValue.replaceAll("[^\\d.]", ""));
                double gbValue = mbValue / 1024.0; // Convert MB to GB
                System.out.println("Quota Value: " + gbValue + "-GB");
            } else {
                System.out.println("Quota Value: " + quotaValue);
            }
} else {
	System.out.println("Quota information not found in the input string.");
}
