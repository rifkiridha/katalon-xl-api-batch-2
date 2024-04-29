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

//def root = new XmlSlurper().parseText(bodyResponse)

//def value = root.offers.offer[0].channel_attributes.channel_attribute[6].value.text()
//
//WS.comment(value);
////
//println "Value: $value"
//
//String[] pairs = value.split(";");
//
//String quotaValue = null;
//for (String pair : pairs) {
//	if (pair.startsWith("QUOTA")) {
//		quotaValue = pair.split("\\|")[1];
//		break;
//	}
//}
//
//if (quotaValue != null) {
//	if (quotaValue.endsWith("-MB")) {
//                double mbValue = Double.parseDouble(quotaValue.replaceAll("[^\\d.]", ""));
//                double gbValue = mbValue / 1024.0; // Convert MB to GB
//                System.out.println("Quota Value: " + gbValue + "-GB");
//				WS.comment("Quota Value: " + gbValue + "-GB");
//            } else {
//                System.out.println("Quota Value: " + quotaValue);
//				WS.comment("Quota Value: " + quotaValue)
//            }
//} else {
//	System.out.println("Quota information not found in the input string.");
//}

// Loop through each offer
//root.offers.offer.each { offer ->
//	// Loop through each channel attribute
//	offer.channel_attributes.channel_attribute.each { attribute ->
//		// Check if the name is "BASE_MAIN_QUOTA"
//		if (attribute.name.text() == "BASE_MAIN_QUOTA") {
//			// Get the value
//			def value = attribute.value.text()
//			
//			// Process the value here
//			println("BASE_MAIN_QUOTA value: $value")
//		}
//	}
//}

def root = new XmlSlurper().parseText(bodyResponse)

// Define a function to convert MB to GB
def mbToGb(valueInMB) {
    return valueInMB.split('-')[0].toInteger() / 1024
}

// List to store all quotas
def allQuotas = []

// Loop through each offer
root.offers.offer.each { offer ->
    // Loop through each channel attribute
    offer.channel_attributes.channel_attribute.each { attribute ->
        // Check if the name is "BASE_MAIN_QUOTA"
        if (attribute.name.text() == "BASE_MAIN_QUOTA") {
            // Get the value
            def value = attribute.value.text()
            
            // Extract the MB value
            def mbValue = value.split('-')[0].toInteger()
            
            // Convert MB to GB
            def gbValue = mbToGb(mbValue)
            
            // Add the quota to the list
            allQuotas.add(gbValue)
            
            // Check if the value is 1 GB
            if (gbValue == 1) {
                // Output the data found for 1 GB
                println("Data for 1 GB: $value")
            }
        }
    }
}

// Print all quotas
println("All quotas: $allQuotas")