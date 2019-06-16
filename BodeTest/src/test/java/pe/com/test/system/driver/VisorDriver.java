package pe.com.test.system.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class VisorDriver {

	public final static WebDriver inicializarWebDriver(String navegador) {
		WebDriver webDriver = null;
		try {
			switch (navegador.toLowerCase()) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\ProgramasInstalados\\geckodriver.exe");
				webDriver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\ProgramasInstalados\\chromedriver.exe");
				webDriver = new ChromeDriver();
				break;
			case "iexplorer":
				System.setProperty("webdriver.ie.driver", "C:\\ProgramasInstalados\\iexplorerdriver.exe");
				webDriver = new InternetExplorerDriver();
				break;
			case "opera":				
			    System.setProperty("webdriver.opera.driver", "C:\\ProgramasInstalados\\operadriver.exe");
			    /*
			    OperaOptions options = new OperaOptions();
			    options.setBinary("C:\\Program Files\\Opera\\60.0.3255.109\\opera.exe");
			    options.addArguments("--allow-elevated-browser");
			    DesiredCapabilities capabilities = new DesiredCapabilities();
			    capabilities.setCapability(OperaOptions.CAPABILITY, options);
			    webDriver = new OperaDriver(capabilities);		*/
			    OperaOptions operaOptions = new OperaOptions();
			    operaOptions.addArguments("--allow-elevated-browser");
			    webDriver = new OperaDriver(operaOptions);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return webDriver;

	}

	public final static void cerrarPagina(WebDriver webDriver) {
		if (webDriver != null) {
			webDriver.quit();
		}

	}
}
