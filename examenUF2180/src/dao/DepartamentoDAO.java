/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Centro;
import modelo.Departamento;

/**
 * @author MJotaCabezas
 *
 */
public class DepartamentoDAO {
	
	private static ConexionBD conexion;
	
	public DepartamentoDAO() {
		this.conexion = new ConexionBD();
	}
	
	public static ArrayList<Departamento> obtenerDepartamentos() {
		
		//conexion con la base de datos
		Connection con = conexion.getConexion();
		
		Statement consulta = null;
		ResultSet resultado = null;
		
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from departamentos");
			
			//recorre todas las final que devuelve la consulta
			while(resultado.next()) {
				int  codDepartamento = resultado.getInt("cod_departamento");
				int  codCentro = resultado.getInt("cod_centro");
				String  tipoDir = resultado.getString("tipo_dir");
				int  presupuesto = resultado.getInt("presupuesto");
				String  nombre = resultado.getString("nombre");
				
				Departamento d = new Departamento(codDepartamento, codCentro, tipoDir, presupuesto, nombre);
				lista.add(d);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta " + e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos " + e.getMessage());
			}
		}
		return lista;
	}
	
	public int insertarDepartamento(Departamento departamento) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO departamentos (`cod_departamento`, `cod_centro`, `tipo_dir`, `presupuesto`, `nombre`)"
					+ "VALUES (?,?,?,?,?)");
			
			
			consulta.setInt(1, departamento.getCod_departamento());
			consulta.setInt(2, departamento.getCod_centro());
			consulta.setString(3, departamento.getTipo_dir());
			consulta.setInt(4, departamento.getPresupuesto());
			consulta.setString(5, departamento.getNombre());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del departamento: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }

}