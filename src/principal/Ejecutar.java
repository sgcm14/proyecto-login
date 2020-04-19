package principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import clases.Usuario;

public class Ejecutar {
	String fa="";
		String obtenerFecha() {
		Date fechaactual = new Date();
		DateFormat formato = DateFormat.getDateTimeInstance();
		fa=formato.format(fechaactual);
		return fa;
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user="",pass="",estado="",impUser="";
		
			Usuario usuario1 = new Usuario("Juan", "Juanito", "123456");
			Usuario usuario2 = new Usuario("Ana", "Anita", "456123");
			Usuario usuario3 = new Usuario("Mariana", "Marianita", "456789");
			/*ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios.add(usuario1);
			usuarios.add(usuario2);	
			usuarios.add(usuario3);*/
			List<Usuario>usuarios=Arrays.asList(usuario1,usuario2,usuario3);
		
			int contador=0;
			int correcto=0;
		
		do {	
		//Ingreso de datos
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese usuario: ");
		user=sc.next();
		System.out.println("Ingrese clave: ");
		pass=sc.next();
		
		for (Usuario usuario : usuarios) {
			if(user.equalsIgnoreCase(usuario.getCuenta())&& pass.equalsIgnoreCase(usuario.getClave())) {
				impUser=usuario.getNombre();
				break;
			}
		}
		
		Ejecutar eje= new Ejecutar();
		
		if(impUser.length()>0)
		{
			System.out.println("BIENVENIDO "+ impUser);
			estado=("El usuario: "+user.toUpperCase()+" ingreso al sistema el "+eje.obtenerFecha());
			correcto=1;
		}
		else
		{
			System.out.println("ERROR AL AUTENTICAR");
			estado=("ERROR: El usuario: "+user.toUpperCase()+" intento ingresar al sistema con la clave "+pass+", el "+eje.obtenerFecha());
			correcto=0;
		}
		
		//fecha y hora
		System.out.println(eje.obtenerFecha());
		System.out.println();
		
		FileWriter f=null;
		PrintWriter p=null;
		
		try {
			f = new FileWriter("C:\\datos\\login.txt",true);
			p = new PrintWriter(f);
		
			p.println(user.toUpperCase()+" | "+estado+" | "+eje.obtenerFecha());
			p.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			p.close();
		}
		contador+=1;
		if(correcto==1) {
			break;
		}
		else {
			System.out.println("Te quedan "+(3-contador)+" intentos restantes");
			System.out.println();	
		}
		}while(contador<3);
	}
}
