package pe.com.test.system.testcase;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Converter;

import pe.com.test.system.data.Excel;
import pe.com.test.system.page.BienvenidaPage;
import pe.com.test.system.page.ProductoPage;
import pe.com.test.system.page.IniciarSesionPage;
import pe.com.test.system.util.Utilitario;

public class MantenimientoProductoTest {

	private IniciarSesionPage iniciarSesionPage;
	private BienvenidaPage bienvenidaPage;
	private ProductoPage productoPage;
private String rutaCapturaPantalla;

	@BeforeTest
	@Parameters({ "navegador", "rutaCapturaPantalla" })
	public void inicioTest(String navegador, String rutaCapturaPantalla) {
		iniciarSesionPage = new IniciarSesionPage(navegador);
		bienvenidaPage = new BienvenidaPage(iniciarSesionPage.obtenerPagina());
		productoPage = new ProductoPage(bienvenidaPage.obtenerPagina());
		this.rutaCapturaPantalla = rutaCapturaPantalla;
	}
	
	@DataProvider(name = "datosRegistrarProducto")
	public static Object[][] datosRegistrarProducto(ITestContext contexto){
		String ruta = contexto.getCurrentXmlTest().getParameter("rutaExcelRegistrar");
		return Excel.leerExcel(ruta);
	}
	
