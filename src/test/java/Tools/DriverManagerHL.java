package Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerHL {
	
	private WebDriver driver;
    
    public WebDriver createDriver(boolean headless){
    	
    	// Set Configuration
    	//String url = "http://demo.nopcommerce.com/";
    	
    	// Set driver location
    	System.setProperty("webdriver.chrome.driver", "./Resources/Driver/chromedriver.exe");
    	
    	// OPTIONS CONFIGURATION
    	ChromeOptions options = new ChromeOptions();
    	
    	options.setHeadless(headless);
    	//options.addArguments("--headless");
    	options.addArguments("start-maximized");
    	options.addArguments("--window-size=1920,1080");
    	
    	// Capabilities are options that you can use to customize and configure a ChromeDriver session.
    	options.setCapability("browserstack,ie,noFlash", "false");
    	options.setCapability("javascriptEnabled", "true");
    	options.setCapability("EnablePersistentHover", "true");
    	options.setCapability("IgnoreZoomLevel", "true");
    	options.setCapability("EnableNativeEvents", "false");
    	options.setCapability("acceptSslCerts", "true");
    	options.setCapability("requireWindowFocus", "true");
    	options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        // Seteamos la configuracion
        WebDriverManager.chromedriver().setup();
		
        // Creamos el driver con su configuracion
        //WebDriver driver = new ChromeDriver(options);
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
//        driver.get(url);
//        
//        System.out.println(driver.getTitle());
//        
//        driver.close();
        
        return driver;
        
    	}
    
    public WebDriver getActualDriver() {
    	return driver;
    }
    
}
  