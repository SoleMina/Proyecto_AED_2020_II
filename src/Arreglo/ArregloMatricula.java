package Arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

import clases.Matricula;

public class ArregloMatricula {

	private ArrayList<Matricula> listaMatriculas;

	public ArregloMatricula() {
		listaMatriculas = new ArrayList<Matricula>();
		cargarMatricula();
	}

	public void adicionar(Matricula x) {
		listaMatriculas.add(x);
		grabarMatricula();

	}

	public int tamaño() {
		return listaMatriculas.size();
	}

	public Matricula obtener(int i) {
		return listaMatriculas.get(i);
	}

	public Matricula buscar(int code) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getNumMatricula() == code)
				return obtener(i);
		}
		return null;
	}

	public Matricula buscarDos(int cod) {

		Optional<Matricula> Matricula = listaMatriculas.stream().filter(a -> a.getNumMatricula() == cod).findFirst();

		return Matricula.isPresent() ? Matricula.get() : null;
	}

	public void eliminar(Matricula x) {
		listaMatriculas.remove(x);
		grabarMatricula();
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 100001;
		else
			return obtener(tamaño() - 1).getNumMatricula() + 1;
	}

	private void cargarMatricula() {
		try {
			BufferedReader al;
			String fecha, hora, linea;
			String[] s;
			int numMatricula, codAlumno, codCurso;

			// ordenar lista
			listaMatriculas.sort((a, b) -> Integer.compare(a.getNumMatricula(), b.getNumMatricula()));

			al = new BufferedReader(new FileReader("datos/matricula.txt"));

			while ((linea = al.readLine()) != null) {

				s = linea.split(";");
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();

				System.out.println("linea TXT-->" + linea);
				listaMatriculas.add(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
			}
			al.close();
		} catch (Exception e) {
		}

	}

	private void grabarMatricula() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("datos/matricula.txt"));

			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getNumMatricula() + ";" + x.getCodAlumno() + ";" + x.getCodCurso() + ";" + x.getFecha() + ";"
						+ x.getHora() + ";";
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public Matricula buscarPorAlumnoCurso(int codAlumno, int codCurso) {

		for (int i = 0; i < tamaño(); i++) {

			if (obtener(i).getCodAlumno() == codAlumno && obtener(i).getCodCurso() == codCurso)
				return obtener(i);
		}

		return null;
	}

}
