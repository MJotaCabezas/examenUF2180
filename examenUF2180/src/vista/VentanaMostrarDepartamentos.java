package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;

public class VentanaMostrarDepartamentos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMostrarDepartamentos frame = new VentanaMostrarDepartamentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMostrarDepartamentos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de Departamentos:");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1 2 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"cod_departamento", "cod_centro", "tipo_dir", "presupuesto", "nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_1, "cell 1 2");
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

	public void setListaDepartamento(ArrayList<Departamento> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Departamento departamento : lista) {
			Object fila [] = {
					departamento.getCod_departamento(),departamento.getCod_centro(), departamento.getTipo_dir(),departamento.getPresupuesto(),
					departamento.getNombre(),
			};
			modelo.addRow(fila);
		}
	}

	
		
	

}
