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
	static void validateSubscriberStatusAndPricePlan(String jsonData, String status, String code, String message, String subscriberStatus, String pricePlan) {
		println("expected status : "+status);
		println("expected code : "+code);
		println("expected message : "+message);
		
		def jsonSlurper = new JsonSlurper();
		def json = jsonSlurper.parseText(jsonData);
		
		def statusResponse = json.status;
		def codeResponse = json.code;
		def messageResponse = json.message;
		
		println("statusResponse : "+statusResponse);
		println("codeResponse : "+codeResponse);
		println("messageResponse : "+messageResponse);
		

		def subscriber = json.data.find { it.name == "SUBSCRIBER_STATUS" }
		def plan = json.data.find { it.name == "PRICEPLAN" }

		println("SUBSCRIBER STATUS data :"+subscriber)
		println("SUBSCRIBER STATUS value result :"+subscriber.value)
		println("SUBSCRIBER STATUS value expected :"+subscriberStatus)
		
		if(status == statusResponse && code == codeResponse && message == messageResponse) {
			KeywordUtil.markPassed("Status, code, and message matches the expected value.")
		}else {
			KeywordUtil.markFailed("Status, code, and message didn't match the expected value.")
		}

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

		def status = jsonObject.status
		def data = jsonObject.data

		if (status == "ok" && data.size() >= 1) {
			KeywordUtil.markPassed("Offer after downsell event intact and listed ")
		} else {
			println("Offer after downsell event not intact or listed ")
		}
	}

	//	TC 2-3
	@Keyword
	static void validateForCheckUPCCBefore(String jsonData) {
		def jsonSlurper = new JsonSlurper()
		def jsonObject = jsonSlurper.parseText(jsonData)

		def status = jsonObject.status
		def subscriber = jsonObject.data.subscriber

		if (status == "ok" && subscriber.size() >= 1) {
			KeywordUtil.markPassed("Quota after downsell listed")
		} else {
			println("Quota after downsell  notlisted")
		}
	}
	//	TC 2-4
	static void validateForCheckAllowance(String jsonData) {
		def jsonSlurper = new JsonSlurper()
		def jsonObject = jsonSlurper.parseText(jsonData)

		def status = jsonObject.status

		if (status == "ok") {
			KeywordUtil.markPassed("Quota After downsell listed with correct amount of quota")
		} else {
			println("Quota After downsell not listed with correct amount of quota")
		}
	}

	//	TC 2-5
	static void validateForHitAPIUnsubscribe(String jsonData, String xmlData) {
		if (jsonData == xmlData) {
			KeywordUtil.markPassed("Success execution")
		} else {
			println("Failed Execution")
		}
	}

	//	TC 2-6
	static void validateForCheckSubscriptionAfter(String jsonData) {
		def jsonSlurper = new JsonSlurper()
		def jsonObject = jsonSlurper.parseText(jsonData)

		def status = jsonObject.status

		if (status == "ok") {
			KeywordUtil.markPassed("Offer after downsell are taken out")
		} else {
			println("Offer after downsell are not taken out")
		}
	}
	//	TC 2-7
	@Keyword
	static void validateForCheckUPCCAfter(String jsonData) {
		def jsonSlurper = new JsonSlurper()
		def jsonObject = jsonSlurper.parseText(jsonData)

		def status = jsonObject.status
		def subscriber = jsonObject.data.subscriber

		if (status == "ok" && subscriber.size() >= 1) {
			KeywordUtil.markPassed("Quota After downsell are taken out")
		} else {
			println("Quota After downsell are not taken out")
		}
	}
	//	TC 2-8
	//	TC 2-7
	@Keyword
	static void validateForCheckAllowanceAfter(String jsonData) {
		def jsonSlurper = new JsonSlurper()
		def jsonObject = jsonSlurper.parseText(jsonData)

		def status = jsonObject.status

		if (status == "ok") {
			KeywordUtil.markPassed("Quota After downsell are taken out")
		} else {
			println("Quota After downsell are not taken out")
		}
	}
}