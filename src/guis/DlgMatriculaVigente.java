package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgMatriculaVigente extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatriculaVigente dialog = new DlgMatriculaVigente();
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
	public DlgMatriculaVigente() {
		setTitle("Reporte - Alumnos con Matrícula Vigente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
