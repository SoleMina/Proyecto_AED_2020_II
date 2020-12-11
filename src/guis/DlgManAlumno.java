package guis;

import Arreglo.ArregloAlumno;

import clases.Alumno;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DlgManAlumno extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblcodAlumno;
	private JTextField txtcodAlumno;
	private JButton btnGuardarAlumno;
	private JButton btnAdicionar_Alumno;
	private JButton btnConsultar_Alumno;
	private JButton btnModificar_Alumno;
	private JButton btnEliminar;
	private JTextField txtEdadAlumno;
	private JLabel lblEdadAlumno;
	private JTextField txtDniAlumno;
	private JLabel lblDniAlumno;
	private JLabel lblCelularAlumno;
	private JTextField txtCelularAlumno;
	private JLabel lblApeAlumno;
	private JLabel lblNomAlumno;
	private JTextField txtNomAlumno;
	private JTextField txtApeAlumno;
	private JScrollPane scrollPane;
	private JTable tblAlumno;
	private JButton btnOpciones;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	// Constantes

	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;
	private int tipoDeOperacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgManAlumno dialog = new DlgManAlumno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgManAlumno() {

		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Alumno");
		setBounds(100, 100, 600, 390);
		getContentPane().setLayout(null);

		lblcodAlumno = new JLabel("Codigo");
		lblcodAlumno.setBounds(10, 15, 46, 14);
		getContentPane().add(lblcodAlumno);

		txtcodAlumno = new JTextField();
		txtcodAlumno.setColumns(10);
		txtcodAlumno.setBounds(66, 12, 86, 20);
		getContentPane().add(txtcodAlumno);

		// ---------------------------------------------------------------------------------//
		btnGuardarAlumno = new JButton("Guardar");
		btnGuardarAlumno.setEnabled(false);
		btnGuardarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tipoDeOperacion == ADICIONAR) {
					adicionarAlumno();
					listar();
					limpiar();
					txtcodAlumno.setText("" + alum.codigoCorrelativo());
				} else {

					modificarAlumno();
					limpiar();
				}
			}
		});
		btnGuardarAlumno.setBounds(162, 11, 89, 23);
		getContentPane().add(btnGuardarAlumno);

		btnAdicionar_Alumno = new JButton("Adicionar");
		btnAdicionar_Alumno.addActionListener(new ActionListener() {

			// BOTON ADICIONAR
			public void actionPerformed(ActionEvent arg0) {
				tipoDeOperacion = ADICIONAR;
				txtcodAlumno.setText("");
				txtcodAlumno.setText("" + alum.codigoCorrelativo());
				habilitarEntradas(true);
				habilitarBotones(false);

			}
		});
		btnAdicionar_Alumno.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionar_Alumno);

		btnConsultar_Alumno = new JButton("Consultar");
		btnConsultar_Alumno.addActionListener(new ActionListener() {
			// Boton consultar
			public void actionPerformed(ActionEvent arg0) {
				tipoDeOperacion = CONSULTAR;
				txtcodAlumno.setText("");
				txtcodAlumno.setEditable(true);
				habilitarBotones(false);
				txtcodAlumno.requestFocus();
			}
		});
		btnConsultar_Alumno.setBounds(485, 36, 89, 23);
		getContentPane().add(btnConsultar_Alumno);

		btnModificar_Alumno = new JButton("Modificar");
		btnModificar_Alumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipoDeOperacion = MODIFICAR;
				txtcodAlumno.setEditable(true);
				habilitarBotones(false);
				txtcodAlumno.requestFocus();

			}
		});
		btnModificar_Alumno.setBounds(485, 61, 89, 23);
		getContentPane().add(btnModificar_Alumno);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarAlumno();

			}
		});
		btnEliminar.setBounds(485, 86, 89, 23);
		getContentPane().add(btnEliminar);

		txtEdadAlumno = new JTextField();
		txtEdadAlumno.setEditable(false);
		txtEdadAlumno.setColumns(10);
		txtEdadAlumno.setBounds(277, 87, 89, 20);
		getContentPane().add(txtEdadAlumno);

		lblEdadAlumno = new JLabel("Edad");
		lblEdadAlumno.setBounds(232, 90, 35, 14);
		getContentPane().add(lblEdadAlumno);

		txtDniAlumno = new JTextField();
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setColumns(10);
		txtDniAlumno.setBounds(66, 87, 110, 20);
		getContentPane().add(txtDniAlumno);

		lblDniAlumno = new JLabel("DNI");
		lblDniAlumno.setBounds(10, 90, 46, 14);
		getContentPane().add(lblDniAlumno);

		lblCelularAlumno = new JLabel("Celular");
		lblCelularAlumno.setBounds(10, 115, 46, 14);
		getContentPane().add(lblCelularAlumno);

		txtCelularAlumno = new JTextField();
		txtCelularAlumno.setColumns(10);
		txtCelularAlumno.setBounds(66, 112, 110, 20);
		getContentPane().add(txtCelularAlumno);

		lblApeAlumno = new JLabel("Apellidos");
		lblApeAlumno.setBounds(10, 65, 46, 14);
		getContentPane().add(lblApeAlumno);

		lblNomAlumno = new JLabel("Nombres");
		lblNomAlumno.setBounds(10, 40, 46, 14);
		getContentPane().add(lblNomAlumno);

		txtNomAlumno = new JTextField();
		txtNomAlumno.setEditable(false);
		txtNomAlumno.setColumns(10);
		txtNomAlumno.setBounds(66, 37, 300, 20);
		getContentPane().add(txtNomAlumno);

		txtApeAlumno = new JTextField();
		txtApeAlumno.setEditable(false);
		txtApeAlumno.setColumns(10);
		txtApeAlumno.setBounds(66, 62, 300, 20);
		getContentPane().add(txtApeAlumno);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 564, 200);
		getContentPane().add(scrollPane);

		// DefaultTableModel modelo = new DefaultTableModel();

		tblAlumno = new JTable();
		tblAlumno.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Estado", "Edad", "Celular", "Nombres", "Apellidos", "DNI" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblAlumno.getColumnModel().getColumn(5).setPreferredWidth(70);
		tblAlumno.getColumnModel().getColumn(6).setPreferredWidth(63);
		scrollPane.setViewportView(tblAlumno);
