/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author MJotaCabrzas
 *
 */



//Crear el usuario y otorgarle los permisos 

/*create user empresaUsuario identified by "1401";

grant all privileges on empresa.* to empresaUsuario;
flush privileges;*/


public class ConexionBD {

	private static final String database = "empresa";
	private static final String usuario = "empresaUsuario";
	private static final String contraseña = "1401";
	private static final String url="jdbc:mysql://localhost/"+database;
	
	private Connection conexion=null;
	
	
	public Connection getConexion() {
		if (conexion!=null) {
			return conexion;
		}
		
		// REgistra el driver de MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexion a bilioteca correcta");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no registrado");
		} catch (SQLException e) {
			System.out.println("Error SQLException: "+e.getMessage());
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			conexion.close();
			conexion=null;
		} catch (SQLException e) {
			System.out.println("Erorr cerrrando la conexion "+ e.getMessage());
		}
	}

}
