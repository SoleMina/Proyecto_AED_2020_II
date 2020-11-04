package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

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
	private JLabel lblCursoMatri;
	private JComboBox<String> cboCurso;
	private JScrollPane scrollPane;
	private JButton btnAdicionar_Matricula;
	private JButton btnModificar_Matricula;
	private JButton btnEliminar_Matricula;
	private JButton btnConsultar_Matricula;
	private JTable tblMatricula;

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
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 15, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigoMatri = new JTextField();
		txtCodigoMatri.setEditable(false);
		txtCodigoMatri.setColumns(10);
		txtCodigoMatri.setBounds(81, 12, 119, 20);
		getContentPane().add(txtCodigoMatri);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 40, 46, 14);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(81, 37, 119, 20);
		getContentPane().add(txtFecha);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(210, 40, 23, 14);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(243, 37, 110, 20);
		getContentPane().add(txtHora);
		
		lblNewLabel = new JLabel("Cod. Alumno");
		lblNewLabel.setBounds(10, 65, 61, 14);
		getContentPane().add(lblNewLabel);
		
		cboCodAlumno = new JComboBox<String>();
		cboCodAlumno.setBounds(81, 61, 119, 22);
		getContentPane().add(cboCodAlumno);
		
		lblCursoMatri = new JLabel("Curso");
		lblCursoMatri.setBounds(10, 90, 46, 14);
		getContentPane().add(lblCursoMatri);
		
		cboCurso = new JComboBox<String>();
		cboCurso.setModel(new DefaultComboBoxModel <String> (new String[] {"Matem\u00E1tica II", "Base de datos"}));
		cboCurso.setBounds(81, 86, 119, 22);
		getContentPane().add(cboCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 564, 195);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		scrollPane.setViewportView(tblMatricula);
		
		btnAdicionar_Matricula = new JButton("Adicionar");
		btnAdicionar_Matricula.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionar_Matricula);
		
		btnModificar_Matricula = new JButton("Modificar");
		btnModificar_Matricula.setBounds(485, 61, 89, 23);
		getContentPane().add(btnModificar_Matricula);
		
		btnEliminar_Matricula = new JButton("Eliminar");
		btnEliminar_Matricula.setBounds(485, 86, 89, 23);
		getContentPane().add(btnEliminar_Matricula);
		
		btnConsultar_Matricula = new JButton("Consultar");
		btnConsultar_Matricula.setBounds(485, 36, 89, 23);
		getContentPane().add(btnConsultar_Matricula);

	}

}
