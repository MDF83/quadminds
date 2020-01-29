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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


response = WS.sendRequest(findTestObject("Search"))

assert response.statusCode == 200

def slurper = new groovy.json.JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

total = result['paging']['total']
limite = result['paging']['limit']


println ("Resultado total: " + total)
println ("Limite: " + limite)

assert total < limite

Random rand = new Random()
random_num = rand.nextInt(total)

println("Posicion random: " + random_num)

id = result['results'][random_num]['id']

moneda = result['results'][random_num]['currency_id']

mercadopago = result['results'][random_num]["accepts_mercadopago"]

println("Consulto detalle de ID: " + id)

responseItem = WS.sendRequest(findTestObject("Items", [('id') : id]))

assert responseItem.statusCode == 200

def resultItem = slurper.parseText(responseItem.getResponseBodyContent())

assert resultItem['currency_id'] == moneda

assert resultItem['accepts_mercadopago'] == mercadopago

println("Moneda: " + moneda)

println("Acepta mercado pago: " + mercadopago)
