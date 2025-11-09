package krakedev.entidades;
import java.util.ArrayList;

public class Estudiante {
	private String codigo;
	private String nombre;
	private String apellido; 
	private String cedula;
	private ArrayList<Nota> notas;
	
	
	
	//CONSTRUCTO CON PARAMETROS
	public Estudiante( String cedula,String nombre, String apellido) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.notas=new ArrayList<Nota>();
	}

	//METODO AGREGAR NOTA: AGREGAR NOTA NUEVA DE CALIFICACION 
	//VERIFICANDO QUE LA NUEVA NOTA NO TENGA CODIGO REPETIDO, DENTRO DEL ARRAY LIST NOTAS
	//TAMBIEN VALIDA QUE NOTA SEA IGUAL O MAYOR A 0
	public void agregarNota(Nota nuevanota) {

		Nota elementoNota;
		Nota notaEncontrada=null;
		for(int i=0; i<notas.size();i++){
			elementoNota=notas.get(i);
			if(elementoNota.getMateria().getCodigo().equals(nuevanota.getMateria().getCodigo())) {
				notaEncontrada=elementoNota;
				break;
			}
		}
		if(notaEncontrada == null && nuevanota.getCalificacion() >=0) {
			notas.add(nuevanota);
			System.out.println("Nota agregada : materia "+nuevanota.getMateria().getNombre()+" calificacion: "+nuevanota.getCalificacion());
		}else {
			System.err.println("CODIGO MATERIA REPETIDA "+nuevanota.getMateria().getNombre()+" O NOTA DEBE SE > = 0 : VALOR NOTA "+nuevanota.getCalificacion());
		}	
	}
	
	//METODO MODIFICAR NOTA: OBJETIVO MODIFICAR LA CALIFICACION DE UNA MATERIA A TRAVEZ DE SU CODIGO 
	//DE NO ENCONTRARSE CON EL CODIGO MOSTRAR MENSAJE DE QUE NO SE ENCONTRO CODIGO 
	//VALIDAR QUE NOTA SEA MAYO IGUAL A 0;
	public void modificarNota(String codigoMateria, double nuevanota) {
		Nota elementoNota;
		Nota notaEncontrada=null;
		for(int i=0; i<notas.size();i++){
			elementoNota=notas.get(i);
			if(elementoNota.getMateria().getCodigo().equals(codigoMateria)) {
				notaEncontrada=elementoNota;
				break;
			}
		}
		if(notaEncontrada!=null && nuevanota>=0) {
			notaEncontrada.setCalificacion(nuevanota);
		}else {
			System.err.println("MATERIA NO ENCONTRADA A O NOTA DEBE SE > = 0");
		}
		
	}
	
	//METODO CALCULAR PROMEDIO ESTUDIANTE: CALCULA PROMEDIO DE UN ESTUDIANTE DEBE BARRIR EL ARRAYLIST
	//SUMAR TODAS LAS NOTAS Y DIVIDIR PARA EL TOTAL DE MATERIAS.
	public double calcularPromedioNotasEstudiante() {
		double promedio=0;
		double sumaNotas=0;
		Nota elementoNota=null;
		
		for(int i=0; i<notas.size();i++) {
			elementoNota=notas.get(i);
			sumaNotas+=elementoNota.getCalificacion();
		}
		promedio=sumaNotas/notas.size();
		return promedio;
	}
	
	//MOSTRAR: INFORMACION DEL ESTUDIANTE
	public void mostrar() {
		
		System.out.println("---------INFORMACION DEL ESTUDIANTE----------");
		System.out.println(
				"CEDULA: "+getCedula()
				+" NOMBRE: "+getNombre()
				+" APELLIDO: "+getApellido()
				);

		System.out.println("---------NOTAS----------");
		Nota elementoNota;
		for(int i=0;i<notas.size();i++) {
			elementoNota=notas.get(i);
			System.out.println(
					"MATERIA: "+elementoNota.getMateria().getNombre()
					+" CALIFICACION: "+elementoNota.getCalificacion()
					);
		}
		
	
	
	}
	
	
	//METODO GET Y SET
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
