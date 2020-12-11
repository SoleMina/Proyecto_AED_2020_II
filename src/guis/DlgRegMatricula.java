package guis;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Arreglo.ArregloAlumno;
import Arreglo.ArregloCurso;
import Arreglo.ArregloMatricula;
import clases.Alumno;
import clases.Matricula;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DlgRegMatricula extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigoMatri;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JLabel lblNewLabel;
	private JComboBox<String> cboCodAlumno;
	private JLabel lblMatriculaMatri;
	private JComboBox<String> cboCurso;
	private JScrollPane scrollPane;
	private JButton btnAdicionar_Matricula;
	private JButton btnModificar_Matricula;
	private JButton btnEliminar_Matricula;
	private JButton btnConsultar_Matricula;
	private JTable tblMatricula;
	private JButton btnOpciones;
	
	
	private DefaultTableModel modelo;
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
					DlgRegMatricula dialog = new DlgRegMatricula();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegMatricula() {
		setResizable(false);
		setModal(true);
		setTitle("Registro | Matricula");
		setBounds(100, 100, 600, 360);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Numero");
		lblCodigo.setBounds(10, 15, 82, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigoMatri = new JTextField();
		txtCodigoMatri.setColumns(10);
		txtCodigoMatri.setBounds(102, 12, 142, 20);
		getContentPane().add(txtCodigoMatri);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 40, 82, 14);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		//txtFecha.setText();
		txtFecha.setColumns(10);
		txtFecha.setBounds(102, 37, 142, 20);
		getContentPane().add(txtFecha);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(271, 15, 42, 14);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(307, 12, 56, 20);
		getContentPane().add(txtHora);
		
		lblNewLabel = new JLabel("Cod. Alumno");
		lblNewLabel.setBounds(10, 65, 82, 14);
		getContentPane().add(lblNewLabel);
		
		cboCodAlumno = new JComboBox<String>();
		for (int i = 0; i < listaalumnos.tamaño(); i++) {
			cboCodAlumno.addItem(listaalumnos.obtener(i).getCodigoAlumno()+"");
		}
		cboCodAlumno.setEnabled(false);
		cboCodAlumno.setBounds(102, 61, 142, 22);
		getContentPane().add(cboCodAlumno);
		
		lblMatriculaMatri = new JLabel("Cod. Curso");
		lblMatriculaMatri.setBounds(10, 90, 82, 14);
		getContentPane().add(lblMatriculaMatri);
		
		cboCurso = new JComboBox<String>();
		for (int i = 0; i < listaCurso.tamaño(); i++) {
			cboCurso.addItem(listaCurso.obtener(i).getCodigoCurso()+"");
		}
		
		//cboMatricula.setModel(new DefaultComboBoxModel <String> (new String[] {"Matem\u00E1tica II", "Base de datos"}));
		cboCurso.setEnabled(false);
		cboCurso.setBounds(102, 86, 142, 22);
		getContentPane().add(cboCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 564, 195);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero", "Cod. Alumno", "Cod. Curso", "Fecha", "Hora" }) {

			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(tblMatricula);
		
		btnAdicionar_Matricula = new JButton("Adicionar");
		btnAdicionar_Matricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tipoDeOperacion = ADICIONAR;
				
				txtCodigoMatri.setText("");
				txtCodigoMatri.setText("" + listaMatriculas.codigoCorrelativo());
				txtFecha.setText(getFechaActual());
				txtHora.setText(getHotaActual());				
				
				habilitarEntradas(true);
				habilitarBotones(false);
			}
		});
		btnAdicionar_Matricula.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionar_Matricula);
		
		btnModificar_Matricula = new JButton("Modificar");
		btnModificar_Matricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar_Matricula.setBounds(485, 61, 89, 23);
		getContentPane().add(btnModificar_Matricula);
		
		btnEliminar_Matricula = new JButton("Eliminar");
		btnEliminar_Matricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCodigoMatri.getText().length() <= 0 || txtCodigoMatri.getText().equals(null)) {
					mensaje("Ingrese un Numero de Matricula Valido!!");
				} else {
					eliminarMatricula(); 
				}

				
			}
		});
		btnEliminar_Matricula.setBounds(485, 86, 89, 23);
		getContentPane().add(btnEliminar_Matricula);
		
		btnConsultar_Matricula = new JButton("Consultar");
		btnConsultar_Matricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tipoDeOperacion = CONSULTAR;
				
				txtCodigoMatri.setText("");
				txtCodigoMatri.setEditable(true);
				habilitarBotones(false);
				txtCodigoMatri.requestFocus();
			}
		});
		btnConsultar_Matricula.setBounds(485, 36, 89, 23);
		getContentPane().add(btnConsultar_Matricula);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBotones(true);
				habilitarEntradas(false);
				limpiarCampos();
				btnGuardar.setEnabled(false);
				txtCodigoMatri.setEditable(false);
			}
		});
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(386, 11, 89, 93);
		getContentPane().add(btnOpciones);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tipoDeOperacion == ADICIONAR) {
					agregarMatricula();
					listarMatriculas();
					limpiarCampos();
					txtCodigoMatri.setText("" + listaMatriculas.codigoCorrelativo());
				} else {

					modificarMatricula();
					limpiarCampos();
				}
			}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(271, 61, 92, 23);
		getContentPane().add(btnGuardar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigoMatri.setEditable(false);
				btnBuscar.setEnabled(true);
				if (tipoDeOperacion == CONSULTAR) {
					btnGuardar.setEnabled(false);
					txtCodigoMatri.setEditable(true);
					txtCodigoMatri.setEnabled(true);
					//cboCodAlumno.setEditable(false);
					//cboCurso.setEditable(false);
				} else {
					btnGuardar.setEnabled(true);
					//cboCodAlumno.setEnabled(true);
					//cboCurso.setEnabled(true);
				}
				consultaMatricula();
				//modificarMatricula();
				habilitarEntradas(false);
			}
		});
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(271, 86, 92, 23);
		getContentPane().add(btnBuscar);
		
		
		modelo = (DefaultTableModel) tblMatricula.getModel();

		listarMatriculas();
	}
	
	
	
	
	
	
	
	
	
	ArregloMatricula listaMatriculas = new ArregloMatricula();
	ArregloAlumno listaalumnos = new ArregloAlumno();
	ArregloCurso listaCurso = new ArregloCurso();
	private JButton btnGuardar;
	private JButton btnBuscar;

	public void listarMatriculas() {
		Matricula x;
		modelo.setRowCount(0);
		for (int i = 0; i < listaMatriculas.tamaño(); i++) {
			x = listaMatriculas.obtener(i);
			Object[] fila = { x.getNumMatricula(), x.getCodAlumno(), x.getCodCurso(), x.getFecha(), x.getHora() };
			modelo.addRow(fila);
		}

	}

	public void habilitarEntradas(boolean estado) {
		//txtCodigoMatri.setEditable(estado);
		txtFecha.setEditable(false);
		txtHora.setEditable(false);
		cboCodAlumno.setEnabled(estado);
		cboCurso.setEnabled(estado);
	}

	public void habilitarBotones(boolean estado) {

		if (tipoDeOperacion == ADICIONAR)
			btnGuardar.setEnabled(!estado);
		else {
			btnBuscar.setEnabled(!estado);
			btnGuardar.setEnabled(estado);
		}
		btnAdicionar_Matricula.setEnabled(estado);
		btnConsultar_Matricula.setEnabled(estado);
		btnEliminar_Matricula.setEnabled(estado);
		btnModificar_Matricula.setEnabled(estado);
		btnOpciones.setEnabled(!estado);

	}

	public void limpiarCampos() {
		txtFecha.setText("");
		txtHora.setText("");
	}

	public void agregarMatricula() {

		int codigo = Integer.parseInt(txtCodigoMatri.getText().trim());
		String fecha = txtFecha.getText().trim();
		String horas = txtHora.getText().trim();
		
		int codAlumno = Integer.parseInt(cboCodAlumno.getSelectedItem().toString());
		int codCurso = Integer.parseInt(cboCurso.getSelectedItem().toString());

		Matricula Matricula = new Matricula(codigo, codAlumno, codCurso, fecha, horas);
		listaMatriculas.adicionar(Matricula);
		
		// cambiar estado de Alumno a 1
		actualizarEstadoAlumno(codAlumno);
	}

	public void consultaMatricula() {

		Matricula matricula = listaMatriculas.buscar(Integer.parseInt(txtCodigoMatri.getText().trim()));

		if (matricula != null) {

			txtCodigoMatri.setText("" + matricula.getNumMatricula());
			cboCodAlumno.setSelectedItem(""+matricula.getCodAlumno());
			cboCurso.setSelectedItem(""+matricula.getCodCurso());
			txtFecha.setText(matricula.getFecha());
			txtHora.setText(matricula.getHora());
		} else {
			mensaje("El codigo del Matricula no existe!!");
		}

	}

	public void modificarMatricula() {

		try {

			int codigo = Integer.parseInt(txtCodigoMatri.getText().trim());

			Matricula matricula = listaMatriculas.buscar(codigo);

			if (matricula != null) {

				matricula.setNumMatricula(codigo);
				//matricula.setCiclo(Integer.parseInt(txtCicloMatricula.getText().trim()));
				//matricula.setcreditos(Integer.parseInt(txtNcreditosMatricula.getText().trim()));
				matricula.setFecha(txtFecha.getText().trim());
				matricula.setHora(txtHora.getText().trim());

				listarMatriculas();

			}
		} catch (Exception e) {
			mensaje("Llenar todos los campos");

		}

	}

	public void eliminarMatricula() {

		int codigo = Integer.parseInt(txtCodigoMatri.getText().trim());
		
		Matricula matricula = listaMatriculas.buscar(codigo);

		if (matricula != null) {

			int confirm = JOptionPane.showConfirmDialog(null, " Desea Eliminar el Matricula ?");
			// 0=yes, 1=no, 2=cancel
			System.out.println(confirm);

			if (confirm == 0) {
				listaMatriculas.eliminar(matricula);
				listarMatriculas();
			}

		} else {
			mensaje("Ingresar Codigo Valido!!");
		}
	}

	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	public boolean validarCamposLlenos(String ciclos, String creditos, String horas, String asignatura) {

		boolean estado = true;

		if (asignatura.trim().length() <= 0 || asignatura.equals(null)) {
			estado = false;
		}

		if (ciclos.trim().length() <= 0 || ciclos.equals(null)) {
			estado = false;
		}

		if (creditos.trim().length() <= 0 || creditos.equals(null)) {
			estado = false;
		}

		if (horas.trim().length() <= 0 || horas.equals(null)) {
			estado = false;
		}

		return estado;
	}

	public String getFechaActual() {
		
		Date date = new Date();
		System.out.println("Fecha Actual-->"+date.toString());
	
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		String convertido = fecha.format(date);

		return convertido;
	}
	
	public String getHotaActual() {
		
		Date date = new Date();
		System.out.println("Fecha Actual-->"+date.toString());
		
		DateFormat hora = new SimpleDateFormat("HH:mm:ss");
		String convertido = hora.format(date);
		
		return convertido;
	}
	
	public void actualizarEstadoAlumno(int codAlumno) {
		
		Alumno alumno = listaalumnos.buscar(codAlumno);
		System.out.println("Objeto-->"+alumno);
		
		listaalumnos.eliminar(alumno);
		alumno.setEstado(1);
		listaalumnos.adicionar(alumno);
		
	}
}
