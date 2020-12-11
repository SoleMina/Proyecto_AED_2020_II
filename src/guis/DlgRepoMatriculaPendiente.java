package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Arreglo.ArregloAlumno;
import clases.Alumno;

import javax.swing.JTable;

public class DlgRepoMatriculaPendiente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgRepoMatriculaPendiente dialog = new DlgRepoMatriculaPendiente();
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
	public DlgRepoMatriculaPendiente() {
		setModal(true);
		setResizable(false);
		setTitle("Reporte | Alumnos con matr\u00EDcula pendiente");
		setBounds(100, 100, 600, 360);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 564, 299);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Estado", "Edad", "Celular", "Nombres", "Apellidos", "DNI" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(63);
		scrollPane.setViewportView(table);
		modelo = (DefaultTableModel) table.getModel();

		alumnosPendiebtes();
	}

	ArregloAlumno listaalumnos = new ArregloAlumno();

	public void alumnosPendiebtes() {

		Alumno alumno;

		modelo.setRowCount(0);

		for (int i = 0; i < listaalumnos.tamaño(); i++) {

			alumno = listaalumnos.obtener(i);

			if (alumno.getEstado() == 0) {
				Object[] fila = { alumno.getCodigoAlumno(), "PENDIENTE", alumno.getEdad(), alumno.getCelular(),
						alumno.getNombre(), alumno.getApellido(), alumno.getDni() };
				modelo.addRow(fila);
			}

		}

	}

}
