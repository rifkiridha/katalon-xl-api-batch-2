package mii

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import groovy.json.JsonSlurper

class JsonParser {

	static parseJson(String jsonString) {
		def jsonSlurper = new JsonSlurper()
		def json = jsonSlurper.parseText(jsonString)
		return json
	}

	static String findNameValue(String jsonData, String nameToFind) {
		def jsonSlurper = new JsonSlurper()
		def json = jsonSlurper.parseText(jsonData)

		def data = json.data.find { it.name == nameToFind }

		if (data) {
			return data.value
		} else {
			return null
		}
	}

//	TC 2-1
	@Keyword
	static void validateSubscriberStatusAndPricePlan(String jsonData, String subscriberStatus, String pricePlan) {
		def jsonSlurper = new JsonSlurper()
		def json = jsonSlurper.parseText(jsonData)

		def subscriber = json.data.find { it.name == "SUBSCRIBER_STATUS" }
		def plan = json.data.find { it.name == "PRICEPLAN" }

		println("SUBSCRIBER STATUS data :"+subscriber)
		println("SUBSCRIBER STATUS value result :"+subscriber.value)
		println("SUBSCRIBER STATUS value expected :"+subscriberStatus)

		if(subscriber.value == subscriberStatus) {
			KeywordUtil.markPassed("Subscriber status result: "+subscriber.value+" match the expected value.")
		}else {
			KeywordUtil.markFailed("Subscriber status result: "+subscriber.value+" didn't match the expected value: "+subscriberStatus)
		}

		println("PRICE PLAN data :"+plan)
		println("PRICE PLAN value result :"+plan.value)
		println("PRICE PLAN value expected :"+pricePlan)

		if(plan.value == pricePlan) {
			KeywordUtil.markPassed("Price plan result: "+plan.value+" match the expected value")
		}else {

			KeywordUtil.markFailed("Price plan result: "+plan.value+" didn't match the expected value: "+pricePlan)
		}

		if((subscriber.value == subscriberStatus)&&(plan.value == pricePlan)) {
			KeywordUtil.markPassed("Subscriber status result: "+subscriber.value+" and Price plan result: "+plan.value+" match the expected value.")
		}else {
			KeywordUtil.markFailed("Subscriber status result: "+subscriber.value+" or Price plan result: "+plan.value+" didn't match the expected value.")
		}
	}
	
//	TC 2-2
	@Keyword
	static void validateForCheckSubcription(String jsonData) {
		def jsonSlurper = new JsonSlurper()
		def jsonObject = jsonSlurper.parseText(jsonData)
		
		def data = jsonObject.data
		
		if (data.size() >= 1) {
			KeywordUtil.markPassed("Offer after downsell event intact and listed ")
		} else {
			println("Offer after downsell event didn't intact or listed ")
		}
	}
//	TC 2-3
//	TC 2-4
//	TC 2-5
//	TC 2-6
//	TC 2-7
//	TC 2-2
}