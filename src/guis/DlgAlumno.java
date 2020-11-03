package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class DlgAlumno extends JDialog implements ActionListener {
	private JLabel lblCdigo;
	private JTextField textField;
	private JLabel lblNombres;
	private JTextField textField_1;
	private JLabel lblApellidos;
	private JTextField textField_2;
	private JLabel lblDni;
	private JTextField textField_3;
	private JLabel lblEdad;
	private JTextField textField_4;
	private JLabel lblCelular;
	private JTextField textField_5;
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumno dialog = new DlgAlumno();
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
	public DlgAlumno() {
		setTitle("Mantenimiento - Alumno");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(19, 22, 61, 16);
		getContentPane().add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(93, 13, 128, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(21, 47, 61, 16);
		getContentPane().add(lblNombres);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 40, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(20, 74, 61, 16);
		getContentPane().add(lblApellidos);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 67, 130, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(22, 101, 61, 16);
		getContentPane().add(lblDni);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 95, 89, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(190, 99, 36, 16);
		getContentPane().add(lblEdad);
		
		textField_4 = new JTextField();
		textField_4.setBounds(231, 93, 39, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(20, 128, 61, 16);
		getContentPane().add(lblCelular);
		
		textField_5 = new JTextField();
		textField_5.setBounds(98, 123, 130, 26);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 154, 409, 109);
		getContentPane().add(scrollPane);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(321, 8, 117, 29);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(322, 33, 117, 29);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(323, 59, 117, 29);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(323, 86, 117, 29);
		getContentPane().add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(323, 113, 117, 29);
		getContentPane().add(btnGuardar);

	}


	public void actionPerformed(ActionEvent e) {
		
	}
}
