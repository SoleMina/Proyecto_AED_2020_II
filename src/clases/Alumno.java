package clases;

public class Alumno {
          
	//	Atributos privados
	private int codigoAlumno, edad;
	private String nombre, apellido, celular, dni;

	//	Constructor
	public Alumno(int codigoAlumno, int edad, String nombre, String apellido, String celular, String dni) {
		this.codigoAlumno = codigoAlumno;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.dni = dni;
	}
	
	//  Métodos de acceso público: set/get
	 //set
   public void SetCodigoAlumno(int codigoAlumno ) {
	   this.codigoAlumno = codigoAlumno;
   }
   public void setEdad(int edad) {
	   this.edad = edad;
   }
   public void setNombre(String nombre) {
	   this.nombre = nombre;
   }
   public void setApellido(String apellido) {
	   this.apellido = apellido;
   }
   public void celular(String celular) {
	   this.celular = celular;
   }
   public void dni(String dni) {
	   this.dni = dni;
   }
      //get
   public int getCodigoAlumno() {
	   return codigoAlumno;
   }
   public int getEdad() {
	   return edad;
   }
   public String  getNombre() {
	   return nombre;
   }
   public String getApellido() {
	   return apellido;
   }
   public String getCelular() {
	   return celular;
   }
   public String getDni() {
	   return dni;
   }
   
}
