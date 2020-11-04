package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DlgConsMatriculasRetiros extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumeroMatricula;
	private JTextField txtNumMatricula;
	private JTextField txtNumRetiro;
	private JLabel lblNumeroDeRetiro;
	private JButton btnBuscar_MatriRet;
	private JScrollPane scrollPane;
	private JTable tblMatriculaRetiros;

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
	public DlgConsMatriculasRetiros() {
		setResizable(false);
		setModal(true);
		setTitle("Consulta | Matr\u00EDculas y retiros");
		setBounds(100, 100, 600, 390);
		getContentPane().setLayout(null);
		
		lblNumeroMatricula = new JLabel("N\u00FAmero de matr\u00EDcula");
		lblNumeroMatricula.setBounds(10, 15, 98, 14);
		getContentPane().add(lblNumeroMatricula);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setColumns(10);
		txtNumMatricula.setBounds(118, 12, 120, 20);
		getContentPane().add(txtNumMatricula);
		
		txtNumRetiro = new JTextField();
		txtNumRetiro.setColumns(10);
		txtNumRetiro.setBounds(118, 37, 120, 20);
		getContentPane().add(txtNumRetiro);
		
		lblNumeroDeRetiro = new JLabel("N\u00FAmero de retiro");
		lblNumeroDeRetiro.setBounds(10, 40, 98, 14);
		getContentPane().add(lblNumeroDeRetiro);
		
		btnBuscar_MatriRet = new JButton("Buscar");
		btnBuscar_MatriRet.setBounds(485, 11, 89, 23);
		getContentPane().add(btnBuscar_MatriRet);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 564, 272);
		getContentPane().add(scrollPane);
		
		tblMatriculaRetiros = new JTable();
		scrollPane.setViewportView(tblMatriculaRetiros);

	}

}
