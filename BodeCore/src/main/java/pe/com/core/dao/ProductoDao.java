package pe.com.core.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import pe.com.core.entity.Producto;

/**
 * Clase que tiene los metodos de Acceso a Datos para la tabla Producto
 * @author 	Henry Joe Wong Urquiza
 * @email 	hwongu@gmail.com
 */
public class ProductoDao extends Conexion<Producto> {

	@Override
	public Producto insertar(Producto p) throws Exception {
		try {

			cn = obtenerConexion();
			String sql = "INSERT INTO PRODUCTO (nombre, cantidad, precio_unitario, tipo, nacional, descuento ) VALUES (?,?,?,?,?,?)";
			pr = cn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, p.getNombre());
			pr.setInt(2, p.getCantidad());
			pr.setDouble(3, p.getPrecio());
			pr.setString(4, p.getTipo());
			pr.setString(5, p.getNacional());
			pr.setString(6, p.getDescuento());
			pr.executeUpdate();
			rs = pr.getGeneratedKeys();
			rs.next();
			p.setId(rs.getInt(1));
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return p;
	}

	@Override
	public Producto actualizar(Producto p) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "UPDATE PRODUCTO SET nombre=?, cantidad=?, precio_unitario=?, tipo=?, nacional=?, descuento=?  WHERE idProducto=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, p.getNombre());
			pr.setInt(2, p.getCantidad());
			pr.setDouble(3, p.getPrecio());
			pr.setString(4, p.getTipo());
			pr.setString(5, p.getNacional());
			pr.setString(6, p.getDescuento());
			pr.setInt(7, p.getId());
			pr.executeUpdate();
		} finally {
			pr.close();
			cn.close();
		}
		return p;
	}

	@Override
	public Producto eliminar(Producto p) throws Exception {
		try {
			cn = obtenerConexion();
			String sql = "DELETE FROM PRODUCTO WHERE idProducto=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, p.getId());
			pr.executeUpdate();
		} finally {
			pr.close();
			cn.close();
		}
		return p;
	}

	@Override
	public Producto obtener(Producto p) throws Exception {
		Producto producto = null;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM PRODUCTO WHERE idProducto=? ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, p.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCantidad(rs.getInt("cantidad"));
				producto.setPrecio(rs.getDouble("precio_unitario"));
				producto.setTipo(rs.getString("tipo"));
				producto.setNacional(rs.getString("nacional"));
				producto.setDescuento(rs.getString("descuento"));
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return producto;
	}

	@Override
	public List<Producto> listar() throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM PRODUCTO ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCantidad(rs.getInt("cantidad"));
				producto.setPrecio(rs.getDouble("precio_unitario"));
				producto.setTipo(rs.getString("tipo"));
				producto.setNacional(rs.getString("nacional"));
				producto.setDescuento(rs.getString("descuento"));
				productos.add(producto);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return productos;
	}

	public List<Producto> listar(String nombre) throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM PRODUCTO ";
			sql += " WHERE nombre LIKE '%" + nombre + "%'";
			sql += " ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCantidad(rs.getInt("cantidad"));
				producto.setPrecio(rs.getDouble("precio_unitario"));
				producto.setTipo(rs.getString("tipo"));
				producto.setNacional(rs.getString("nacional"));
				producto.setDescuento(rs.getString("descuento"));
				productos.add(producto);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return productos;
	}
}
