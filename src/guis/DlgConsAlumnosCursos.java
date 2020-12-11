package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Arreglo.ArregloAlumno;
import Arreglo.ArregloCurso;
import Arreglo.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class DlgConsAlumnosCursos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoAlumno;
	private JTextField txtCodCurso;
	private JTextField txtCodAlumno;
	private JLabel lblCodigoCurso;
	private JButton btnBuscar;

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
		lblCodigoAlumno.setBounds(10, 15, 90, 14);
		getContentPane().add(lblCodigoAlumno);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(127, 37, 109, 20);
		getContentPane().add(txtCodCurso);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBounds(127, 12, 109, 20);
		getContentPane().add(txtCodAlumno);
		
		lblCodigoCurso = new JLabel("Codigo Curso");
		lblCodigoCurso.setBounds(10, 40, 90, 14);
		getContentPane().add(lblCodigoCurso);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buscar();
			}
		});
		btnBuscar.setBounds(471, 11, 103, 23);
		getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Datos del Alumno");
		lblNewLabel.setBounds(10, 98, 149, 15);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDatosDelCurso = new JLabel("Datos del Curso");
		lblDatosDelCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosDelCurso.setBounds(308, 99, 129, 14);
		getContentPane().add(lblDatosDelCurso);
		lblDatosDelCurso.setVerticalAlignment(SwingConstants.BOTTOM);
		
		txtPanelAlumno = new JTextPane();
		txtPanelAlumno.setEditable(false);
		txtPanelAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPanelAlumno.setBounds(10, 124, 261, 178);
		getContentPane().add(txtPanelAlumno);
		
		txtPanelCurso = new JTextPane();
		txtPanelCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPanelCurso.setEditable(false);
		txtPanelCurso.setBounds(308, 124, 249, 178);
		getContentPane().add(txtPanelCurso);

	}
	
	
	ArregloMatricula listaMatriculas = new ArregloMatricula();
	ArregloAlumno listaalumnos = new ArregloAlumno();
	ArregloCurso listaCurso = new ArregloCurso();
	private JTextPane txtPanelAlumno;
	private JTextPane txtPanelCurso;
	
	
	public void buscar() {
		
		String codAlumno = txtCodAlumno.getText().trim();
		String codCurso = txtCodCurso.getText().trim();
		
		if(codAlumno.length() <= 0 || codAlumno.equals(null) || codCurso.length() <= 0 || codCurso.equals(null)) {
			mensaje("Ingrese los campos!!");
		} else {
		
			 Alumno alumno = listaalumnos.buscar(Integer.parseInt(codAlumno));
			 
			 if(alumno != null) {
				 
				 Matricula matricula = listaMatriculas.buscarPorAlumnoCurso(Integer.parseInt(codAlumno), Integer.parseInt(codCurso));
				 
				 if(matricula != null) {
					 // falta validar que el estado del alumno este en 1 para confirmar que este matriculado
					 // el alumno esta matriculado en el curso
					 // setear los datos del alumno y del CURSO
					 
					 Curso curso = listaCurso.buscar(Integer.parseInt(codCurso));
					 
					 String datosAlumno = "";
					 
					 datosAlumno += "Cod. Alumno:   "+alumno.getCodigoAlumno()+"\n";
					 datosAlumno += "Nombre:   "+alumno.getNombre()+"\n";
					 datosAlumno += "Apellidos:   "+alumno.getApellido()+"\n";
					 datosAlumno += "DNI:   "+alumno.getDni()+"\n";
					 datosAlumno += "Edad:   "+alumno.getEdad()+"\n";
					 datosAlumno += "Celular:   "+alumno.getCelular()+"\n";
					 
					 txtPanelAlumno.setText(datosAlumno);
					 
					 String datosCurso = "";
					 datosCurso += "Cod. Curso:   "+curso.getCodigoCurso()+"\n";
					 datosCurso += "Asignatura:   "+curso.getAsignatura()+"\n";
					 datosCurso += "Ciclo:   "+curso.getCiclo()+"\n";
					 datosCurso += "Creditos:   "+curso.getcreditos()+"\n";
					 datosCurso += "Horas:   "+curso.gethoras()+"\n";
					 					 
					 txtPanelCurso.setText(datosCurso);
				 } else {
					 
					 // setear solo los datos del alumno
					 String datosAlumno = "";
					 
					 datosAlumno += "Cod. Alumno:   "+alumno.getCodigoAlumno()+"\n";
					 datosAlumno += "Nombre:   "+alumno.getNombre()+"\n";
					 datosAlumno += "Apellidos:   "+alumno.getApellido()+"\n";
					 datosAlumno += "DNI:   "+alumno.getDni()+"\n";
					 datosAlumno += "Edad:   "+alumno.getEdad()+"\n";
					 datosAlumno += "Celular:   "+alumno.getCelular()+"\n";
					 
					 txtPanelAlumno.setText(datosAlumno);
					 
					 String datosCurso = "";
					 datosCurso += "El Alumno no se encuentra Matriculado en el Curso";
					 txtPanelCurso.setText(datosCurso);
				 }
			 } else {
				 mensaje("El Alumno no existe!!");
			 } 			 
		}
	}
	
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
}