	@Test(dataProvider = "datosRegistrarProducto")
	public void insetarProducto_FlujoBasico(String nombreCasoPrueba, String url, String usuario, String clave, String nombre, String cantidad, String precio, String tipo, String nacionalidad, String descuento, String valorEsperado) {
		try {
			iniciarSesionPage.ingresarPagina(url);
			iniciarSesionPage.iniciarSesion(usuario, clave);
			bienvenidaPage.hacerClicMenuPrincipal();
			bienvenidaPage.hacerClicMenuModuloAlmacen();
			bienvenidaPage.hacerClicMenuMntDeProducto();
			productoPage.hacerClicBotonNuevo();
			productoPage.escribirCampoNombre(nombre.trim());
			productoPage.escribirCampoCantidad(cantidad.trim());
			productoPage.escribirCampoPrecio(precio.trim());
			productoPage.escribirCampoTipo(tipo.trim());
			productoPage.escribirCampoNacionalidad(nacionalidad.trim());
			productoPage.escribirCampoDescuento(descuento.trim());
			String valorObtenido = productoPage.guardarProducto();
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch(AssertionError e) {
			Utilitario.caputarPantallarError(rutaCapturaPantalla, e.getMessage(), productoPage.obtenerPagina());
			Assert.fail(e.getMessage());			
		}catch (Exception e) {
			Assert.fail("Eror: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	/*
	@DataProvider(name = "datosBuscarProducto")
	public static Object[][] datosBuscarProducto(ITestContext contexto){
		String ruta = contexto.getCurrentXmlTest().getParameter("rutaExcelBuscar");
		return Excel.leerExcel(ruta);
	}
	
	@Test(dataProvider = "datosBuscarProducto")
	public void buscarProducto_FlujoBasico(String nombreCasoPrueba, String url, String usuario, String clave, String filtro, String valorEsperado) {
		try {
			iniciarSesionPage.ingresarPagina(url);
			iniciarSesionPage.iniciarSesion(usuario, clave);
			bienvenidaPage.hacerClicMenuPrincipal();
			bienvenidaPage.hacerClicMenuModuloAlmacen();
			bienvenidaPage.hacerClicMenuMntDeProducto();
			productoPage.escribirCampoFiltro(filtro.trim());
			int valorObtenido = productoPage.buscarProducto();
			Assert.assertTrue(valorObtenido>=Double.parseDouble(valorEsperado));
		}catch(AssertionError e) {
			Utilitario.caputarPantallarError(rutaCapturaPantalla, e.getMessage(), productoPage.obtenerPagina());
			Assert.fail(e.getMessage());			
		}catch (Exception e) {
			Assert.fail("Eror: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	
	@DataProvider(name = "datosEditarProducto")
	public static Object[][] datosEditarProducto(ITestContext contexto){
		String ruta = contexto.getCurrentXmlTest().getParameter("rutaExcelEditar");
		return Excel.leerExcel(ruta);
	}
	
	@Test(dataProvider = "datosEditarProducto")
	public void editarProducto_FlujoBasico(String nombreCasoPrueba, String url, String usuario, String clave, String nombre, String cantidad, String precio, String tipo, String nacionalidad, String descuento, String precioNuevo, String valorEsperado) {
		try {
			iniciarSesionPage.ingresarPagina(url);
			iniciarSesionPage.iniciarSesion(usuario, clave);
			bienvenidaPage.hacerClicMenuPrincipal();
			bienvenidaPage.hacerClicMenuModuloAlmacen();
			bienvenidaPage.hacerClicMenuMntDeProducto();
			// IMPORTANTE: Si lanzas la prueba dos veces.. el registro ya no existirá con ese nombre.
			// Por lo que es preferible listar todo.
			productoPage.escribirCampoFiltro(nombre.trim());
			int nroRegistros = productoPage.buscarProducto();
			productoPage.seleccionarProducto();
			productoPage.hacerClicBotonEditar();
			productoPage.escribirCampoNombre(nombre.trim());
			productoPage.escribirCampoCantidad(cantidad.trim());
			productoPage.escribirCampoPrecio(precioNuevo.trim());
			productoPage.escribirCampoTipo(tipo.trim());
			productoPage.escribirCampoNacionalidad(nacionalidad.trim());
			productoPage.escribirCampoDescuento(descuento.trim());
			String valorObtenido = productoPage.guardarProducto();
			Assert.assertEquals(valorObtenido, valorEsperado);
		}catch(AssertionError e) {
			Utilitario.caputarPantallarError(rutaCapturaPantalla, e.getMessage(), productoPage.obtenerPagina());
			Assert.fail(e.getMessage());			
		}catch (Exception e) {
			Assert.fail("Eror: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "datosEliminarProducto")
	public static Object[][] datosEliminarProducto(ITestContext contexto){
		String ruta = contexto.getCurrentXmlTest().getParameter("rutaExcelEliminar");
		return Excel.leerExcel(ruta);
	}
	
	@Test(dataProvider = "datosEliminarProducto")
	public void eliminarProducto_FlujoBasico(String nombreCasoPrueba, String url, String usuario, String clave, String nombre, String preguntaEliminar, String valorEsperado) {
		try {
			iniciarSesionPage.ingresarPagina(url);
			iniciarSesionPage.iniciarSesion(usuario, clave);
			bienvenidaPage.hacerClicMenuPrincipal();
			bienvenidaPage.hacerClicMenuModuloAlmacen();
			bienvenidaPage.hacerClicMenuMntDeProducto();
			productoPage.escribirCampoFiltro(nombre.trim());
			int nroRegistros = productoPage.buscarProducto();
			productoPage.seleccionarProducto();
			productoPage.hacerClicBotonEliminar();
			String valorObtenido = "";
			if (preguntaEliminar.equals("Si"))
				valorObtenido = productoPage.eliminarProducto();
			else
				productoPage.hacerClicBotonNoEliminar();			
			Assert.assertEquals(valorObtenido, valorEsperado);			
		}catch(AssertionError e) {
			Utilitario.caputarPantallarError(rutaCapturaPantalla, e.getMessage(), productoPage.obtenerPagina());
			Assert.fail(e.getMessage());			
		}catch (Exception e) {
			Assert.fail("Eror: " + e.getMessage());
			e.printStackTrace();
		}
	}
	*/	
	@AfterTest
	public void inicioTest() {
		iniciarSesionPage.cerrarPagina();
	}
}
