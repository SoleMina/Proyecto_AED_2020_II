package clases;

public class Alumno {

	// Atributos privados
	private int codigoAlumno, edad, celular, estado;
	private String nombre, apellido, dni;

	// Constructor
	public Alumno(int codigoAlumno, int edad, int celular, int estado, String nombre, String apellido, String dni) {
		this.codigoAlumno = codigoAlumno;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	// Métodos de acceso público: set/get
	// set
	public void SetCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// get
	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public int getCelular() {
		return celular;
	}

	public int getEstado() {
		return estado;
	}

	public String getNombre() {
		return nombre;
	}

	

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	
	@Override
	public String toString() {
		return "Alumno [codigoAlumno=" + codigoAlumno + ", edad=" + edad + ", celular=" + celular + ", estado=" + estado
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	
	
	
}
