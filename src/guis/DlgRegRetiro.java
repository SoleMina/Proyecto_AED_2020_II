package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class DlgRegRetiro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoRetiro;
	private JTextField txtCodigoRetiro;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JLabel lblCodigoAlumno;
	private JComboBox<String> cboCodAlumno;
	private JLabel lblCursoMatri;
	private JComboBox<String> cboCurso;
	private JButton btnEliminar_Retiro;
	private JButton btnModificar_Retiro;
	private JButton btnConsultar_Retiro;
	private JButton btnAdicionar_Retiro;
	private JScrollPane scrollPane;
	private JTable tblRetiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgRegRetiro dialog = new DlgRegRetiro();
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
	public DlgRegRetiro() {
		setResizable(false);
		setModal(true);
		setTitle("Registro | Retiro");
		setBounds(100, 100, 600, 360);
		getContentPane().setLayout(null);
		
		lblCodigoRetiro = new JLabel("Codigo");
		lblCodigoRetiro.setBounds(10, 17, 46, 14);
		getContentPane().add(lblCodigoRetiro);
		
		txtCodigoRetiro = new JTextField();
		txtCodigoRetiro.setEditable(false);
		txtCodigoRetiro.setColumns(10);
		txtCodigoRetiro.setBounds(76, 11, 119, 20);
		getContentPane().add(txtCodigoRetiro);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 42, 46, 14);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(76, 36, 119, 20);
		getContentPane().add(txtFecha);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(205, 42, 23, 14);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(238, 39, 110, 20);
		getContentPane().add(txtHora);
		
		lblCodigoAlumno = new JLabel("Cod. Alumno");
		lblCodigoAlumno.setBounds(10, 63, 61, 14);
		getContentPane().add(lblCodigoAlumno);
		
		cboCodAlumno = new JComboBox<String>();
		cboCodAlumno.setBounds(76, 59, 119, 22);
		getContentPane().add(cboCodAlumno);
		
		lblCursoMatri = new JLabel("Curso");
		lblCursoMatri.setBounds(10, 88, 46, 14);
		getContentPane().add(lblCursoMatri);
		
		cboCurso = new JComboBox<String>();
		cboCurso.setModel(new DefaultComboBoxModel <String> (new String[] {"Matem\u00E1tica II", "Base de Datos"}));
		cboCurso.setBounds(76, 84, 119, 22);
		getContentPane().add(cboCurso);
		
		btnEliminar_Retiro = new JButton("Eliminar");
		btnEliminar_Retiro.setBounds(485, 82, 89, 23);
		getContentPane().add(btnEliminar_Retiro);
		
		btnModificar_Retiro = new JButton("Modificar");
		btnModificar_Retiro.setBounds(485, 59, 89, 23);
		getContentPane().add(btnModificar_Retiro);
		
		btnConsultar_Retiro = new JButton("Consultar");
		btnConsultar_Retiro.setBounds(485, 38, 89, 23);
		getContentPane().add(btnConsultar_Retiro);
		
		btnAdicionar_Retiro = new JButton("Adicionar");
		btnAdicionar_Retiro.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionar_Retiro);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 564, 197);
		getContentPane().add(scrollPane);
		
		tblRetiro = new JTable();
		scrollPane.setViewportView(tblRetiro);

	}

}
