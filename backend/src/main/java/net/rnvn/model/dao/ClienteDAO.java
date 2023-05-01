package net.rnvn.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.Cliente;

public class ClienteDAO extends PolizasDAO {
	public ClienteDAO() {
		super();
	}

	public boolean agregarCliente(Cliente cliente) {
		boolean result = false;
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_ADD_CLIENTE)) {

			stmt.clearParameters();
			stmt.setString(1, cliente.getIdentificacion());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellidos());
			stmt.setString(4, cliente.getTelefono());
			stmt.setString(5, cliente.getCorreo());
			result = stmt.executeUpdate() > 0;
		} catch (Exception e) {
			String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al agregar cliente: " + e.getMessage());
		}
		return result;
	}

	public Cliente getCliente(String identificacion) {
		Cliente cliente = null;
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_GET_CLIENTE)) {
			stmt.clearParameters();
			stmt.setString(1, identificacion);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String nombre = rs.getString("nombre");
					String apellidos = rs.getString("apellido");
					String telefono = rs.getString("telefono");
					String correo = rs.getString("correo");
					cliente = new Cliente(identificacion, nombre, apellidos, telefono, correo);
				}
			}
		} catch (Exception e) {
			String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al obtener cliente: " + e.getMessage());
		}
		return cliente;
	}

	public boolean actualizarCliente(Cliente cliente) {
		boolean result = false;
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_CLIENTE)) {
			stmt.clearParameters();
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellidos());
			stmt.setString(3, cliente.getTelefono());
			stmt.setString(4, cliente.getCorreo());
			stmt.setString(5, cliente.getIdentificacion());
			result = stmt.executeUpdate() > 0;
		} catch (Exception e) {
			String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al actualizar cliente: " + e.getMessage());
		}
		return result;
	}

	public boolean eliminarCliente(String identificacion) {
		boolean result = false;
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_CLIENTE)) {
			stmt.clearParameters();
			stmt.setString(1, identificacion);
			result = stmt.executeUpdate() > 0;
		} catch (Exception e) {
			String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al eliminar cliente: " + e.getMessage());
		}
		return result;
	}

	public boolean registrarUsuario(Cliente cliente, String password) {
		boolean result = false;
		try (Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(SQL_SP_REGISTRAR_USUARIO)) {
			cstmt.clearParameters();
			cstmt.setString(1, cliente.getIdentificacion());
			cstmt.setString(2, password);
			cstmt.setString(3, cliente.getNombre());
			cstmt.setString(4, cliente.getApellidos());
			cstmt.setString(5, cliente.getTelefono());
			cstmt.setString(6, cliente.getCorreo());
			ResultSet rs = cstmt.executeQuery();
			if (rs.next()) {
				result = rs.getBoolean("success");
			}
		} catch (Exception e) {
			String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al registrar usuario: " + e.getMessage());
		}
		return result;
	}

	// consultas SQL

	private static final String TABLE_NAME = "clientes";

	private static final String SQL_ADD_CLIENTE //
			= QueryGen.genInsertInto(
					TABLE_NAME,
					new String[] { "identificacion", "nombre", "apellido", "telefono", "correo" });
	private static final String SQL_GET_CLIENTE //
			= QueryGen.genSelectString(
					TABLE_NAME,
					new String[] { "nombre", "apellido", "telefono", "correo" },
					new String[] { "identificacion = ?" });
	private static final String SQL_UPDATE_CLIENTE //
			= QueryGen.genUpdateString(
					TABLE_NAME,
					new String[] { "nombre", "apellido", "telefono", "correo" },
					new String[] { "identificacion = ?" });
	private static final String SQL_DELETE_CLIENTE //
			= QueryGen.genDeleteString(
					TABLE_NAME,
					new String[] { "identificacion = ?" });
	private static final String SQL_SP_REGISTRAR_USUARIO //
			= QueryGen.genCallStoredProcedure(
					"sp_registrar_usuario",
					new String[] { "identificacion", "password", "nombre", "apellido", "telefono", "correo" });

}
