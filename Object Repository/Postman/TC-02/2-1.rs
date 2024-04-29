<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>2-1</name>
   <tag></tag>
   <elementGuidId>26df4b36-9665-4a32-bbdf-0d002ab5f312</elementGuidId>
   <selectorMethod>XPATH</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;attributes\&quot;: [\n        \&quot;SUBSCRIBER_NUMBER\&quot;,\n    \&quot;SUBSCRIBER_STATUS\&quot;,\n        \&quot;PRICEPLAN\&quot;,\n        \&quot;BALANCE\&quot;,\n        \&quot;IR_INDICATOR\&quot;,\n        \&quot;IR_DATE\&quot;,\n        \&quot;PAYMENT_CATEGORY\&quot;,\n        \&quot;HOME_POC\&quot;,\n        \&quot;BALANCE_GRACE_END_DATE\&quot;,\n        \&quot;FIRST_EVENT_INDICATOR\&quot;,\n        \&quot;FIRST_EVENT_NOTIF\&quot;,\n    \&quot;FIRST_EVENT_DATE\&quot;\n    ],\n    \&quot;msisdn\&quot;: \&quot;${msisdn}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>284c27c8-849f-4500-b957-eddb658788e9</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>accept</name>
      <type>Main</type>
      <value>*/*</value>
      <webElementGuid>f392276a-dca8-4d29-82b8-7596bb7bc330</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>ax-request-id</name>
      <type>Main</type>
      <value>123</value>
      <webElementGuid>895220d5-973e-4023-93f9-a4922d23ccaa</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>channel</name>
      <type>Main</type>
      <value>axisnet</value>
      <webElementGuid>4edddf7f-4061-4104-85f0-810c97268023</webElementGuid>
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
   <variables>
      <defaultValue>findTestData('TC-02/2-1').getValue(1, 1)</defaultValue>
      <description></description>
      <id>4e7049a8-db26-4ef7-a312-88dcc2f0448c</id>
      <masked>false</masked>
      <name>msisdn</name>
   </variables>
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
