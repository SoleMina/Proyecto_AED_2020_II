package clases;

public class Curso {

	private int codigoCurso, ciclo, creditos, horas;
	private String asignatura;

	public Curso(int codigoCurso, int ciclo, int creditos, int horas, String asignatura) {
		
		this.codigoCurso = codigoCurso;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
		this.asignatura = asignatura;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public void setcreditos(int creditos) {
		this.creditos = creditos;
	}

	public void sethoras(int horas) {
		this.horas = horas;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public int getCiclo() {
		return ciclo;
	}

	public int getcreditos() {
		return creditos;
	}

	public int gethoras() {
		return horas;
	}

	public String getAsignatura() {
		return asignatura;
	}

	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", ciclo=" + ciclo + ", créditos=" + creditos + ", horas=" + horas
				+ ", asignatura=" + asignatura + "]";
	}

}
