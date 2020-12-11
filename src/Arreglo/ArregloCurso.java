package Arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

import clases.Curso;

public class ArregloCurso {

	private ArrayList<Curso> listaCurso;

	public ArregloCurso() {
		listaCurso = new ArrayList<Curso>();
		cargarCurso();
	}

	public void adicionar(Curso x) {
		listaCurso.add(x);
		grabarCurso();

	}

	public int tamaño() {
		return listaCurso.size();
	}

	public Curso obtener(int i) {
		return listaCurso.get(i);
	}

	public Curso buscar(int code) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigoCurso() == code)
				return obtener(i);
		}
		return null;
	}

	public Curso buscarDos(int cod) {

		Optional<Curso> Curso = listaCurso.stream().filter(a -> a.getCodigoCurso() == cod).findFirst();

		return Curso.isPresent() ? Curso.get() : null;
	}

	public void eliminar(Curso x) {
		listaCurso.remove(x);
		grabarCurso();
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño() - 1).getCodigoCurso() + 1;
	}

	private void cargarCurso() {
		try {
			BufferedReader al;
			String asignatura, linea;
			String[] s;
			int codigoCurso, ciclo, creditos, horas;
			
			// ordenar lista
			listaCurso.sort( (a, b) -> Integer.compare(a.getCodigoCurso(),b.getCodigoCurso()));

			al = new BufferedReader(new FileReader("datos/curso.txt"));
			while ((linea = al.readLine()) != null) {
				s = linea.split(";");
				codigoCurso = Integer.parseInt(s[0].trim());
				ciclo = Integer.parseInt(s[1].trim());
				creditos = Integer.parseInt(s[2].trim());
				horas = Integer.parseInt(s[3].trim());
				asignatura = s[4].trim();

				System.out.println("linea TXT-->" + linea);
				listaCurso.add(new Curso(codigoCurso, ciclo, creditos, horas, asignatura));
			}
			al.close();
		} catch (Exception e) {
		}

	}

	private void grabarCurso() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("datos/curso.txt"));
			
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoCurso() + ";" + x.getCiclo() + ";" + x.getcreditos() + ";" + x.gethoras() + ";"+ x.getAsignatura() + ";";
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

}
