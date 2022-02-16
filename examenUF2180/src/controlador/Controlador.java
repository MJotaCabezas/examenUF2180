/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.CentroDAO;
import dao.DepartamentoDAO;
import modelo.Centro;
import modelo.Departamento;
import vista.DialogoA�adirCentro;
import vista.InsertarDepartamento;
import vista.VentanaMostrarCentros;
import vista.VentanaMostrarDepartamentos;
import vista.VentanaPpal;

/**
 * @author MJotaCabezas
 *
 */
public class Controlador {

	// Ventanas del sistema
	private VentanaPpal ventanaPpal;
	private VentanaMostrarCentros ventanaMostrarCentros;
	private DialogoA�adirCentro dialogoA�adirCentro;
	private VentanaMostrarDepartamentos ventanaMostrarDepartamentos;
	private InsertarDepartamento insertarDepartamento;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;
	private DepartamentoDAO departamentoDAO;

	
	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoA�adirCentro = new DialogoA�adirCentro();
		ventanaMostrarDepartamentos = new VentanaMostrarDepartamentos();
		insertarDepartamento = new InsertarDepartamento();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoA�adirCentro.setControlador(this);
		ventanaMostrarDepartamentos.setControlador(this);
		insertarDepartamento.setControlador(this);

		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
		departamentoDAO = new DepartamentoDAO();
	}
	
	
	/**
	 * M�todo que arranca el programa principal
	 */
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarListarCentros() {
		ArrayList<Centro> lista = centroDAO.obtenerCentros();
		ventanaMostrarCentros.setListaCentros(lista);
		ventanaMostrarCentros.setVisible(true);
	}
	
	public void mostrarInsertarCentros() {
		dialogoA�adirCentro.setVisible(true);
	}


	/*
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoA�adirCentro, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(dialogoA�adirCentro, "Insercion del centro correcta");
			dialogoA�adirCentro.setVisible(false);
		}
	}
	

	public void mostrarListarDepartamentos() {
		ArrayList<Departamento> lista = departamentoDAO.obtenerDepartamentos();
		ventanaMostrarDepartamentos.setListaDepartamento(lista);
		ventanaMostrarDepartamentos.setVisible(true);
	}
	
	public void insertarDepartamento(Departamento departamento) {
		
		int resultado = departamentoDAO.insertarDepartamento(departamento);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(insertarDepartamento, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(insertarDepartamento, "Insercion del departamento correcta");
			insertarDepartamento.setVisible(false);
		}
	}


	public void mostrarInsertarDepartamentos() {
		ArrayList<Centro> listaCentros = centroDAO.obtenerCentros();
		insertarDepartamento.setListaCentros(listaCentros);
		
		insertarDepartamento.setVisible(true);
		
	}
	
	
}