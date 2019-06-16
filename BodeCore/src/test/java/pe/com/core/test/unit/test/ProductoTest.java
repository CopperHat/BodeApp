package pe.com.core.test.unit.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Mockito.spy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



import pe.com.core.dao.ProductoDao;
import pe.com.core.entity.Producto;

@RunWith(MockitoJUnitRunner.class)
public class ProductoTest {
	@Mock
	private ProductoDao productoDao;
	@Mock
	private Producto producto;
	@Mock
	private List<Producto> listaProducto;
	
	@BeforeClass
	public static void inicioClase() {
		System.out.println("Inicio de la clase");
	}
	
	@AfterClass
	public static void finClase() {
		System.out.println("Fin de la clase");
	}
	
	@Before
	public void inicioMetodo() {
		System.out.println("Inicio de cada test");
	}
	
	@After
	public void despuesMetodo() {
		System.out.println("Después de cada test");
	}
	
	@Test
	public void insertarProducto() {
		try {
			System.out.println("Metodo insertar");
			producto = new Producto(1);
			producto.setNombre("Galleta Oreo Clásica");
			producto.setCantidad(70);
			producto.setPrecio(0.8);
			producto.setTipo("Golosina - Galleta");
			producto.setNacional("Peruana");
			producto.setDescuento("true");
			when(productoDao.insertar(Matchers.any())).thenReturn(producto);
			Producto productoObtenido = productoDao.insertar(producto);
			Assert.assertTrue(productoObtenido.getId()>0);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: "+e.getMessage());
		}
	}
	@Test
	public void actualizarProducto() {
		try {
			System.out.println("Metodo actualizar");
			producto = new Producto();
			producto.setNombre("Galleta Oreo Clásica");
			producto.setCantidad(70);
			producto.setPrecio(2.0);
			producto.setTipo("Golosina - Galleta");
			producto.setNacional("Extranjera");
			producto.setDescuento("false");
			producto.setId(1);				
			when(productoDao.actualizar(Matchers.any())).thenReturn(producto);		
			Producto productoObtenido = productoDao.actualizar(producto);
			
			Assert.assertTrue(productoObtenido.getNombre().equals(producto.getNombre()) &&
							  productoObtenido.getCantidad() == producto.getCantidad() &&
							  productoObtenido.getPrecio() == producto.getPrecio() &&
							  productoObtenido.getTipo().equals(producto.getTipo()) &&
							  productoObtenido.getNacional() == producto.getNacional() &&
							  productoObtenido.getDescuento() == producto.getDescuento()
							  );
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: "+e.getMessage());
		}
	}
	@Test
	public void eliminarProducto() {
		try {
			System.out.println("Metodo eliminar");
			
			Producto producto = new Producto();
			producto.setId(1);			
			when(productoDao.eliminar(Matchers.any())).thenReturn(null);
			Producto productoEliminado = productoDao.eliminar(producto);			
			Assert.assertNull(productoEliminado);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: "+e.getMessage());
		}
	}
	
	@Test
	public void obtenerProducto() {
		try {
			System.out.println("Metodo obtener");
			
			producto = new Producto();
			producto.setNombre("Galleta Oreo Clásica");
			producto.setCantidad(70);
			producto.setPrecio(2.0);
			producto.setTipo("Golosina - Galleta");
			producto.setNacional("Extranjera");
			producto.setDescuento("false");
			producto.setId(1);		
			when(productoDao.obtener(Matchers.any())).thenReturn(producto);			
			Producto productoObtenido = productoDao.obtener(producto);
			Assert.assertNotNull(productoObtenido);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: "+e.getMessage());
		}
	}
	
	@Test
	public void listarProducto() {
		try {
			System.out.println("Metodo listar nombre");
			listaProducto = new ArrayList<Producto>();
			producto = new Producto();
			producto.setNombre("Galleta Oreo Clásica");
			producto.setCantidad(70);
			producto.setPrecio(2.0);
			producto.setTipo("Golosina - Galleta");
			producto.setNacional("Extranjera");
			producto.setDescuento("false");
			producto.setId(1);
			listaProducto.add(producto);					
			when(productoDao.listar()).thenReturn(listaProducto);
			List<Producto> listaObtenida = productoDao.listar();
			Assert.assertTrue(listaObtenida !=null && listaObtenida.size()>0);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: "+e.getMessage());
		}
	}
	
	@Test
	public void listarProductoNombre() {
		try {
			System.out.println("Metodo listar nombre");
			listaProducto = new ArrayList<Producto>();
			producto = new Producto();
			producto.setNombre("Galleta Oreo Clásica");
			producto.setCantidad(70);
			producto.setPrecio(2.0);
			producto.setTipo("Golosina - Galleta");
			producto.setNacional("Extranjera");
			producto.setDescuento("false");
			producto.setId(1);
			listaProducto.add(producto);					
			when(productoDao.listar(Matchers.any())).thenReturn(listaProducto);
			String nombreBuscar = "Galleta";
			List<Producto> listaObtenida = productoDao.listar(nombreBuscar);
			Assert.assertTrue(listaObtenida !=null && listaObtenida.size()>0);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: "+e.getMessage());
		}
	}
}