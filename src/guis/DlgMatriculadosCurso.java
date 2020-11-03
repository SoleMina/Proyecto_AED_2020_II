package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgMatriculadosCurso extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatriculadosCurso dialog = new DlgMatriculadosCurso();
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
	public DlgMatriculadosCurso() {
		setTitle("Reporte - Alumnos Matriculados por Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
