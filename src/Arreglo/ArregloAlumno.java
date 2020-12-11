package Arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

import clases.Alumno;

public class ArregloAlumno {

	private ArrayList<Alumno> alu;

	public ArregloAlumno() {

		alu = new ArrayList<Alumno>();
		cargarAlumno();
	}

	public void adicionar(Alumno x) {
		alu.add(x);
		grabarAlumno();

	}

	public int tamaño() {
		return alu.size();
	}

	public Alumno obtener(int i) {
		return alu.get(i);
	}

	public Alumno buscar(int code) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigoAlumno() == code)
				return obtener(i);
		}
		return null;
	}

	public Alumno buscarDni(String dni) {
		Alumno x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);

			if (x.getDni().equals(dni))

				return x;
		}
		return null;
	}

	public Alumno buscarDos(int cod) {

		Optional<Alumno> alumno = alu.stream().filter(a -> a.getCodigoAlumno() == cod).findFirst();

		return alumno.isPresent() ? alumno.get() : null;
	}

	public void eliminar(Alumno x) {
		alu.remove(x);
		grabarAlumno();
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 202010001;
		else
			return obtener(tamaño() - 1).getCodigoAlumno() + 1;
	}

	private void cargarAlumno() {
		try {
			BufferedReader al;
			String nombre, apellido, dni, linea;
			String[] s;
			int codigoAlumno, edad, celular, estado;

			al = new BufferedReader(new FileReader("datos/alumno.txt"));
			while ((linea = al.readLine()) != null) {
				s = linea.split(";");
				codigoAlumno = Integer.parseInt(s[0].trim());
				edad = Integer.parseInt(s[1].trim());
				celular = Integer.parseInt(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				nombre = s[4].trim();
				apellido = s[5].trim();
				dni = s[6].trim();
				System.out.println("linea TXT-->"+ linea);
				alu.add(new Alumno(codigoAlumno, edad, celular, estado, nombre, apellido, dni));
			//	adicionar(new Alumno(codigoAlumno, edad, celular, estado, nombre, apellido, dni));
			}
			al.close();
		} catch (Exception e) {
		}

	}

	private void grabarAlumno() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("datos/alumno.txt"));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoAlumno() + ";" + x.getEdad() + ";" + x.getCelular() + ";" + x.getEstado() + ";"
						+ x.getNombre() + ";" + x.getApellido() + ";" + x.getDni() + ";";

				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

}
