<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>2-1-checkSubscriberStatus</name>
   <tag></tag>
   <elementGuidId>792cb146-1d69-4161-aecf-476dc033df92</elementGuidId>
   <selectorMethod>XPATH</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;attributes\&quot;: [\n        \&quot;SUBSCRIBER_NUMBER\&quot;,\n    \&quot;SUBSCRIBER_STATUS\&quot;,\n        \&quot;PRICEPLAN\&quot;,\n        \&quot;BALANCE\&quot;,\n        \&quot;IR_INDICATOR\&quot;,\n        \&quot;IR_DATE\&quot;,\n        \&quot;PAYMENT_CATEGORY\&quot;,\n        \&quot;HOME_POC\&quot;,\n        \&quot;BALANCE_GRACE_END_DATE\&quot;,\n        \&quot;FIRST_EVENT_INDICATOR\&quot;,\n        \&quot;FIRST_EVENT_NOTIF\&quot;,\n    \&quot;FIRST_EVENT_DATE\&quot;\n    ],\n    \&quot;msisdn\&quot;: \&quot;6287766961235\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>c74f76d5-7440-4eb1-860a-d184c9d38932</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>accept</name>
      <type>Main</type>
      <value>*/*</value>
      <webElementGuid>415ee258-6c68-4f50-8a47-434bd4ee295e</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>ax-request-id</name>
      <type>Main</type>
      <value>123</value>
      <webElementGuid>da86d891-b356-4490-8996-64e3d3ee74aa</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>channel</name>
      <type>Main</type>
      <value>axisnet</value>
      <webElementGuid>8819b20a-fb39-47dc-b498-37d354afe58b</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.3.2</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://subscriber-info-sit4.api.devgcp.excelcom.co.id/info/v1/atomic</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
