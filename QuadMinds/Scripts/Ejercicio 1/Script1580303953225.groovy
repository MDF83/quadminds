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
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://mercadolibre.com.ar/')

WebUI.click(findTestObject('Page_Mercado Libre Argentina/a_Categoras'))

WebUI.click(findTestObject('Page_Mercado Libre Argentina/a_Tecnologa'))

WebUI.click(findTestObject('Page_Mercado Libre Argentina/a_Componentes de PC'))

WebUI.click(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/span_Entendido'))

WebUI.click(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/span_Capital Federal'))

WebUI.click(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/div_Modo_lista'))

WebDriver driver = DriverFactory.getWebDriver()

println("Cantidad de resultados: " + driver.findElements(By.xpath("//*[@id='searchResults']/li")).size())



s_title = WebUI.getText(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/ol_lastResultTitle'))

println("Titulo de la publicaciòn: " + s_title)


s_price = WebUI.getText(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/ol_lastResultPrice'))

println("Precio de la publicaciòn: " + s_price)

WebUI.click(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/ol_lastResult'))

s_title_detalle = WebUI.getText(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/rs_Title'))

s_price_detalle = WebUI.getText(findTestObject('Page_Componentes de PC en Mercado Libre Argentina/rs_Price'))


assert s_title == s_title_detalle

assert s_price == s_price_detalle





