package pe.com.test.system.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.system.driver.VisorDriver;

public class ProductoPage {
	private By botonNuevo = By.id("btnNuevo");
	private By botonEditar = By.id("btnActualizar");
	private By botonBuscar = By.id("btnFiltrar");
	private By botonEliminar = By.id("btnEliminar");
	private By botonSiEliminar = By.id("btnSi");
	private By botonNoEliminar = By.id("btnNo");
	private By botonGuardar = By.id("btnGuardar");
	private By cajaNombre = By.id("txtNombre");
	private By cajaCantidad = By.id("txtCantidad");
	private By cajaPrecio = By.id("txtPrecio");
	private By cajaTipo = By.id("cboTipo");
	private By cajaNacionalidad = By.id("rdoNacionalidad");
	private By cajaDescuento = By.id("chkDescuento");
	private By cajaFiltro = By.id("txtFiltro");
	private By mensajeRespuesta = By.id("messages");
	private WebDriver webDriver = null;
	private final static int MAXIMO_TIEMPO = 3000;
	
	public ProductoPage(WebDriver pagina) {
		webDriver = pagina;
	}

	public void hacerClicBotonNuevo() throws Exception{
		webDriver.findElement(botonNuevo).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoNombre(String nombre) throws Exception{
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaNombre).sendKeys(nombre);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoCantidad(String cantidad) throws Exception{
		webDriver.findElement(cajaCantidad).clear();
		webDriver.findElement(cajaCantidad).sendKeys(cantidad);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoPrecio(String precio) throws Exception{
		webDriver.findElement(cajaPrecio).clear();
		webDriver.findElement(cajaPrecio).sendKeys(precio);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoTipo(String tipo) throws Exception{
		webDriver.findElement(cajaTipo).clear();
		webDriver.findElement(cajaTipo).sendKeys(tipo);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoNacionalidad(String nacionalidad) throws Exception{
		webDriver.findElement(cajaNacionalidad).clear();
		webDriver.findElement(cajaNacionalidad).sendKeys(nacionalidad);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoDescuento(String descuento) throws Exception{
		webDriver.findElement(cajaDescuento).clear();
		webDriver.findElement(cajaDescuento).sendKeys(descuento);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void escribirCampoFiltro(String filtro) throws Exception{
		webDriver.findElement(cajaFiltro).clear();
		webDriver.findElement(cajaFiltro).sendKeys(filtro);
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public String guardarProducto() throws Exception{
		webDriver.findElement(botonGuardar).click();
		Thread.sleep(MAXIMO_TIEMPO);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public int buscarProducto() throws Exception{
		webDriver.findElement(botonBuscar).click();
		Thread.sleep(MAXIMO_TIEMPO);
		return webDriver.findElements(By.xpath("//tbody[@id='tablaProductos_data']/tr")).size();
	}
	public void seleccionarProducto() throws Exception{
		webDriver.findElements(By.xpath("//tbody[@id='tablaProductos_data']/tr/td")).get(0).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	public void hacerClicBotonEditar() throws Exception{
		webDriver.findElement(botonEditar).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public void hacerClicBotonEliminar() throws Exception{
		webDriver.findElement(botonEliminar).click();
		Thread.sleep(MAXIMO_TIEMPO);
	}
	
	public String eliminarProducto() throws Exception{
		webDriver.findElement(botonSiEliminar).click();
		Thread.sleep(MAXIMO_TIEMPO);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public String hacerClicBotonNoEliminar() throws Exception{
		webDriver.findElement(botonNoEliminar).click();
		Thread.sleep(MAXIMO_TIEMPO);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	
	public WebDriver obtenerPagina() {
		return webDriver;
	}
	
	public void cerrarPagina() {
		VisorDriver.cerrarPagina(webDriver);
	}
}
