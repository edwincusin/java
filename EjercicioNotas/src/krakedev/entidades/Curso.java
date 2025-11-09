package krakedev.entidades;
import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes;

	//CONSTRUCTOR
	public Curso() {
		this.estudiantes = new ArrayList<Estudiante>();
	}
	
	//METODO BUSCAR ESTUDIANTE : VERIFICA POR LA CEDULA SI UN ESTUDIANTE YA NO ESTA DENTRO DE UN CUSRO 
	//SI NO RETORNA NULL CASO CONTRARIO DEVUELVE UN MENSAJE

	public  Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
		Estudiante elementoEstudiante;
		Estudiante estudianteEncontrado=null;
		
		for(int i=0; i<estudiantes.size();i++) {
			elementoEstudiante=estudiantes.get(i);
			if(elementoEstudiante.getCedula().equals(cedulaEstudiante)) {
				estudianteEncontrado=elementoEstudiante;
				break;
			}
		}
		
		if (estudianteEncontrado!=null) {
			System.out.println("EL ESTUDIANTE SE ENCUENTRA REGISTRADO EN UN CURSO");
		}
		
		return estudianteEncontrado;		
	}
	
	//METODO MATRICULAR ESTUDIANTES;
	public void matricularEstudiante(Estudiante estudiante) {
		Estudiante existeEstudianteregistrado=buscarEstudiantePorCedula(estudiante.getCedula());
		
		if(existeEstudianteregistrado==null) {
			estudiantes.add(estudiante);
			System.out.println("MATRICULADO CON EXITO");
		}else{
			System.out.println("EL ESTUDIANTE YA SE ENCUENTRA REGISTRADO EN UN CURSO"+estudiante.getNombre());
		}
	}
	
	//CALCULAR PROMEDIO TOTAL DE LA CLASE
	public double calcularPromedioCurso() {
		double promedio=0;
		double sumaNotas=0;
		Estudiante elementoEstudiante=null;
		Nota elementoNota=null;
		ArrayList<Nota> notasCurso= new ArrayList<Nota>();
		for(int i=0;i<estudiantes.size();i++) {
			elementoEstudiante=estudiantes.get(i);
			for(int j=0; j<elementoEstudiante.getNotas().size();j++) {
				elementoNota=elementoEstudiante.getNotas().get(j);
				notasCurso.add(elementoNota);
			}
		}
		
		for(int i=0; i<notasCurso.size();i++) {
			elementoNota=notasCurso.get(i);
			sumaNotas+=elementoNota.getCalificacion();
		}
		promedio=sumaNotas/notasCurso.size();
		
		return promedio;
	}
	
	
	//MOSTRAR INFORMACION DEL CURSO
	public void mostrar() {
		
		Estudiante elementoestudiante;
		
		System.out.println("\n---------INFORMACION DE ESTUDIANTES MATRICULADOS----------");
		for(int i=0;i<estudiantes.size();i++) {
		elementoestudiante=estudiantes.get(i);
		System.out.println("\n---------ESTUDIANTE "+i+"----------");
		System.out.println(
				"CEDULA: "+elementoestudiante.getCedula()
				+" NOMBRE: "+elementoestudiante.getNombre()
				+" APELLIDO: "+elementoestudiante.getApellido()
				);

		System.out.println("---------NOTAS----------");
		Nota elementoNota;
			for(int j=0;j<elementoestudiante.getNotas().size();j++) {
				elementoNota=elementoestudiante.getNotas().get(j);
				System.out.println(
						"MATERIA: "+elementoNota.getMateria().getNombre()
						+" CALIFICACION: "+elementoNota.getCalificacion()
						);
			}
		}
	
	
	}
	
	
	//METODOS GET Y SET
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	
}
