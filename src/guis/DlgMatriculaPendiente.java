package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgMatriculaPendiente extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatriculaPendiente dialog = new DlgMatriculaPendiente();
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
	public DlgMatriculaPendiente() {
		setTitle("Reporte - Alumnos con Matriculas Pendientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
