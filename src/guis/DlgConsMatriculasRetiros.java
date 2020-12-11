package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Arreglo.ArregloAlumno;
import Arreglo.ArregloCurso;
import Arreglo.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DlgConsMatriculasRetiros extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumeroMatricula;
	private JTextField txtCodigo;
	private JButton btnBuscar_MatriRet;
	private JLabel lblNewLabel;
	private JTextPane txtPanelAlumno;
	private JLabel lblDatosDelCurso;
	private JTextPane txtPanelCurso;
	private JComboBox<String> cboTipoBusqueda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsMatriculasRetiros dialog = new DlgConsMatriculasRetiros();
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
	public DlgConsMatriculasRetiros() {
		setResizable(false);
		setModal(true);
		setTitle("Consulta | Matr\u00EDculas y retiros");
		setBounds(100, 100, 600, 390);
		getContentPane().setLayout(null);

		lblNumeroMatricula = new JLabel("Buscar por :");
		lblNumeroMatricula.setBounds(10, 15, 124, 14);
		getContentPane().add(lblNumeroMatricula);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(290, 12, 120, 20);
		getContentPane().add(txtCodigo);

		btnBuscar_MatriRet = new JButton("Buscar");
		btnBuscar_MatriRet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar_MatriRet.setBounds(485, 11, 89, 23);
		getContentPane().add(btnBuscar_MatriRet);

		lblNewLabel = new JLabel("Datos del Alumno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 87, 149, 15);
		getContentPane().add(lblNewLabel);

		txtPanelAlumno = new JTextPane();
		txtPanelAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPanelAlumno.setEditable(false);
		txtPanelAlumno.setBounds(21, 113, 261, 178);
		getContentPane().add(txtPanelAlumno);

		lblDatosDelCurso = new JLabel("Datos del Curso");
		lblDatosDelCurso.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDatosDelCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosDelCurso.setBounds(324, 88, 129, 14);
		getContentPane().add(lblDatosDelCurso);

		txtPanelCurso = new JTextPane();
		txtPanelCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPanelCurso.setEditable(false);
		txtPanelCurso.setBounds(324, 113, 249, 178);
		getContentPane().add(txtPanelCurso);

		cboTipoBusqueda = new JComboBox<String>();
		cboTipoBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboTipoBusqueda.setModel(new DefaultComboBoxModel<String>(new String[] { "Numero de Matricula", "Numero de Retiro" }));
		cboTipoBusqueda.setBounds(96, 11, 173, 22);
		getContentPane().add(cboTipoBusqueda);

	}

	ArregloMatricula listaMatriculas = new ArregloMatricula();
	ArregloAlumno listaalumnos = new ArregloAlumno();
	ArregloCurso listaCurso = new ArregloCurso();

	public void buscar() {

		String codMatricula = txtCodigo.getText().trim();
		// 0 = codigo Matricula    1 = codigo Retiro
		int tipoDeBusqueda =  cboTipoBusqueda.getSelectedIndex();

		if (codMatricula.length() <= 0 || codMatricula.equals(null) ) {
			mensaje("Ingrese el Codigo de Busqueda!!");
		} else {
			
			if(tipoDeBusqueda == 0) {
				
				Matricula matricula = listaMatriculas.buscar(Integer.parseInt(codMatricula));
				
				if(matricula != null) { 
					
					Alumno alumno = listaalumnos.buscar(matricula.getCodAlumno());
					Curso curso = listaCurso.buscar(matricula.getCodCurso());
					
					String datosAlumno = "";
					datosAlumno += "Cod. Alumno:   " + alumno.getCodigoAlumno() + "\n";
					datosAlumno += "Nombre:   " + alumno.getNombre() + "\n";
					datosAlumno += "Apellidos:   " + alumno.getApellido() + "\n";
					datosAlumno += "DNI:   " + alumno.getDni() + "\n";
					datosAlumno += "Edad:   " + alumno.getEdad() + "\n";
					datosAlumno += "Celular:   " + alumno.getCelular() + "\n";
					txtPanelAlumno.setText(datosAlumno);
					
					String datosCurso = "";
					datosCurso += "Cod. Curso:   " + curso.getCodigoCurso() + "\n";
					datosCurso += "Asignatura:   " + curso.getAsignatura() + "\n";
					datosCurso += "Ciclo:   " + curso.getCiclo() + "\n";
					datosCurso += "Creditos:   " + curso.getcreditos() + "\n";
					datosCurso += "Horas:   " + curso.gethoras() + "\n";
					txtPanelCurso.setText(datosCurso);
					
				} else {
					mensaje("El Matricula no existe!!");
				}
				
			} else {
				// buscar RETIRO
			}
		}
	}

	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
}
