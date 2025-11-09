package krakedev.entidades;

public class Nota {
	private Materia materia;
	private double calificacion;
	
	
	//CONSTRUCTOR CON PARAMETROS 
	public Nota(Materia materia, double calificacion) {
		this.materia = materia;
		this.calificacion = calificacion;
	}

	//METODO MOSTRAR : PARA VER LA INFORMACION DE LA NOTA
	public void mostrar() {
		System.out.println("Materia : "+materia.getNombre()+" Calificacion: "+getCalificacion());
	}
	
	//METODOS GET Y SET 
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
