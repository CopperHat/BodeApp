package pe.com.test.system.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.system.driver.VisorDriver;

public class IniciarSesionPage {
	private By cajaUsuario = By.id("txtUsuario");
	private By cajaClave = By.id("txtClave");
	private By botonIniciarSesion = By.id("btnIniciarSesion");
	private WebDriver webDriver = null;
	private final static int MAXIMO_TIEMPO = 3000;
	
	public IniciarSesionPage(String navegador) {
		this.webDriver = VisorDriver.inicializarWebDriver(navegador);		
	}
	
	public void ingresarPagina(String urlInicial) throws Exception{
		webDriver.get(urlInicial);
		Thread.sleep(MAXIMO_TIEMPO);
		
	}
	
	public void iniciarSesion(String usuario, String clave) throws Exception{
		webDriver.findElement(cajaUsuario).clear();
		webDriver.findElement(cajaUsuario).sendKeys(usuario);
		webDriver.findElement(cajaClave).clear();
		webDriver.findElement(cajaClave).sendKeys(clave);
		webDriver.findElement(botonIniciarSesion).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public WebDriver obtenerPagina() {
		return webDriver;
	}
	
	public void cerrarPagina() {
		VisorDriver.cerrarPagina(webDriver);
	}


}
