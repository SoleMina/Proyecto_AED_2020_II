package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DlgManCurso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JButton btnGuardar_Curso;
	private JButton btnAdicionar_Curso;
	private JButton btnConsultar_Curso;
	private JButton btnModificar_Curso;
	private JButton btnEliminar_Curso;
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
		
		btnGuardar_Curso = new JButton("Guardar");
		btnGuardar_Curso.setBounds(277, 11, 89, 23);
		getContentPane().add(btnGuardar_Curso);
		
		btnAdicionar_Curso = new JButton("Adicionar");
		btnAdicionar_Curso.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionar_Curso);
		
		btnConsultar_Curso = new JButton("Consultar");
		btnConsultar_Curso.setBounds(485, 36, 89, 23);
		getContentPane().add(btnConsultar_Curso);
		
		btnModificar_Curso = new JButton("Modificar");
		btnModificar_Curso.setBounds(485, 61, 89, 23);
		getContentPane().add(btnModificar_Curso);
		
		btnEliminar_Curso = new JButton("Eliminar");
		btnEliminar_Curso.setBounds(485, 86, 89, 23);
		getContentPane().add(btnEliminar_Curso);
		
		lblAsignaturaCurso = new JLabel("Asignatura");
		lblAsignaturaCurso.setBounds(10, 40, 52, 14);
		getContentPane().add(lblAsignaturaCurso);
		
		txtAsignaturaCurso = new JTextField();
		txtAsignaturaCurso.setColumns(10);
		txtAsignaturaCurso.setBounds(66, 37, 300, 20);
		getContentPane().add(txtAsignaturaCurso);
		
		lblCicloCurso = new JLabel("Ciclo");
		lblCicloCurso.setBounds(10, 65, 46, 14);
		getContentPane().add(lblCicloCurso);
		
		txtCicloCurso = new JTextField();
		txtCicloCurso.setColumns(10);
		txtCicloCurso.setBounds(66, 62, 86, 20);
		getContentPane().add(txtCicloCurso);
		
		lblNcreditosCurso = new JLabel("N\u00B0 Cr\u00E9ditos");
		lblNcreditosCurso.setBounds(207, 65, 60, 14);
		getContentPane().add(lblNcreditosCurso);
		
		txtNcreditosCurso = new JTextField();
		txtNcreditosCurso.setColumns(10);
		txtNcreditosCurso.setBounds(277, 62, 89, 20);
		getContentPane().add(txtNcreditosCurso);
		
		lblHorasCurso = new JLabel("Horas");
		lblHorasCurso.setBounds(10, 90, 46, 14);
		getContentPane().add(lblHorasCurso);
		
		txtHorasCurso = new JTextField();
		txtHorasCurso.setColumns(10);
		txtHorasCurso.setBounds(66, 87, 86, 20);
		getContentPane().add(txtHorasCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 564, 225);
		getContentPane().add(scrollPane);
		
		tblCurso = new JTable();
		scrollPane.setViewportView(tblCurso);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(386, 11, 89, 98);
		getContentPane().add(btnOpciones);

	}

}
