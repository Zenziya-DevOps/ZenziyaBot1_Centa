package Repositories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Repo_WebRepository {
	WebDriver driver = null;
	WebDriverWait waitFor;

	public void setDriver(WebDriver d) {
		driver = d;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	}
	
	// --> IFRAMES --<
	public WebElement get_leftIframe() {
		return driver.findElement(By.xpath("//iframe[@id='leftFrame']"));
	}
	//
	public WebElement get_MainIframe() {
		return driver.findElement(By.xpath("//iframe[@id='mainFrame']"));
	}
	//
	public WebElement get_topIframe() {
		return driver.findElement(By.xpath("//iframe[@name='topFrame']"));
	}
	
	// --> LOGIN <--
	public String[] get_def_txtDocumento() {
		return new String[] {"name","//input[@name='ctl00$MainHolder$txtDocumentNumber']"};
	}
	public WebElement get_txtDocumento(){		
		return driver.findElement(By.xpath("//input[@name='ctl00$MainHolder$txtDocumentNumber']"));
	}
	//
	public String[] get_def_txtUsername() {
		return new String[] {"name","//input[@name='ctl00$MainHolder$TextBoxUserName']"};
	}
	public WebElement get_txtUsername() {
		return driver.findElement(By.xpath("//input[@name='ctl00$MainHolder$TextBoxUserName']"));
	}
	//
	public String[] get_def_btnContinuar() {
		return new String[] {"text","//a[text()='Continuar']"};
	}
	public WebElement get_btnContinuar() {
		return driver.findElement(By.xpath("//a[text()='Continuar']"));
	}
	//
	public String[] get_def_txtPassword() {
		return new String[] {"name","//input[@name='ctl00$MainHolder$Password']"};
	}
	public WebElement get_txtPassword() {
		return driver.findElement(By.xpath("//input[@name='ctl00$MainHolder$Password']"));
	}
	
	// --> MENU LATERAL <--
	public String[] get_def_lnkTransferencias() {
		return new String[] {"id","//a[text()='Transferencias']"};
	}
	public WebElement get_lnkTransferencias(){		
		return driver.findElement(By.xpath("//a[text()='Transferencias']"));
	}
	//
	public String[] get_def_lnkTerceros() {
		return new String[] {"text","//a[text()='Terceros']"};
	}
	public WebElement get_lnkTerceros(){		
		return driver.findElement(By.xpath("//a[text()='Terceros']"));
	}

	// --> PAGINA TRANSFERENCIA <--
	public String[] get_def_cboCtaOrigen() {
		return new String[] {"id","//li[@class='etiqueta ' and contains(.,'Cuenta origen:')]/..//a[@class='dkddl_toggle dkddl_label']"};
	}
	public WebElement get_cboCtaOrigen(){		
		return driver.findElement(By.xpath("//div[@id='dkddl_container_ctl00_MainHolder_TransfersControl_FromAccount_ddlProducts']"));
	}
	//
	public String[] get_def_itemCboCtaOrigen() {
		return new String[] {"text","//a[contains(.,'9603059624')]"};
	}
	public WebElement get_itemCboCtaOrigen(){		
		return driver.findElement(By.xpath("//a[contains(.,'9603059624')]"));
	}
	//
	public String[] get_def_cboCtaDestino() {
		return new String[] {"text","//li[@class='etiqueta' and contains(.,'Número de cuenta')]/..//a[@class='dkddl_toggle dkddl_label']"};
	}
	public WebElement get_cboCtaDestino(){		
		return driver.findElement(By.xpath("//div[@id='dkddl_container_ctl00_MainHolder_TransfersControl_ddlProductTypeBeneficiary']"));
	}
	//
	public String[] get_def_itemCboCtaDestino(String tipoCta) {
		return new String[] {"text","//a[text()='" + tipoCta + "']"};
	}
	public WebElement get_itemCboCtaDestino(String tipoCta){		
		return driver.findElement(By.xpath("//a[text()='" + tipoCta + "']"));
	}
	//
	public String[] get_def_txtDOP() {
		return new String[] {"name","//input[@name='ctl00$MainHolder$TransfersControl$txtProductIdBeneficiary']"};
	}
	public WebElement get_txtDOP(){		
		return driver.findElement(By.xpath("//input[@name='ctl00$MainHolder$TransfersControl$txtProductIdBeneficiary']"));
	}
	//
	public String[] get_def_txtMonto() {
		return new String[] {"name","//input[@name='ctl00$MainHolder$TransfersControl$txtAmount']"};
	}
	public WebElement get_txtMonto(){		
		return driver.findElement(By.xpath("//input[@name='ctl00$MainHolder$TransfersControl$txtAmount']"));
	}
	//
	public String[] get_def_btnSiguiente() {
		return new String[] {"id","//a[@id='ctl00_MainHolder_lnkStep1']"};
	}
	public WebElement get_btnSiguiente(){		
		return driver.findElement(By.xpath("//a[@id='ctl00_MainHolder_lnkStep1']"));
	}
	
	// MENSAJES DE ERROR 1
	public String[] get_def_lblError() {
		return new String[] {"class","//span[@id='ctl00_MainHolder_TransfersControl_cvTxtProductNumber']"};

	}
	public WebElement get_lblError(){
		return driver.findElement(By.xpath("//span[@id='ctl00_MainHolder_TransfersControl_cvTxtProductNumber']"));
	}

	// MENSAJES DE ERROR 2
	public String[] get_def_lblError2() {
		return new String[] {"class","//span[@id='ctl00_MainHolder_TransfersControl_RegularExprProductBeneficiary']"};
	}
	public WebElement get_lblError2(){
		return driver.findElement(By.xpath("//span[@id='ctl00_MainHolder_TransfersControl_RegularExprProductBeneficiary']"));
		}
	
	// INPUT DONDE SE ENCUENTRA EL NOMBRE DE VERIFICACION
	public String[] get_def_inputVerifNombre() {
		return new String[] {"id","//li[@class='campo campoLHP']"};
	}
	public WebElement get_inputVerifNombre(){		
		return driver.findElement(By.xpath("//li[@class='campo campoLHP']"));
	}
	
	// Hasta acá
	public String[] get_def_btnSalir() {
		return new String[] {"text","//a[contains(.,'Salir')]"};
	}
	public WebElement get_btnSalir(){		
		return driver.findElement(By.xpath("//a[contains(.,'Salir')]"));
	}
	
	// Hasta acá | ///a[contains(.,'Salir')]
	public String[] get_def_txtLastName() {
		return new String[] {"id","//input[@id='LastName']"};
	}
	public WebElement get_obj_txtLastName(){		
		return driver.findElement(By.xpath("//input[@id='LastName']"));
	}
	//
	public String[] get_def_btnAdd() {
		return new String[] {"id","//input[@id='Add']"};
	}
	public WebElement get_obj_btnAdd(){		
		return driver.findElement(By.xpath("//input[@id='Add']"));
	}

}