//   ------------------------------------------------------//
		modelo = (DefaultTableModel) tblAlumno.getModel();
		btnOpciones = new JButton("Opciones");
		btnOpciones.setEnabled(false);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habilitarBotones(true);
				habilitarEntradas(false);
				limpiar();

			}

		});
		btnOpciones.setBounds(386, 11, 89, 98);
		getContentPane().add(btnOpciones);

		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(218, 115, 46, 14);
		getContentPane().add(lblNewLabel);

		JComboBox cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2" }));

		cboEstado.setBounds(277, 111, 89, 22);
		getContentPane().add(cboEstado);
		// btnGuardarAlumno.setEnabled(false);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtcodAlumno.setEditable(false);
				btnBuscar.setEnabled(false);
				if (tipoDeOperacion == CONSULTAR) {
					btnGuardarAlumno.setEnabled(false);
				} else {
					btnGuardarAlumno.setEnabled(true);
				}
				consultar();
				modificarAlumno();
				habilitarEntradas(true);
			}
		});
		btnBuscar.setBounds(277, 11, 89, 23);
		getContentPane().add(btnBuscar);

		listar();
	}

	ArregloAlumno alum = new ArregloAlumno();

	public void actionPerformed(ActionEvent e) {

	}

	int leerCodigo() {
		return Integer.parseInt(txtcodAlumno.getText().trim());
	}

	int leerEdadAlumno() {
		return Integer.parseInt(txtEdadAlumno.getText().trim());
	}

	String leerDniAlumno() {
		return txtDniAlumno.getText().trim() + "";
	}

	int leerCelAlumno() {
		return Integer.parseInt(txtCelularAlumno.getText().trim());
	}

	String leerNomAlumno() {
		return txtNomAlumno.getText().trim() + "";
	}

	String leerApeAlumno() {
		return txtApeAlumno.getText().trim() + "";
	}

	void habilitarEntradas(boolean sino) {
		txtNomAlumno.setEditable(sino);
		if (tipoDeOperacion == ADICIONAR)
			txtDniAlumno.setEditable(sino);

		txtApeAlumno.setEditable(sino);
		txtNomAlumno.setEditable(sino);
		txtCelularAlumno.setEditable(sino);
		txtEdadAlumno.setEditable(sino);

		// cboEstado.setEditable();
	}

	void habilitarBotones(boolean sino) {
		if (tipoDeOperacion == ADICIONAR)
			btnGuardarAlumno.setEnabled(!sino);

		else {

			btnBuscar.setEnabled(!sino);
			btnGuardarAlumno.setEnabled(sino);

		}

		btnAdicionar_Alumno.setEnabled(sino);
		btnConsultar_Alumno.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnModificar_Alumno.setEnabled(sino);

		// if (tipoDeOperacion == ADICIONAR)

		btnOpciones.setEnabled(!sino);

	}

	public void limpiar() {
		txtNomAlumno.setText("");
		txtApeAlumno.setText("");
		txtCelularAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");

	}

	void adicionarAlumno() {

		int codigo = leerCodigo();
		String nombre = leerNomAlumno();
		String apellido = leerApeAlumno();
		int edad = leerEdadAlumno();
		String dni = leerDniAlumno();
		int cel = leerCelAlumno();
		int estado = 0;

		Alumno dnis = alum.buscarDni(dni);

		if (dnis == null) {

			Alumno alumn = new Alumno(codigo, edad, cel, estado, nombre, apellido, dni);
			alum.adicionar(alumn);

		} else {
			mensaje("El DNI se encuentra registrado");
		}
	}

	void listar() {
		Alumno x;
		modelo.setRowCount(0);
		for (int i = 0; i < alum.tamaño(); i++) {
			x = alum.obtener(i);
			Object[] fila = { x.getCodigoAlumno(), x.getEstado(), x.getEdad(), x.getCelular(), x.getNombre(),
					x.getApellido(), x.getDni() };
			modelo.addRow(fila);
		}

	}

	void consultar() {
		Alumno a = alum.buscar(leerCodigo());
		if (a != null) {
			txtNomAlumno.setText(a.getNombre());
			txtApeAlumno.setText(a.getApellido());
			txtCelularAlumno.setText("" + a.getCelular());
			txtDniAlumno.setText("" + a.getDni());
			txtEdadAlumno.setText("" + a.getEdad());
		}

		else {
			mensaje("El codigo no existe");
		}

	}

	void modificarAlumno() {
		try {
			int codigo = leerCodigo();
			Alumno a = alum.buscar(codigo);
			if (a != null) {
				String nombre = leerNomAlumno();
				String apellido = leerApeAlumno();
				String dni = leerDniAlumno();
				int celular = leerCelAlumno();
				int edad = leerEdadAlumno();
				a.SetCodigoAlumno(codigo);
				a.setNombre(nombre);
				a.setApellido(apellido);
				a.setDni(dni);
				a.setCelular(celular);
				a.setEdad(edad);
				listar();

			}
		} catch (Exception e) {
			mensaje("Llenar todos los campos");

		}

	}

	void eliminarAlumno() {
		int codigo = leerCodigo();
		Alumno a = alum.buscar(codigo);
		if (a != null) {

			int confirm = JOptionPane.showConfirmDialog(null, " Desea Eliminar ?");
			// 0=yes, 1=no, 2=cancel
			System.out.println(confirm);

			if (confirm == 0) {
				alum.eliminar(a);
				listar();

			}

		} else {
			mensaje("Ingresar Codigo");
		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

}
