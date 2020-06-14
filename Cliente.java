import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {
	private String DNI;
	private String nombre;
	private LocalDate fechaNacimiento;


	
	public Cliente (String nombre, String DNI, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.DNI = DNI;
		this.fechaNacimiento = fechaNacimiento; 
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
	
	@Override
	public String toString() {
		return "Los datos del cliente: "+"\nNombre: "+nombre+"\nDNI: "+DNI+"\nFecha de nacimiento: "+fechaNacimiento;
	}
	

	
}
