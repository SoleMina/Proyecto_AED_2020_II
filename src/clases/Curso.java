package clases;

public class Curso {
    //	Atributos privados
	private int codigoCurso, ciclo, créditos, horas;
	private String asignatura;

	//	Constructor
	
//<<<<<<< HEAD
	public Curso(int codigoCurso, int ciclo, int créditos, int horas, String asignatura) {
		this.codigoCurso = codigoCurso;
		this.ciclo = ciclo;
		this.créditos = créditos;
		
//>>>>>>> fc707458c5264fac9bc3be84ac961e43315a16aa
		this.horas = horas;
		this.asignatura = asignatura;
	}
	
	//  MÃ©todos de acceso pÃºblico: set/get
	  //set
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	public void setcreditos(int creditos) {
		this.créditos = creditos;
	}
	public void sethoras(int horas) {
		this.horas = horas;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	   //get
	public int getCodigoCurso() {
		return codigoCurso;
	}
	public int getCiclo() {
		return ciclo;
	}
	public int getcreditos() {
		return créditos;
	}
	public int gethoras() {
		return horas;
	}
	public String getAsignatura() {
		return asignatura;
	}
    

}
