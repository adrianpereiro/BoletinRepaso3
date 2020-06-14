import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {
	private String DNI;
	private String nombre;
	private LocalDate fechaNacimiento;
	private float edad;
	private String edad2;

	
	public Cliente (String nombre, String DNI, LocalDate fechaNacimiento, float edad ) {
		this.nombre = nombre;
		this.DNI = DNI;
		this.fechaNacimiento = fechaNacimiento; 
		this.edad = edad;
	}
	public Cliente (String nombre, String DNI, LocalDate fechaNacimiento, String edad2 ) {
		this.nombre = nombre;
		this.DNI = DNI;
		this.fechaNacimiento = fechaNacimiento; 
		this.setEdad2(edad2);
	}
	
	public static long devolverEdad(int dia, int mes, int año) {
		LocalDate fechaNacimiento= LocalDate.of(año, mes, dia);
		LocalDate hoy= LocalDate.now();
		long edad = ChronoUnit.YEARS.between(fechaNacimiento,hoy );
		return edad;
	}
	
	public void mostrarDatos() {
		System.out.printf("Nombre: %s\nDNI: %s\nFecha de nacimiento: %s\n",nombre,DNI,fechaNacimiento);
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public float getEdad() {
		return edad;
	}
	
	public void setEdad(long edad) {
		this.edad = edad;
	}
	
	public String getEdad2() {
		return edad2;
	}
	
	public void setEdad2(String edad2) {
		this.edad2 = edad2;
	}
	
	@Override
	public String toString() {
		return "Los datos del cliente: "+"\nNombre: "+nombre+"\nDNI: "+DNI+"\nFecha de nacimiento: "+fechaNacimiento;
	}
	

	
}
