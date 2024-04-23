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
import com.google.gson.Gson
import com.google.gson.GsonBuilder

// Define classes to represent the JSON structure
class Address {
    String street
    String city
    String state
    String postalCode
}

class PhoneNumber {
    String home
    String work
}

class Person {
    String name
    int age
    Address address
    List<String> emails
    PhoneNumber phoneNumbers
}

// JSON string representing the data
def jsonString = '''
{"name": "John Doe", "age": 30, "address": {"street": "123 Main St","city": "Anytown","state": "CA","postalCode": "12345"},
"emails": ["john@example.com","johndoe@gmail.com"],"phoneNumbers": {"home": "555-1234","work": "555-5678"
  }
}
'''

// Create Gson object with pretty printing enabled
def gson = new GsonBuilder().setPrettyPrinting().create()

// Deserialize JSON string into a Person object
def person = gson.fromJson(jsonString, Person.class)

// Convert Person object back to pretty-printed JSON string
def prettyJsonString = gson.toJson(person)

// Print the pretty-printed JSON string
println(prettyJsonString)
