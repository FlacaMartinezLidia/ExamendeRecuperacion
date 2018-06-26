import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Mac;
import alumnnoclase.Alumno;
import com.sun.glass.ui.Menu;
import java.lang.NullPointerException;


public class EstudiantesEscuela {

	static final String ruta ="C:/Users/martinez/Documents ";
	private final static Alumno alumno  = null;
	static Scanner sc;

		public static boolean agregar(int carnet,String nombre,byte edad){
			try{
				FileOutputStream out = new FileOutputStream (ruta,true);
				DataOutputStream dout = new DataOutputStream(out);
				dout.writeInt(carnet);
				dout.writeUTF(nombre);
				dout.writeByte(edad);
				dout.close();
				return true; 
			}catch (IOException e){
			System.out.println("\nOcurrio una falla al agregra alumno \n" + e.getMessage());
				return false;
			}
		}
		public static void modificarAlumno(File  AlumnoAntiguo,String Santigualinea,String Snuevalinea){
			Random numaleatorio = new Random (3816L);
			String SnombreAlumNuev=AlumnoAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";
			File AlumnoNuevo= new File (SnombreAlumNuev);
			try{
				Object AalumnoNuevo;
				if(AlumnoAntiguo.exists()){
					BufferedReader Flee= new BufferedReader(new FileReader(AlumnoAntiguo));
					String Slinea;
					while((Slinea = Flee.readLine())!=null){
						if(Slinea.toUpperCase().trim().equals(Santigualinea.toUpperCase().trim())){
							agregarAlumno();	
						}
					}
				String SnomAntiguo=AlumnoAntiguo.getName();
				eliminarAlumno();
				AalumnoNuevo.ReNameTo(AlumnoAntiguo);
				Flee.close();
			}else{
				System.out.println("Alumno no exixte");
			}		
		}catch(IOException e){
			
			System.out.println("\n ocurrio un error al agregar alumno\n" + e.getMessage());
		}
		
		}
			
		public static  boolean eliminarAlumno(){
			if(Alumno.exists()){
				Alumno.delete();
				System.out.println("Fichero eliminado con exito");
				
			}
				return false;
			}
		public static void listarAlumno(){
			try {
				FileInputStream in = new FileInputStream (ruta);
				DataInputStream din = new DataInputStream ( in);
				try{
					do{
						System.out.println("\n Clave:" + din.readInt());
						System.out.println("\nNombre:" +din.readUTF());
						System.out.println("\nEdad:" + din.readByte());
			
				}while(true);		
				}catch (IOException f){
					
				}
				
				din.close();
				
			}catch (IOException e){
				System.out.println("\nOcurrio una falla al extraer los datos del archivo" + e.getMessage());
			}
		}
		public void alumno(){
			Alumno alumno = new Alumno();
			Scanner sc = null;
			alumno.setNombre(sc.nextLine());
			alumno.setCarnet(sc.nextInt());
			alumno.setEdad(sc.nextByte());
		
			System.out.println("");
		}

		public void buscarCarnet(int Carnet){
			int tmpCarnet;
			String nombre;
			byte edad;
			
			try{
				FileInputStream in = new FileInputStream(ruta);
				DataInputStream din = new DataInputStream (in);
				try{
					do{
						tmpCarnet = din.readInt ();
						nombre = din.readUTF();
						edad =din.readByte();
						 
						
						if (tmpCarnet == Carnet){
							System.out.print("\nCarnet:"+ tmpCarnet);
							System.out.print("\nNombre:"+ nombre);
							System.out.print("\nEdad:"+ edad);
							
						
						}
					}while (tmpCarnet != Carnet);
				}catch (EOFException f){
					System.out.print("el carnet buscada no se esncuentra en el archivo\n" + f.getMessage());	
				}
				din.close();
				
			}catch(IOException e){
		 System.out.print("\nOcurrio una falla a extraer los datos del archivo \n" + e.getMessage());
				
			}
		}
		public static boolean agregarAlumno (){
			String nombre;
			int Carnet;
			byte edad;
			System.out.print("\nIndique el Carnet");
			Carnet = sc.nextInt();
			System.out.print("\nIndique el nombre");
			sc.nextLine();//limpiar buffer
			nombre = sc.nextLine();
			edad = sc.nextByte();
			System.out.print("\nIndique la edad");
			edad= sc.nextByte();
			return agregar(Carnet, nombre, edad);
		}
 
	/**
	 * @param args
	 */
	public static void main(String[] args){
		EstudiantesEscuela as = new EstudiantesEscuela();
		Alumno alumno = new Alumno ();		
		as.menu ();			
		}
		// TODO Auto-generated method stub
	private static void menu() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
			
		byte opt;
		do{
		System.out.println("Bienvenidos\n ");
		System.out.println("Elija una Opcion\n ");
		System.out.println("1. Agregar Alumno");
		System.out.println("2. Modificar Alumno");
		System.out.println("3. Eliminar Alumno");
		System.out.println("4. Listar Alumno");
		System.out.println("5. Buscar Alumno");
		System.out.println("6. Salir");
		
		opt = sc.nextByte();
		switch (opt){
		case 1:
			if (agregarAlumno()){
				System.out.print("\nLos datos an sido agredado correctamente");
			}else{
				System.out.print("\nLos datos no existe");
			}
		     break;
		case 2:
			if (modificarAlumno()){
				System.out.print("\nEl alumno  ha sido modificado satisfactoriament ");
			}else{
				System.out.println("\nEl alumno no sido modificado");
			}
			break;
		case 3:
			if (eliminarAlumno()){
				System.out.print("\n Los datos han sido insertados satisfactoriamente");
			}
			break;
		case 4:	
			listarAlumno();
			break;
		case 5:
	
			System.out.print("Indique la clave a buscar:");
			break;
		}
	}while (opt !=6);
	
		
	}
		private static boolean modificarAlumno() {
			// TODO Auto-generated method stub
			return false;
		}
	
		// TODO Auto-generated method stub
		
}
