package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DlgManAlumno extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblcodAlumno;
	private JTextField txtcodAlumno;
	private JButton btnGuardar_Alumno;
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
		txtcodAlumno.setEditable(false);
		txtcodAlumno.setColumns(10);
		txtcodAlumno.setBounds(66, 12, 110, 20);
		getContentPane().add(txtcodAlumno);
		
		btnGuardar_Alumno = new JButton("Guardar");
		btnGuardar_Alumno.setBounds(277, 11, 89, 23);
		getContentPane().add(btnGuardar_Alumno);
		
		btnAdicionar_Alumno = new JButton("Adicionar");
		btnAdicionar_Alumno.setBounds(485, 11, 89, 23);
		getContentPane().add(btnAdicionar_Alumno);
		
		btnConsultar_Alumno = new JButton("Consultar");
		btnConsultar_Alumno.setBounds(485, 36, 89, 23);
		getContentPane().add(btnConsultar_Alumno);
		
		btnModificar_Alumno = new JButton("Modificar");
		btnModificar_Alumno.setBounds(485, 61, 89, 23);
		getContentPane().add(btnModificar_Alumno);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(485, 86, 89, 23);
		getContentPane().add(btnEliminar);
		
		txtEdadAlumno = new JTextField();
		txtEdadAlumno.setColumns(10);
		txtEdadAlumno.setBounds(277, 87, 89, 20);
		getContentPane().add(txtEdadAlumno);
		
		lblEdadAlumno = new JLabel("Edad");
		lblEdadAlumno.setBounds(232, 90, 35, 14);
		getContentPane().add(lblEdadAlumno);
		
		txtDniAlumno = new JTextField();
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
		txtNomAlumno.setColumns(10);
		txtNomAlumno.setBounds(66, 37, 300, 20);
		getContentPane().add(txtNomAlumno);
		
		txtApeAlumno = new JTextField();
		txtApeAlumno.setColumns(10);
		txtApeAlumno.setBounds(66, 62, 300, 20);
		getContentPane().add(txtApeAlumno);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 564, 200);
		getContentPane().add(scrollPane);
		
		tblAlumno = new JTable();
		scrollPane.setViewportView(tblAlumno);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(386, 11, 89, 98);
		getContentPane().add(btnOpciones);

	}


	public void actionPerformed(ActionEvent e) {
		
	}
}
