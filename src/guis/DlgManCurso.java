package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Arreglo.ArregloCurso;
import clases.Alumno;
import clases.Curso;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class DlgManCurso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JButton btnGuardarCurso;
	private JButton btnBuscar;
	private JButton btnAdicionarCurso;
	private JButton btnConsultarCurso;
	private JButton btnModificarCurso;
	private JButton btnEliminarCurso;
	private JLabel lblAsignaturaCurso;
	private JTextField txtAsignaturaCurso;
	private JLabel lblCicloCurso;
	private JTextField txtCicloCurso;
	private JLabel lblNcreditosCurso;
	private JTextField txtNcreditosCurso;
	private JLabel lblHorasCurso;
	private JTextField txtHorasCurso;
	private JScrollPane scrollPane;
	private JTable tblCurso;
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
					DlgManCurso dialog = new DlgManCurso();
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
	public DlgManCurso() {
		setResizable(false);
		setModal(true);
		setTitle("Mantenimiento | Curso");
		setBounds(100, 100, 600, 390);
		getContentPane().setLayout(null);

		lblCodCurso = new JLabel("Codigo");
		lblCodCurso.setBounds(10, 15, 46, 14);
		getContentPane().add(lblCodCurso);

		txtCodCurso = new JTextField();
		txtCodCurso.setEditable(false);
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(66, 12, 86, 20);
		getContentPane().add(txtCodCurso);

		btnGuardarCurso = new JButton("Guardar");
		btnGuardarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean isCamposLlenos = validarCamposLlenos(txtCicloCurso.getText(), txtHorasCurso.getText(), txtNcreditosCurso.getText(), txtAsignaturaCurso.getText());
				
				if(isCamposLlenos) {
					
					if (tipoDeOperacion == ADICIONAR) {
						agregarCurso();
						listarCursos();
						limpiarCampos();
						txtCodCurso.setText("" + listaCursos.codigoCorrelativo());
					} else {

						modificarCurso();
						limpiarCampos();
					}
					
				} else {
					mensaje("Complete todos los campos!!");
				}
			}
		});
		btnGuardarCurso.setEnabled(false);
		btnGuardarCurso.setBounds(176, 11, 89, 23);
		getContentPane().add(btnGuardarCurso);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodCurso.setEditable(false);
				btnBuscar.setEnabled(true);
				if (tipoDeOperacion == CONSULTAR) {
					btnGuardarCurso.setEnabled(false);
				} else {
					btnGuardarCurso.setEnabled(true);
				}
				consultaCurso();
				modificarCurso();
				habilitarEntradas(true);
			}
		});
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(270, 11, 89, 23);
		getContentPane().add(btnBuscar);

		btnAdicionarCurso = new JButton("Adicionar");
		btnAdicionarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tipoDeOperacion = ADICIONAR;
				
				txtCodCurso.setText("");
				txtCodCurso.setText("" + listaCursos.codigoCorrelativo());
				habilitarEntradas(true);
				habilitarBotones(false);
			}
			
		});
		btnAdicionarCurso.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionarCurso);

		btnConsultarCurso = new JButton("Consultar");
		btnConsultarCurso.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				tipoDeOperacion = CONSULTAR;
				
				txtCodCurso.setText("");
				txtCodCurso.setEditable(true);
				habilitarBotones(false);
				txtCodCurso.requestFocus();
			}
		});
		btnConsultarCurso.setBounds(485, 36, 89, 23);
		getContentPane().add(btnConsultarCurso);

		btnModificarCurso = new JButton("Modificar");
		btnModificarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tipoDeOperacion = MODIFICAR;
				
				txtCodCurso.setEditable(true);
				habilitarBotones(false);
				txtCodCurso.requestFocus();
			}
		});
		btnModificarCurso.setBounds(485, 61, 89, 23);
		getContentPane().add(btnModificarCurso);

		btnEliminarCurso = new JButton("Eliminar");
		btnEliminarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCodCurso.getText().length() <= 0 || txtCodCurso.getText().equals(null)) {
					
					mensaje("Ingrese un Codigo de Curso Valido!!");
				} else {
					eliminarCurso();
				}	
			}
		});
		btnEliminarCurso.setBounds(485, 86, 89, 23);
		getContentPane().add(btnEliminarCurso);

		lblAsignaturaCurso = new JLabel("Asignatura");
		lblAsignaturaCurso.setBounds(10, 40, 52, 14);
		getContentPane().add(lblAsignaturaCurso);

		txtAsignaturaCurso = new JTextField();
		txtAsignaturaCurso.setEditable(false);
		txtAsignaturaCurso.setColumns(10);
		txtAsignaturaCurso.setBounds(66, 37, 300, 20);
		getContentPane().add(txtAsignaturaCurso);

		lblCicloCurso = new JLabel("Ciclo");
		lblCicloCurso.setBounds(10, 65, 46, 14);
		getContentPane().add(lblCicloCurso);

		txtCicloCurso = new JTextField();
		txtCicloCurso.setEditable(false);
		txtCicloCurso.setColumns(10);
		txtCicloCurso.setBounds(66, 62, 86, 20);
		getContentPane().add(txtCicloCurso);

		lblNcreditosCurso = new JLabel("N\u00B0 Cr\u00E9ditos");
		lblNcreditosCurso.setBounds(207, 65, 60, 14);
		getContentPane().add(lblNcreditosCurso);

		txtNcreditosCurso = new JTextField();
		txtNcreditosCurso.setEditable(false);
		txtNcreditosCurso.setColumns(10);
		txtNcreditosCurso.setBounds(277, 62, 89, 20);
		getContentPane().add(txtNcreditosCurso);

		lblHorasCurso = new JLabel("Horas");
		lblHorasCurso.setBounds(10, 90, 46, 14);
		getContentPane().add(lblHorasCurso);

		txtHorasCurso = new JTextField();
		txtHorasCurso.setEditable(false);
		txtHorasCurso.setColumns(10);
		txtHorasCurso.setBounds(66, 87, 86, 20);
		getContentPane().add(txtHorasCurso);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 564, 225);
		getContentPane().add(scrollPane);

		tblCurso = new JTable();
		tblCurso.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Ciclo", "Creditos", "Horas", "Asignatura" }) {

			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(tblCurso);

		modelo = (DefaultTableModel) tblCurso.getModel();

		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBotones(true);
				habilitarEntradas(false);
				limpiarCampos();
			}
		});
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(386, 11, 89, 98);
		getContentPane().add(btnOpciones);


		/************************* ****************************/

		listarCursos();

	}

	/*********************** Metodos ********************************/

	ArregloCurso listaCursos = new ArregloCurso();

	public void listarCursos() {
		Curso x;
		modelo.setRowCount(0);
		for (int i = 0; i < listaCursos.tamaño(); i++) {
			x = listaCursos.obtener(i);
			Object[] fila = { x.getCodigoCurso(), x.getCiclo(), x.getcreditos(), x.gethoras(), x.getAsignatura() };
			modelo.addRow(fila);
		}

	}

	public void habilitarEntradas(boolean estado) {
		txtAsignaturaCurso.setEditable(estado);
		txtCicloCurso.setEditable(estado);
		txtHorasCurso.setEditable(estado);
		txtNcreditosCurso.setEditable(estado);
	}

	public void habilitarBotones(boolean estado) {

		if (tipoDeOperacion == ADICIONAR)
			btnGuardarCurso.setEnabled(!estado);
		else {
			btnBuscar.setEnabled(!estado);
			btnGuardarCurso.setEnabled(estado);
		}
		btnAdicionarCurso.setEnabled(estado);
		btnConsultarCurso.setEnabled(estado);
		btnEliminarCurso.setEnabled(estado);
		btnModificarCurso.setEnabled(estado);
		btnOpciones.setEnabled(!estado);

	}

	public void limpiarCampos() {

		txtAsignaturaCurso.setText("");
		txtCicloCurso.setText("");
		txtHorasCurso.setText("");
		txtNcreditosCurso.setText("");
	}

	public void agregarCurso() {

		int codigo = Integer.parseInt(txtCodCurso.getText().trim());
		int ciclo = Integer.parseInt(txtCicloCurso.getText().trim());
		int creditos = Integer.parseInt(txtNcreditosCurso.getText().trim());
		int horas = Integer.parseInt(txtHorasCurso.getText().trim());
		String asignatura = txtAsignaturaCurso.getText().trim();

		Curso curso = new Curso(codigo, ciclo, creditos, horas, asignatura);
		listaCursos.adicionar(curso);
	}

	public void consultaCurso() {

		Curso curso = listaCursos.buscar(Integer.parseInt(txtCodCurso.getText().trim()));

		if (curso != null) {

			txtCicloCurso.setText("" + curso.getCiclo());
			txtNcreditosCurso.setText("" + curso.getcreditos());
			txtHorasCurso.setText("" + curso.gethoras());
			txtAsignaturaCurso.setText(curso.getAsignatura());
		} else {
			mensaje("El codigo del Curso no existe!!");
		}

	}

	public void modificarCurso() {

		try {

			int codigo = Integer.parseInt(txtCodCurso.getText().trim());

			Curso curso = listaCursos.buscar(codigo);

			if (curso != null) {

				curso.setCodigoCurso(codigo);
				curso.setCiclo(Integer.parseInt(txtCicloCurso.getText().trim()));
				curso.setcreditos(Integer.parseInt(txtNcreditosCurso.getText().trim()));
				curso.sethoras(Integer.parseInt(txtHorasCurso.getText().trim()));
				curso.setAsignatura(txtAsignaturaCurso.getText().trim());

				listarCursos();

			}
		} catch (Exception e) {
			mensaje("Llenar todos los campos");

		}

	}

	public void eliminarCurso() {

		int codigo = Integer.parseInt(txtCodCurso.getText().trim());

		Curso curso = listaCursos.buscar(codigo);

		if (curso != null) {

			int confirm = JOptionPane.showConfirmDialog(null, " Desea Eliminar el Curso ?");
			// 0=yes, 1=no, 2=cancel
			System.out.println(confirm);

			if (confirm == 0) {
				listaCursos.eliminar(curso);
				listarCursos();
			}

		} else {
			mensaje("Ingresar Codigo");
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

}
