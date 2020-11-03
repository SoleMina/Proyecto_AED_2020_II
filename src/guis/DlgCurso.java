package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgCurso extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCurso dialog = new DlgCurso();
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
	public DlgCurso() {
		setTitle("Mantenimiento - Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
