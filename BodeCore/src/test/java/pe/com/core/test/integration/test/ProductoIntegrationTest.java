package pe.com.core.test.integration.test;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pe.com.core.business.ProductoBusiness;
import pe.com.core.entity.Producto;

public class ProductoIntegrationTest {
	
	private final  ProductoBusiness productoBusiness = new ProductoBusiness();
	private static Producto producto = new Producto();
	private static List<Producto> listaProducto = new ArrayList<>();
	private String mensaje = "";
	private String nombreProducto = "";	
	private int cantidadProducto = 0;	
	private double precioUnitarioProducto = 0;
	private String tipoProducto = "";	
	private String nacionalidadProducto = "";	
	private String descuentoProducto = "";
	private String filtro = "";
	@Mock
	private HttpServletResponse response;
	
	@Given("^despues de iniciar sesion en la aplicacion$")
	public void despues_de_iniciar_sesion_en_la_aplicacion() throws Throwable {
	    MockitoAnnotations.initMocks(this);
	    doNothing().when(response).sendRedirect("http://www.bode.com");
	    Assert.assertTrue(true);
	}

	@When("^hago click en el enlace de Mantenimiento de Producto$")
	public void hago_click_en_el_enlace_de_Mantenimiento_de_Producto() throws Throwable {
		MockitoAnnotations.initMocks(this);
	    doNothing().when(response).sendRedirect("http://www.bode.com/mntAdmProducto.xhtml");
	    Assert.assertTrue(true);
	}

	@When("^luego hago click en el boton de Nuevo$")
	public void luego_hago_click_en_el_boton_de_Nuevo() throws Throwable {
		MockitoAnnotations.initMocks(this);
	    doNothing().when(response).sendRedirect("http://www.bode.com/registrarAdmProducto.xhtml");
	    Assert.assertTrue(true);
	}

	@When("^en campo Nombre el valor de \"([^\"]*)\"$")
	public void en_campo_Nombre_el_valor_de(String arg1) throws Throwable {
		nombreProducto = arg1;
	    producto.setNombre(nombreProducto);
	    Assert.assertTrue(true);
	}

	@When("^en campo Cantidad el valor de (\\d+)$")
	public void en_campo_Cantidad_el_valor_de(int arg1) throws Throwable {
		cantidadProducto = arg1;
	    producto.setCantidad(cantidadProducto);
	    Assert.assertTrue(true);
	}

	@When("^en campo Precio Unitario el valor de \"([^\"]*)\"$")
	public void en_campo_Precio_Unitario_el_valor_de(String arg1) throws Throwable {
		precioUnitarioProducto = Double.parseDouble(arg1);
	    producto.setPrecio(precioUnitarioProducto);
	    Assert.assertTrue(true);
	}

	@When("^en campo Tipo el valor de \"([^\"]*)\"$")
	public void en_campo_Tipo_el_valor_de(String arg1) throws Throwable {
		tipoProducto = arg1;
	    producto.setTipo(tipoProducto);
	    Assert.assertTrue(true);
	}

	@When("^en campo Nacionalidad el valor de \"([^\"]*)\"$")
	public void en_campo_Nacionalidad_el_valor_de(String arg1) throws Throwable {
		nacionalidadProducto = arg1;
	    producto.setNacional(nacionalidadProducto);
	    Assert.assertTrue(true);
	}

	@When("^en campo Descuento el valor de \"([^\"]*)\"$")
	public void en_campo_Descuento_el_valor_de(String arg1) throws Throwable {	
		descuentoProducto = arg1.equals("checked")?"true":"false";	
	    producto.setDescuento(descuentoProducto);
	    Assert.assertTrue(true);
	}

	@When("^presiono el boton de Guardar$")
	public void presiono_el_boton_de_Guardar() throws Throwable {
	    try {
	    	productoBusiness.insertar(producto);
	    	mensaje = "Se guardó correctamente el Producto";
	    	Assert.assertTrue(true);
	    } catch (Exception e) {
	    	mensaje = "Errror: " + e.getMessage();
	    	Assert.fail(mensaje);
	    }
	}

	@Then("^el sistema me muestra el mensaje de: \"([^\"]*)\"$")
	public void el_sistema_me_muestra_el_mensaje_de(String arg1) throws Throwable {
	    Assert.assertEquals(arg1, mensaje);
	}

	@When("^busco el producto \"([^\"]*)\" para seleccionarlo de la tabla de Producto$")
	public void busco_el_producto_para_seleccionarlo_de_la_tabla_de_Producto(String arg1) throws Throwable {
	    try {
	    	List<Producto> lista = productoBusiness.listar(arg1);
	    	Assert.assertTrue(lista.size() > 0);
	    	producto = lista.get(0);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	Assert.fail("Error: " + e.getMessage());
	    }
	}

	@When("^luego hago click en el boton de Editar$")
	public void luego_hago_click_en_el_boton_de_Editar() throws Throwable {	    
		MockitoAnnotations.initMocks(this);
	    doNothing().when(response).sendRedirect("http://www.bode.com/actualizarAdmProducto.xhtml");		
		try {
			producto = productoBusiness.obtener(producto.getId());
		    Assert.assertTrue(true);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	Assert.fail("Error: " + e.getMessage());
	    }
	}

	@When("^presiono el boton de Actualizar$")
	public void presiono_el_boton_de_Actualizar() throws Throwable {
	    try {
	    	productoBusiness.actualizar(producto);
	    	mensaje = "Se actualizó correctamente el Producto";
	    	Assert.assertTrue(true);
	    } catch (Exception e) {
	    	mensaje = "Error: " + e.getMessage();
	    	 Assert.fail(mensaje);
	    }
	}

	@When("^presiono el boton de Eliminar y presiono el boton \"([^\"]*)\"$")
	public void presiono_el_boton_de_Eliminar_y_presiono_el_boton(String arg1) throws Throwable {
	    try {	    	
	    	if (arg1.equals("Si")) {
		    	productoBusiness.eliminar(producto);
		    	mensaje = "Se eliminó correctamente el Producto";
	    	}	    	
	    	Assert.assertTrue(true);
	    } catch (Exception e) {
	    	mensaje = "Error: " + e.getMessage();
	    	Assert.fail(mensaje);
	    }
	}

	@When("^en la nueva pantalla escribo en campo Filtro el valor de \"([^\"]*)\"$")
	public void en_la_nueva_pantalla_escribo_en_campo_Filtro_el_valor_de(String arg1) throws Throwable {
		filtro = arg1;
	    Assert.assertTrue(true);
	}
	
	@When("^presiono el boton de Buscar$")
	public void presiono_el_boton_de_Buscar() throws Throwable {
	    try {
	    	if (filtro.isEmpty())
	    		listaProducto = productoBusiness.listar();
	    	else
		    	listaProducto = productoBusiness.listar(filtro);
	    	
	    	Assert.assertTrue(true);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	Assert.fail("Error: " + e.getMessage());
	    }
	}

	@Then("^el sistema me muestra la lista de productos que corresponden al filtro ingresado$")
	public void el_sistema_me_muestra_la_lista_de_productos_que_corresponden_al_filtro_ingresado() throws Throwable {
	    Assert.assertTrue(listaProducto.size()>0);
	}
}