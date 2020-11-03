package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proyecto_AED_2020_II extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmAlumnosYCursos;
	private JMenuItem mntmMatriculasYRetiros;
	private JMenuItem mntmAlumnosConMatrcula;
	private JMenuItem mntmAlumnosConMatrcula_1;
	private JMenuItem mntmAlumnosMatriculadosPor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_AED_2020_II frame = new Proyecto_AED_2020_II();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto_AED_2020_II() {
		setTitle("Proyecto AED 2020 II desarrollado por ABC SRL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnNewMenu.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.addActionListener(this);
		mnRegistro.add(mntmMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmAlumnosYCursos = new JMenuItem("Alumnos y cursos");
		mntmAlumnosYCursos.addActionListener(this);
		mnConsulta.add(mntmAlumnosYCursos);
		
		mntmMatriculasYRetiros = new JMenuItem("Matriculas y retiros");
		mntmMatriculasYRetiros.addActionListener(this);
		mnConsulta.add(mntmMatriculasYRetiros);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmAlumnosConMatrcula = new JMenuItem("Alumnos con matrícula pendiente");
		mntmAlumnosConMatrcula.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatrcula);
		
		mntmAlumnosConMatrcula_1 = new JMenuItem("Alumnos con matrícula vigente");
		mntmAlumnosConMatrcula_1.addActionListener(this);
		mnReporte.add(mntmAlumnosConMatrcula_1);
		
		mntmAlumnosMatriculadosPor = new JMenuItem("Alumnos matriculados por curso");
		mntmAlumnosMatriculadosPor.addActionListener(this);
		mnReporte.add(mntmAlumnosMatriculadosPor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAlumnosMatriculadosPor) {
			actionPerformedMntmAlumnosMatriculadosPor(e);
		}
		if (e.getSource() == mntmAlumnosConMatrcula_1) {
			actionPerformedMntmAlumnosConMatrcula_1(e);
		}
		if (e.getSource() == mntmAlumnosConMatrcula) {
			actionPerformedMntmAlumnosConMatrcula(e);
		}
		if (e.getSource() == mntmMatriculasYRetiros) {
			actionPerformedMntmMatriculasYRetiros(e);
		}
		if (e.getSource() == mntmAlumnosYCursos) {
			actionPerformedMntmAlumnosYCursos(e);
		}
		if (e.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(e);
		}
		if (e.getSource() == mntmMatricula) {
			actionPerformedMntmMatricula(e);
		}
		if (e.getSource() == mntmCurso) {
			actionPerformedMntmCurso(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		DlgAlumno da = new DlgAlumno();
		da.setLocationRelativeTo(this);
		da.setVisible(true);
		
		
	}
	protected void actionPerformedMntmCurso(ActionEvent e) {
		DlgCurso dc = new DlgCurso();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmMatricula(ActionEvent e) {
		DlgMatricula dm =  new DlgMatricula();
		dm.setLocationRelativeTo(this);
		dm.setVisible(true);
		
	}
	
	protected void actionPerformedMntmRetiro(ActionEvent e) {
		DlgRetiro dr = new DlgRetiro();
		dr.setLocationRelativeTo(this);
		dr.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosYCursos(ActionEvent e) {
		DlgAlumnoCurso dac = new DlgAlumnoCurso();
		dac.setLocationRelativeTo(this);
		dac.setVisible(true);
	}
	protected void actionPerformedMntmMatriculasYRetiros(ActionEvent e) {
		DlgMatriculaRetiro dmr = new DlgMatriculaRetiro();
		dmr.setLocationRelativeTo(this);
		dmr.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosConMatrcula(ActionEvent e) {
		DlgMatriculaPendiente dmp = new DlgMatriculaPendiente();
		dmp.setLocationRelativeTo(this);
		dmp.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosConMatrcula_1(ActionEvent e) {
		DlgMatriculaVigente dmv = new DlgMatriculaVigente();
		dmv.setLocationRelativeTo(this);
		dmv.setVisible(true);
	}
	protected void actionPerformedMntmAlumnosMatriculadosPor(ActionEvent e) {
		DlgMatriculadosCurso dmc = new DlgMatriculadosCurso();
		dmc.setLocationRelativeTo(this);
		dmc.setVisible(true);
	}

}
