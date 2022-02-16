package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class InsertarDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JComponent cbbCentros;
	private JRadioButton nrbPropiedad;
	private JComponent nrbFunciones;
	private JSpinner spinnerPresupuesto;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Controlador controlador;
	private ArrayList<Centro> listaCentros;
	private final ButtonGroup buttonGroup = new ButtonGroup();



	/**
	 * Create the dialog.
	 */
	public InsertarDepartamento() {
		setTitle("Insertar Departamento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow][122.00,grow][][]", "[][][][][][][][]"));
		{
			JLabel lblCodigo = new JLabel("C\u00F3digo:");
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblCodigo, "cell 0 0,alignx trailing");
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(txtCodigo, "cell 1 0 4 1,growx");
			txtCodigo.setColumns(10);
		}
		{
			JLabel lblCentro = new JLabel("Centro:");
			lblCentro.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblCentro, "cell 0 2,alignx trailing");
		}
		{
			cbbCentros = new JComboBox();
			cbbCentros.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(cbbCentros, "cell 1 2 4 1,growx");
		}
		{
			JLabel lblTipo = new JLabel("Tipo Direcci\u00F3n:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblTipo, "cell 0 4");
		}
		{
			nrbPropiedad = new JRadioButton("Propiedad");
			nrbPropiedad.setSelected(true);
			buttonGroup.add(nrbPropiedad);
			nrbPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(nrbPropiedad, "cell 1 4");
		}
		{
			nrbFunciones = new JRadioButton("En funciones");
			buttonGroup.add((AbstractButton) nrbFunciones);
			nrbFunciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(nrbFunciones, "cell 2 4");
		}
		{
			JLabel lblPresupuesto = new JLabel("Presupuesto:");
			lblPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblPresupuesto, "cell 0 6,alignx right");
		}
		{
			spinnerPresupuesto = new JSpinner();
			spinnerPresupuesto.setModel(new SpinnerNumberModel(5, 1, 100, 1));
			spinnerPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(spinnerPresupuesto, "cell 1 6");
		}
		{
			JLabel lblInfo = new JLabel("(en miles de \u20AC)");
			lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblInfo, "cell 2 6");
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNombre, "cell 0 7,alignx trailing");
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(txtNombre, "cell 1 7 4 1,growx");
			txtNombre.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("OK");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						recogerDatos();
						
					}
				});
				btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						
					}
				});
				btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	protected void recogerDatos() {
		int codDepartamento = Integer.parseInt(txtCodigo.getText());
		Centro centro = (Centro) ((JComboBox) cbbCentros).getSelectedItem();
		String tipoDir = null;
		if(nrbPropiedad.isSelected()) {
			tipoDir = "P";
		} else {
			tipoDir = "F";
		}
		int presupuesto = (int) spinnerPresupuesto.getValue();
		String nombre = txtNombre.getText();
		Departamento departamento = new Departamento(codDepartamento, centro.getCod_centro(), tipoDir, presupuesto, nombre);
		
		
		controlador.insertarDepartamento(departamento);
		
	}
	
public void setListaCentros(ArrayList<Centro> listaCentros) {
		
		this.listaCentros = listaCentros;
		for (Centro centro : listaCentros) {
			((JComboBox) cbbCentros).addItem(centro);
		}
		
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	

}