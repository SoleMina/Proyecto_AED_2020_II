package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DlgConsAlumnosCursos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoAlumno;
	private JTextField txtCodCurso;
	private JTextField txtCodAlumno;
	private JLabel lblCodigoCurso;
	private JButton btnBuscar_AlumCurso;
	private JScrollPane scrollPane;
	private JTable tblAlumnosCursos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsAlumnosCursos dialog = new DlgConsAlumnosCursos();
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
	public DlgConsAlumnosCursos() {
		setResizable(false);
		setModal(true);
		setTitle("Consulta | Alumnos y cursos");
		setBounds(100, 100, 600, 390);
		getContentPane().setLayout(null);
		
		lblCodigoAlumno = new JLabel("Codigo Alumno");
		lblCodigoAlumno.setBounds(10, 15, 71, 14);
		getContentPane().add(lblCodigoAlumno);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(91, 37, 109, 20);
		getContentPane().add(txtCodCurso);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBounds(91, 12, 109, 20);
		getContentPane().add(txtCodAlumno);
		
		lblCodigoCurso = new JLabel("Codigo Curso");
		lblCodigoCurso.setBounds(10, 40, 76, 14);
		getContentPane().add(lblCodigoCurso);
		
		btnBuscar_AlumCurso = new JButton("Buscar");
		btnBuscar_AlumCurso.setBounds(471, 11, 103, 23);
		getContentPane().add(btnBuscar_AlumCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 564, 275);
		getContentPane().add(scrollPane);
		
		tblAlumnosCursos = new JTable();
		scrollPane.setViewportView(tblAlumnosCursos);

	}
}
