package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;

import Arreglo.ArregloAlumno;
import Arreglo.ArregloCurso;
import Arreglo.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;

public class DlgRepoMatriculadosCurso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane txtPanelAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgRepoMatriculadosCurso dialog = new DlgRepoMatriculadosCurso();
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
	public DlgRepoMatriculadosCurso() {
		setResizable(false);
		setModal(true);
		setTitle("Reporte | Alumnos matriculados por curso");
		setBounds(100, 100, 600, 360);
		getContentPane().setLayout(null);
		
		txtPanelAlumno = new JTextPane();
		txtPanelAlumno.setEditable(false);
		txtPanelAlumno.setBounds(10, 24, 553, 276);
		getContentPane().add(txtPanelAlumno);
		
		alumnosPorCurso();
	}
	
	ArregloMatricula listaMatriculas = new ArregloMatricula();
	ArregloAlumno listaalumnos = new ArregloAlumno();
	ArregloCurso listaCurso = new ArregloCurso();
	
	public void alumnosPorCurso() {
		
		Curso curso;
		Matricula matricula;
		String datosAlumno = "";
		int cont=0;
		
		for (int i = 0; i < listaCurso.tamaño(); i++) {
			
			curso = listaCurso.obtener(i);
			System.out.println("CURSO-->"+curso);
			datosAlumno += "CURSO:   " + curso.getCodigoCurso()+" - "+curso.getAsignatura() + "\n";
			datosAlumno += "ALUMNOS:   ";
			for (int j = 0; j < listaMatriculas.tamaño(); j++) { 
				
				matricula = listaMatriculas.obtener(j);	
				if(curso.getCodigoCurso() == matricula.getCodCurso()) {
					System.out.println("ALUMNOS-->"+matricula.getCodAlumno());
					Alumno alumno = listaalumnos.buscar(matricula.getCodAlumno());
					datosAlumno += alumno.getNombre()+" "+ alumno.getApellido() + "  ,   ";
					cont++;
				}
			}
			
			if(cont <= 0) {
				datosAlumno += " No hay Alumnos Matriculados en el Curso";
			}
			
			datosAlumno += "\n\n";
			
			cont=0;
		}
		txtPanelAlumno.setText(datosAlumno);
	}
}
